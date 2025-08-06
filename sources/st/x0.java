package st;

import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.tradenew.presenter.TradeVerticalSpotPresenter;
import java.util.List;
import rx.functions.Func2;

public final /* synthetic */ class x0 implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotPresenter.a f29252b;

    public /* synthetic */ x0(TradeVerticalSpotPresenter.a aVar) {
        this.f29252b = aVar;
    }

    public final Object call(Object obj, Object obj2) {
        return this.f29252b.c((BalanceDataTotal) obj, (List) obj2);
    }
}
