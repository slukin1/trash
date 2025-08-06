package kr;

import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GradientDrawable f57976b;

    public /* synthetic */ c(GradientDrawable gradientDrawable) {
        this.f57976b = gradientDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f57976b.setAlpha((int) (valueAnimator.getAnimatedFraction() * 255.0f));
    }
}
