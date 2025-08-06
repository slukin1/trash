package ze;

import android.view.View;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.hbg.module.linear.swap.viewhandler.LinearSwapPositionOrderItemHandler;

public final /* synthetic */ class o implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f62160b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LinearSwapPositionOrderItem f62161c;

    public /* synthetic */ o(View view, LinearSwapPositionOrderItem linearSwapPositionOrderItem) {
        this.f62160b = view;
        this.f62161c = linearSwapPositionOrderItem;
    }

    public final void onClick(View view) {
        LinearSwapPositionOrderItemHandler.F(this.f62160b, this.f62161c, view);
    }
}
