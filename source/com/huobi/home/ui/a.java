package com.huobi.home.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f72548b;

    public /* synthetic */ a(HomeFragment homeFragment) {
        this.f72548b = homeFragment;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        HomeFragment.ni(this.f72548b, valueAnimator);
    }
}
