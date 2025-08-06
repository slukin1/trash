package com.huobi.finance.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class w9 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferActivity f47382b;

    public /* synthetic */ w9(UnifyTransferActivity unifyTransferActivity) {
        this.f47382b = unifyTransferActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f47382b.si(valueAnimator);
    }
}
