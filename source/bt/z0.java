package bt;

import android.text.TextUtils;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.hbg.lib.network.pro.core.util.Period;
import com.huobi.page.SmartRefreshPageSplitter;
import ct.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Func1;
import vo.b;
import yo.s0;

public class z0 implements SmartRefreshPageSplitter.c<b> {

    /* renamed from: a  reason: collision with root package name */
    public d f77048a;

    public z0(d dVar) {
        v(dVar);
    }

    public static /* synthetic */ Boolean o(List list) {
        return Boolean.valueOf(list != null);
    }

    public static /* synthetic */ b q(AlgoOrderInfo algoOrderInfo) {
        return new b(algoOrderInfo);
    }

    public static /* synthetic */ Boolean r(List list) {
        return Boolean.valueOf(list != null);
    }

    public static /* synthetic */ b t(AlgoOrderInfo algoOrderInfo) {
        return new b(algoOrderInfo);
    }

    public Func1<? super b, ? extends Long> a() {
        return u0.f12976b;
    }

    public Observable<List<b>> c() {
        return s0.d0().a0(m()).filter(w0.f12981b).flatMap(x0.f12984b).map(t0.f12973b).take(20).toList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z0)) {
            return false;
        }
        z0 z0Var = (z0) obj;
        if (!z0Var.k(this)) {
            return false;
        }
        d l11 = l();
        d l12 = z0Var.l();
        return l11 != null ? l11.equals(l12) : l12 == null;
    }

    public int hashCode() {
        d l11 = l();
        return 59 + (l11 == null ? 43 : l11.hashCode());
    }

    public boolean k(Object obj) {
        return obj instanceof z0;
    }

    public d l() {
        return this.f77048a;
    }

    public final Map<String, Object> m() {
        String state = l().getState();
        String o02 = !TextUtils.isEmpty(l().o0()) ? l().o0() : null;
        String orderType = l().getOrderType();
        HashMap hashMap = new HashMap();
        hashMap.put("algoTypes", "1");
        if (!TextUtils.isEmpty(o02)) {
            hashMap.put("symbol", o02);
        }
        if (!TextUtils.isEmpty(state)) {
            hashMap.put("orderSide", state);
        }
        if (TextUtils.isEmpty(orderType)) {
            hashMap.put("orderStatus", "canceled,rejected,triggered");
        } else {
            hashMap.put("orderStatus", orderType);
        }
        hashMap.put("size", 20);
        Long b11 = DateTimeUtils.b(l().Ec());
        if (b11 != null) {
            hashMap.put("startTime", b11);
        }
        Long b12 = DateTimeUtils.b(l().M7());
        if (b12 != null) {
            hashMap.put("endTime", Long.valueOf(b12.longValue() + Period.DAY_MILLS));
        }
        return hashMap;
    }

    public String toString() {
        return "HistoryPlanTradePageRequestHandler(callback=" + l() + ")";
    }

    /* renamed from: u */
    public Observable<List<b>> b(b bVar) {
        Map<String, Object> m11 = m();
        m11.put("from", bVar.a());
        return s0.d0().a0(m11).filter(v0.f12978b).flatMap(y0.f12987b).map(s0.f12970b).take(20).toList();
    }

    public void v(d dVar) {
        this.f77048a = dVar;
    }
}
