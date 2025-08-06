package pt;

import android.view.View;
import com.huobi.trade.bean.TradeSymbolChangeItem;
import com.huobi.tradenew.handler.TradeSymbolChangeViewHandler;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeSymbolChangeItem f53249b;

    public /* synthetic */ q(TradeSymbolChangeItem tradeSymbolChangeItem) {
        this.f53249b = tradeSymbolChangeItem;
    }

    public final void onClick(View view) {
        TradeSymbolChangeViewHandler.d(this.f53249b, view);
    }
}
