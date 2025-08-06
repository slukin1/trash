package hb;

import android.animation.ValueAnimator;
import com.hbg.lite.market.widget.LiteTradingView;

public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiteTradingView f54914b;

    public /* synthetic */ c(LiteTradingView liteTradingView) {
        this.f54914b = liteTradingView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f54914b.E(valueAnimator);
    }
}
