package bt;

import android.content.Context;
import android.view.View;
import com.huobi.trade.bean.TradeOrderHistory;
import com.huobi.trade.handler.TradeOrderHistoryHandler;

public final /* synthetic */ class i2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12916b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeOrderHistory f12917c;

    public /* synthetic */ i2(Context context, TradeOrderHistory tradeOrderHistory) {
        this.f12916b = context;
        this.f12917c = tradeOrderHistory;
    }

    public final void onClick(View view) {
        TradeOrderHistoryHandler.h(this.f12916b, this.f12917c, view);
    }
}
