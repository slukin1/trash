package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class p implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CommonHorizontalSelectorView f72113b;

    public /* synthetic */ p(CommonHorizontalSelectorView commonHorizontalSelectorView) {
        this.f72113b = commonHorizontalSelectorView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72113b.b(valueAnimator);
    }
}
