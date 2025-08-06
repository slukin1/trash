package com.huobi.homemarket.bean;

import android.view.View;
import com.hbg.lib.network.index.core.bean.IndexCurrencyInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.contract.viewhandler.IndexMarketNewHandler;
import ml.b;

public class MarketIndexPriceItem implements b {

    /* renamed from: b  reason: collision with root package name */
    public IndexCurrencyInfo f72606b;

    /* renamed from: c  reason: collision with root package name */
    public SymbolPrice f72607c;

    /* renamed from: d  reason: collision with root package name */
    public String f72608d = "--";

    /* renamed from: e  reason: collision with root package name */
    public String f72609e = "--";

    /* renamed from: f  reason: collision with root package name */
    public boolean f72610f = true;

    /* renamed from: g  reason: collision with root package name */
    public int f72611g;

    /* renamed from: h  reason: collision with root package name */
    public String f72612h;

    /* renamed from: i  reason: collision with root package name */
    public String f72613i;

    /* renamed from: j  reason: collision with root package name */
    public int f72614j;

    /* renamed from: k  reason: collision with root package name */
    public int f72615k;

    /* renamed from: l  reason: collision with root package name */
    public String f72616l;

    /* renamed from: m  reason: collision with root package name */
    public String f72617m;

    /* renamed from: n  reason: collision with root package name */
    public a f72618n;

    /* renamed from: o  reason: collision with root package name */
    public String f72619o;

    public interface a {
        void a(View view, MarketIndexPriceItem marketIndexPriceItem);
    }

    public boolean a(Object obj) {
        return obj instanceof MarketIndexPriceItem;
    }

    public int b() {
        return this.f72615k;
    }

    public a c() {
        return this.f72618n;
    }

    public String d() {
        return this.f72608d;
    }

    public String e() {
        return this.f72609e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketIndexPriceItem)) {
            return false;
        }
        MarketIndexPriceItem marketIndexPriceItem = (MarketIndexPriceItem) obj;
        if (!marketIndexPriceItem.a(this)) {
            return false;
        }
        IndexCurrencyInfo f11 = f();
        IndexCurrencyInfo f12 = marketIndexPriceItem.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        SymbolPrice symbolPrice = getSymbolPrice();
        SymbolPrice symbolPrice2 = marketIndexPriceItem.getSymbolPrice();
        if (symbolPrice != null ? !symbolPrice.equals(symbolPrice2) : symbolPrice2 != null) {
            return false;
        }
        String d11 = d();
        String d12 = marketIndexPriceItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = marketIndexPriceItem.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        if (k() != marketIndexPriceItem.k() || j() != marketIndexPriceItem.j()) {
            return false;
        }
        String baseCurrency = getBaseCurrency();
        String baseCurrency2 = marketIndexPriceItem.getBaseCurrency();
        if (baseCurrency != null ? !baseCurrency.equals(baseCurrency2) : baseCurrency2 != null) {
            return false;
        }
        String quoteCurrency = getQuoteCurrency();
        String quoteCurrency2 = marketIndexPriceItem.getQuoteCurrency();
        if (quoteCurrency != null ? !quoteCurrency.equals(quoteCurrency2) : quoteCurrency2 != null) {
            return false;
        }
        if (getWeight() != marketIndexPriceItem.getWeight() || b() != marketIndexPriceItem.b()) {
            return false;
        }
        String g11 = g();
        String g12 = marketIndexPriceItem.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String h11 = h();
        String h12 = marketIndexPriceItem.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = marketIndexPriceItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String i11 = i();
        String i12 = marketIndexPriceItem.i();
        return i11 != null ? i11.equals(i12) : i12 == null;
    }

    public IndexCurrencyInfo f() {
        return this.f72606b;
    }

    public String g() {
        return this.f72616l;
    }

    public String getBaseCurrency() {
        return this.f72612h;
    }

    public String getBaseCurrencyDisplayName() {
        return this.f72612h;
    }

    public String getQuoteCurrency() {
        return this.f72613i;
    }

    public SymbolPrice getSymbolPrice() {
        return this.f72607c;
    }

    public String getViewHandlerName() {
        return IndexMarketNewHandler.class.getName();
    }

    public int getWeight() {
        return this.f72614j;
    }

    public String h() {
        return this.f72617m;
    }

    public int hashCode() {
        IndexCurrencyInfo f11 = f();
        int i11 = 43;
        int hashCode = f11 == null ? 43 : f11.hashCode();
        SymbolPrice symbolPrice = getSymbolPrice();
        int hashCode2 = ((hashCode + 59) * 59) + (symbolPrice == null ? 43 : symbolPrice.hashCode());
        String d11 = d();
        int hashCode3 = (hashCode2 * 59) + (d11 == null ? 43 : d11.hashCode());
        String e11 = e();
        int hashCode4 = (((((hashCode3 * 59) + (e11 == null ? 43 : e11.hashCode())) * 59) + (k() ? 79 : 97)) * 59) + j();
        String baseCurrency = getBaseCurrency();
        int hashCode5 = (hashCode4 * 59) + (baseCurrency == null ? 43 : baseCurrency.hashCode());
        String quoteCurrency = getQuoteCurrency();
        int hashCode6 = (((((hashCode5 * 59) + (quoteCurrency == null ? 43 : quoteCurrency.hashCode())) * 59) + getWeight()) * 59) + b();
        String g11 = g();
        int hashCode7 = (hashCode6 * 59) + (g11 == null ? 43 : g11.hashCode());
        String h11 = h();
        int hashCode8 = (hashCode7 * 59) + (h11 == null ? 43 : h11.hashCode());
        a c11 = c();
        int hashCode9 = (hashCode8 * 59) + (c11 == null ? 43 : c11.hashCode());
        String i12 = i();
        int i13 = hashCode9 * 59;
        if (i12 != null) {
            i11 = i12.hashCode();
        }
        return i13 + i11;
    }

    public String i() {
        return this.f72619o;
    }

    public int j() {
        return this.f72611g;
    }

    public boolean k() {
        return this.f72610f;
    }

    public void l(String str) {
        this.f72612h = str;
    }

    public void m(a aVar) {
        this.f72618n = aVar;
    }

    public void n(String str) {
        this.f72608d = str;
    }

    public void o(String str) {
        this.f72609e = str;
    }

    public void p(int i11) {
        this.f72615k = i11;
    }

    public void q(IndexCurrencyInfo indexCurrencyInfo) {
        this.f72606b = indexCurrencyInfo;
    }

    public void r(boolean z11) {
        this.f72610f = z11;
    }

    public void s(String str) {
        this.f72616l = str;
    }

    public void t(String str) {
        this.f72617m = str;
    }

    public String toString() {
        return "MarketIndexPriceItem(indexCurrencyInfo=" + f() + ", symbolPrice=" + getSymbolPrice() + ", close=" + d() + ", cnyStr=" + e() + ", isCollection=" + k() + ", type=" + j() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", weight=" + getWeight() + ", collectionWeight=" + b() + ", showName=" + g() + ", showSubName=" + h() + ", callback=" + c() + ", symbol=" + i() + ")";
    }

    public void u(String str) {
        this.f72619o = str;
    }

    public void v(SymbolPrice symbolPrice) {
        this.f72607c = symbolPrice;
    }

    public void w(int i11) {
        this.f72614j = i11;
    }
}
