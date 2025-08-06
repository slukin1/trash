package com.huobi.finance.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class o5 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HtExchangeActivity f47263b;

    public /* synthetic */ o5(HtExchangeActivity htExchangeActivity) {
        this.f47263b = htExchangeActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f47263b.Ch(valueAnimator);
    }
}
