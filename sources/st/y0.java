package st;

import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.tradenew.presenter.TradeVerticalSpotPresenter;
import java.util.List;
import rx.functions.Func3;

public final /* synthetic */ class y0 implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotPresenter.m f29254b;

    public /* synthetic */ y0(TradeVerticalSpotPresenter.m mVar) {
        this.f29254b = mVar;
    }

    public final Object call(Object obj, Object obj2, Object obj3) {
        return this.f29254b.c((BalanceDataTotal) obj, (String) obj2, (List) obj3);
    }
}
