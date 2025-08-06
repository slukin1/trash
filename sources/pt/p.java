package pt;

import android.content.Context;
import android.view.View;
import com.huobi.trade.bean.TradeOrderHistory;
import com.huobi.tradenew.handler.TradeOrderHistoryHandler;

public final /* synthetic */ class p implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f53247b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeOrderHistory f53248c;

    public /* synthetic */ p(Context context, TradeOrderHistory tradeOrderHistory) {
        this.f53247b = context;
        this.f53248c = tradeOrderHistory;
    }

    public final void onClick(View view) {
        TradeOrderHistoryHandler.h(this.f53247b, this.f53248c, view);
    }
}
