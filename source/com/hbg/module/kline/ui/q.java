package com.hbg.module.kline.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class q implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractKlineFragment f24254b;

    public /* synthetic */ q(AbstractKlineFragment abstractKlineFragment) {
        this.f24254b = abstractKlineFragment;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f24254b.Ii(valueAnimator);
    }
}
