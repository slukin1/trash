package bt;

import android.view.View;
import com.huobi.trade.bean.TradeOrderOutstanding;
import com.huobi.trade.handler.TradeOrderOutstandingHandler;

public final /* synthetic */ class k2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeOrderOutstandingHandler f12926b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeOrderOutstanding f12927c;

    public /* synthetic */ k2(TradeOrderOutstandingHandler tradeOrderOutstandingHandler, TradeOrderOutstanding tradeOrderOutstanding) {
        this.f12926b = tradeOrderOutstandingHandler;
        this.f12927c = tradeOrderOutstanding;
    }

    public final void onClick(View view) {
        this.f12926b.d(this.f12927c, view);
    }
}
