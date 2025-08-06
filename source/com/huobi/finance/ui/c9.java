package com.huobi.finance.ui;

import android.animation.ValueAnimator;
import android.widget.FrameLayout;

public final /* synthetic */ class c9 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyStableCurrencyExchangeDialog f47076b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FrameLayout.LayoutParams f47077c;

    public /* synthetic */ c9(UnifyStableCurrencyExchangeDialog unifyStableCurrencyExchangeDialog, FrameLayout.LayoutParams layoutParams) {
        this.f47076b = unifyStableCurrencyExchangeDialog;
        this.f47077c = layoutParams;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f47076b.Xh(this.f47077c, valueAnimator);
    }
}
