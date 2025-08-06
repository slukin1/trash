package aj;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.contract.viewhandler.OrderMoreItemHandler;
import s9.a;

public class e implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f40711b;

    /* renamed from: c  reason: collision with root package name */
    public int f40712c;

    /* renamed from: d  reason: collision with root package name */
    public TradeType f40713d;

    /* renamed from: e  reason: collision with root package name */
    public String f40714e;

    /* renamed from: f  reason: collision with root package name */
    public String f40715f;

    /* renamed from: g  reason: collision with root package name */
    public int f40716g;

    public e(String str, int i11, TradeType tradeType) {
        this.f40711b = str;
        this.f40712c = i11;
        this.f40713d = tradeType;
    }

    public boolean a(Object obj) {
        return obj instanceof e;
    }

    public String c() {
        return this.f40714e;
    }

    public String d() {
        return this.f40715f;
    }

    public int e() {
        return this.f40716g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!eVar.a(this)) {
            return false;
        }
        String g11 = g();
        String g12 = eVar.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        if (f() != eVar.f()) {
            return false;
        }
        TradeType h11 = h();
        TradeType h12 = eVar.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = eVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = eVar.d();
        if (d11 != null ? d11.equals(d12) : d12 == null) {
            return e() == eVar.e();
        }
        return false;
    }

    public int f() {
        return this.f40712c;
    }

    public String g() {
        return this.f40711b;
    }

    public String getViewHandlerName() {
        return OrderMoreItemHandler.class.getName();
    }

    public TradeType h() {
        return this.f40713d;
    }

    public int hashCode() {
        String g11 = g();
        int i11 = 43;
        int hashCode = (((g11 == null ? 43 : g11.hashCode()) + 59) * 59) + f();
        TradeType h11 = h();
        int hashCode2 = (hashCode * 59) + (h11 == null ? 43 : h11.hashCode());
        String c11 = c();
        int hashCode3 = (hashCode2 * 59) + (c11 == null ? 43 : c11.hashCode());
        String d11 = d();
        int i12 = hashCode3 * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return ((i12 + i11) * 59) + e();
    }

    public String toString() {
        return "OrderMoreItem(symbol=" + g() + ", orderType=" + f() + ", tradeType=" + h() + ", contractCode=" + c() + ", contractShortType=" + d() + ", marginMode=" + e() + ")";
    }

    public e(String str, int i11, TradeType tradeType, String str2) {
        this.f40711b = str;
        this.f40712c = i11;
        this.f40713d = tradeType;
        this.f40715f = str2;
    }

    public e(String str, String str2, int i11, int i12, TradeType tradeType) {
        this.f40711b = str2;
        this.f40712c = i11;
        this.f40713d = tradeType;
        this.f40714e = str;
        this.f40716g = i12;
    }
}
