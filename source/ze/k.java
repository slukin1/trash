package ze;

import android.content.Context;
import android.view.View;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.hbg.module.linear.swap.viewhandler.LinearSwapPositionOrderItemHandler;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapPositionOrderItemHandler f62150b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ LinearSwapPosition f62151c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f62152d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f62153e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f62154f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LinearSwapPositionOrderItem f62155g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FutureContractInfo f62156h;

    public /* synthetic */ k(LinearSwapPositionOrderItemHandler linearSwapPositionOrderItemHandler, LinearSwapPosition linearSwapPosition, int i11, Context context, String str, LinearSwapPositionOrderItem linearSwapPositionOrderItem, FutureContractInfo futureContractInfo) {
        this.f62150b = linearSwapPositionOrderItemHandler;
        this.f62151c = linearSwapPosition;
        this.f62152d = i11;
        this.f62153e = context;
        this.f62154f = str;
        this.f62155g = linearSwapPositionOrderItem;
        this.f62156h = futureContractInfo;
    }

    public final void onClick(View view) {
        this.f62150b.z(this.f62151c, this.f62152d, this.f62153e, this.f62154f, this.f62155g, this.f62156h, view);
    }
}
