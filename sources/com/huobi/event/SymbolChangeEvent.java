package com.huobi.event;

import com.hbg.lib.data.symbol.TradeType;

public class SymbolChangeEvent {

    /* renamed from: a  reason: collision with root package name */
    public String f44609a;

    /* renamed from: b  reason: collision with root package name */
    public String f44610b;

    /* renamed from: c  reason: collision with root package name */
    public String f44611c;

    /* renamed from: d  reason: collision with root package name */
    public TradeType f44612d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f44613e;

    public boolean a(Object obj) {
        return obj instanceof SymbolChangeEvent;
    }

    public String b() {
        return this.f44611c;
    }

    public String c() {
        return this.f44610b;
    }

    public String d() {
        return this.f44609a;
    }

    public TradeType e() {
        return this.f44612d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SymbolChangeEvent)) {
            return false;
        }
        SymbolChangeEvent symbolChangeEvent = (SymbolChangeEvent) obj;
        if (!symbolChangeEvent.a(this)) {
            return false;
        }
        String d11 = d();
        String d12 = symbolChangeEvent.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = symbolChangeEvent.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String b11 = b();
        String b12 = symbolChangeEvent.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        TradeType e11 = e();
        TradeType e12 = symbolChangeEvent.e();
        if (e11 != null ? e11.equals(e12) : e12 == null) {
            return f() == symbolChangeEvent.f();
        }
        return false;
    }

    public boolean f() {
        return this.f44613e;
    }

    public void g(String str) {
        this.f44611c = str;
    }

    public void h(boolean z11) {
        this.f44613e = z11;
    }

    public int hashCode() {
        String d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        String c11 = c();
        int hashCode2 = ((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
        String b11 = b();
        int hashCode3 = (hashCode2 * 59) + (b11 == null ? 43 : b11.hashCode());
        TradeType e11 = e();
        int i12 = hashCode3 * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return ((i12 + i11) * 59) + (f() ? 79 : 97);
    }

    public void i(String str) {
        this.f44609a = str;
    }

    public void j(TradeType tradeType) {
        this.f44612d = tradeType;
    }

    public String toString() {
        return "SymbolChangeEvent(lastCode=" + d() + ", currencyType=" + c() + ", code=" + b() + ", tradeType=" + e() + ", isForceRefresh=" + f() + ")";
    }
}
