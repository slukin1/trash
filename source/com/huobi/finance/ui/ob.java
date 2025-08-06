package com.huobi.finance.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class ob implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UsdtExchangeActivity f47270b;

    public /* synthetic */ ob(UsdtExchangeActivity usdtExchangeActivity) {
        this.f47270b = usdtExchangeActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f47270b.yh(valueAnimator);
    }
}
