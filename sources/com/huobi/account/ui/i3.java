package com.huobi.account.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class i3 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecuritySetActivity f41711b;

    public /* synthetic */ i3(SecuritySetActivity securitySetActivity) {
        this.f41711b = securitySetActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f41711b.Nh(valueAnimator);
    }
}
