package oq;

import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.quicktrade.order.presenter.QuickTradeOrderVerticalSpotPresenter;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickTradeOrderVerticalSpotPresenter.a f58879b;

    public /* synthetic */ a(QuickTradeOrderVerticalSpotPresenter.a aVar) {
        this.f58879b = aVar;
    }

    public final void call(Object obj) {
        this.f58879b.c((BalanceDataTotal) obj);
    }
}
