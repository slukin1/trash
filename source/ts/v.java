package ts;

import android.animation.ValueAnimator;
import android.widget.RelativeLayout;
import com.huobi.swap.ui.SwapPositionTradeDialogFragment;

public final /* synthetic */ class v implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapPositionTradeDialogFragment f60440b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RelativeLayout.LayoutParams f60441c;

    public /* synthetic */ v(SwapPositionTradeDialogFragment swapPositionTradeDialogFragment, RelativeLayout.LayoutParams layoutParams) {
        this.f60440b = swapPositionTradeDialogFragment;
        this.f60441c = layoutParams;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f60440b.ti(this.f60441c, valueAnimator);
    }
}
