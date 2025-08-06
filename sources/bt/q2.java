package bt;

import android.view.View;
import com.huobi.trade.bean.TradingBotSelectMarketInfo;
import com.huobi.trade.handler.TradingBotSelectMarketItemHandler;

public final /* synthetic */ class q2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradingBotSelectMarketInfo f12966b;

    public /* synthetic */ q2(TradingBotSelectMarketInfo tradingBotSelectMarketInfo) {
        this.f12966b = tradingBotSelectMarketInfo;
    }

    public final void onClick(View view) {
        TradingBotSelectMarketItemHandler.e(this.f12966b, view);
    }
}
