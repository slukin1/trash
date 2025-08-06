package com.hbg.module.kline.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractKlineActivity f24146b;

    public /* synthetic */ a(AbstractKlineActivity abstractKlineActivity) {
        this.f24146b = abstractKlineActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f24146b.mi(valueAnimator);
    }
}
