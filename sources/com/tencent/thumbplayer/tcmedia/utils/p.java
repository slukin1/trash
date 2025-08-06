package com.tencent.thumbplayer.tcmedia.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class p {

    public static class a implements RejectedExecutionHandler {
        private a() {
        }

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                threadPoolExecutor.getQueue().put(runnable);
                TPLogUtil.i("TPPlayer[TPThreadPoolExecutor]", "rejectedExecution put task to queue");
            } catch (InterruptedException e11) {
                TPLogUtil.e("TPPlayer[TPThreadPoolExecutor]", "rejectedExecution has exception:" + e11.toString());
            }
        }
    }

    public static class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private AtomicInteger f49730a;

        private b() {
            this.f49730a = new AtomicInteger(0);
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("TP-Thread" + this.f49730a.incrementAndGet());
            return thread;
        }
    }

    public static ExecutorService a(int i11, int i12) {
        return new ThreadPoolExecutor(i11, i12, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(20), new b(), new a());
    }
}
