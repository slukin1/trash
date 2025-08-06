package com.hbg.module.market.widget.bean;

import com.hbg.lib.data.symbol.TradeType;
import hf.b;
import java.io.Serializable;

public class MarketWidgetInfo implements Serializable {
    private String baseCurrency;
    private transient int color;
    private String name;
    private transient String percent;
    private transient String price;
    private String quoteCurrency;
    private String symbol;
    private String type;

    public MarketWidgetInfo(String str, String str2) {
        this.symbol = str;
        this.type = str2;
        b.w(this);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof MarketWidgetInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarketWidgetInfo)) {
            return false;
        }
        MarketWidgetInfo marketWidgetInfo = (MarketWidgetInfo) obj;
        if (!marketWidgetInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = marketWidgetInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String name2 = getName();
        String name3 = marketWidgetInfo.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String type2 = getType();
        String type3 = marketWidgetInfo.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = marketWidgetInfo.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = marketWidgetInfo.getQuoteCurrency();
        return quoteCurrency2 != null ? quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 == null;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public int getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public String getPercent() {
        return this.percent;
    }

    public String getPrice() {
        return this.price;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public TradeType getTradeType() {
        return TradeType.valueOf(this.type);
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String name2 = getName();
        int hashCode2 = ((hashCode + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
        String type2 = getType();
        int hashCode3 = (hashCode2 * 59) + (type2 == null ? 43 : type2.hashCode());
        String baseCurrency2 = getBaseCurrency();
        int hashCode4 = (hashCode3 * 59) + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int i12 = hashCode4 * 59;
        if (quoteCurrency2 != null) {
            i11 = quoteCurrency2.hashCode();
        }
        return i12 + i11;
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setColor(int i11) {
        this.color = i11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPercent(String str) {
        this.percent = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradeType(TradeType tradeType) {
        setType(tradeType.toString());
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "MarketWidgetInfo(symbol=" + getSymbol() + ", name=" + getName() + ", percent=" + getPercent() + ", price=" + getPrice() + ", color=" + getColor() + ", type=" + getType() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ")";
    }
}
