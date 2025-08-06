package com.hbg.lib.widgets;

import android.animation.ValueAnimator;
import com.hbg.lib.widgets.LittlePieChartAnimView;

public final /* synthetic */ class b1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LittlePieChartAnimView.a.C0786a f71751b;

    public /* synthetic */ b1(LittlePieChartAnimView.a.C0786a aVar) {
        this.f71751b = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f71751b.b(valueAnimator);
    }
}
