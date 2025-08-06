package com.scwang.smartrefresh.header.waveswipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

public class DropBounceInterpolator implements Interpolator {
    public DropBounceInterpolator() {
    }

    public float getInterpolation(float f11) {
        if (f11 < 0.25f) {
            return (((float) Math.pow(((double) f11) - 0.125d, 2.0d)) * -38.4f) + 0.6f;
        }
        double d11 = (double) f11;
        if (d11 < 0.5d || d11 >= 0.75d) {
            return 0.0f;
        }
        return (((float) Math.pow(d11 - 0.625d, 2.0d)) * -19.2f) + 0.3f;
    }

    public DropBounceInterpolator(Context context, AttributeSet attributeSet) {
    }
}
