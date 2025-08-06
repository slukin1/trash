package com.huobi.homemarket.bean;

import android.view.View;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.contract.viewhandler.MarketViewCollectionHandler;
import com.huobi.homemarket.handler.MarketViewHandler;
import ml.b;

public class MarketSymbolPriceItem implements b {

    /* renamed from: b  reason: collision with root package name */
    public SymbolPrice f72646b;

    /* renamed from: c  reason: collision with root package name */
    public String f72647c;

    /* renamed from: d  reason: collision with root package name */
    public String f72648d;

    /* renamed from: e  reason: collision with root package name */
    public String f72649e;

    /* renamed from: f  reason: collision with root package name */
    public String f72650f;

    /* renamed from: g  reason: collision with root package name */
    public String f72651g;

    /* renamed from: h  reason: collision with root package name */
    public String f72652h;

    /* renamed from: i  reason: collision with root package name */
    public String f72653i;

    /* renamed from: j  reason: collision with root package name */
    public int f72654j;

    /* renamed from: k  reason: collision with root package name */
    public TradeType f72655k;

    /* renamed from: l  reason: collision with root package name */
    public int f72656l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f72657m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f72658n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f72659o;

    /* renamed from: p  reason: collision with root package name */
    public SymbolBean f72660p;

    /* renamed from: q  reason: collision with root package name */
    public String f72661q = "--";

    /* renamed from: r  reason: collision with root package name */
    public String f72662r = "--";

    /* renamed from: s  reason: collision with root package name */
    public String f72663s;

    /* renamed from: t  reason: collision with root package name */
    public String f72664t;

    /* renamed from: u  reason: collision with root package name */
    public a f72665u;

    /* renamed from: v  reason: collision with root package name */
    public int f72666v;

    /* renamed from: w  reason: collision with root package name */
    public long f72667w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f72668x;

    public interface a {
        void a(View view, MarketSymbolPriceItem marketSymbolPriceItem);
    }

    public void A(boolean z11) {
        this.f72659o = z11;
    }

    public void B(boolean z11) {
        this.f72658n = z11;
    }

    public void C(String str) {
        this.f72650f = str;
    }

    public void D(String str) {
        this.f72652h = str;
    }

    public void E(boolean z11) {
        this.f72668x = z11;
    }

    public void F(boolean z11) {
        this.f72657m = z11;
    }

    public void G(String str) {
        this.f72653i = str;
    }

    public void H(String str) {
        this.f72647c = str;
    }

    public void I(SymbolBean symbolBean) {
        this.f72660p = symbolBean;
    }

    public void J(SymbolPrice symbolPrice) {
        this.f72646b = symbolPrice;
    }

    public void K(long j11) {
        this.f72667w = j11;
    }

    public void L(TradeType tradeType) {
        this.f72655k = tradeType;
    }

    public void M(int i11) {
        this.f72666v = i11;
    }

    public void N(int i11) {
        this.f72654j = i11;
    }

    public boolean a(Object obj) {
        return obj instanceof MarketSymbolPriceItem;
    }

    public int b() {
        return this.f72656l;
    }

    public a c() {
        return this.f72665u;
    }

    public String d() {
        return this.f72662r;
    }

    public String e() {
        return this.f72661q;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketSymbolPriceItem)) {
            return false;
        }
        MarketSymbolPriceItem marketSymbolPriceItem = (MarketSymbolPriceItem) obj;
        if (!marketSymbolPriceItem.a(this)) {
            return false;
        }
        SymbolPrice symbolPrice = getSymbolPrice();
        SymbolPrice symbolPrice2 = marketSymbolPriceItem.getSymbolPrice();
        if (symbolPrice != null ? !symbolPrice.equals(symbolPrice2) : symbolPrice2 != null) {
            return false;
        }
        String j11 = j();
        String j12 = marketSymbolPriceItem.j();
        if (j11 != null ? !j11.equals(j12) : j12 != null) {
            return false;
        }
        String g11 = g();
        String g12 = marketSymbolPriceItem.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String baseCurrency = getBaseCurrency();
        String baseCurrency2 = marketSymbolPriceItem.getBaseCurrency();
        if (baseCurrency != null ? !baseCurrency.equals(baseCurrency2) : baseCurrency2 != null) {
            return false;
        }
        String quoteCurrency = getQuoteCurrency();
        String quoteCurrency2 = marketSymbolPriceItem.getQuoteCurrency();
        if (quoteCurrency != null ? !quoteCurrency.equals(quoteCurrency2) : quoteCurrency2 != null) {
            return false;
        }
        String baseCurrencyDisplayName = getBaseCurrencyDisplayName();
        String baseCurrencyDisplayName2 = marketSymbolPriceItem.getBaseCurrencyDisplayName();
        if (baseCurrencyDisplayName != null ? !baseCurrencyDisplayName.equals(baseCurrencyDisplayName2) : baseCurrencyDisplayName2 != null) {
            return false;
        }
        String h11 = h();
        String h12 = marketSymbolPriceItem.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        String i11 = i();
        String i12 = marketSymbolPriceItem.i();
        if (i11 != null ? !i11.equals(i12) : i12 != null) {
            return false;
        }
        if (getWeight() != marketSymbolPriceItem.getWeight()) {
            return false;
        }
        TradeType m11 = m();
        TradeType m12 = marketSymbolPriceItem.m();
        if (m11 != null ? !m11.equals(m12) : m12 != null) {
            return false;
        }
        if (b() != marketSymbolPriceItem.b() || s() != marketSymbolPriceItem.s() || q() != marketSymbolPriceItem.q() || p() != marketSymbolPriceItem.p()) {
            return false;
        }
        SymbolBean k11 = k();
        SymbolBean k12 = marketSymbolPriceItem.k();
        if (k11 != null ? !k11.equals(k12) : k12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = marketSymbolPriceItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = marketSymbolPriceItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String f11 = f();
        String f12 = marketSymbolPriceItem.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        String o11 = o();
        String o12 = marketSymbolPriceItem.o();
        if (o11 != null ? !o11.equals(o12) : o12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = marketSymbolPriceItem.c();
        if (c11 != null ? c11.equals(c12) : c12 == null) {
            return n() == marketSymbolPriceItem.n() && l() == marketSymbolPriceItem.l() && r() == marketSymbolPriceItem.r();
        }
        return false;
    }

    public String f() {
        return this.f72663s;
    }

    public String g() {
        return this.f72648d;
    }

    public String getBaseCurrency() {
        return this.f72649e;
    }

    public String getBaseCurrencyDisplayName() {
        return this.f72651g;
    }

    public String getQuoteCurrency() {
        return this.f72650f;
    }

    public SymbolPrice getSymbolPrice() {
        return this.f72646b;
    }

    public String getViewHandlerName() {
        if (this.f72666v == 1) {
            return MarketViewCollectionHandler.class.getName();
        }
        return MarketViewHandler.class.getName();
    }

    public int getWeight() {
        return this.f72654j;
    }

    public String h() {
        return this.f72652h;
    }

    public int hashCode() {
        SymbolPrice symbolPrice = getSymbolPrice();
        int i11 = 43;
        int hashCode = symbolPrice == null ? 43 : symbolPrice.hashCode();
        String j11 = j();
        int hashCode2 = ((hashCode + 59) * 59) + (j11 == null ? 43 : j11.hashCode());
        String g11 = g();
        int hashCode3 = (hashCode2 * 59) + (g11 == null ? 43 : g11.hashCode());
        String baseCurrency = getBaseCurrency();
        int hashCode4 = (hashCode3 * 59) + (baseCurrency == null ? 43 : baseCurrency.hashCode());
        String quoteCurrency = getQuoteCurrency();
        int hashCode5 = (hashCode4 * 59) + (quoteCurrency == null ? 43 : quoteCurrency.hashCode());
        String baseCurrencyDisplayName = getBaseCurrencyDisplayName();
        int hashCode6 = (hashCode5 * 59) + (baseCurrencyDisplayName == null ? 43 : baseCurrencyDisplayName.hashCode());
        String h11 = h();
        int hashCode7 = (hashCode6 * 59) + (h11 == null ? 43 : h11.hashCode());
        String i12 = i();
        int hashCode8 = (((hashCode7 * 59) + (i12 == null ? 43 : i12.hashCode())) * 59) + getWeight();
        TradeType m11 = m();
        int i13 = 79;
        int hashCode9 = (((((((((hashCode8 * 59) + (m11 == null ? 43 : m11.hashCode())) * 59) + b()) * 59) + (s() ? 79 : 97)) * 59) + (q() ? 79 : 97)) * 59) + (p() ? 79 : 97);
        SymbolBean k11 = k();
        int hashCode10 = (hashCode9 * 59) + (k11 == null ? 43 : k11.hashCode());
        String e11 = e();
        int hashCode11 = (hashCode10 * 59) + (e11 == null ? 43 : e11.hashCode());
        String d11 = d();
        int hashCode12 = (hashCode11 * 59) + (d11 == null ? 43 : d11.hashCode());
        String f11 = f();
        int hashCode13 = (hashCode12 * 59) + (f11 == null ? 43 : f11.hashCode());
        String o11 = o();
        int hashCode14 = (hashCode13 * 59) + (o11 == null ? 43 : o11.hashCode());
        a c11 = c();
        int i14 = hashCode14 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        long l11 = l();
        int n11 = (((((i14 + i11) * 59) + n()) * 59) + ((int) (l11 ^ (l11 >>> 32)))) * 59;
        if (!r()) {
            i13 = 97;
        }
        return n11 + i13;
    }

    public String i() {
        return this.f72653i;
    }

    public String j() {
        return this.f72647c;
    }

    public SymbolBean k() {
        return this.f72660p;
    }

    public long l() {
        return this.f72667w;
    }

    public TradeType m() {
        return this.f72655k;
    }

    public int n() {
        return this.f72666v;
    }

    public String o() {
        return this.f72664t;
    }

    public boolean p() {
        return this.f72659o;
    }

    public boolean q() {
        return this.f72658n;
    }

    public boolean r() {
        return this.f72668x;
    }

    public boolean s() {
        return this.f72657m;
    }

    public void t(String str) {
        this.f72649e = str;
    }

    public String toString() {
        return "MarketSymbolPriceItem(symbolPrice=" + getSymbolPrice() + ", symbol=" + j() + ", name=" + g() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", baseCurrencyDisplayName=" + getBaseCurrencyDisplayName() + ", quoteCurrencyDisplayName=" + h() + ", state=" + i() + ", weight=" + getWeight() + ", tradeType=" + m() + ", collectionWeight=" + b() + ", isStTag=" + s() + ", isPrime=" + q() + ", isHadaxTag=" + p() + ", symbolBean=" + k() + ", cnyStr=" + e() + ", close=" + d() + ", currencyAmount24H=" + f() + ", webSite=" + o() + ", callback=" + c() + ", type=" + n() + ", tradeOpenAt=" + l() + ", showStBg=" + r() + ")";
    }

    public void u(String str) {
        this.f72651g = str;
    }

    public void v(a aVar) {
        this.f72665u = aVar;
    }

    public void w(String str) {
        this.f72662r = str;
    }

    public void x(String str) {
        this.f72661q = str;
    }

    public void y(int i11) {
        this.f72656l = i11;
    }

    public void z(String str) {
        this.f72663s = str;
    }
}
