package com.huobi.account.bean;

public class AccountKycInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f40942a;

    /* renamed from: b  reason: collision with root package name */
    public String f40943b;

    /* renamed from: c  reason: collision with root package name */
    public String f40944c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f40945d;

    /* renamed from: e  reason: collision with root package name */
    public String f40946e;

    /* renamed from: f  reason: collision with root package name */
    public String f40947f;

    /* renamed from: g  reason: collision with root package name */
    public int f40948g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f40949h;

    /* renamed from: i  reason: collision with root package name */
    public int f40950i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f40951j;

    public boolean a(Object obj) {
        return obj instanceof AccountKycInfo;
    }

    public String b() {
        return this.f40944c;
    }

    public int c() {
        return this.f40950i;
    }

    public String d() {
        return this.f40946e;
    }

    public int e() {
        return this.f40948g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountKycInfo)) {
            return false;
        }
        AccountKycInfo accountKycInfo = (AccountKycInfo) obj;
        if (!accountKycInfo.a(this)) {
            return false;
        }
        String g11 = g();
        String g12 = accountKycInfo.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String h11 = h();
        String h12 = accountKycInfo.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        String b11 = b();
        String b12 = accountKycInfo.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        if (k() != accountKycInfo.k()) {
            return false;
        }
        String d11 = d();
        String d12 = accountKycInfo.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String f11 = f();
        String f12 = accountKycInfo.f();
        if (f11 != null ? f11.equals(f12) : f12 == null) {
            return e() == accountKycInfo.e() && j() == accountKycInfo.j() && c() == accountKycInfo.c() && i() == accountKycInfo.i();
        }
        return false;
    }

    public String f() {
        return this.f40947f;
    }

    public String g() {
        return this.f40942a;
    }

    public String h() {
        return this.f40943b;
    }

    public int hashCode() {
        String g11 = g();
        int i11 = 43;
        int hashCode = g11 == null ? 43 : g11.hashCode();
        String h11 = h();
        int hashCode2 = ((hashCode + 59) * 59) + (h11 == null ? 43 : h11.hashCode());
        String b11 = b();
        int i12 = 79;
        int hashCode3 = (((hashCode2 * 59) + (b11 == null ? 43 : b11.hashCode())) * 59) + (k() ? 79 : 97);
        String d11 = d();
        int hashCode4 = (hashCode3 * 59) + (d11 == null ? 43 : d11.hashCode());
        String f11 = f();
        int i13 = hashCode4 * 59;
        if (f11 != null) {
            i11 = f11.hashCode();
        }
        int e11 = (((((((i13 + i11) * 59) + e()) * 59) + (j() ? 79 : 97)) * 59) + c()) * 59;
        if (!i()) {
            i12 = 97;
        }
        return e11 + i12;
    }

    public boolean i() {
        return this.f40951j;
    }

    public boolean j() {
        return this.f40949h;
    }

    public boolean k() {
        return this.f40945d;
    }

    public void l(String str) {
        this.f40944c = str;
    }

    public void m(boolean z11) {
        this.f40951j = z11;
    }

    public void n(boolean z11) {
        this.f40949h = z11;
    }

    public void o(int i11) {
        this.f40950i = i11;
    }

    public void p(String str) {
        this.f40946e = str;
    }

    public void q(int i11) {
        this.f40948g = i11;
    }

    public void r(String str) {
        this.f40947f = str;
    }

    public void s(String str) {
        this.f40942a = str;
    }

    public void t(boolean z11) {
        this.f40945d = z11;
    }

    public String toString() {
        return "AccountKycInfo(name=" + g() + ", uid=" + h() + ", avatarUrl=" + b() + ", showKycLabel=" + k() + ", kycLabelText=" + d() + ", kycStep=" + f() + ", kycStateWithNoStep=" + e() + ", isInst=" + j() + ", instStatus=" + c() + ", display=" + i() + ")";
    }

    public void u(String str) {
        this.f40943b = str;
    }
}
