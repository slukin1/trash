package rq;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.quicktrade.trade.presenter.QuickTradeBasePresenter;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickTradeBasePresenter f25781b;

    public /* synthetic */ a(QuickTradeBasePresenter quickTradeBasePresenter) {
        this.f25781b = quickTradeBasePresenter;
    }

    public final void call(Object obj) {
        this.f25781b.D0((BalanceProfitLossData) obj);
    }
}
