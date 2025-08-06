package ze;

import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.hbg.module.linear.swap.viewhandler.LinearSwapPositionOrderItemHandler;
import rx.functions.Action1;

public final /* synthetic */ class n implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapPositionOrderItem f62159b;

    public /* synthetic */ n(LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
        this.f62159b = linearSwapPositionOrderItem;
    }

    public final void call(Object obj) {
        LinearSwapPositionOrderItemHandler.E(this.f62159b, (Void) obj);
    }
}
