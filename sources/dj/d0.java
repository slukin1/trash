package dj;

import android.animation.ValueAnimator;
import android.widget.RelativeLayout;
import com.huobi.contract.ui.ContractPositionTradeDialogFragment;

public final /* synthetic */ class d0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractPositionTradeDialogFragment f53659b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RelativeLayout.LayoutParams f53660c;

    public /* synthetic */ d0(ContractPositionTradeDialogFragment contractPositionTradeDialogFragment, RelativeLayout.LayoutParams layoutParams) {
        this.f53659b = contractPositionTradeDialogFragment;
        this.f53660c = layoutParams;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f53659b.si(this.f53660c, valueAnimator);
    }
}
