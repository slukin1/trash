package cn;

import android.animation.ValueAnimator;
import android.widget.RelativeLayout;
import com.huobi.linearswap.ui.LinearSwapPositionTradeDialogFragment;

public final /* synthetic */ class i0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapPositionTradeDialogFragment f13151b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RelativeLayout.LayoutParams f13152c;

    public /* synthetic */ i0(LinearSwapPositionTradeDialogFragment linearSwapPositionTradeDialogFragment, RelativeLayout.LayoutParams layoutParams) {
        this.f13151b = linearSwapPositionTradeDialogFragment;
        this.f13152c = layoutParams;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f13151b.wi(this.f13152c, valueAnimator);
    }
}
