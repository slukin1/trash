package com.iproov.sdk.ui.views;

import android.animation.ValueAnimator;
import com.iproov.sdk.ui.views.HovalayView;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HovalayView f38882b;

    public /* synthetic */ a(HovalayView hovalayView) {
        this.f38882b = hovalayView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        HovalayView.Cfor.m2189if(this.f38882b, valueAnimator);
    }
}
