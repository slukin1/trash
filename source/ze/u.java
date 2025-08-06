package ze;

import android.view.View;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.hbg.module.linear.swap.viewhandler.LinearSwapPositionOrderItemHandler;

public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapPositionOrderItem f62167b;

    public /* synthetic */ u(LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
        this.f62167b = linearSwapPositionOrderItem;
    }

    public final void onClick(View view) {
        LinearSwapPositionOrderItemHandler.C(this.f62167b, view);
    }
}
