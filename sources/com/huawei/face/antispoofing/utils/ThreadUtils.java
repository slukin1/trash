package com.huawei.face.antispoofing.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ThreadUtils {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Handler f37614a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private ThreadPoolExecutor f37615b;

    public static abstract class Callback<T> {
        public void onFailure(Throwable th2) {
        }

        public void onFinish() {
        }

        public void onStart() {
        }

        public void onSuccess(T t11) {
        }
    }

    public class a implements ThreadFactory {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicInteger f37616b = new AtomicInteger(1);

        public a(ThreadUtils threadUtils) {
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder c11 = a.a.c("AsyncTask #");
            c11.append(this.f37616b.getAndIncrement());
            return new Thread(runnable, c11.toString());
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Callback f37617b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Callable f37618c;

        public class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ CountDownLatch f37620b;

            public a(CountDownLatch countDownLatch) {
                this.f37620b = countDownLatch;
            }

            public void run() {
                b.this.f37617b.onStart();
                this.f37620b.countDown();
            }
        }

        /* renamed from: com.huawei.face.antispoofing.utils.ThreadUtils$b$b  reason: collision with other inner class name */
        public class C0513b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Object f37622b;

            public C0513b(Object obj) {
                this.f37622b = obj;
            }

            public void run() {
                b.this.f37617b.onSuccess(this.f37622b);
            }
        }

        public class c implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Throwable f37624b;

            public c(Throwable th2) {
                this.f37624b = th2;
            }

            public void run() {
                b.this.f37617b.onFailure(this.f37624b);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            public void run() {
                b.this.f37617b.onFinish();
            }
        }

        public b(Callback callback, Callable callable) {
            this.f37617b = callback;
            this.f37618c = callable;
        }

        public void run() {
            try {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                if (this.f37617b != null) {
                    ThreadUtils.this.f37614a.post(new a(countDownLatch));
                }
                countDownLatch.await(1000, TimeUnit.MILLISECONDS);
                Object call = this.f37618c.call();
                if (this.f37617b != null) {
                    ThreadUtils.this.f37614a.post(new C0513b(call));
                }
                if (this.f37617b != null) {
                    ThreadUtils.this.f37614a.post(new d());
                }
            } catch (Throwable th2) {
                if (this.f37617b != null) {
                    ThreadUtils.this.f37614a.post(new d());
                }
                throw th2;
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Callback f37627b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Callable f37628c;

        public c(ThreadUtils threadUtils, Callback callback, Callable callable) {
            this.f37627b = callback;
            this.f37628c = callable;
        }

        public void run() {
            Callback callback;
            try {
                Callback callback2 = this.f37627b;
                if (callback2 != null) {
                    callback2.onStart();
                }
                Object call = this.f37628c.call();
                Callback callback3 = this.f37627b;
                if (callback3 != null) {
                    callback3.onSuccess(call);
                }
                callback = this.f37627b;
                if (callback == null) {
                    return;
                }
            } catch (Throwable th2) {
                Callback callback4 = this.f37627b;
                if (callback4 != null) {
                    callback4.onFinish();
                }
                throw th2;
            }
            callback.onFinish();
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public static final ThreadUtils f37629a = new ThreadUtils((a) null);
    }

    private ThreadUtils() {
        a aVar = new a(this);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Math.max(2, Math.min(availableProcessors - 1, 4)), (availableProcessors * 2) + 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(128), aVar);
        this.f37615b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static ThreadUtils getInstance() {
        return d.f37629a;
    }

    public <T> void enqueue(Callable<T> callable, Callback<T> callback) {
        if (callable != null) {
            this.f37615b.execute(new c(this, callback, callable));
        }
    }

    public <T> void enqueueOnUiThread(Callable<T> callable, Callback<T> callback) {
        if (callable != null) {
            this.f37615b.execute(new b(callback, callable));
        }
    }

    public void execute(Runnable runnable) {
        if (runnable != null) {
            this.f37615b.execute(runnable);
        }
    }

    public void removeUiAllTasks() {
        this.f37614a.removeCallbacksAndMessages((Object) null);
    }

    public void removeUiCallbacks(Runnable runnable) {
        if (runnable != null) {
            this.f37614a.removeCallbacks(runnable);
        }
    }

    public boolean runOnUiPostAtTime(Runnable runnable, long j11) {
        if (runnable != null) {
            return this.f37614a.postAtTime(runnable, j11);
        }
        return false;
    }

    public boolean runOnUiPostDelayed(Runnable runnable, long j11) {
        if (runnable != null) {
            return this.f37614a.postDelayed(runnable, j11);
        }
        return false;
    }

    public void runOnUiThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.f37614a.post(runnable);
        }
    }

    public <T> Future<T> submit(Callable<T> callable) {
        if (callable != null) {
            return this.f37615b.submit(callable);
        }
        return null;
    }

    public /* synthetic */ ThreadUtils(a aVar) {
        a aVar2 = new a(this);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Math.max(2, Math.min(availableProcessors - 1, 4)), (availableProcessors * 2) + 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(128), aVar2);
        this.f37615b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }
}
