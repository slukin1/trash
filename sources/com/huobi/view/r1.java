package com.huobi.view;

import android.animation.ValueAnimator;
import android.widget.TextView;

public final /* synthetic */ class r1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TextView f19101b;

    public /* synthetic */ r1(TextView textView) {
        this.f19101b = textView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f19101b.setTextSize(0, ((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
