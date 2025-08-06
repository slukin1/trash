package et;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.trade.presenter.TradeBasePresenter;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeBasePresenter f54427b;

    public /* synthetic */ d(TradeBasePresenter tradeBasePresenter) {
        this.f54427b = tradeBasePresenter;
    }

    public final void call(Object obj) {
        this.f54427b.h1((APIStatusErrorException) obj);
    }
}
