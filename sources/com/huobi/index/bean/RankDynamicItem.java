package com.huobi.index.bean;

import com.hbg.lib.network.hbg.core.bean.RankListItemBean;
import com.huobi.index.presenter.g;
import com.huobi.index.viewhandler.RankDynamicItemHandler;
import com.huobi.index.viewhandler.RankNewSymbolItemHandler;
import s9.a;

public class RankDynamicItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public RankListItemBean f73207b;

    /* renamed from: c  reason: collision with root package name */
    public g.b f73208c;

    /* renamed from: d  reason: collision with root package name */
    public String f73209d;

    /* renamed from: e  reason: collision with root package name */
    public String f73210e;

    /* renamed from: f  reason: collision with root package name */
    public String f73211f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f73212g;

    /* renamed from: h  reason: collision with root package name */
    public String f73213h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f73214i;

    /* renamed from: j  reason: collision with root package name */
    public String f73215j;

    /* renamed from: k  reason: collision with root package name */
    public int f73216k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f73217l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f73218m;

    public boolean a(Object obj) {
        return obj instanceof RankDynamicItem;
    }

    public g.b c() {
        return this.f73208c;
    }

    public String d() {
        return this.f73213h;
    }

    public String e() {
        return this.f73211f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RankDynamicItem)) {
            return false;
        }
        RankDynamicItem rankDynamicItem = (RankDynamicItem) obj;
        if (!rankDynamicItem.a(this)) {
            return false;
        }
        RankListItemBean g11 = g();
        RankListItemBean g12 = rankDynamicItem.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        g.b c11 = c();
        g.b c12 = rankDynamicItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String baseCurrencyDisplayName = getBaseCurrencyDisplayName();
        String baseCurrencyDisplayName2 = rankDynamicItem.getBaseCurrencyDisplayName();
        if (baseCurrencyDisplayName != null ? !baseCurrencyDisplayName.equals(baseCurrencyDisplayName2) : baseCurrencyDisplayName2 != null) {
            return false;
        }
        String f11 = f();
        String f12 = rankDynamicItem.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = rankDynamicItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        if (k() != rankDynamicItem.k()) {
            return false;
        }
        String d11 = d();
        String d12 = rankDynamicItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        if (l() != rankDynamicItem.l()) {
            return false;
        }
        String h11 = h();
        String h12 = rankDynamicItem.h();
        if (h11 != null ? h11.equals(h12) : h12 == null) {
            return i() == rankDynamicItem.i() && j() == rankDynamicItem.j() && m() == rankDynamicItem.m();
        }
        return false;
    }

    public String f() {
        return this.f73210e;
    }

    public RankListItemBean g() {
        return this.f73207b;
    }

    public String getBaseCurrencyDisplayName() {
        return this.f73209d;
    }

    public String getViewHandlerName() {
        if (this.f73218m) {
            return RankNewSymbolItemHandler.class.getName();
        }
        return RankDynamicItemHandler.class.getName();
    }

    public String h() {
        return this.f73215j;
    }

    public int hashCode() {
        RankListItemBean g11 = g();
        int i11 = 43;
        int hashCode = g11 == null ? 43 : g11.hashCode();
        g.b c11 = c();
        int hashCode2 = ((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
        String baseCurrencyDisplayName = getBaseCurrencyDisplayName();
        int hashCode3 = (hashCode2 * 59) + (baseCurrencyDisplayName == null ? 43 : baseCurrencyDisplayName.hashCode());
        String f11 = f();
        int hashCode4 = (hashCode3 * 59) + (f11 == null ? 43 : f11.hashCode());
        String e11 = e();
        int i12 = 79;
        int hashCode5 = (((hashCode4 * 59) + (e11 == null ? 43 : e11.hashCode())) * 59) + (k() ? 79 : 97);
        String d11 = d();
        int hashCode6 = (((hashCode5 * 59) + (d11 == null ? 43 : d11.hashCode())) * 59) + (l() ? 79 : 97);
        String h11 = h();
        int i13 = hashCode6 * 59;
        if (h11 != null) {
            i11 = h11.hashCode();
        }
        int i14 = (((((i13 + i11) * 59) + i()) * 59) + (j() ? 79 : 97)) * 59;
        if (!m()) {
            i12 = 97;
        }
        return i14 + i12;
    }

    public int i() {
        return this.f73216k;
    }

    public boolean j() {
        return this.f73217l;
    }

    public boolean k() {
        return this.f73212g;
    }

    public boolean l() {
        return this.f73214i;
    }

    public boolean m() {
        return this.f73218m;
    }

    public void n(String str) {
        this.f73209d = str;
    }

    public void o(g.b bVar) {
        this.f73208c = bVar;
    }

    public void p(String str) {
        this.f73213h = str;
    }

    public void q(String str) {
        this.f73211f = str;
    }

    public void r(String str) {
        this.f73210e = str;
    }

    public void s(RankListItemBean rankListItemBean) {
        this.f73207b = rankListItemBean;
    }

    public void t(boolean z11) {
        this.f73217l = z11;
    }

    public String toString() {
        return "RankDynamicItem(rankBean=" + g() + ", futureRankItem=" + c() + ", baseCurrencyDisplayName=" + getBaseCurrencyDisplayName() + ", quoteCurrencyDisplayName=" + f() + ", price=" + e() + ", showPercent=" + k() + ", percent=" + d() + ", showSymbol=" + l() + ", tagUrl=" + h() + ", type=" + i() + ", screen=" + j() + ", untradeable=" + m() + ")";
    }

    public void u(boolean z11) {
        this.f73212g = z11;
    }

    public void v(boolean z11) {
        this.f73214i = z11;
    }

    public void w(String str) {
        this.f73215j = str;
    }

    public void x(int i11) {
        this.f73216k = i11;
    }
}
