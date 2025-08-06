package rb;

import android.animation.ValueAnimator;
import com.hbg.lite.view.TradingHoseAnimatorView;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradingHoseAnimatorView f70526b;

    public /* synthetic */ c(TradingHoseAnimatorView tradingHoseAnimatorView) {
        this.f70526b = tradingHoseAnimatorView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f70526b.l(valueAnimator);
    }
}
