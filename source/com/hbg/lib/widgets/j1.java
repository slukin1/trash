package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class j1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PrimeCountDownAnimView f72053b;

    public /* synthetic */ j1(PrimeCountDownAnimView primeCountDownAnimView) {
        this.f72053b = primeCountDownAnimView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72053b.o(valueAnimator);
    }
}
