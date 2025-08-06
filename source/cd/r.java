package cd;

import android.animation.ValueAnimator;
import com.hbg.module.exchange.grid.ui.GridTradeHandView;

public final /* synthetic */ class r implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GridTradeHandView f13061b;

    public /* synthetic */ r(GridTradeHandView gridTradeHandView) {
        this.f13061b = gridTradeHandView;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f13061b.C(valueAnimator);
    }
}
