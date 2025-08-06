package ws;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.trade.handler.TradeOrderMoreItemHandler;
import s9.a;

public class f implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f85045b;

    /* renamed from: c  reason: collision with root package name */
    public int f85046c;

    /* renamed from: d  reason: collision with root package name */
    public int f85047d;

    /* renamed from: e  reason: collision with root package name */
    public TradeType f85048e;

    public f(String str, int i11, int i12, TradeType tradeType) {
        this.f85045b = str;
        this.f85046c = i11;
        this.f85047d = i12;
        this.f85048e = tradeType;
    }

    public boolean a(Object obj) {
        return obj instanceof f;
    }

    public int c() {
        return this.f85046c;
    }

    public int d() {
        return this.f85047d;
    }

    public String e() {
        return this.f85045b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (!fVar.a(this)) {
            return false;
        }
        String e11 = e();
        String e12 = fVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        if (c() != fVar.c() || d() != fVar.d()) {
            return false;
        }
        TradeType f11 = f();
        TradeType f12 = fVar.f();
        return f11 != null ? f11.equals(f12) : f12 == null;
    }

    public TradeType f() {
        return this.f85048e;
    }

    public String getViewHandlerName() {
        return TradeOrderMoreItemHandler.class.getName();
    }

    public int hashCode() {
        String e11 = e();
        int i11 = 43;
        int hashCode = (((((e11 == null ? 43 : e11.hashCode()) + 59) * 59) + c()) * 59) + d();
        TradeType f11 = f();
        int i12 = hashCode * 59;
        if (f11 != null) {
            i11 = f11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "TradeOrderMoreItem(symbol=" + e() + ", orderType=" + c() + ", pageId=" + d() + ", tradeType=" + f() + ")";
    }
}
