package com.hbg.lib.widgets;

import android.animation.ValueAnimator;
import com.hbg.lib.widgets.LittlePieChartAnimView;

public final /* synthetic */ class z0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LittlePieChartAnimView.a f72442b;

    public /* synthetic */ z0(LittlePieChartAnimView.a aVar) {
        this.f72442b = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72442b.d(valueAnimator);
    }
}
