package rq;

import com.huobi.quicktrade.trade.presenter.QuickTradeVerticalSpotPresenter;
import rx.functions.Func1;

public final /* synthetic */ class g implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f25788b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f25789c;

    public /* synthetic */ g(String str, String str2) {
        this.f25788b = str;
        this.f25789c = str2;
    }

    public final Object call(Object obj) {
        return QuickTradeVerticalSpotPresenter.u1(this.f25788b, this.f25789c, (Long) obj);
    }
}
