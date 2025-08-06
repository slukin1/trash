package com.huobi.woodpecker.kalle.util;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkExecutor implements Executor {

    /* renamed from: c  reason: collision with root package name */
    public static final int f21129c = Runtime.getRuntime().availableProcessors();

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadFactory f21130d = new a();

    /* renamed from: b  reason: collision with root package name */
    public ThreadPoolExecutor f21131b;

    public class a implements ThreadFactory {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicInteger f21132b = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Request #" + this.f21132b.getAndIncrement());
        }
    }

    public WorkExecutor() {
        int i11 = f21129c;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Math.max(2, Math.min(i11 - 1, 4)), (i11 * 2) + 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(128), f21130d);
        this.f21131b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public void execute(Runnable runnable) {
        this.f21131b.execute(runnable);
    }
}
