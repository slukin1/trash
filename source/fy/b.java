package fy;

import android.annotation.TargetApi;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

@TargetApi(21)
public class b {
    public static Interpolator a(float f11, float f12) {
        return new PathInterpolator(f11, f12);
    }
}
