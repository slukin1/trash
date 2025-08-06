package et;

import com.huobi.trade.presenter.TradeVerticalSpotPresenter;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class u implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotPresenter f54451b;

    public /* synthetic */ u(TradeVerticalSpotPresenter tradeVerticalSpotPresenter) {
        this.f54451b = tradeVerticalSpotPresenter;
    }

    public final void call(Object obj) {
        this.f54451b.e3((List) obj);
    }
}
