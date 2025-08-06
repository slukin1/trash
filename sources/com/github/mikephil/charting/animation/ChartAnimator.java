package com.github.mikephil.charting.animation;

import android.animation.ValueAnimator;

public class ChartAnimator {

    /* renamed from: a  reason: collision with root package name */
    public ValueAnimator.AnimatorUpdateListener f65330a;

    /* renamed from: b  reason: collision with root package name */
    public float f65331b = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f65332c = 1.0f;

    public ChartAnimator() {
    }

    public float a() {
        return this.f65332c;
    }

    public float b() {
        return this.f65331b;
    }

    public ChartAnimator(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f65330a = animatorUpdateListener;
    }
}
