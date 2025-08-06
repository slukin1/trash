package com.hbg.module.livesquare.custom;

import android.view.animation.Interpolator;

public final class DecelerateAccelerateInterpolator implements Interpolator {
    public float getInterpolation(float f11) {
        return (float) ((Math.tan(((double) (((f11 * ((float) 2)) - ((float) 1)) / ((float) 4))) * 3.141592653589793d) / ((double) 2.0f)) + ((double) 0.5f));
    }
}
