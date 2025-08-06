package kr;

import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GradientDrawable f57974b;

    public /* synthetic */ a(GradientDrawable gradientDrawable) {
        this.f57974b = gradientDrawable;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f57974b.setAlpha((int) ((1.0f - valueAnimator.getAnimatedFraction()) * 255.0f));
    }
}
