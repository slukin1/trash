package pt;

import android.view.View;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.huobi.tradenew.handler.CurrentPlanOrderHandler;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrentPlanOrderHandler f53213b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AlgoOrderInfo f53214c;

    public /* synthetic */ a(CurrentPlanOrderHandler currentPlanOrderHandler, AlgoOrderInfo algoOrderInfo) {
        this.f53213b = currentPlanOrderHandler;
        this.f53214c = algoOrderInfo;
    }

    public final void onClick(View view) {
        this.f53213b.g(this.f53214c, view);
    }
}
