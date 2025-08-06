package bt;

import android.content.Context;
import android.view.View;
import com.huobi.trade.bean.TradeOrderHistory;
import com.huobi.trade.handler.TradeOrderHistoryHandler;

public final /* synthetic */ class h2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12910b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeOrderHistory f12911c;

    public /* synthetic */ h2(Context context, TradeOrderHistory tradeOrderHistory) {
        this.f12910b = context;
        this.f12911c = tradeOrderHistory;
    }

    public final void onClick(View view) {
        TradeOrderHistoryHandler.i(this.f12910b, this.f12911c, view);
    }
}
