package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonCornerTabLayout f72051b;

    public /* synthetic */ j(CommonCornerTabLayout commonCornerTabLayout) {
        this.f72051b = commonCornerTabLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72051b.f(valueAnimator);
    }
}
