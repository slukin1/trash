package bt;

import android.content.Context;
import android.view.View;
import com.huobi.order.bean.CurrentTimeTradeInfo;
import com.huobi.trade.handler.CurrentTimeOrderHandler;

public final /* synthetic */ class n implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrentTimeTradeInfo.a f12942b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CurrentTimeTradeInfo f12943c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f12944d;

    public /* synthetic */ n(CurrentTimeTradeInfo.a aVar, CurrentTimeTradeInfo currentTimeTradeInfo, Context context) {
        this.f12942b = aVar;
        this.f12943c = currentTimeTradeInfo;
        this.f12944d = context;
    }

    public final void onClick(View view) {
        CurrentTimeOrderHandler.h(this.f12942b, this.f12943c, this.f12944d, view);
    }
}
