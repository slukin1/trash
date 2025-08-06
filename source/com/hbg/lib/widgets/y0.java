package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class y0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LittlePieChartAnimView f72438b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f72439c;

    public /* synthetic */ y0(LittlePieChartAnimView littlePieChartAnimView, int i11) {
        this.f72438b = littlePieChartAnimView;
        this.f72439c = i11;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72438b.m(this.f72439c, valueAnimator);
    }
}
