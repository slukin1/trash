package rq;

import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.quicktrade.trade.presenter.QuickTradeVerticalSpotPresenter;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickTradeVerticalSpotPresenter f25785b;

    public /* synthetic */ d(QuickTradeVerticalSpotPresenter quickTradeVerticalSpotPresenter) {
        this.f25785b = quickTradeVerticalSpotPresenter;
    }

    public final void call(Object obj) {
        this.f25785b.t1((TradeRiskReminder) obj);
    }
}
