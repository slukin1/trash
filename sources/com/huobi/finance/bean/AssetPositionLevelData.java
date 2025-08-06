package com.huobi.finance.bean;

import al.t;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.asset.AssetAccountType;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.viewhandler.AssetPositionLevelItemViewHandler;
import com.huobi.supermargin.bean.MarginOverview;
import i6.m;
import java.math.BigDecimal;
import wi.a;

public class AssetPositionLevelData extends BasePositionSortAccountItem<AssetPositionLevelData> {

    /* renamed from: b  reason: collision with root package name */
    public AssetAccountType f45294b = AssetAccountType.MARGIN;

    /* renamed from: c  reason: collision with root package name */
    public boolean f45295c = false;

    /* renamed from: d  reason: collision with root package name */
    public String f45296d;

    /* renamed from: e  reason: collision with root package name */
    public String f45297e;

    /* renamed from: f  reason: collision with root package name */
    public String f45298f;

    /* renamed from: g  reason: collision with root package name */
    public MarginOverview f45299g;

    /* renamed from: h  reason: collision with root package name */
    public String f45300h;

    /* renamed from: i  reason: collision with root package name */
    public String f45301i;

    /* renamed from: j  reason: collision with root package name */
    public String f45302j;

    /* renamed from: k  reason: collision with root package name */
    public String f45303k;

    /* renamed from: l  reason: collision with root package name */
    public String f45304l;

    /* renamed from: m  reason: collision with root package name */
    public String f45305m;

    /* renamed from: n  reason: collision with root package name */
    public String f45306n;

    /* renamed from: o  reason: collision with root package name */
    public String f45307o;

    /* renamed from: p  reason: collision with root package name */
    public String f45308p;

    /* renamed from: q  reason: collision with root package name */
    public String f45309q;

    /* renamed from: r  reason: collision with root package name */
    public String f45310r;

    /* renamed from: s  reason: collision with root package name */
    public String f45311s;

    /* renamed from: t  reason: collision with root package name */
    public String f45312t;

    /* renamed from: u  reason: collision with root package name */
    public String f45313u;

    /* renamed from: v  reason: collision with root package name */
    public String f45314v;

    /* renamed from: w  reason: collision with root package name */
    public String f45315w;

    public void A(String str) {
        this.f45303k = str;
    }

    public void B(String str) {
        this.f45306n = str;
    }

    public void C(String str) {
        this.f45296d = str;
    }

    public void D(String str) {
        this.f45301i = str;
    }

    public void E(MarginOverview marginOverview) {
        this.f45299g = marginOverview;
    }

    public void F(String str) {
        this.f45302j = str;
    }

    public void G(String str) {
        this.f45298f = str;
    }

    public void H(String str) {
        this.f45311s = str;
    }

    public void I(String str) {
        this.f45309q = str;
    }

    public void J(String str) {
        this.f45313u = str;
    }

    public void K(String str) {
        this.f45315w = str;
    }

    public void L(String str) {
        this.f45304l = str;
    }

    public void M(String str) {
        this.f45307o = str;
    }

    public void N(String str) {
        this.f45300h = str;
    }

    public void O(boolean z11) {
        this.f45295c = z11;
    }

    public boolean c() {
        BigDecimal bigDecimal;
        if (this.f45295c) {
            bigDecimal = t.a(this.f45296d, m.a(n()).add(m.a(i())).toPlainString());
        } else {
            bigDecimal = t.a(this.f45297e, m.a(h()).add(m.a(g())).toPlainString()).add(t.a(this.f45298f, m.a(q()).add(m.a(p())).toPlainString()));
        }
        return bigDecimal.abs().compareTo(a.f48036a) < 0;
    }

    /* renamed from: e */
    public int a(int i11, AssetPositionLevelData assetPositionLevelData) {
        if (i11 == 1 || i11 == 2 || i11 == 3) {
            return m.a(j()).compareTo(m.a(assetPositionLevelData.j()));
        }
        return 0;
    }

    public String f() {
        return this.f45305m;
    }

    public String g() {
        return this.f45312t;
    }

    public String getBaseCurrency() {
        return this.f45297e;
    }

    public String getBaseCurrencyDisplayName() {
        return this.f45308p;
    }

    public String getQuoteCurrency() {
        return this.f45298f;
    }

    public String getViewHandlerName() {
        return AssetPositionLevelItemViewHandler.class.getName();
    }

    public String h() {
        return this.f45303k;
    }

    public String i() {
        return this.f45306n;
    }

    public String j() {
        if (this.f45295c) {
            return LegalCurrencyConfigUtil.G(n(), k(), TradeType.PRO);
        }
        String h11 = h();
        String baseCurrency = getBaseCurrency();
        TradeType tradeType = TradeType.PRO;
        return m.a(LegalCurrencyConfigUtil.G(h11, baseCurrency, tradeType)).add(m.a(LegalCurrencyConfigUtil.G(q(), getQuoteCurrency(), tradeType))).toPlainString();
    }

    public String k() {
        return this.f45296d;
    }

    public AssetAccountType l() {
        return this.f45294b;
    }

    public MarginOverview m() {
        return this.f45299g;
    }

    public String n() {
        return this.f45302j;
    }

    public String o() {
        return this.f45309q;
    }

    public String p() {
        return this.f45313u;
    }

    public String q() {
        return this.f45304l;
    }

    public String r() {
        MarginOverview marginOverview;
        if (!this.f45295c || (marginOverview = this.f45299g) == null) {
            return this.f45307o;
        }
        return marginOverview.getRiskRate();
    }

    public String s() {
        return this.f45300h;
    }

    public boolean t() {
        return this.f45295c;
    }

    public void u(String str) {
        this.f45305m = str;
    }

    public void v(String str) {
        this.f45297e = str;
    }

    public void w(String str) {
        this.f45310r = str;
    }

    public void x(String str) {
        this.f45308p = str;
    }

    public void y(String str) {
        this.f45312t = str;
    }

    public void z(String str) {
        this.f45314v = str;
    }
}
