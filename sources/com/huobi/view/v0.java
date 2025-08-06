package com.huobi.view;

import android.animation.ValueAnimator;
import android.widget.TextView;

public final /* synthetic */ class v0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f19116b;

    public /* synthetic */ v0(TextView textView) {
        this.f19116b = textView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f19116b.setTextSize(0, ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
