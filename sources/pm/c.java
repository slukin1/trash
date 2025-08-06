package pm;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.kline.presenter.MarketInfoPresenter;
import com.huobi.main.trade.ui.SymbolSelectionFragment;
import pm.j;

public final /* synthetic */ class c implements SymbolSelectionFragment.f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MarketInfoPresenter.e f53173a;

    public /* synthetic */ c(MarketInfoPresenter.e eVar) {
        this.f53173a = eVar;
    }

    public final void a(TradeType tradeType, String str, Object obj) {
        j.a.T(this.f53173a, tradeType, str, obj);
    }
}
