package bt;

import android.content.Context;
import android.view.View;
import com.huobi.order.bean.CurrentTimeTradeInfo;
import com.huobi.trade.handler.CurrentTimeOrderHandler;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrentTimeTradeInfo.a f12928b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CurrentTimeTradeInfo f12929c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f12930d;

    public /* synthetic */ l(CurrentTimeTradeInfo.a aVar, CurrentTimeTradeInfo currentTimeTradeInfo, Context context) {
        this.f12928b = aVar;
        this.f12929c = currentTimeTradeInfo;
        this.f12930d = context;
    }

    public final void onClick(View view) {
        CurrentTimeOrderHandler.f(this.f12928b, this.f12929c, this.f12930d, view);
    }
}
