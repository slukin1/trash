package st;

import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.tradenew.presenter.TradeHorizontalSpotPresenter;
import rx.functions.Action1;

public final /* synthetic */ class f0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeHorizontalSpotPresenter.n f29211b;

    public /* synthetic */ f0(TradeHorizontalSpotPresenter.n nVar) {
        this.f29211b = nVar;
    }

    public final void call(Object obj) {
        this.f29211b.d((BalanceDataTotal) obj);
    }
}
