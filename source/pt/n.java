package pt;

import android.content.Context;
import android.view.View;
import com.huobi.trade.bean.TradeOrderHistory;
import com.huobi.tradenew.handler.TradeOrderHistoryHandler;

public final /* synthetic */ class n implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f53243b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeOrderHistory f53244c;

    public /* synthetic */ n(Context context, TradeOrderHistory tradeOrderHistory) {
        this.f53243b = context;
        this.f53244c = tradeOrderHistory;
    }

    public final void onClick(View view) {
        TradeOrderHistoryHandler.g(this.f53243b, this.f53244c, view);
    }
}
