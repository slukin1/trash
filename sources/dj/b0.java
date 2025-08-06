package dj;

import android.animation.ValueAnimator;
import android.widget.RelativeLayout;
import com.huobi.contract.ui.ContractPositionTradeDialogFragment;

public final /* synthetic */ class b0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractPositionTradeDialogFragment f53645b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RelativeLayout.LayoutParams f53646c;

    public /* synthetic */ b0(ContractPositionTradeDialogFragment contractPositionTradeDialogFragment, RelativeLayout.LayoutParams layoutParams) {
        this.f53645b = contractPositionTradeDialogFragment;
        this.f53646c = layoutParams;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f53645b.ti(this.f53646c, valueAnimator);
    }
}
