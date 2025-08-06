package rb;

import android.animation.ValueAnimator;
import com.hbg.lite.view.TradingHoseAnimatorView;

public final /* synthetic */ class e implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradingHoseAnimatorView f70528b;

    public /* synthetic */ e(TradingHoseAnimatorView tradingHoseAnimatorView) {
        this.f70528b = tradingHoseAnimatorView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f70528b.m(valueAnimator);
    }
}
