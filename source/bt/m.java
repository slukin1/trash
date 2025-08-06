package bt;

import android.content.Context;
import android.view.View;
import com.huobi.order.bean.CurrentTimeTradeInfo;
import com.huobi.trade.handler.CurrentTimeOrderHandler;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CurrentTimeTradeInfo.a f12935b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CurrentTimeTradeInfo f12936c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f12937d;

    public /* synthetic */ m(CurrentTimeTradeInfo.a aVar, CurrentTimeTradeInfo currentTimeTradeInfo, Context context) {
        this.f12935b = aVar;
        this.f12936c = currentTimeTradeInfo;
        this.f12937d = context;
    }

    public final void onClick(View view) {
        CurrentTimeOrderHandler.g(this.f12935b, this.f12936c, this.f12937d, view);
    }
}
