package com.huawei.face.antispoofing.utils;

import android.view.animation.Interpolator;

public class SpringScaleInterpolator implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private float f37613a;

    public SpringScaleInterpolator(float f11) {
        this.f37613a = f11;
    }

    public float getInterpolation(float f11) {
        double pow = Math.pow(2.0d, (double) (-10.0f * f11));
        float f12 = this.f37613a;
        return (float) ((Math.sin((((double) (f11 - (f12 / 4.0f))) * 6.283185307179586d) / ((double) f12)) * pow) + 1.0d);
    }
}
