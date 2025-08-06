package bt;

import android.content.Context;
import android.view.View;
import com.huobi.trade.bean.TradeOrderHistory;
import com.huobi.trade.handler.TradeOrderHistoryHandler;

public final /* synthetic */ class j2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12922b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeOrderHistory f12923c;

    public /* synthetic */ j2(Context context, TradeOrderHistory tradeOrderHistory) {
        this.f12922b = context;
        this.f12923c = tradeOrderHistory;
    }

    public final void onClick(View view) {
        TradeOrderHistoryHandler.j(this.f12922b, this.f12923c, view);
    }
}
