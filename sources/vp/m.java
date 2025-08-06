package vp;

import android.animation.ValueAnimator;
import com.huobi.otc.widget.FAQGestureFrameLayout;

public final /* synthetic */ class m implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FAQGestureFrameLayout f61159b;

    public /* synthetic */ m(FAQGestureFrameLayout fAQGestureFrameLayout) {
        this.f61159b = fAQGestureFrameLayout;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f61159b.i(valueAnimator);
    }
}
