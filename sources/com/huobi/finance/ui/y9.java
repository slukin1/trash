package com.huobi.finance.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class y9 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferActivity f47415b;

    public /* synthetic */ y9(UnifyTransferActivity unifyTransferActivity) {
        this.f47415b = unifyTransferActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f47415b.ri(valueAnimator);
    }
}
