package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class k0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GesturePwdRippleView f72055b;

    public /* synthetic */ k0(GesturePwdRippleView gesturePwdRippleView) {
        this.f72055b = gesturePwdRippleView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72055b.m(valueAnimator);
    }
}
