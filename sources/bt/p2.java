package bt;

import android.view.View;
import com.huobi.trade.bean.TradeSymbolChangeItem;
import com.huobi.trade.handler.TradeSymbolChangeViewHandler;

public final /* synthetic */ class p2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeSymbolChangeItem f12960b;

    public /* synthetic */ p2(TradeSymbolChangeItem tradeSymbolChangeItem) {
        this.f12960b = tradeSymbolChangeItem;
    }

    public final void onClick(View view) {
        TradeSymbolChangeViewHandler.d(this.f12960b, view);
    }
}
