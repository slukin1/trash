package rb;

import android.animation.ValueAnimator;
import com.hbg.lite.view.TradingHoseAnimatorView;

public final /* synthetic */ class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradingHoseAnimatorView f70527b;

    public /* synthetic */ d(TradingHoseAnimatorView tradingHoseAnimatorView) {
        this.f70527b = tradingHoseAnimatorView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f70527b.n(valueAnimator);
    }
}
