package bt;

import com.huobi.order.bean.OrderBean;
import com.huobi.page.SmartRefreshPageSplitter;
import ct.d;
import d7.a1;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import yo.s0;

public class f0 implements SmartRefreshPageSplitter.c<OrderBean> {

    /* renamed from: a  reason: collision with root package name */
    public d f77038a;

    /* renamed from: b  reason: collision with root package name */
    public OrderBean.a f77039b;

    public f0(d dVar, OrderBean.a aVar) {
        z(dVar);
        this.f77039b = aVar;
    }

    public static /* synthetic */ Boolean q(List list) {
        return Boolean.valueOf(list != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ OrderBean t(OrderBean orderBean) {
        orderBean.setShowSymbol(true);
        orderBean.setCallAuctionTwo(a1.v().o0(orderBean.getSymbol(), n().D0()));
        orderBean.setCallback(this.f77039b);
        return orderBean;
    }

    public static /* synthetic */ Boolean u(List list) {
        return Boolean.valueOf(list != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ OrderBean x(OrderBean orderBean) {
        orderBean.setShowSymbol(true);
        orderBean.setCallAuctionTwo(a1.v().o0(orderBean.getSymbol(), n().D0()));
        orderBean.setCallback(this.f77039b);
        return orderBean;
    }

    public Func1<? super OrderBean, ? extends Long> a() {
        return a0.f12872b;
    }

    public Observable<List<OrderBean>> c() {
        return s0.d0().g0(false, n().D0(), 0, n().o0(), new s0.d(10, 0, -1, n().getOrderType(), n().getState())).filter(e0.f12893b).flatMap(c0.f12883b).map(z.f12989b).map(new w(this)).take(10).toList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        if (!f0Var.m(this)) {
            return false;
        }
        d n11 = n();
        d n12 = f0Var.n();
        if (n11 != null ? !n11.equals(n12) : n12 != null) {
            return false;
        }
        OrderBean.a o11 = o();
        OrderBean.a o12 = f0Var.o();
        return o11 != null ? o11.equals(o12) : o12 == null;
    }

    public int hashCode() {
        d n11 = n();
        int i11 = 43;
        int hashCode = n11 == null ? 43 : n11.hashCode();
        OrderBean.a o11 = o();
        int i12 = (hashCode + 59) * 59;
        if (o11 != null) {
            i11 = o11.hashCode();
        }
        return i12 + i11;
    }

    public boolean m(Object obj) {
        return obj instanceof f0;
    }

    public d n() {
        return this.f77038a;
    }

    public OrderBean.a o() {
        return this.f77039b;
    }

    public String toString() {
        return "CurrentTradePageRequestHandler(callback=" + n() + ", mOrderBeanCallback=" + o() + ")";
    }

    /* renamed from: y */
    public Observable<List<OrderBean>> b(OrderBean orderBean) {
        return s0.d0().g0(false, n().D0(), 0, n().o0(), new s0.d(10, 0, orderBean.getId(), n().getOrderType(), n().getState())).filter(b0.f12877b).flatMap(d0.f12888b).map(y.f12986b).map(new x(this)).take(10).toList();
    }

    public void z(d dVar) {
        this.f77038a = dVar;
    }
}
