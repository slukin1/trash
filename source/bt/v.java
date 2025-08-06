package bt;

import android.text.TextUtils;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.huobi.order.bean.CurrentTimeTradeInfo;
import com.huobi.page.SmartRefreshPageSplitter;
import ct.d;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import yo.s0;

public class v implements SmartRefreshPageSplitter.c<CurrentTimeTradeInfo> {

    /* renamed from: a  reason: collision with root package name */
    public d f77046a;

    /* renamed from: b  reason: collision with root package name */
    public CurrentTimeTradeInfo.a f77047b;

    public v(d dVar, CurrentTimeTradeInfo.a aVar) {
        v(dVar);
        this.f77047b = aVar;
    }

    public static /* synthetic */ Boolean o(List list) {
        return Boolean.valueOf(list != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ CurrentTimeTradeInfo q(AlgoOrderInfo algoOrderInfo) {
        CurrentTimeTradeInfo currentTimeTradeInfo = new CurrentTimeTradeInfo(algoOrderInfo);
        currentTimeTradeInfo.setCallback(this.f77047b);
        return currentTimeTradeInfo;
    }

    public static /* synthetic */ Boolean r(List list) {
        return Boolean.valueOf(list != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ CurrentTimeTradeInfo t(AlgoOrderInfo algoOrderInfo) {
        CurrentTimeTradeInfo currentTimeTradeInfo = new CurrentTimeTradeInfo(algoOrderInfo);
        currentTimeTradeInfo.setCallback(this.f77047b);
        return currentTimeTradeInfo;
    }

    public Func1<? super CurrentTimeTradeInfo, ? extends Long> a() {
        return q.f12961b;
    }

    public Observable<List<CurrentTimeTradeInfo>> c() {
        String state = l().getState();
        return s0.d0().X(2, 0, !TextUtils.isEmpty(l().o0()) ? l().o0() : null, state, 0, 20).filter(t.f12972b).flatMap(r.f12967b).map(new o(this)).take(20).toList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        if (!vVar.k(this)) {
            return false;
        }
        d l11 = l();
        d l12 = vVar.l();
        if (l11 != null ? !l11.equals(l12) : l12 != null) {
            return false;
        }
        CurrentTimeTradeInfo.a m11 = m();
        CurrentTimeTradeInfo.a m12 = vVar.m();
        return m11 != null ? m11.equals(m12) : m12 == null;
    }

    public int hashCode() {
        d l11 = l();
        int i11 = 43;
        int hashCode = l11 == null ? 43 : l11.hashCode();
        CurrentTimeTradeInfo.a m11 = m();
        int i12 = (hashCode + 59) * 59;
        if (m11 != null) {
            i11 = m11.hashCode();
        }
        return i12 + i11;
    }

    public boolean k(Object obj) {
        return obj instanceof v;
    }

    public d l() {
        return this.f77046a;
    }

    public CurrentTimeTradeInfo.a m() {
        return this.f77047b;
    }

    public String toString() {
        return "CurrentTimeTradePageRequestHandler(callback=" + l() + ", mTimeTradeInfoCallback=" + m() + ")";
    }

    /* renamed from: u */
    public Observable<List<CurrentTimeTradeInfo>> b(CurrentTimeTradeInfo currentTimeTradeInfo) {
        String state = l().getState();
        return s0.d0().X(2, 0, !TextUtils.isEmpty(l().o0()) ? l().o0() : null, state, currentTimeTradeInfo.getId().longValue(), 20).filter(s.f12969b).flatMap(u.f12975b).map(new p(this)).take(20).toList();
    }

    public void v(d dVar) {
        this.f77046a = dVar;
    }
}
