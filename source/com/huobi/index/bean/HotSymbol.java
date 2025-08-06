package com.huobi.index.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.Expose;
import com.huobi.index.viewhandler.HotSymbolItemHandler;
import s9.a;

@Keep
public class HotSymbol implements a {
    private String baseCurrencyDisplayName;
    private String displayName;
    @Expose(serialize = false)
    private String percent;
    @Expose(serialize = false)
    private String price;
    private String quoteCurrencyDisplayName;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof HotSymbol;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HotSymbol)) {
            return false;
        }
        HotSymbol hotSymbol = (HotSymbol) obj;
        if (!hotSymbol.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = hotSymbol.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String baseCurrencyDisplayName2 = getBaseCurrencyDisplayName();
        String baseCurrencyDisplayName3 = hotSymbol.getBaseCurrencyDisplayName();
        if (baseCurrencyDisplayName2 != null ? !baseCurrencyDisplayName2.equals(baseCurrencyDisplayName3) : baseCurrencyDisplayName3 != null) {
            return false;
        }
        String quoteCurrencyDisplayName2 = getQuoteCurrencyDisplayName();
        String quoteCurrencyDisplayName3 = hotSymbol.getQuoteCurrencyDisplayName();
        if (quoteCurrencyDisplayName2 != null ? !quoteCurrencyDisplayName2.equals(quoteCurrencyDisplayName3) : quoteCurrencyDisplayName3 != null) {
            return false;
        }
        String displayName2 = getDisplayName();
        String displayName3 = hotSymbol.getDisplayName();
        if (displayName2 != null ? !displayName2.equals(displayName3) : displayName3 != null) {
            return false;
        }
        String percent2 = getPercent();
        String percent3 = hotSymbol.getPercent();
        if (percent2 != null ? !percent2.equals(percent3) : percent3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = hotSymbol.getPrice();
        return price2 != null ? price2.equals(price3) : price3 == null;
    }

    public String getBaseCurrencyDisplayName() {
        return this.baseCurrencyDisplayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getPercent() {
        return this.percent;
    }

    public String getPrice() {
        return this.price;
    }

    public String getQuoteCurrencyDisplayName() {
        return this.quoteCurrencyDisplayName;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getViewHandlerName() {
        return HotSymbolItemHandler.class.getName();
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String baseCurrencyDisplayName2 = getBaseCurrencyDisplayName();
        int hashCode2 = ((hashCode + 59) * 59) + (baseCurrencyDisplayName2 == null ? 43 : baseCurrencyDisplayName2.hashCode());
        String quoteCurrencyDisplayName2 = getQuoteCurrencyDisplayName();
        int hashCode3 = (hashCode2 * 59) + (quoteCurrencyDisplayName2 == null ? 43 : quoteCurrencyDisplayName2.hashCode());
        String displayName2 = getDisplayName();
        int hashCode4 = (hashCode3 * 59) + (displayName2 == null ? 43 : displayName2.hashCode());
        String percent2 = getPercent();
        int hashCode5 = (hashCode4 * 59) + (percent2 == null ? 43 : percent2.hashCode());
        String price2 = getPrice();
        int i12 = hashCode5 * 59;
        if (price2 != null) {
            i11 = price2.hashCode();
        }
        return i12 + i11;
    }

    public void setBaseCurrencyDisplayName(String str) {
        this.baseCurrencyDisplayName = str;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setPercent(String str) {
        this.percent = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setQuoteCurrencyDisplayName(String str) {
        this.quoteCurrencyDisplayName = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "HotSymbol(symbol=" + getSymbol() + ", baseCurrencyDisplayName=" + getBaseCurrencyDisplayName() + ", quoteCurrencyDisplayName=" + getQuoteCurrencyDisplayName() + ", displayName=" + getDisplayName() + ", percent=" + getPercent() + ", price=" + getPrice() + ")";
    }
}
