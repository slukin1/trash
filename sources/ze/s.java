package ze;

import android.view.View;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.hbg.module.linear.swap.viewhandler.LinearSwapPositionOrderItemHandler;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapPositionOrderItem f62165b;

    public /* synthetic */ s(LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
        this.f62165b = linearSwapPositionOrderItem;
    }

    public final void onClick(View view) {
        LinearSwapPositionOrderItemHandler.v(this.f62165b, view);
    }
}
