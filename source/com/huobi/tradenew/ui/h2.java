package com.huobi.tradenew.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class h2 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeTopTabItemView f83417b;

    public /* synthetic */ h2(TradeTopTabItemView tradeTopTabItemView) {
        this.f83417b = tradeTopTabItemView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f83417b.e(valueAnimator);
    }
}
