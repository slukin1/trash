package st;

import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.tradenew.presenter.TradeHorizontalSpotPresenter;
import rx.functions.Action1;

public final /* synthetic */ class z implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeHorizontalSpotPresenter.a f29255b;

    public /* synthetic */ z(TradeHorizontalSpotPresenter.a aVar) {
        this.f29255b = aVar;
    }

    public final void call(Object obj) {
        this.f29255b.d((BalanceDataTotal) obj);
    }
}
