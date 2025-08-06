package i6;

import android.os.Handler;
import android.os.Looper;

public class i {

    /* renamed from: b  reason: collision with root package name */
    public static i f68172b = new i();

    /* renamed from: a  reason: collision with root package name */
    public Handler f68173a = new Handler(Looper.getMainLooper());

    public static i b() {
        return f68172b;
    }

    public static /* synthetic */ void e(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th2) {
            th2.printStackTrace();
            d.d("ui ThreadMethod Exception-->" + th2.toString());
        }
    }

    public void c() {
        this.f68173a = new Handler(Looper.getMainLooper());
    }

    public void d(Runnable runnable) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            runnable.run();
        } else {
            f(new h(runnable));
        }
    }

    public void f(Runnable runnable) {
        this.f68173a.post(runnable);
    }

    public void g(Runnable runnable, int i11) {
        this.f68173a.postDelayed(runnable, (long) i11);
    }

    public void h(Runnable runnable) {
        this.f68173a.removeCallbacks(runnable);
    }
}
