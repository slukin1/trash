package ce;

import com.hbg.lib.network.pro.socket.bean.FundSituationBean;
import com.hbg.module.kline.presenter.MarketInfoCapitalFlowPresenter;
import java.util.List;
import rx.functions.Func3;

public final /* synthetic */ class e implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketInfoCapitalFlowPresenter f13074b;

    public /* synthetic */ e(MarketInfoCapitalFlowPresenter marketInfoCapitalFlowPresenter) {
        this.f13074b = marketInfoCapitalFlowPresenter;
    }

    public final Object call(Object obj, Object obj2, Object obj3) {
        return this.f13074b.m0((List) obj, (List) obj2, (FundSituationBean) obj3);
    }
}
