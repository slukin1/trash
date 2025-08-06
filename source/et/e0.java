package et;

import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.trade.presenter.TradeVerticalSpotPresenter;
import rx.functions.Action1;

public final /* synthetic */ class e0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotPresenter.j f54430b;

    public /* synthetic */ e0(TradeVerticalSpotPresenter.j jVar) {
        this.f54430b = jVar;
    }

    public final void call(Object obj) {
        this.f54430b.d((BalanceDataTotal) obj);
    }
}
