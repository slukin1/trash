package et;

import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.trade.presenter.TradeVerticalSpotPresenter;
import rx.functions.Action1;

public final /* synthetic */ class c0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotPresenter.i f54426b;

    public /* synthetic */ c0(TradeVerticalSpotPresenter.i iVar) {
        this.f54426b = iVar;
    }

    public final void call(Object obj) {
        this.f54426b.d((BalanceDataTotal) obj);
    }
}
