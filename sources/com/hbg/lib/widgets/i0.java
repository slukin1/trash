package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class i0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GesturePwdRippleView f72048b;

    public /* synthetic */ i0(GesturePwdRippleView gesturePwdRippleView) {
        this.f72048b = gesturePwdRippleView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72048b.n(valueAnimator);
    }
}
