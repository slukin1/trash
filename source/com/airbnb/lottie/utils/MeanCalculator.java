package com.airbnb.lottie.utils;

public class MeanCalculator {

    /* renamed from: n  reason: collision with root package name */
    private int f14041n;
    private float sum;

    public void add(float f11) {
        float f12 = this.sum + f11;
        this.sum = f12;
        int i11 = this.f14041n + 1;
        this.f14041n = i11;
        if (i11 == Integer.MAX_VALUE) {
            this.sum = f12 / 2.0f;
            this.f14041n = i11 / 2;
        }
    }

    public float getMean() {
        int i11 = this.f14041n;
        if (i11 == 0) {
            return 0.0f;
        }
        return this.sum / ((float) i11);
    }
}
