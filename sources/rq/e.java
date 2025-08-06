package rq;

import com.huobi.quicktrade.trade.presenter.QuickTradeVerticalSpotPresenter;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickTradeVerticalSpotPresenter f25786b;

    public /* synthetic */ e(QuickTradeVerticalSpotPresenter quickTradeVerticalSpotPresenter) {
        this.f25786b = quickTradeVerticalSpotPresenter;
    }

    public final Object call(Object obj) {
        return this.f25786b.r1((List) obj);
    }
}
