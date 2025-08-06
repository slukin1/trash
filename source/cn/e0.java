package cn;

import android.animation.ValueAnimator;
import android.widget.RelativeLayout;
import com.huobi.linearswap.ui.LinearSwapPositionTradeDialogFragment;

public final /* synthetic */ class e0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapPositionTradeDialogFragment f13132b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RelativeLayout.LayoutParams f13133c;

    public /* synthetic */ e0(LinearSwapPositionTradeDialogFragment linearSwapPositionTradeDialogFragment, RelativeLayout.LayoutParams layoutParams) {
        this.f13132b = linearSwapPositionTradeDialogFragment;
        this.f13133c = layoutParams;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f13132b.vi(this.f13133c, valueAnimator);
    }
}
