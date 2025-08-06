package st;

import com.hbg.lib.network.hbg.core.bean.EtpAvailableBean;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.tradenew.presenter.TradeVerticalSpotPresenter;
import java.util.List;
import rx.functions.Func3;

public final /* synthetic */ class a1 implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotPresenter.o f29199b;

    public /* synthetic */ a1(TradeVerticalSpotPresenter.o oVar) {
        this.f29199b = oVar;
    }

    public final Object call(Object obj, Object obj2, Object obj3) {
        return this.f29199b.c((BalanceDataTotal) obj, (EtpAvailableBean) obj2, (List) obj3);
    }
}
