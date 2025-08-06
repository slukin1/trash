package bt;

import android.text.TextUtils;
import com.hbg.lib.network.pro.core.bean.AlgoOrderMatchResult;
import com.hbg.lib.network.pro.core.bean.PeriodTrade;
import com.huobi.order.bean.TimeOrderBeanDetails;
import com.huobi.order.provider.OrderParams;
import com.huobi.page.SmartRefreshPageSplitter;
import com.huobi.trade.bean.AlgoOrderMatchBean;
import ct.d;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import yo.s0;

public class z1 implements SmartRefreshPageSplitter.c<TimeOrderBeanDetails> {

    /* renamed from: a  reason: collision with root package name */
    public d f77049a;

    public z1(d dVar) {
        v(dVar);
    }

    public static /* synthetic */ Boolean o(List list) {
        return Boolean.valueOf(list != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ TimeOrderBeanDetails q(AlgoOrderMatchResult algoOrderMatchResult) {
        AlgoOrderMatchBean algoOrderMatchBean = new AlgoOrderMatchBean();
        algoOrderMatchBean.setId(algoOrderMatchResult.getId());
        algoOrderMatchBean.setSymbol(algoOrderMatchResult.getSymbol());
        algoOrderMatchBean.setOrderSide(algoOrderMatchResult.getOrderSide());
        PeriodTrade periodTrade = new PeriodTrade();
        w(algoOrderMatchResult, periodTrade);
        algoOrderMatchBean.setPeriodTrade(periodTrade);
        TimeOrderBeanDetails timeOrderBeanDetails = new TimeOrderBeanDetails(algoOrderMatchBean);
        timeOrderBeanDetails.setStyle(1);
        return timeOrderBeanDetails;
    }

    public static /* synthetic */ Boolean r(List list) {
        return Boolean.valueOf(list != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ TimeOrderBeanDetails t(AlgoOrderMatchResult algoOrderMatchResult) {
        AlgoOrderMatchBean algoOrderMatchBean = new AlgoOrderMatchBean();
        algoOrderMatchBean.setId(algoOrderMatchResult.getId());
        algoOrderMatchBean.setSymbol(algoOrderMatchResult.getSymbol());
        algoOrderMatchBean.setOrderSide(algoOrderMatchResult.getOrderSide());
        PeriodTrade periodTrade = new PeriodTrade();
        w(algoOrderMatchResult, periodTrade);
        algoOrderMatchBean.setPeriodTrade(periodTrade);
        TimeOrderBeanDetails timeOrderBeanDetails = new TimeOrderBeanDetails(algoOrderMatchBean);
        timeOrderBeanDetails.setStyle(1);
        return timeOrderBeanDetails;
    }

    public Func1<? super TimeOrderBeanDetails, ? extends Long> a() {
        return u1.f12977b;
    }

    public Observable<List<TimeOrderBeanDetails>> c() {
        return s0.d0().l0(m()).filter(y1.f12988b).flatMap(x1.f12985b).map(new t1(this)).take(20).toList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z1)) {
            return false;
        }
        z1 z1Var = (z1) obj;
        if (!z1Var.k(this)) {
            return false;
        }
        d l11 = l();
        d l12 = z1Var.l();
        return l11 != null ? l11.equals(l12) : l12 == null;
    }

    public int hashCode() {
        d l11 = l();
        return 59 + (l11 == null ? 43 : l11.hashCode());
    }

    public boolean k(Object obj) {
        return obj instanceof z1;
    }

    public d l() {
        return this.f77049a;
    }

    public final OrderParams m() {
        String state = l().getState();
        String o02 = !TextUtils.isEmpty(l().o0()) ? l().o0() : null;
        OrderParams orderParams = new OrderParams();
        orderParams.n(o02);
        orderParams.l(20);
        orderParams.o(state);
        orderParams.m(l().Ec());
        orderParams.i(l().M7());
        orderParams.k("canceled,rejected,triggered,stopped");
        return orderParams;
    }

    public String toString() {
        return "TimeFilledOrderPageRequestHandler(callback=" + l() + ")";
    }

    /* renamed from: u */
    public Observable<List<TimeOrderBeanDetails>> b(TimeOrderBeanDetails timeOrderBeanDetails) {
        OrderParams m11 = m();
        m11.j(String.valueOf(timeOrderBeanDetails.getId()));
        return s0.d0().l0(m11).filter(w1.f12982b).flatMap(v1.f12979b).map(new s1(this)).take(20).toList();
    }

    public void v(d dVar) {
        this.f77049a = dVar;
    }

    public final void w(AlgoOrderMatchResult algoOrderMatchResult, PeriodTrade periodTrade) {
        periodTrade.setOrderTradeTime(algoOrderMatchResult.getOrderTradeTime());
        periodTrade.setOrderLimitPrice(algoOrderMatchResult.getOrderLimitPrice());
        periodTrade.setOrderLimitSize(algoOrderMatchResult.getOrderLimitSize());
        periodTrade.setOrderAmount(algoOrderMatchResult.getOrderAmount());
        periodTrade.setOrderPrice(algoOrderMatchResult.getOrderPrice());
        periodTrade.setOrderSize(algoOrderMatchResult.getOrderSize());
        periodTrade.setOrderFee(algoOrderMatchResult.getOrderFee());
        periodTrade.setOrderPoint(algoOrderMatchResult.getOrderPoint());
        periodTrade.setOrderHt(algoOrderMatchResult.getOrderHt());
    }
}
