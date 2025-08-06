package st;

import com.huobi.login.usercenter.data.source.bean.TradeRiskReminder;
import com.huobi.tradenew.presenter.TradeHorizontalSpotPresenter;
import rx.functions.Action1;

public final /* synthetic */ class q implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeHorizontalSpotPresenter f29234b;

    public /* synthetic */ q(TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter) {
        this.f29234b = tradeHorizontalSpotPresenter;
    }

    public final void call(Object obj) {
        this.f29234b.N2((TradeRiskReminder) obj);
    }
}
