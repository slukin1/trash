package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class j0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GesturePwdRippleView f72052b;

    public /* synthetic */ j0(GesturePwdRippleView gesturePwdRippleView) {
        this.f72052b = gesturePwdRippleView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72052b.j(valueAnimator);
    }
}
