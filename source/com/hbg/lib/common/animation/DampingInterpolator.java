package com.hbg.lib.common.animation;

import android.view.animation.Interpolator;

public class DampingInterpolator implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public float f67411a = 1.2f;

    /* renamed from: b  reason: collision with root package name */
    public float f67412b = 2.0794f;

    /* renamed from: c  reason: collision with root package name */
    public float f67413c = 1.38047f;

    /* renamed from: d  reason: collision with root package name */
    public float f67414d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f67415e = 0.0f;

    public float getInterpolation(float f11) {
        double pow = ((double) this.f67413c) * Math.pow(2.718281828459045d, (double) ((-this.f67412b) * f11)) * Math.sin(((double) this.f67411a) * 6.283185307179586d * ((double) f11));
        float f12 = (float) pow;
        if (this.f67415e < f12 && pow > 1.0d) {
            this.f67415e = f12;
            this.f67414d = f11;
        }
        return f12;
    }
}
