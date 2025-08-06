package bt;

import android.text.TextUtils;
import com.huobi.order.bean.OrderBeanDetails;
import com.huobi.order.provider.OrderParams;
import com.huobi.page.SmartRefreshPageSplitter;
import ct.d;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import yo.s0;

public class r0 implements SmartRefreshPageSplitter.c<OrderBeanDetails> {

    /* renamed from: a  reason: collision with root package name */
    public d f77045a;

    public r0(d dVar) {
        v(dVar);
    }

    public static /* synthetic */ Boolean o(List list) {
        return Boolean.valueOf(list != null);
    }

    public static /* synthetic */ Boolean r(List list) {
        return Boolean.valueOf(list != null);
    }

    public Func1<? super OrderBeanDetails, ? extends Long> a() {
        return m0.f12938b;
    }

    public Observable<List<OrderBeanDetails>> c() {
        return s0.d0().Z(m()).filter(q0.f12962b).flatMap(n0.f12945b).map(l0.f12931b).take(20).toList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r0)) {
            return false;
        }
        r0 r0Var = (r0) obj;
        if (!r0Var.k(this)) {
            return false;
        }
        d l11 = l();
        d l12 = r0Var.l();
        return l11 != null ? l11.equals(l12) : l12 == null;
    }

    public int hashCode() {
        d l11 = l();
        return 59 + (l11 == null ? 43 : l11.hashCode());
    }

    public boolean k(Object obj) {
        return obj instanceof r0;
    }

    public d l() {
        return this.f77045a;
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
        return orderParams;
    }

    public String toString() {
        return "FilledOrderPageRequestHandler(callback=" + l() + ")";
    }

    /* renamed from: u */
    public Observable<List<OrderBeanDetails>> b(OrderBeanDetails orderBeanDetails) {
        OrderParams m11 = m();
        m11.j(String.valueOf(orderBeanDetails.getId()));
        return s0.d0().Z(m11).filter(o0.f12949b).flatMap(p0.f12956b).map(k0.f12924b).take(20).toList();
    }

    public void v(d dVar) {
        this.f77045a = dVar;
    }
}
