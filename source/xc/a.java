package xc;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.exchange.grid.handler.ExchangeOrderMoreItemHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public String f23437b;

    /* renamed from: c  reason: collision with root package name */
    public int f23438c;

    /* renamed from: d  reason: collision with root package name */
    public TradeType f23439d;

    public a(String str, int i11, TradeType tradeType) {
        this.f23437b = str;
        this.f23438c = i11;
        this.f23439d = tradeType;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public int c() {
        return this.f23438c;
    }

    public String d() {
        return this.f23437b;
    }

    public TradeType e() {
        return this.f23439d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.a(this)) {
            return false;
        }
        String d11 = d();
        String d12 = aVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        if (c() != aVar.c()) {
            return false;
        }
        TradeType e11 = e();
        TradeType e12 = aVar.e();
        return e11 != null ? e11.equals(e12) : e12 == null;
    }

    public String getViewHandlerName() {
        return ExchangeOrderMoreItemHandler.class.getName();
    }

    public int hashCode() {
        String d11 = d();
        int i11 = 43;
        int hashCode = (((d11 == null ? 43 : d11.hashCode()) + 59) * 59) + c();
        TradeType e11 = e();
        int i12 = hashCode * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "ExchangeOrderMoreItem(symbol=" + d() + ", orderType=" + c() + ", tradeType=" + e() + ")";
    }
}
