package et;

import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.trade.presenter.TradeVerticalSpotPresenter;
import rx.functions.Action1;

public final /* synthetic */ class a0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotPresenter.h f54422b;

    public /* synthetic */ a0(TradeVerticalSpotPresenter.h hVar) {
        this.f54422b = hVar;
    }

    public final void call(Object obj) {
        this.f54422b.d((BalanceDataTotal) obj);
    }
}
