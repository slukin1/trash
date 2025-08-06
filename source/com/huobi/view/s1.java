package com.huobi.view;

import android.animation.ValueAnimator;
import android.widget.TextView;

public final /* synthetic */ class s1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f19105b;

    public /* synthetic */ s1(TextView textView) {
        this.f19105b = textView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f19105b.setTextSize(0, ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
