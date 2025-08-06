package y1;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f16808b = new a();

    /* renamed from: c  reason: collision with root package name */
    public static final int f16809c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f16810d;

    /* renamed from: e  reason: collision with root package name */
    public static final int f16811e;

    /* renamed from: a  reason: collision with root package name */
    public final Executor f16812a = new b();

    public static class b implements Executor {
        public b() {
        }

        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f16809c = availableProcessors;
        f16810d = availableProcessors + 1;
        f16811e = (availableProcessors * 2) + 1;
    }

    @SuppressLint({"NewApi"})
    public static void a(ThreadPoolExecutor threadPoolExecutor, boolean z11) {
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z11);
        }
    }

    public static ExecutorService b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f16810d, f16811e, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    public static Executor c() {
        return f16808b.f16812a;
    }
}
