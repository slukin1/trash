package c2;

import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.thread.DefaultThreadFactory;
import com.alibaba.android.arouter.utils.TextUtils;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class b extends ThreadPoolExecutor {

    /* renamed from: b  reason: collision with root package name */
    public static final int f13000b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f13001c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f13002d;

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f13003e;

    public class a implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            b2.a.f12290c.error(ILogger.defaultTag, "Task rejected, too many task!");
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f13000b = availableProcessors;
        int i11 = availableProcessors + 1;
        f13001c = i11;
        f13002d = i11;
    }

    public b(int i11, int i12, long j11, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i11, i12, j11, timeUnit, blockingQueue, threadFactory, new a());
    }

    public static b a() {
        if (f13003e == null) {
            synchronized (b.class) {
                if (f13003e == null) {
                    f13003e = new b(f13001c, f13002d, 30, TimeUnit.SECONDS, new ArrayBlockingQueue(64), new DefaultThreadFactory());
                }
            }
        }
        return f13003e;
    }

    public void afterExecute(Runnable runnable, Throwable th2) {
        super.afterExecute(runnable, th2);
        if (th2 == null && (runnable instanceof Future)) {
            try {
                ((Future) runnable).get();
            } catch (CancellationException e11) {
                th2 = e11;
            } catch (ExecutionException e12) {
                th2 = e12.getCause();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        if (th2 != null) {
            ILogger iLogger = b2.a.f12290c;
            iLogger.warning(ILogger.defaultTag, "Running task appeared exception! Thread [" + Thread.currentThread().getName() + "], because [" + th2.getMessage() + "]\n" + TextUtils.a(th2.getStackTrace()));
        }
    }
}
