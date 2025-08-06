package vp;

import android.animation.ValueAnimator;
import com.huobi.otc.widget.CouponCountDownView;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CouponCountDownView f61134b;

    public /* synthetic */ c(CouponCountDownView couponCountDownView) {
        this.f61134b = couponCountDownView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f61134b.i(valueAnimator);
    }
}
