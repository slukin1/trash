package com.huobi.finance.ui;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;

public final /* synthetic */ class s8 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyStableCurrencyExchangeDialog f47323b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FrameLayout.LayoutParams f47324c;

    public /* synthetic */ s8(UnifyStableCurrencyExchangeDialog unifyStableCurrencyExchangeDialog, FrameLayout.LayoutParams layoutParams) {
        this.f47323b = unifyStableCurrencyExchangeDialog;
        this.f47324c = layoutParams;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f47323b.Zh(this.f47324c, valueAnimator);
    }
}
