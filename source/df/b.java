package df;

import android.animation.ValueAnimator;
import com.hbg.module.livesquare.view.ParallaxLayout;

public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ParallaxLayout f53631b;

    public /* synthetic */ b(ParallaxLayout parallaxLayout) {
        this.f53631b = parallaxLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ParallaxLayout.p(this.f53631b, valueAnimator);
    }
}
