package com.scwang.smartrefresh.layout.util;

import android.view.animation.Interpolator;

public class ViscousFluidInterpolator implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public static final float f29941a;

    /* renamed from: b  reason: collision with root package name */
    public static final float f29942b;

    static {
        float a11 = 1.0f / a(1.0f);
        f29941a = a11;
        f29942b = 1.0f - (a11 * a(1.0f));
    }

    public static float a(float f11) {
        float f12 = f11 * 8.0f;
        if (f12 < 1.0f) {
            return f12 - (1.0f - ((float) Math.exp((double) (-f12))));
        }
        return ((1.0f - ((float) Math.exp((double) (1.0f - f12)))) * 0.63212055f) + 0.36787945f;
    }

    public float getInterpolation(float f11) {
        float a11 = f29941a * a(f11);
        return a11 > 0.0f ? a11 + f29942b : a11;
    }
}
