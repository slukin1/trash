package com.alibaba.android.arouter.thread;

import com.alibaba.android.arouter.facade.template.ILogger;
import java.lang.Thread;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadFactory implements ThreadFactory {

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicInteger f14070e = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    public final AtomicInteger f14071b = new AtomicInteger(1);

    /* renamed from: c  reason: collision with root package name */
    public final ThreadGroup f14072c;

    /* renamed from: d  reason: collision with root package name */
    public final String f14073d;

    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        public void uncaughtException(Thread thread, Throwable th2) {
            ILogger iLogger = b2.a.f12290c;
            iLogger.info(ILogger.defaultTag, "Running task appeared exception! Thread [" + thread.getName() + "], because [" + th2.getMessage() + "]");
        }
    }

    public DefaultThreadFactory() {
        ThreadGroup threadGroup;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            threadGroup = securityManager.getThreadGroup();
        } else {
            threadGroup = Thread.currentThread().getThreadGroup();
        }
        this.f14072c = threadGroup;
        this.f14073d = "ARouter task pool No." + f14070e.getAndIncrement() + ", thread No.";
    }

    public Thread newThread(Runnable runnable) {
        String str = this.f14073d + this.f14071b.getAndIncrement();
        b2.a.f12290c.info(ILogger.defaultTag, "Thread production, name is [" + str + "]");
        Thread thread = new Thread(this.f14072c, runnable, str, 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        thread.setUncaughtExceptionHandler(new a());
        return thread;
    }
}
