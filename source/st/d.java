package st;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.tradenew.presenter.TradeBasePresenter;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeBasePresenter f29206b;

    public /* synthetic */ d(TradeBasePresenter tradeBasePresenter) {
        this.f29206b = tradeBasePresenter;
    }

    public final void call(Object obj) {
        this.f29206b.p1((APIStatusErrorException) obj);
    }
}
