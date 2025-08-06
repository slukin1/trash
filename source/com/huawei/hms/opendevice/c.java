package com.huawei.hms.opendevice;

import java.lang.Thread;
import java.util.concurrent.ThreadFactory;

public class c implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadGroup f38306a;

    /* renamed from: b  reason: collision with root package name */
    private int f38307b = 1;

    /* renamed from: c  reason: collision with root package name */
    private final String f38308c;

    public c(String str) {
        SecurityManager securityManager = System.getSecurityManager();
        this.f38306a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.f38308c = str + "-pool-";
    }

    public Thread newThread(Runnable runnable) {
        synchronized (this) {
            this.f38307b++;
        }
        Thread thread = new Thread(this.f38306a, runnable, this.f38308c + this.f38307b, 0);
        thread.setUncaughtExceptionHandler((Thread.UncaughtExceptionHandler) null);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        return thread;
    }
}
