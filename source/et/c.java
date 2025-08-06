package et;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.trade.presenter.TradeBasePresenter;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeBasePresenter f54425b;

    public /* synthetic */ c(TradeBasePresenter tradeBasePresenter) {
        this.f54425b = tradeBasePresenter;
    }

    public final void call(Object obj) {
        this.f54425b.j1((BalanceProfitLossData) obj);
    }
}
