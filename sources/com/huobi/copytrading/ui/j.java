package com.huobi.copytrading.ui;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f43693b;

    public /* synthetic */ j(View view) {
        this.f43693b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        CopyTradingMainActivity.Fh(this.f43693b, valueAnimator);
    }
}
