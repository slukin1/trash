package bt;

import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.huobi.order.bean.TimeTradeInfo;
import com.huobi.page.SmartRefreshPageSplitter;
import ct.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Func1;
import yo.s0;

public class h1 implements SmartRefreshPageSplitter.c<TimeTradeInfo> {

    /* renamed from: a  reason: collision with root package name */
    public d f77040a;

    /* renamed from: b  reason: collision with root package name */
    public TimeTradeInfo.a f77041b;

    public h1(d dVar, TimeTradeInfo.a aVar) {
        w(dVar);
        this.f77041b = aVar;
    }

    public static /* synthetic */ Boolean p(List list) {
        return Boolean.valueOf(list != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ TimeTradeInfo r(AlgoOrderInfo algoOrderInfo) {
        TimeTradeInfo timeTradeInfo = new TimeTradeInfo(algoOrderInfo);
        timeTradeInfo.setCallback(this.f77041b);
        return timeTradeInfo;
    }

    public static /* synthetic */ Boolean s(List list) {
        return Boolean.valueOf(list != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ TimeTradeInfo u(AlgoOrderInfo algoOrderInfo) {
        TimeTradeInfo timeTradeInfo = new TimeTradeInfo(algoOrderInfo);
        timeTradeInfo.setCallback(this.f77041b);
        return timeTradeInfo;
    }

    public Func1<? super TimeTradeInfo, ? extends Long> a() {
        return c1.f12884b;
    }

    public Observable<List<TimeTradeInfo>> c() {
        return s0.d0().b0(m()).filter(f1.f12898b).flatMap(e1.f12894b).map(new b1(this)).take(20).toList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h1)) {
            return false;
        }
        h1 h1Var = (h1) obj;
        if (!h1Var.k(this)) {
            return false;
        }
        d l11 = l();
        d l12 = h1Var.l();
        if (l11 != null ? !l11.equals(l12) : l12 != null) {
            return false;
        }
        TimeTradeInfo.a n11 = n();
        TimeTradeInfo.a n12 = h1Var.n();
        return n11 != null ? n11.equals(n12) : n12 == null;
    }

    public int hashCode() {
        d l11 = l();
        int i11 = 43;
        int hashCode = l11 == null ? 43 : l11.hashCode();
        TimeTradeInfo.a n11 = n();
        int i12 = (hashCode + 59) * 59;
        if (n11 != null) {
            i11 = n11.hashCode();
        }
        return i12 + i11;
    }

    public boolean k(Object obj) {
        return obj instanceof h1;
    }

    public d l() {
        return this.f77040a;
    }

    public final Map<String, Object> m() {
        String state = l().getState();
        String o02 = !TextUtils.isEmpty(l().o0()) ? l().o0() : null;
        String orderType = l().getOrderType();
        HashMap hashMap = new HashMap();
        hashMap.put("delegateType", 2);
        hashMap.put("algoTypes", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC);
        if (!TextUtils.isEmpty(o02)) {
            hashMap.put("symbol", o02);
        }
        if (!TextUtils.isEmpty(state)) {
            hashMap.put("orderSide", state);
        }
        if (TextUtils.isEmpty(orderType)) {
            hashMap.put("orderStatus", "canceled,rejected,triggered,stopped");
        } else {
            hashMap.put("orderStatus", orderType);
        }
        hashMap.put("size", 20);
        if (!TextUtils.isEmpty(l().Ec())) {
            hashMap.put("start-date", l().Ec());
        }
        if (!TextUtils.isEmpty(l().M7())) {
            hashMap.put("end-date", l().M7());
        }
        return hashMap;
    }

    public TimeTradeInfo.a n() {
        return this.f77041b;
    }

    public String toString() {
        return "HistoryTimeTradePageRequestHandler(callback=" + l() + ", timeTradeInfoCallback=" + n() + ")";
    }

    /* renamed from: v */
    public Observable<List<TimeTradeInfo>> b(TimeTradeInfo timeTradeInfo) {
        Map<String, Object> m11 = m();
        m11.put("from", timeTradeInfo.getId());
        return s0.d0().a0(m11).filter(d1.f12889b).flatMap(g1.f12903b).map(new a1(this)).take(20).toList();
    }

    public void w(d dVar) {
        this.f77040a = dVar;
    }
}
