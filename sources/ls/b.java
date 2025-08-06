package ls;

import com.huobi.supermargin.presenter.TradeVerticalSuperMarginPresenter;
import java.util.Map;
import rx.functions.Action1;

public final /* synthetic */ class b implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSuperMarginPresenter f58060b;

    public /* synthetic */ b(TradeVerticalSuperMarginPresenter tradeVerticalSuperMarginPresenter) {
        this.f58060b = tradeVerticalSuperMarginPresenter;
    }

    public final void call(Object obj) {
        this.f58060b.u3((Map) obj);
    }
}
