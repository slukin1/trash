package st;

import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.tradenew.presenter.TradeHorizontalSpotPresenter;
import rx.functions.Action1;

public final /* synthetic */ class b0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeHorizontalSpotPresenter.l f29201b;

    public /* synthetic */ b0(TradeHorizontalSpotPresenter.l lVar) {
        this.f29201b = lVar;
    }

    public final void call(Object obj) {
        this.f29201b.d((BalanceDataTotal) obj);
    }
}
