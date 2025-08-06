package com.huobi.view;

import android.animation.ValueAnimator;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AnimTradeMenuView f19004b;

    public /* synthetic */ c(AnimTradeMenuView animTradeMenuView) {
        this.f19004b = animTradeMenuView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f19004b.lambda$init$1(valueAnimator);
    }
}
