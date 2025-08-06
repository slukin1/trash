package v1;

import android.annotation.SuppressLint;
import android.view.View;

public class v extends a0 {

    /* renamed from: f  reason: collision with root package name */
    public static boolean f16693f = true;

    public void a(View view) {
    }

    @SuppressLint({"NewApi"})
    public float c(View view) {
        if (f16693f) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f16693f = false;
            }
        }
        return view.getAlpha();
    }

    public void d(View view) {
    }

    @SuppressLint({"NewApi"})
    public void g(View view, float f11) {
        if (f16693f) {
            try {
                view.setTransitionAlpha(f11);
                return;
            } catch (NoSuchMethodError unused) {
                f16693f = false;
            }
        }
        view.setAlpha(f11);
    }
}
