package com.huobi.finance.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class a2 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BalanceAssetFragment f47038b;

    public /* synthetic */ a2(BalanceAssetFragment balanceAssetFragment) {
        this.f47038b = balanceAssetFragment;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f47038b.bk(valueAnimator);
    }
}
