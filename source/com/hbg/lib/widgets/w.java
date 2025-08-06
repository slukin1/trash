package com.hbg.lib.widgets;

import android.animation.ValueAnimator;
import android.widget.ImageView;

public final /* synthetic */ class w implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageView f72429b;

    public /* synthetic */ w(ImageView imageView) {
        this.f72429b = imageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72429b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
