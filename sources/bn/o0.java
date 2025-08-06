package bn;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter;

public final /* synthetic */ class o0 implements DialogUtils.b.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LinearSwapTradeBasePresenter.d0 f12841a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapPositionOrderItem f12842b;

    public /* synthetic */ o0(LinearSwapTradeBasePresenter.d0 d0Var, LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
        this.f12841a = d0Var;
        this.f12842b = linearSwapPositionOrderItem;
    }

    public final void a(HBDialogFragment hBDialogFragment) {
        this.f12841a.q(this.f12842b, hBDialogFragment);
    }
}
