package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class g implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ClosePathFloatView f72039b;

    public /* synthetic */ g(ClosePathFloatView closePathFloatView) {
        this.f72039b = closePathFloatView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72039b.e(valueAnimator);
    }
}
