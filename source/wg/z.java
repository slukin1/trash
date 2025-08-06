package wg;

import android.animation.ValueAnimator;
import com.huobi.account.widget.PrimeCountDownAnimView;

public final /* synthetic */ class z implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PrimeCountDownAnimView f61277b;

    public /* synthetic */ z(PrimeCountDownAnimView primeCountDownAnimView) {
        this.f61277b = primeCountDownAnimView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f61277b.n(valueAnimator);
    }
}
