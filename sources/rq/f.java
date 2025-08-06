package rq;

import com.huobi.quicktrade.trade.presenter.QuickTradeVerticalSpotPresenter;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class f implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickTradeVerticalSpotPresenter f25787b;

    public /* synthetic */ f(QuickTradeVerticalSpotPresenter quickTradeVerticalSpotPresenter) {
        this.f25787b = quickTradeVerticalSpotPresenter;
    }

    public final Object call(Object obj) {
        return this.f25787b.s1((List) obj);
    }
}
