package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ClipScaleLayout f72031b;

    public /* synthetic */ f(ClipScaleLayout clipScaleLayout) {
        this.f72031b = clipScaleLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72031b.b(valueAnimator);
    }
}
