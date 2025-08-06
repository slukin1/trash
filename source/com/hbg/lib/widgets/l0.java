package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class l0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GesturePwdRippleView f72058b;

    public /* synthetic */ l0(GesturePwdRippleView gesturePwdRippleView) {
        this.f72058b = gesturePwdRippleView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72058b.l(valueAnimator);
    }
}
