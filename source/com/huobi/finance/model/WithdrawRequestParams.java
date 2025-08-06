package com.huobi.finance.model;

import com.huobi.login.usercenter.data.source.bean.SecurityStrategySet;

public class WithdrawRequestParams {

    /* renamed from: a  reason: collision with root package name */
    public String f45442a;

    /* renamed from: b  reason: collision with root package name */
    public SecurityStrategySet f45443b;

    /* renamed from: c  reason: collision with root package name */
    public String f45444c;

    /* renamed from: d  reason: collision with root package name */
    public String f45445d;

    /* renamed from: e  reason: collision with root package name */
    public String f45446e;

    /* renamed from: f  reason: collision with root package name */
    public String f45447f;

    /* renamed from: g  reason: collision with root package name */
    public String f45448g;

    /* renamed from: h  reason: collision with root package name */
    public String f45449h;

    /* renamed from: i  reason: collision with root package name */
    public String f45450i;

    /* renamed from: j  reason: collision with root package name */
    public String f45451j;

    /* renamed from: k  reason: collision with root package name */
    public String f45452k;

    public boolean a(Object obj) {
        return obj instanceof WithdrawRequestParams;
    }

    public String b() {
        return this.f45450i;
    }

    public String c() {
        return this.f45449h;
    }

    public String d() {
        return this.f45445d;
    }

    public String e() {
        return this.f45452k;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WithdrawRequestParams)) {
            return false;
        }
        WithdrawRequestParams withdrawRequestParams = (WithdrawRequestParams) obj;
        if (!withdrawRequestParams.a(this)) {
            return false;
        }
        String g11 = g();
        String g12 = withdrawRequestParams.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        SecurityStrategySet j11 = j();
        SecurityStrategySet j12 = withdrawRequestParams.j();
        if (j11 != null ? !j11.equals(j12) : j12 != null) {
            return false;
        }
        String l11 = l();
        String l12 = withdrawRequestParams.l();
        if (l11 != null ? !l11.equals(l12) : l12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = withdrawRequestParams.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String i11 = i();
        String i12 = withdrawRequestParams.i();
        if (i11 != null ? !i11.equals(i12) : i12 != null) {
            return false;
        }
        String f11 = f();
        String f12 = withdrawRequestParams.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        String h11 = h();
        String h12 = withdrawRequestParams.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = withdrawRequestParams.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String b11 = b();
        String b12 = withdrawRequestParams.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        String k11 = k();
        String k12 = withdrawRequestParams.k();
        if (k11 != null ? !k11.equals(k12) : k12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = withdrawRequestParams.e();
        return e11 != null ? e11.equals(e12) : e12 == null;
    }

    public String f() {
        return this.f45447f;
    }

    public String g() {
        return this.f45442a;
    }

    public String h() {
        return this.f45448g;
    }

    public int hashCode() {
        String g11 = g();
        int i11 = 43;
        int hashCode = g11 == null ? 43 : g11.hashCode();
        SecurityStrategySet j11 = j();
        int hashCode2 = ((hashCode + 59) * 59) + (j11 == null ? 43 : j11.hashCode());
        String l11 = l();
        int hashCode3 = (hashCode2 * 59) + (l11 == null ? 43 : l11.hashCode());
        String d11 = d();
        int hashCode4 = (hashCode3 * 59) + (d11 == null ? 43 : d11.hashCode());
        String i12 = i();
        int hashCode5 = (hashCode4 * 59) + (i12 == null ? 43 : i12.hashCode());
        String f11 = f();
        int hashCode6 = (hashCode5 * 59) + (f11 == null ? 43 : f11.hashCode());
        String h11 = h();
        int hashCode7 = (hashCode6 * 59) + (h11 == null ? 43 : h11.hashCode());
        String c11 = c();
        int hashCode8 = (hashCode7 * 59) + (c11 == null ? 43 : c11.hashCode());
        String b11 = b();
        int hashCode9 = (hashCode8 * 59) + (b11 == null ? 43 : b11.hashCode());
        String k11 = k();
        int hashCode10 = (hashCode9 * 59) + (k11 == null ? 43 : k11.hashCode());
        String e11 = e();
        int i13 = hashCode10 * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return i13 + i11;
    }

    public String i() {
        return this.f45446e;
    }

    public SecurityStrategySet j() {
        return this.f45443b;
    }

    public String k() {
        return this.f45451j;
    }

    public String l() {
        return this.f45444c;
    }

    public void m(String str) {
        this.f45450i = str;
    }

    public void n(String str) {
        this.f45449h = str;
    }

    public void o(String str) {
        this.f45445d = str;
    }

    public void p(String str) {
        this.f45452k = str;
    }

    public void q(String str) {
        this.f45447f = str;
    }

    public void r(String str) {
        this.f45442a = str;
    }

    public void s(String str) {
        this.f45448g = str;
    }

    public void t(String str) {
        this.f45446e = str;
    }

    public String toString() {
        return "WithdrawRequestParams(orderId=" + g() + ", strategySet=" + j() + ", useType=" + l() + ", emailCode=" + d() + ", smsCode=" + i() + ", gaCode=" + f() + ", password=" + h() + ", amount=" + c() + ", address=" + b() + ", tag=" + k() + ", fee=" + e() + ")";
    }

    public void u(SecurityStrategySet securityStrategySet) {
        this.f45443b = securityStrategySet;
    }

    public void v(String str) {
        this.f45451j = str;
    }

    public void w(String str) {
        this.f45444c = str;
    }
}
