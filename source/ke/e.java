package ke;

import android.animation.ValueAnimator;
import com.hbg.module.libkt.custom.SemicircleProgressView;

public final /* synthetic */ class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SemicircleProgressView f56564b;

    public /* synthetic */ e(SemicircleProgressView semicircleProgressView) {
        this.f56564b = semicircleProgressView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SemicircleProgressView.f(this.f56564b, valueAnimator);
    }
}
