package bn;

import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.huobi.linearswap.presenter.LinearSwapTradeBasePresenter;

public final /* synthetic */ class p0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapTradeBasePresenter.d0 f12844b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LinearSwapPositionOrderItem f12845c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ DialogUtils.b f12846d;

    public /* synthetic */ p0(LinearSwapTradeBasePresenter.d0 d0Var, LinearSwapPositionOrderItem linearSwapPositionOrderItem, DialogUtils.b bVar) {
        this.f12844b = d0Var;
        this.f12845c = linearSwapPositionOrderItem;
        this.f12846d = bVar;
    }

    public final void run() {
        this.f12844b.s(this.f12845c, this.f12846d);
    }
}
