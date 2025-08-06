package com.iproov.sdk.ui.views;

import android.animation.ValueAnimator;
import com.iproov.sdk.ui.views.HovalayView;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HovalayView f38883b;

    public /* synthetic */ b(HovalayView hovalayView) {
        this.f38883b = hovalayView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        HovalayView.Cfor.m2187do(this.f38883b, valueAnimator);
    }
}
