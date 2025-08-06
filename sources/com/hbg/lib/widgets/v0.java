package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class v0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KlineCountDownAnimView f72427b;

    public /* synthetic */ v0(KlineCountDownAnimView klineCountDownAnimView) {
        this.f72427b = klineCountDownAnimView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72427b.o(valueAnimator);
    }
}
