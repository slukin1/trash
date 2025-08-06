package com.huobi.homemarket.bean;

import android.view.View;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.contract.viewhandler.ContractCollectionMarketNewHandler;
import com.huobi.contract.viewhandler.ContractMarketNewHandler;
import ml.b;

public class MarketContractSymbolPriceItem implements b {

    /* renamed from: b  reason: collision with root package name */
    public ContractCurrencyInfo f72591b;

    /* renamed from: c  reason: collision with root package name */
    public String f72592c;

    /* renamed from: d  reason: collision with root package name */
    public String f72593d;

    /* renamed from: e  reason: collision with root package name */
    public String f72594e;

    /* renamed from: f  reason: collision with root package name */
    public String f72595f;

    /* renamed from: g  reason: collision with root package name */
    public int f72596g;

    /* renamed from: h  reason: collision with root package name */
    public int f72597h;

    /* renamed from: i  reason: collision with root package name */
    public SymbolPrice f72598i;

    /* renamed from: j  reason: collision with root package name */
    public String f72599j = "--";

    /* renamed from: k  reason: collision with root package name */
    public String f72600k = "--";

    /* renamed from: l  reason: collision with root package name */
    public String f72601l;

    /* renamed from: m  reason: collision with root package name */
    public int f72602m;

    /* renamed from: n  reason: collision with root package name */
    public String f72603n;

    /* renamed from: o  reason: collision with root package name */
    public String f72604o;

    /* renamed from: p  reason: collision with root package name */
    public a f72605p;

    public interface a {
        void a(View view, MarketContractSymbolPriceItem marketContractSymbolPriceItem);
    }

    public boolean a(Object obj) {
        return obj instanceof MarketContractSymbolPriceItem;
    }

    public int b() {
        return this.f72596g;
    }

    public a c() {
        return this.f72605p;
    }

    public String d() {
        return this.f72599j;
    }

    public String e() {
        return this.f72600k;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketContractSymbolPriceItem)) {
            return false;
        }
        MarketContractSymbolPriceItem marketContractSymbolPriceItem = (MarketContractSymbolPriceItem) obj;
        if (!marketContractSymbolPriceItem.a(this)) {
            return false;
        }
        ContractCurrencyInfo f11 = f();
        ContractCurrencyInfo f12 = marketContractSymbolPriceItem.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        String baseCurrency = getBaseCurrency();
        String baseCurrency2 = marketContractSymbolPriceItem.getBaseCurrency();
        if (baseCurrency != null ? !baseCurrency.equals(baseCurrency2) : baseCurrency2 != null) {
            return false;
        }
        String quoteCurrency = getQuoteCurrency();
        String quoteCurrency2 = marketContractSymbolPriceItem.getQuoteCurrency();
        if (quoteCurrency != null ? !quoteCurrency.equals(quoteCurrency2) : quoteCurrency2 != null) {
            return false;
        }
        String g11 = g();
        String g12 = marketContractSymbolPriceItem.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String k11 = k();
        String k12 = marketContractSymbolPriceItem.k();
        if (k11 != null ? !k11.equals(k12) : k12 != null) {
            return false;
        }
        if (b() != marketContractSymbolPriceItem.b() || getWeight() != marketContractSymbolPriceItem.getWeight()) {
            return false;
        }
        SymbolPrice symbolPrice = getSymbolPrice();
        SymbolPrice symbolPrice2 = marketContractSymbolPriceItem.getSymbolPrice();
        if (symbolPrice != null ? !symbolPrice.equals(symbolPrice2) : symbolPrice2 != null) {
            return false;
        }
        String d11 = d();
        String d12 = marketContractSymbolPriceItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = marketContractSymbolPriceItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        String h11 = h();
        String h12 = marketContractSymbolPriceItem.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        if (l() != marketContractSymbolPriceItem.l()) {
            return false;
        }
        String i11 = i();
        String i12 = marketContractSymbolPriceItem.i();
        if (i11 != null ? !i11.equals(i12) : i12 != null) {
            return false;
        }
        String j11 = j();
        String j12 = marketContractSymbolPriceItem.j();
        if (j11 != null ? !j11.equals(j12) : j12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = marketContractSymbolPriceItem.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public ContractCurrencyInfo f() {
        return this.f72591b;
    }

    public String g() {
        return this.f72594e;
    }

    public String getBaseCurrency() {
        return this.f72592c;
    }

    public String getBaseCurrencyDisplayName() {
        return this.f72592c;
    }

    public String getQuoteCurrency() {
        return this.f72593d;
    }

    public SymbolPrice getSymbolPrice() {
        return this.f72598i;
    }

    public String getViewHandlerName() {
        if (this.f72602m == 2) {
            return ContractCollectionMarketNewHandler.class.getName();
        }
        return ContractMarketNewHandler.class.getName();
    }

    public int getWeight() {
        return this.f72597h;
    }

    public String h() {
        return this.f72601l;
    }

    public int hashCode() {
        ContractCurrencyInfo f11 = f();
        int i11 = 43;
        int hashCode = f11 == null ? 43 : f11.hashCode();
        String baseCurrency = getBaseCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (baseCurrency == null ? 43 : baseCurrency.hashCode());
        String quoteCurrency = getQuoteCurrency();
        int hashCode3 = (hashCode2 * 59) + (quoteCurrency == null ? 43 : quoteCurrency.hashCode());
        String g11 = g();
        int hashCode4 = (hashCode3 * 59) + (g11 == null ? 43 : g11.hashCode());
        String k11 = k();
        int hashCode5 = (((((hashCode4 * 59) + (k11 == null ? 43 : k11.hashCode())) * 59) + b()) * 59) + getWeight();
        SymbolPrice symbolPrice = getSymbolPrice();
        int hashCode6 = (hashCode5 * 59) + (symbolPrice == null ? 43 : symbolPrice.hashCode());
        String d11 = d();
        int hashCode7 = (hashCode6 * 59) + (d11 == null ? 43 : d11.hashCode());
        String e11 = e();
        int hashCode8 = (hashCode7 * 59) + (e11 == null ? 43 : e11.hashCode());
        String h11 = h();
        int hashCode9 = (((hashCode8 * 59) + (h11 == null ? 43 : h11.hashCode())) * 59) + l();
        String i12 = i();
        int hashCode10 = (hashCode9 * 59) + (i12 == null ? 43 : i12.hashCode());
        String j11 = j();
        int hashCode11 = (hashCode10 * 59) + (j11 == null ? 43 : j11.hashCode());
        a c11 = c();
        int i13 = hashCode11 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i13 + i11;
    }

    public String i() {
        return this.f72603n;
    }

    public String j() {
        return this.f72604o;
    }

    public String k() {
        return this.f72595f;
    }

    public int l() {
        return this.f72602m;
    }

    public void m(String str) {
        this.f72592c = str;
    }

    public void n(a aVar) {
        this.f72605p = aVar;
    }

    public void o(String str) {
        this.f72599j = str;
    }

    public void p(String str) {
        this.f72600k = str;
    }

    public void q(int i11) {
        this.f72596g = i11;
    }

    public void r(ContractCurrencyInfo contractCurrencyInfo) {
        this.f72591b = contractCurrencyInfo;
    }

    public void s(String str) {
        this.f72594e = str;
    }

    public void t(String str) {
        this.f72601l = str;
    }

    public String toString() {
        return "MarketContractSymbolPriceItem(contractCurrencyInfo=" + f() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", contractShortType=" + g() + ", state=" + k() + ", collectionWeight=" + b() + ", weight=" + getWeight() + ", symbolPrice=" + getSymbolPrice() + ", close=" + d() + ", cnyStr=" + e() + ", currencyAmount24H=" + h() + ", type=" + l() + ", showName=" + i() + ", showSubName=" + j() + ", callback=" + c() + ")";
    }

    public void u(String str) {
        this.f72603n = str;
    }

    public void v(String str) {
        this.f72604o = str;
    }

    public void w(SymbolPrice symbolPrice) {
        this.f72598i = symbolPrice;
    }

    public void x(int i11) {
        this.f72602m = i11;
    }

    public void y(int i11) {
        this.f72597h = i11;
    }
}
