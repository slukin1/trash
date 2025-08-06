package kr;

import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;

public final /* synthetic */ class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GradientDrawable f57977b;

    public /* synthetic */ d(GradientDrawable gradientDrawable) {
        this.f57977b = gradientDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f57977b.setAlpha((int) ((1.0f - valueAnimator.getAnimatedFraction()) * 255.0f));
    }
}
