package df;

import android.animation.ValueAnimator;
import com.hbg.module.livesquare.view.ParallaxLayout;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ParallaxLayout f53630b;

    public /* synthetic */ a(ParallaxLayout parallaxLayout) {
        this.f53630b = parallaxLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ParallaxLayout.o(this.f53630b, valueAnimator);
    }
}
