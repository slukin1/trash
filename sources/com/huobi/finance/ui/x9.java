package com.huobi.finance.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class x9 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyTransferActivity f47401b;

    public /* synthetic */ x9(UnifyTransferActivity unifyTransferActivity) {
        this.f47401b = unifyTransferActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f47401b.ti(valueAnimator);
    }
}
