package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class w0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KlineCountDownAnimView f72430b;

    public /* synthetic */ w0(KlineCountDownAnimView klineCountDownAnimView) {
        this.f72430b = klineCountDownAnimView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72430b.n(valueAnimator);
    }
}
