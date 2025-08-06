package com.huobi.index.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class f implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexFragment f73888b;

    public /* synthetic */ f(IndexFragment indexFragment) {
        this.f73888b = indexFragment;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f73888b.Wk(valueAnimator);
    }
}
