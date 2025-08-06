package et;

import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.trade.presenter.TradeVerticalSpotPresenter;
import rx.functions.Action1;

public final /* synthetic */ class t implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotPresenter f54450b;

    public /* synthetic */ t(TradeVerticalSpotPresenter tradeVerticalSpotPresenter) {
        this.f54450b = tradeVerticalSpotPresenter;
    }

    public final void call(Object obj) {
        this.f54450b.c3((TradeRiskReminder) obj);
    }
}
