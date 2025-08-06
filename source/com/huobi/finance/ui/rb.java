package com.huobi.finance.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class rb implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UsdtExchangeActivity f47313b;

    public /* synthetic */ rb(UsdtExchangeActivity usdtExchangeActivity) {
        this.f47313b = usdtExchangeActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f47313b.Ch(valueAnimator);
    }
}
