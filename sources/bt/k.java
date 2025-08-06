package bt;

import android.text.TextUtils;
import com.hbg.lib.network.pro.core.bean.AlgoOrderInfo;
import com.huobi.page.SmartRefreshPageSplitter;
import ct.d;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import vo.a;
import yo.s0;

public class k implements SmartRefreshPageSplitter.c<a> {

    /* renamed from: a  reason: collision with root package name */
    public d f77042a;

    /* renamed from: b  reason: collision with root package name */
    public a.C0887a f77043b;

    public k(d dVar, a.C0887a aVar) {
        v(dVar);
        this.f77043b = aVar;
    }

    public static /* synthetic */ Boolean o(List list) {
        return Boolean.valueOf(list != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ a q(AlgoOrderInfo algoOrderInfo) {
        a aVar = new a(algoOrderInfo);
        aVar.i(this.f77043b);
        return aVar;
    }

    public static /* synthetic */ Boolean r(List list) {
        return Boolean.valueOf(list != null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ a t(AlgoOrderInfo algoOrderInfo) {
        a aVar = new a(algoOrderInfo);
        aVar.i(this.f77043b);
        return aVar;
    }

    public Func1<? super a, ? extends Long> a() {
        return f.f12897b;
    }

    public Observable<List<a>> c() {
        String state = l().getState();
        return s0.d0().Y(0, !TextUtils.isEmpty(l().o0()) ? l().o0() : null, state, 0).filter(j.f12918b).flatMap(g.f12900b).map(new d(this)).take(20).toList();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (!kVar.k(this)) {
            return false;
        }
        d l11 = l();
        d l12 = kVar.l();
        if (l11 != null ? !l11.equals(l12) : l12 != null) {
            return false;
        }
        a.C0887a m11 = m();
        a.C0887a m12 = kVar.m();
        return m11 != null ? m11.equals(m12) : m12 == null;
    }

    public int hashCode() {
        d l11 = l();
        int i11 = 43;
        int hashCode = l11 == null ? 43 : l11.hashCode();
        a.C0887a m11 = m();
        int i12 = (hashCode + 59) * 59;
        if (m11 != null) {
            i11 = m11.hashCode();
        }
        return i12 + i11;
    }

    public boolean k(Object obj) {
        return obj instanceof k;
    }

    public d l() {
        return this.f77042a;
    }

    public a.C0887a m() {
        return this.f77043b;
    }

    public String toString() {
        return "CurrentPlanTradePageRequestHandler(callback=" + l() + ", mPlanTradeInfoCallback=" + m() + ")";
    }

    /* renamed from: u */
    public Observable<List<a>> b(a aVar) {
        String state = l().getState();
        return s0.d0().Y(0, !TextUtils.isEmpty(l().o0()) ? l().o0() : null, state, aVar.d().longValue()).filter(h.f12905b).flatMap(i.f12912b).map(new e(this)).take(20).toList();
    }

    public void v(d dVar) {
        this.f77042a = dVar;
    }
}
