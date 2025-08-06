package com.huobi.finance.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class l9 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferActivity f47224b;

    public /* synthetic */ l9(UnifyTransferActivity unifyTransferActivity) {
        this.f47224b = unifyTransferActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f47224b.ai(valueAnimator);
    }
}
