package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class f1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarqueeView f72033b;

    public /* synthetic */ f1(MarqueeView marqueeView) {
        this.f72033b = marqueeView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72033b.e(valueAnimator);
    }
}
