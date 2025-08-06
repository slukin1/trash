package wg;

import android.animation.ValueAnimator;
import com.huobi.account.widget.PrimeCountDownAnimView;

public final /* synthetic */ class y implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PrimeCountDownAnimView f61276b;

    public /* synthetic */ y(PrimeCountDownAnimView primeCountDownAnimView) {
        this.f61276b = primeCountDownAnimView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f61276b.o(valueAnimator);
    }
}
