package pt;

import android.content.Context;
import android.view.View;
import com.huobi.trade.bean.TradeOrderHistory;
import com.huobi.tradenew.handler.TradeOrderHistoryHandler;

public final /* synthetic */ class o implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f53245b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeOrderHistory f53246c;

    public /* synthetic */ o(Context context, TradeOrderHistory tradeOrderHistory) {
        this.f53245b = context;
        this.f53246c = tradeOrderHistory;
    }

    public final void onClick(View view) {
        TradeOrderHistoryHandler.i(this.f53245b, this.f53246c, view);
    }
}
