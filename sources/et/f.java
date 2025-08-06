package et;

import com.huobi.trade.presenter.TradeBasePresenter;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class f implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeBasePresenter f54431b;

    public /* synthetic */ f(TradeBasePresenter tradeBasePresenter) {
        this.f54431b = tradeBasePresenter;
    }

    public final void call(Object obj) {
        this.f54431b.g1((List) obj);
    }
}
