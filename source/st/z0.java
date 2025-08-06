package st;

import com.hbg.lib.network.hbg.core.bean.RemainingAmountBean;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.tradenew.presenter.TradeVerticalSpotPresenter;
import java.util.List;
import rx.functions.Func3;

public final /* synthetic */ class z0 implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotPresenter.n f29256b;

    public /* synthetic */ z0(TradeVerticalSpotPresenter.n nVar) {
        this.f29256b = nVar;
    }

    public final Object call(Object obj, Object obj2, Object obj3) {
        return this.f29256b.c((BalanceDataTotal) obj, (RemainingAmountBean) obj2, (List) obj3);
    }
}
