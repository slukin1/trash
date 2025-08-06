package com.alibaba.sdk.android.crashdefend.b;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadFactory f14504a = new C0067a();

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f14505b;

    /* renamed from: com.alibaba.sdk.android.crashdefend.b.a$a  reason: collision with other inner class name */
    public class C0067a implements ThreadFactory {
        public C0067a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "safe_thread");
            thread.setDaemon(false);
            return thread;
        }
    }

    public synchronized ExecutorService a() {
        if (this.f14505b == null) {
            this.f14505b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1, TimeUnit.SECONDS, new SynchronousQueue(), this.f14504a);
        }
        return this.f14505b;
    }
}
