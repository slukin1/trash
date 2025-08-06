package st;

import com.hbg.lib.network.hbg.core.bean.RemainingAmountBean;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.tradenew.presenter.TradeHorizontalSpotPresenter;
import java.util.List;
import rx.functions.Func3;

public final /* synthetic */ class e0 implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ e0 f29209b = new e0();

    public final Object call(Object obj, Object obj2, Object obj3) {
        return TradeHorizontalSpotPresenter.m.e((BalanceDataTotal) obj, (RemainingAmountBean) obj2, (List) obj3);
    }
}
