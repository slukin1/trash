package com.hbg.lib.widgets;

import android.animation.ValueAnimator;
import android.widget.ImageView;

public final /* synthetic */ class x implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageView f72432b;

    public /* synthetic */ x(ImageView imageView) {
        this.f72432b = imageView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f72432b.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
