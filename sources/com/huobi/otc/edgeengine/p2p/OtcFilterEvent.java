package com.huobi.otc.edgeengine.p2p;

import com.huobi.edgeengine.ability.AbilityFunction;

public class OtcFilterEvent {

    /* renamed from: a  reason: collision with root package name */
    public String f78335a;

    /* renamed from: b  reason: collision with root package name */
    public String f78336b;

    /* renamed from: c  reason: collision with root package name */
    public String f78337c;

    /* renamed from: d  reason: collision with root package name */
    public int f78338d;

    /* renamed from: e  reason: collision with root package name */
    public int f78339e;

    /* renamed from: f  reason: collision with root package name */
    public String f78340f;

    /* renamed from: g  reason: collision with root package name */
    public String f78341g;

    /* renamed from: h  reason: collision with root package name */
    public AbilityFunction.a f78342h;

    public boolean a(Object obj) {
        return obj instanceof OtcFilterEvent;
    }

    public String b() {
        return this.f78335a;
    }

    public AbilityFunction.a c() {
        return this.f78342h;
    }

    public String d() {
        return this.f78341g;
    }

    public int e() {
        return this.f78338d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcFilterEvent)) {
            return false;
        }
        OtcFilterEvent otcFilterEvent = (OtcFilterEvent) obj;
        if (!otcFilterEvent.a(this)) {
            return false;
        }
        String b11 = b();
        String b12 = otcFilterEvent.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        String h11 = h();
        String h12 = otcFilterEvent.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        String i11 = i();
        String i12 = otcFilterEvent.i();
        if (i11 != null ? !i11.equals(i12) : i12 != null) {
            return false;
        }
        if (e() != otcFilterEvent.e() || f() != otcFilterEvent.f()) {
            return false;
        }
        String g11 = g();
        String g12 = otcFilterEvent.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = otcFilterEvent.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        AbilityFunction.a c11 = c();
        AbilityFunction.a c12 = otcFilterEvent.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public int f() {
        return this.f78339e;
    }

    public String g() {
        return this.f78340f;
    }

    public String h() {
        return this.f78336b;
    }

    public int hashCode() {
        String b11 = b();
        int i11 = 43;
        int hashCode = b11 == null ? 43 : b11.hashCode();
        String h11 = h();
        int hashCode2 = ((hashCode + 59) * 59) + (h11 == null ? 43 : h11.hashCode());
        String i12 = i();
        int hashCode3 = (((((hashCode2 * 59) + (i12 == null ? 43 : i12.hashCode())) * 59) + e()) * 59) + f();
        String g11 = g();
        int hashCode4 = (hashCode3 * 59) + (g11 == null ? 43 : g11.hashCode());
        String d11 = d();
        int hashCode5 = (hashCode4 * 59) + (d11 == null ? 43 : d11.hashCode());
        AbilityFunction.a c11 = c();
        int i13 = hashCode5 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i13 + i11;
    }

    public String i() {
        return this.f78337c;
    }

    public void j(String str) {
        this.f78335a = str;
    }

    public void k(AbilityFunction.a aVar) {
        this.f78342h = aVar;
    }

    public void l(String str) {
        this.f78341g = str;
    }

    public void m(int i11) {
        this.f78338d = i11;
    }

    public void n(int i11) {
        this.f78339e = i11;
    }

    public void o(String str) {
        this.f78340f = str;
    }

    public void p(String str) {
        this.f78336b = str;
    }

    public void q(String str) {
        this.f78337c = str;
    }

    public String toString() {
        return "OtcFilterEvent(action=" + b() + ", params=" + h() + ", text=" + i() + ", fontSize=" + e() + ", fontWeight=" + f() + ", method=" + g() + ", currencyName=" + d() + ", callback=" + c() + ")";
    }
}
