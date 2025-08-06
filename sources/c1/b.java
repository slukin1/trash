package c1;

import android.graphics.Path;
import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

public final class b {

    public static class a {
        public static Interpolator a(float f11, float f12) {
            return new PathInterpolator(f11, f12);
        }

        public static Interpolator b(float f11, float f12, float f13, float f14) {
            return new PathInterpolator(f11, f12, f13, f14);
        }

        public static Interpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    public static Interpolator a(float f11, float f12, float f13, float f14) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.b(f11, f12, f13, f14);
        }
        return new a(f11, f12, f13, f14);
    }

    public static Interpolator b(Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.c(path);
        }
        return new a(path);
    }
}
