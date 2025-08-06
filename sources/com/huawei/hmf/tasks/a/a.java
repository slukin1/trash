package com.huawei.hmf.tasks.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f37634b = new a();

    /* renamed from: c  reason: collision with root package name */
    public static final int f37635c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f37636d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f37637e;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f37638a = new C0514a((byte) 0);

    /* renamed from: com.huawei.hmf.tasks.a.a$a  reason: collision with other inner class name */
    public static class C0514a implements Executor {
        public C0514a() {
        }

        public /* synthetic */ C0514a(byte b11) {
            this();
        }

        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f37635c = availableProcessors;
        f37636d = availableProcessors + 1;
        f37637e = (availableProcessors * 2) + 1;
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f37636d, f37637e, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return f37634b.f37638a;
    }
}
