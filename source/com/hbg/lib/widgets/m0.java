package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class m0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GesturePwdRippleView f72080b;

    public /* synthetic */ m0(GesturePwdRippleView gesturePwdRippleView) {
        this.f72080b = gesturePwdRippleView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72080b.k(valueAnimator);
    }
}
