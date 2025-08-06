package ts;

import android.animation.ValueAnimator;
import android.widget.RelativeLayout;
import com.huobi.swap.ui.SwapPositionTradeDialogFragment;

public final /* synthetic */ class x implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapPositionTradeDialogFragment f60451b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RelativeLayout.LayoutParams f60452c;

    public /* synthetic */ x(SwapPositionTradeDialogFragment swapPositionTradeDialogFragment, RelativeLayout.LayoutParams layoutParams) {
        this.f60451b = swapPositionTradeDialogFragment;
        this.f60452c = layoutParams;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f60451b.si(this.f60452c, valueAnimator);
    }
}
