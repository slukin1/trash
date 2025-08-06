package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class k1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PrimeCountDownAnimView f72056b;

    public /* synthetic */ k1(PrimeCountDownAnimView primeCountDownAnimView) {
        this.f72056b = primeCountDownAnimView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72056b.n(valueAnimator);
    }
}
