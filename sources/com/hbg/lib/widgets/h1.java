package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class h1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NumAnimTextView f72045b;

    public /* synthetic */ h1(NumAnimTextView numAnimTextView) {
        this.f72045b = numAnimTextView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72045b.h(valueAnimator);
    }
}
