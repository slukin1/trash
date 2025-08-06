package xg;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.activity.FutureTradeContainerActivity;
import com.huobi.main.trade.ui.SymbolSelectionFragment;

public final /* synthetic */ class s implements SymbolSelectionFragment.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FutureTradeContainerActivity f61582a;

    public /* synthetic */ s(FutureTradeContainerActivity futureTradeContainerActivity) {
        this.f61582a = futureTradeContainerActivity;
    }

    public final void a(TradeType tradeType, String str, Object obj) {
        this.f61582a.Zf(tradeType, str, obj);
    }
}
