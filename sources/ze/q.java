package ze;

import android.view.View;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.hbg.module.linear.swap.viewhandler.LinearSwapPositionOrderItemHandler;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapPositionOrderItem f62163b;

    public /* synthetic */ q(LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
        this.f62163b = linearSwapPositionOrderItem;
    }

    public final void onClick(View view) {
        LinearSwapPositionOrderItemHandler.u(this.f62163b, view);
    }
}
