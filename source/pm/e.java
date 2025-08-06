package pm;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.kline.presenter.MarketInfoPresenter;
import com.huobi.main.trade.ui.TradeDialogFragment;
import pm.j;
import s9.a;

public final /* synthetic */ class e implements TradeDialogFragment.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MarketInfoPresenter.e f53175a;

    public /* synthetic */ e(MarketInfoPresenter.e eVar) {
        this.f53175a = eVar;
    }

    public final void a(TradeType tradeType, a aVar) {
        j.a.S(this.f53175a, tradeType, aVar);
    }
}
