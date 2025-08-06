package com.iproov.sdk.ui.views;

import android.animation.ValueAnimator;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ShimmeringImageView f38884b;

    public /* synthetic */ c(ShimmeringImageView shimmeringImageView) {
        this.f38884b = shimmeringImageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ShimmeringImageView.m2225do(this.f38884b, valueAnimator);
    }
}
