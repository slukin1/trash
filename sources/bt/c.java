package bt;

import android.view.View;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.huobi.trade.handler.CurrentPlanOrderHandler;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrentPlanOrderHandler f12881b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AlgoOrderInfo f12882c;

    public /* synthetic */ c(CurrentPlanOrderHandler currentPlanOrderHandler, AlgoOrderInfo algoOrderInfo) {
        this.f12881b = currentPlanOrderHandler;
        this.f12882c = algoOrderInfo;
    }

    public final void onClick(View view) {
        this.f12881b.g(this.f12882c, view);
    }
}
