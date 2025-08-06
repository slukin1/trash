package st;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.tradenew.presenter.TradeBasePresenter;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeBasePresenter f29203b;

    public /* synthetic */ c(TradeBasePresenter tradeBasePresenter) {
        this.f29203b = tradeBasePresenter;
    }

    public final void call(Object obj) {
        this.f29203b.j1((BalanceProfitLossData) obj);
    }
}
