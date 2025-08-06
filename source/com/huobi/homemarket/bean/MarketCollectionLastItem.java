package com.huobi.homemarket.bean;

import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.contract.viewhandler.MarketCollectionLastHandler;
import ml.b;

public class MarketCollectionLastItem implements b {

    /* renamed from: b  reason: collision with root package name */
    public int f72586b;

    /* renamed from: c  reason: collision with root package name */
    public int f72587c;

    /* renamed from: d  reason: collision with root package name */
    public String f72588d;

    /* renamed from: e  reason: collision with root package name */
    public String f72589e;

    /* renamed from: f  reason: collision with root package name */
    public SymbolPrice f72590f;

    public boolean a(Object obj) {
        return obj instanceof MarketCollectionLastItem;
    }

    public int b() {
        return this.f72586b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketCollectionLastItem)) {
            return false;
        }
        MarketCollectionLastItem marketCollectionLastItem = (MarketCollectionLastItem) obj;
        if (!marketCollectionLastItem.a(this) || b() != marketCollectionLastItem.b() || getWeight() != marketCollectionLastItem.getWeight()) {
            return false;
        }
        String baseCurrency = getBaseCurrency();
        String baseCurrency2 = marketCollectionLastItem.getBaseCurrency();
        if (baseCurrency != null ? !baseCurrency.equals(baseCurrency2) : baseCurrency2 != null) {
            return false;
        }
        String quoteCurrency = getQuoteCurrency();
        String quoteCurrency2 = marketCollectionLastItem.getQuoteCurrency();
        if (quoteCurrency != null ? !quoteCurrency.equals(quoteCurrency2) : quoteCurrency2 != null) {
            return false;
        }
        SymbolPrice symbolPrice = getSymbolPrice();
        SymbolPrice symbolPrice2 = marketCollectionLastItem.getSymbolPrice();
        return symbolPrice != null ? symbolPrice.equals(symbolPrice2) : symbolPrice2 == null;
    }

    public String getBaseCurrency() {
        return this.f72588d;
    }

    public String getBaseCurrencyDisplayName() {
        return this.f72588d;
    }

    public String getQuoteCurrency() {
        return this.f72589e;
    }

    public SymbolPrice getSymbolPrice() {
        return this.f72590f;
    }

    public String getViewHandlerName() {
        return MarketCollectionLastHandler.class.getName();
    }

    public int getWeight() {
        return this.f72587c;
    }

    public int hashCode() {
        int b11 = ((b() + 59) * 59) + getWeight();
        String baseCurrency = getBaseCurrency();
        int i11 = 43;
        int hashCode = (b11 * 59) + (baseCurrency == null ? 43 : baseCurrency.hashCode());
        String quoteCurrency = getQuoteCurrency();
        int hashCode2 = (hashCode * 59) + (quoteCurrency == null ? 43 : quoteCurrency.hashCode());
        SymbolPrice symbolPrice = getSymbolPrice();
        int i12 = hashCode2 * 59;
        if (symbolPrice != null) {
            i11 = symbolPrice.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "MarketCollectionLastItem(collectionWeight=" + b() + ", weight=" + getWeight() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", symbolPrice=" + getSymbolPrice() + ")";
    }
}
