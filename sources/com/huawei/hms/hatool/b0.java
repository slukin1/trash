package com.huawei.hms.hatool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class b0 {

    /* renamed from: b  reason: collision with root package name */
    private static b0 f38120b = new b0();

    /* renamed from: c  reason: collision with root package name */
    private static b0 f38121c = new b0();

    /* renamed from: d  reason: collision with root package name */
    private static b0 f38122d = new b0();

    /* renamed from: a  reason: collision with root package name */
    private ThreadPoolExecutor f38123a = new ThreadPoolExecutor(0, 1, 60000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(5000), new b());

    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Runnable f38124a;

        public a(Runnable runnable) {
            this.f38124a = runnable;
        }

        public void run() {
            Runnable runnable = this.f38124a;
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Exception unused) {
                    v.e("hmsSdk", "InnerTask : Exception has happened,From internal operations!");
                }
            }
        }
    }

    public static class b implements ThreadFactory {

        /* renamed from: d  reason: collision with root package name */
        private static final AtomicInteger f38125d = new AtomicInteger(1);

        /* renamed from: a  reason: collision with root package name */
        private final ThreadGroup f38126a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f38127b = new AtomicInteger(1);

        /* renamed from: c  reason: collision with root package name */
        private final String f38128c;

        public b() {
            SecurityManager securityManager = System.getSecurityManager();
            this.f38126a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f38128c = "FormalHASDK-base-" + f38125d.getAndIncrement();
        }

        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f38126a;
            return new Thread(threadGroup, runnable, this.f38128c + this.f38127b.getAndIncrement(), 0);
        }
    }

    static {
        new b0();
        new b0();
    }

    private b0() {
    }

    public static b0 a() {
        return f38122d;
    }

    public static b0 b() {
        return f38121c;
    }

    public static b0 c() {
        return f38120b;
    }

    public void a(g gVar) {
        try {
            this.f38123a.execute(new a(gVar));
        } catch (RejectedExecutionException unused) {
            v.e("hmsSdk", "addToQueue() Exception has happened!Form rejected execution");
        }
    }
}
