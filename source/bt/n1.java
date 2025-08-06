package bt;

import com.huobi.page.SmartRefreshPageSplitter;
import com.huobi.trade.bean.TradeOrderHistory;
import ct.d;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import s9.a;
import yo.s0;

public class n1 implements SmartRefreshPageSplitter.c<TradeOrderHistory> {

    /* renamed from: a  reason: collision with root package name */
    public d f77044a;

    public n1(d dVar) {
        q(dVar);
    }

    public static /* synthetic */ TradeOrderHistory m(a aVar) {
        return (TradeOrderHistory) aVar;
    }

    public static /* synthetic */ TradeOrderHistory o(a aVar) {
        return (TradeOrderHistory) aVar;
    }

    public Func1<? super TradeOrderHistory, ? extends Long> a() {
        return k1.f12925b;
    }

    public Observable<List<TradeOrderHistory>> c() {
        j().getOrderType();
        s0.e eVar = new s0.e(10, 0, -1, j().getOrderType(), j().getState());
        eVar.b(j().Ec());
        eVar.a(j().M7());
        return s0.d0().g0(false, j().D0(), 2, j().o0(), eVar).flatMap(l1.f12932b).map(j1.f12921b).toList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n1)) {
            return false;
        }
        n1 n1Var = (n1) obj;
        if (!n1Var.i(this)) {
            return false;
        }
        d j11 = j();
        d j12 = n1Var.j();
        return j11 != null ? j11.equals(j12) : j12 == null;
    }

    public int hashCode() {
        d j11 = j();
        return 59 + (j11 == null ? 43 : j11.hashCode());
    }

    public boolean i(Object obj) {
        return obj instanceof n1;
    }

    public d j() {
        return this.f77044a;
    }

    /* renamed from: p */
    public Observable<List<TradeOrderHistory>> b(TradeOrderHistory tradeOrderHistory) {
        j().getOrderType();
        s0.e eVar = new s0.e(10, 0, tradeOrderHistory.getId().longValue(), j().getOrderType(), j().getState());
        eVar.b(j().Ec());
        eVar.a(j().M7());
        return s0.d0().g0(false, j().D0(), 2, j().o0(), eVar).flatMap(m1.f12939b).map(i1.f12915b).toList();
    }

    public void q(d dVar) {
        this.f77044a = dVar;
    }

    public String toString() {
        return "HistoryTradePageRequestHandler(callback=" + j() + ")";
    }
}
