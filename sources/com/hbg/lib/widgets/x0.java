package com.hbg.lib.widgets;

import android.animation.ValueAnimator;

public final /* synthetic */ class x0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LittlePieChartAnimView f72433b;

    public /* synthetic */ x0(LittlePieChartAnimView littlePieChartAnimView) {
        this.f72433b = littlePieChartAnimView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72433b.l(valueAnimator);
    }
}
