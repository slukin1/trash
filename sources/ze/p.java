package ze;

import android.view.View;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.hbg.module.linear.swap.viewhandler.LinearSwapPositionOrderItemHandler;

public final /* synthetic */ class p implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapPositionOrderItem f62162b;

    public /* synthetic */ p(LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
        this.f62162b = linearSwapPositionOrderItem;
    }

    public final void onClick(View view) {
        LinearSwapPositionOrderItemHandler.A(this.f62162b, view);
    }
}
