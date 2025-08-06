package com.huobi.order.provider;

public class OrderParams {

    /* renamed from: a  reason: collision with root package name */
    public String f78122a;

    /* renamed from: b  reason: collision with root package name */
    public int f78123b;

    /* renamed from: c  reason: collision with root package name */
    public String f78124c;

    /* renamed from: d  reason: collision with root package name */
    public String f78125d;

    /* renamed from: e  reason: collision with root package name */
    public String f78126e;

    /* renamed from: f  reason: collision with root package name */
    public String f78127f;

    /* renamed from: g  reason: collision with root package name */
    public String f78128g;

    public boolean a(Object obj) {
        return obj instanceof OrderParams;
    }

    public String b() {
        return this.f78127f;
    }

    public String c() {
        return this.f78125d;
    }

    public String d() {
        return this.f78128g;
    }

    public int e() {
        return this.f78123b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderParams)) {
            return false;
        }
        OrderParams orderParams = (OrderParams) obj;
        if (!orderParams.a(this)) {
            return false;
        }
        String g11 = g();
        String g12 = orderParams.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        if (e() != orderParams.e()) {
            return false;
        }
        String h11 = h();
        String h12 = orderParams.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = orderParams.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String f11 = f();
        String f12 = orderParams.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        String b11 = b();
        String b12 = orderParams.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = orderParams.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public String f() {
        return this.f78126e;
    }

    public String g() {
        return this.f78122a;
    }

    public String h() {
        return this.f78124c;
    }

    public int hashCode() {
        String g11 = g();
        int i11 = 43;
        int hashCode = (((g11 == null ? 43 : g11.hashCode()) + 59) * 59) + e();
        String h11 = h();
        int hashCode2 = (hashCode * 59) + (h11 == null ? 43 : h11.hashCode());
        String c11 = c();
        int hashCode3 = (hashCode2 * 59) + (c11 == null ? 43 : c11.hashCode());
        String f11 = f();
        int hashCode4 = (hashCode3 * 59) + (f11 == null ? 43 : f11.hashCode());
        String b11 = b();
        int hashCode5 = (hashCode4 * 59) + (b11 == null ? 43 : b11.hashCode());
        String d11 = d();
        int i12 = hashCode5 * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public void i(String str) {
        this.f78127f = str;
    }

    public void j(String str) {
        this.f78125d = str;
    }

    public void k(String str) {
        this.f78128g = str;
    }

    public void l(int i11) {
        this.f78123b = i11;
    }

    public void m(String str) {
        this.f78126e = str;
    }

    public void n(String str) {
        this.f78122a = str;
    }

    public void o(String str) {
        this.f78124c = str;
    }

    public String toString() {
        return "OrderParams(symbol=" + g() + ", size=" + e() + ", types=" + h() + ", fromId=" + c() + ", startDate=" + f() + ", endDate=" + b() + ", orderStatus=" + d() + ")";
    }
}
