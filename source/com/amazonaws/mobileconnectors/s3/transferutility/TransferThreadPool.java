package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class TransferThreadPool {

    /* renamed from: a  reason: collision with root package name */
    public static final Log f15032a = LogFactory.b(TransferService.class);

    /* renamed from: b  reason: collision with root package name */
    public static ExecutorService f15033b;

    /* renamed from: c  reason: collision with root package name */
    public static ExecutorService f15034c;

    public static ExecutorService a(int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i11, i11, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static synchronized void b(int i11) {
        synchronized (TransferThreadPool.class) {
            Log log = f15032a;
            log.h("Initializing the thread pool of size: " + i11);
            int max = Math.max((int) Math.ceil(((double) i11) / 2.0d), 1);
            if (f15033b == null) {
                f15033b = a(max);
            }
            if (f15034c == null) {
                f15034c = a(max);
            }
        }
    }

    public static <T> Future<T> c(Callable<T> callable) {
        b(TransferUtilityOptions.getDefaultThreadPoolSize());
        if (callable instanceof UploadPartTask) {
            return f15034c.submit(callable);
        }
        return f15033b.submit(callable);
    }
}
