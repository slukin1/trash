package kr;

import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GradientDrawable f57975b;

    public /* synthetic */ b(GradientDrawable gradientDrawable) {
        this.f57975b = gradientDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f57975b.setAlpha((int) (valueAnimator.getAnimatedFraction() * 255.0f));
    }
}
