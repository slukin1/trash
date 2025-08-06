package f9;

import android.os.Handler;
import android.os.Looper;

public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f70850b = new b();

    /* renamed from: a  reason: collision with root package name */
    public Handler f70851a = new Handler(Looper.getMainLooper());

    public static b a() {
        return f70850b;
    }

    public void b(Runnable runnable) {
        this.f70851a.post(runnable);
    }

    public void c(Runnable runnable, int i11) {
        this.f70851a.postDelayed(runnable, (long) i11);
    }

    public void d(Runnable runnable) {
        this.f70851a.removeCallbacks(runnable);
    }
}
