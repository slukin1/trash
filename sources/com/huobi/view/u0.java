package com.huobi.view;

import android.animation.ValueAnimator;
import android.widget.TextView;

public final /* synthetic */ class u0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f19113b;

    public /* synthetic */ u0(TextView textView) {
        this.f19113b = textView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f19113b.setTextSize(0, ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
