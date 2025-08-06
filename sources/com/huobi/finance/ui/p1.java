package com.huobi.finance.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class p1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetFragment f47273b;

    public /* synthetic */ p1(BalanceAssetFragment balanceAssetFragment) {
        this.f47273b = balanceAssetFragment;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f47273b.Kj(valueAnimator);
    }
}
