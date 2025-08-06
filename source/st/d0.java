package st;

import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.tradenew.presenter.TradeHorizontalSpotPresenter;
import rx.functions.Action1;

public final /* synthetic */ class d0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeHorizontalSpotPresenter.m f29207b;

    public /* synthetic */ d0(TradeHorizontalSpotPresenter.m mVar) {
        this.f29207b = mVar;
    }

    public final void call(Object obj) {
        this.f29207b.d((BalanceDataTotal) obj);
    }
}
