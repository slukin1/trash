package com.hbg.lib.widgets;

import android.animation.ValueAnimator;
import com.hbg.lib.widgets.LittlePieChartAnimView;

public final /* synthetic */ class a1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LittlePieChartAnimView.a f71731b;

    public /* synthetic */ a1(LittlePieChartAnimView.a aVar) {
        this.f71731b = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f71731b.c(valueAnimator);
    }
}
