package com.huobi.homemarket.bean;

import android.view.View;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.contract.viewhandler.LinearSwapCollectionMarketNewHandler;
import com.huobi.contract.viewhandler.LinearSwapMarketNewHandler;
import ml.b;

public class MarketLinearSwapPriceItem implements b {

    /* renamed from: b  reason: collision with root package name */
    public int f72620b;

    /* renamed from: c  reason: collision with root package name */
    public int f72621c;

    /* renamed from: d  reason: collision with root package name */
    public String f72622d;

    /* renamed from: e  reason: collision with root package name */
    public String f72623e;

    /* renamed from: f  reason: collision with root package name */
    public FutureContractInfo f72624f;

    /* renamed from: g  reason: collision with root package name */
    public SymbolPrice f72625g;

    /* renamed from: h  reason: collision with root package name */
    public String f72626h = "--";

    /* renamed from: i  reason: collision with root package name */
    public String f72627i = "--";

    /* renamed from: j  reason: collision with root package name */
    public String f72628j;

    /* renamed from: k  reason: collision with root package name */
    public int f72629k;

    /* renamed from: l  reason: collision with root package name */
    public String f72630l;

    /* renamed from: m  reason: collision with root package name */
    public String f72631m;

    /* renamed from: n  reason: collision with root package name */
    public a f72632n;

    public interface a {
        void a(View view, MarketLinearSwapPriceItem marketLinearSwapPriceItem);
    }

    public boolean a(Object obj) {
        return obj instanceof MarketLinearSwapPriceItem;
    }

    public int b() {
        return this.f72620b;
    }

    public a c() {
        return this.f72632n;
    }

    public String d() {
        return this.f72626h;
    }

    public String e() {
        return this.f72627i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketLinearSwapPriceItem)) {
            return false;
        }
        MarketLinearSwapPriceItem marketLinearSwapPriceItem = (MarketLinearSwapPriceItem) obj;
        if (!marketLinearSwapPriceItem.a(this) || b() != marketLinearSwapPriceItem.b() || getWeight() != marketLinearSwapPriceItem.getWeight()) {
            return false;
        }
        String baseCurrency = getBaseCurrency();
        String baseCurrency2 = marketLinearSwapPriceItem.getBaseCurrency();
        if (baseCurrency != null ? !baseCurrency.equals(baseCurrency2) : baseCurrency2 != null) {
            return false;
        }
        String quoteCurrency = getQuoteCurrency();
        String quoteCurrency2 = marketLinearSwapPriceItem.getQuoteCurrency();
        if (quoteCurrency != null ? !quoteCurrency.equals(quoteCurrency2) : quoteCurrency2 != null) {
            return false;
        }
        FutureContractInfo i11 = i();
        FutureContractInfo i12 = marketLinearSwapPriceItem.i();
        if (i11 != null ? !i11.equals(i12) : i12 != null) {
            return false;
        }
        SymbolPrice symbolPrice = getSymbolPrice();
        SymbolPrice symbolPrice2 = marketLinearSwapPriceItem.getSymbolPrice();
        if (symbolPrice != null ? !symbolPrice.equals(symbolPrice2) : symbolPrice2 != null) {
            return false;
        }
        String d11 = d();
        String d12 = marketLinearSwapPriceItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = marketLinearSwapPriceItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        String f11 = f();
        String f12 = marketLinearSwapPriceItem.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        if (j() != marketLinearSwapPriceItem.j()) {
            return false;
        }
        String g11 = g();
        String g12 = marketLinearSwapPriceItem.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String h11 = h();
        String h12 = marketLinearSwapPriceItem.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = marketLinearSwapPriceItem.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String f() {
        return this.f72628j;
    }

    public String g() {
        return this.f72630l;
    }

    public String getBaseCurrency() {
        return this.f72622d;
    }

    public String getBaseCurrencyDisplayName() {
        return this.f72622d;
    }

    public String getQuoteCurrency() {
        return this.f72623e;
    }

    public SymbolPrice getSymbolPrice() {
        return this.f72625g;
    }

    public String getViewHandlerName() {
        if (this.f72629k == 2) {
            return LinearSwapCollectionMarketNewHandler.class.getName();
        }
        return LinearSwapMarketNewHandler.class.getName();
    }

    public int getWeight() {
        return this.f72621c;
    }

    public String h() {
        return this.f72631m;
    }

    public int hashCode() {
        int b11 = ((b() + 59) * 59) + getWeight();
        String baseCurrency = getBaseCurrency();
        int i11 = 43;
        int hashCode = (b11 * 59) + (baseCurrency == null ? 43 : baseCurrency.hashCode());
        String quoteCurrency = getQuoteCurrency();
        int hashCode2 = (hashCode * 59) + (quoteCurrency == null ? 43 : quoteCurrency.hashCode());
        FutureContractInfo i12 = i();
        int hashCode3 = (hashCode2 * 59) + (i12 == null ? 43 : i12.hashCode());
        SymbolPrice symbolPrice = getSymbolPrice();
        int hashCode4 = (hashCode3 * 59) + (symbolPrice == null ? 43 : symbolPrice.hashCode());
        String d11 = d();
        int hashCode5 = (hashCode4 * 59) + (d11 == null ? 43 : d11.hashCode());
        String e11 = e();
        int hashCode6 = (hashCode5 * 59) + (e11 == null ? 43 : e11.hashCode());
        String f11 = f();
        int hashCode7 = (((hashCode6 * 59) + (f11 == null ? 43 : f11.hashCode())) * 59) + j();
        String g11 = g();
        int hashCode8 = (hashCode7 * 59) + (g11 == null ? 43 : g11.hashCode());
        String h11 = h();
        int hashCode9 = (hashCode8 * 59) + (h11 == null ? 43 : h11.hashCode());
        a c11 = c();
        int i13 = hashCode9 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i13 + i11;
    }

    public FutureContractInfo i() {
        return this.f72624f;
    }

    public int j() {
        return this.f72629k;
    }

    public void k(String str) {
        this.f72622d = str;
    }

    public void l(a aVar) {
        this.f72632n = aVar;
    }

    public void m(String str) {
        this.f72626h = str;
    }

    public void n(String str) {
        this.f72627i = str;
    }

    public void o(int i11) {
        this.f72620b = i11;
    }

    public void p(String str) {
        this.f72628j = str;
    }

    public void q(String str) {
        this.f72630l = str;
    }

    public void r(String str) {
        this.f72631m = str;
    }

    public void s(FutureContractInfo futureContractInfo) {
        this.f72624f = futureContractInfo;
    }

    public void t(SymbolPrice symbolPrice) {
        this.f72625g = symbolPrice;
    }

    public String toString() {
        return "MarketLinearSwapPriceItem(collectionWeight=" + b() + ", weight=" + getWeight() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", swapCurrencyInfo=" + i() + ", symbolPrice=" + getSymbolPrice() + ", close=" + d() + ", cnyStr=" + e() + ", currencyAmount24H=" + f() + ", type=" + j() + ", showName=" + g() + ", showSubName=" + h() + ", callback=" + c() + ")";
    }

    public void u(int i11) {
        this.f72629k = i11;
    }

    public void v(int i11) {
        this.f72621c = i11;
    }
}
