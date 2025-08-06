package fy;

import android.os.Build;
import android.view.animation.Interpolator;

public final class a {
    public static Interpolator a(float f11, float f12) {
        if (Build.VERSION.SDK_INT >= 21) {
            return b.a(f11, f12);
        }
        return c.a(f11, f12);
    }
}
