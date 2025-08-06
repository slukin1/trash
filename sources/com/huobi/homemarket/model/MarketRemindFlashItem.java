package com.huobi.homemarket.model;

import com.huobi.homemarket.handler.MarketRemindFlashHandler;
import s9.a;

public class MarketRemindFlashItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public long f72730b;

    /* renamed from: c  reason: collision with root package name */
    public long f72731c;

    /* renamed from: d  reason: collision with root package name */
    public String f72732d;

    /* renamed from: e  reason: collision with root package name */
    public String f72733e;

    /* renamed from: f  reason: collision with root package name */
    public int f72734f;

    /* renamed from: g  reason: collision with root package name */
    public String f72735g;

    /* renamed from: h  reason: collision with root package name */
    public String f72736h;

    /* renamed from: i  reason: collision with root package name */
    public String f72737i;

    /* renamed from: j  reason: collision with root package name */
    public String f72738j;

    /* renamed from: k  reason: collision with root package name */
    public String f72739k;

    /* renamed from: l  reason: collision with root package name */
    public String f72740l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f72741m;

    public boolean a(Object obj) {
        return obj instanceof MarketRemindFlashItem;
    }

    public String c() {
        return this.f72738j;
    }

    public String d() {
        return this.f72737i;
    }

    public String e() {
        return this.f72739k;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketRemindFlashItem)) {
            return false;
        }
        MarketRemindFlashItem marketRemindFlashItem = (MarketRemindFlashItem) obj;
        if (!marketRemindFlashItem.a(this) || g() != marketRemindFlashItem.g() || m() != marketRemindFlashItem.m()) {
            return false;
        }
        String h11 = h();
        String h12 = marketRemindFlashItem.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        String j11 = j();
        String j12 = marketRemindFlashItem.j();
        if (j11 != null ? !j11.equals(j12) : j12 != null) {
            return false;
        }
        if (f() != marketRemindFlashItem.f()) {
            return false;
        }
        String i11 = i();
        String i12 = marketRemindFlashItem.i();
        if (i11 != null ? !i11.equals(i12) : i12 != null) {
            return false;
        }
        String l11 = l();
        String l12 = marketRemindFlashItem.l();
        if (l11 != null ? !l11.equals(l12) : l12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = marketRemindFlashItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = marketRemindFlashItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = marketRemindFlashItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        String k11 = k();
        String k12 = marketRemindFlashItem.k();
        if (k11 != null ? k11.equals(k12) : k12 == null) {
            return n() == marketRemindFlashItem.n();
        }
        return false;
    }

    public int f() {
        return this.f72734f;
    }

    public long g() {
        return this.f72730b;
    }

    public String getViewHandlerName() {
        return MarketRemindFlashHandler.class.getName();
    }

    public String h() {
        return this.f72732d;
    }

    public int hashCode() {
        long g11 = g();
        long m11 = m();
        String h11 = h();
        int i11 = (((((int) (g11 ^ (g11 >>> 32))) + 59) * 59) + ((int) ((m11 >>> 32) ^ m11))) * 59;
        int i12 = 43;
        int hashCode = i11 + (h11 == null ? 43 : h11.hashCode());
        String j11 = j();
        int hashCode2 = (((hashCode * 59) + (j11 == null ? 43 : j11.hashCode())) * 59) + f();
        String i13 = i();
        int hashCode3 = (hashCode2 * 59) + (i13 == null ? 43 : i13.hashCode());
        String l11 = l();
        int hashCode4 = (hashCode3 * 59) + (l11 == null ? 43 : l11.hashCode());
        String d11 = d();
        int hashCode5 = (hashCode4 * 59) + (d11 == null ? 43 : d11.hashCode());
        String c11 = c();
        int hashCode6 = (hashCode5 * 59) + (c11 == null ? 43 : c11.hashCode());
        String e11 = e();
        int hashCode7 = (hashCode6 * 59) + (e11 == null ? 43 : e11.hashCode());
        String k11 = k();
        int i14 = hashCode7 * 59;
        if (k11 != null) {
            i12 = k11.hashCode();
        }
        return ((i14 + i12) * 59) + (n() ? 79 : 97);
    }

    public String i() {
        return this.f72735g;
    }

    public String j() {
        return this.f72733e;
    }

    public String k() {
        return this.f72740l;
    }

    public String l() {
        return this.f72736h;
    }

    public long m() {
        return this.f72731c;
    }

    public boolean n() {
        return this.f72741m;
    }

    public void o(String str) {
        this.f72738j = str;
    }

    public void p(String str) {
        this.f72737i = str;
    }

    public void q(String str) {
        this.f72739k = str;
    }

    public void r(int i11) {
        this.f72734f = i11;
    }

    public void s(long j11) {
        this.f72730b = j11;
    }

    public void t(String str) {
        this.f72732d = str;
    }

    public String toString() {
        return "MarketRemindFlashItem(id=" + g() + ", ts=" + m() + ", pairId=" + h() + ", symbol=" + j() + ", direction=" + f() + ", strategyName=" + i() + ", title=" + l() + ", content=" + d() + ", coin=" + c() + ", date=" + e() + ", time=" + k() + ", sameDateWithPre=" + n() + ")";
    }

    public void u(boolean z11) {
        this.f72741m = z11;
    }

    public void v(String str) {
        this.f72735g = str;
    }

    public void w(String str) {
        this.f72733e = str;
    }

    public void x(String str) {
        this.f72740l = str;
    }

    public void y(String str) {
        this.f72736h = str;
    }

    public void z(long j11) {
        this.f72731c = j11;
    }
}
