package com.mob.commons;

import android.text.TextUtils;
import com.mob.commons.a.l;
import com.xiaomi.mipush.sdk.Constants;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class z {

    /* renamed from: a  reason: collision with root package name */
    public static final String f27382a = ("M-" + l.a("002=glil"));

    /* renamed from: b  reason: collision with root package name */
    public static final String f27383b = ("M-" + l.a("003Jhmgfil"));

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadPoolExecutor f27384c;

    /* renamed from: d  reason: collision with root package name */
    public static final ThreadPoolExecutor f27385d;

    /* renamed from: e  reason: collision with root package name */
    public static final ExecutorService f27386e = Executors.newCachedThreadPool(new b(2));

    /* renamed from: f  reason: collision with root package name */
    public static final ExecutorService f27387f = Executors.newCachedThreadPool(new b(3));

    /* renamed from: g  reason: collision with root package name */
    public static final ExecutorService f27388g = Executors.newCachedThreadPool(new b(4));

    public static class a implements RejectedExecutionHandler {
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                l.a().d(500, runnable);
            } catch (Throwable unused) {
            }
        }
    }

    public static class b implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private static final AtomicInteger f27389a = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        private final ThreadGroup f27390b;

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f27391c = new AtomicInteger(1);

        /* renamed from: d  reason: collision with root package name */
        private final String f27392d;

        public b(int i11) {
            SecurityManager securityManager = System.getSecurityManager();
            this.f27390b = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            if (TextUtils.isEmpty("M-")) {
                this.f27392d = l.a("005kEelelJh>il") + f27389a.getAndIncrement() + l.a("008Mil'ji-ek8ge4edil");
                return;
            }
            this.f27392d = z.f27383b + i11 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + f27389a.getAndIncrement() + Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }

        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f27390b;
            Thread thread = new Thread(threadGroup, runnable, this.f27392d + this.f27391c.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    static {
        int max = Math.max(2, 5);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f27384c = new ThreadPoolExecutor(2, max, 60, timeUnit, new SynchronousQueue(), new b(0), new a());
        f27385d = new ThreadPoolExecutor(1, 1, 120, timeUnit, new LinkedBlockingQueue(), new b(1));
    }
}
