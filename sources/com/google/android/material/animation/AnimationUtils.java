package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

public class AnimationUtils {
    public static final TimeInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    public static final TimeInterpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
    public static final TimeInterpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    public static final TimeInterpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final TimeInterpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();

    public static float lerp(float f11, float f12, float f13) {
        return f11 + (f13 * (f12 - f11));
    }

    public static int lerp(int i11, int i12, float f11) {
        return i11 + Math.round(f11 * ((float) (i12 - i11)));
    }

    public static float lerp(float f11, float f12, float f13, float f14, float f15) {
        if (f15 < f13) {
            return f11;
        }
        return f15 > f14 ? f12 : lerp(f11, f12, (f15 - f13) / (f14 - f13));
    }
}
