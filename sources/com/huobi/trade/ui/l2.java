package com.huobi.trade.ui;

import android.animation.ValueAnimator;

public final /* synthetic */ class l2 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeTopTabItemView f82665b;

    public /* synthetic */ l2(TradeTopTabItemView tradeTopTabItemView) {
        this.f82665b = tradeTopTabItemView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f82665b.e(valueAnimator);
    }
}
