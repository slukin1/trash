package st;

import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.tradenew.presenter.TradeVerticalSpotPresenter;
import rx.functions.Action1;

public final /* synthetic */ class o0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotPresenter f29231b;

    public /* synthetic */ o0(TradeVerticalSpotPresenter tradeVerticalSpotPresenter) {
        this.f29231b = tradeVerticalSpotPresenter;
    }

    public final void call(Object obj) {
        this.f29231b.h3((TradeRiskReminder) obj);
    }
}
