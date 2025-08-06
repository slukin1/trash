package ze;

import android.view.View;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.hbg.module.linear.swap.viewhandler.LinearSwapPositionOrderItemHandler;

public final /* synthetic */ class w implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapPositionOrderItem f62169b;

    public /* synthetic */ w(LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
        this.f62169b = linearSwapPositionOrderItem;
    }

    public final void onClick(View view) {
        LinearSwapPositionOrderItemHandler.w(this.f62169b, view);
    }
}
