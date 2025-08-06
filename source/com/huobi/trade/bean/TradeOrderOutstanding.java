package com.huobi.trade.bean;

import androidx.annotation.Keep;
import com.huobi.trade.handler.TradeOrderOutstandingHandler;
import java.io.Serializable;
import s9.a;

@Keep
public class TradeOrderOutstanding implements Serializable, a {
    private String borrowSize;
    private String currency;
    private String liquidationPrice;
    private String toLiquidationPrice;
    private String usdtPoistionValue;

    public boolean canEqual(Object obj) {
        return obj instanceof TradeOrderOutstanding;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradeOrderOutstanding)) {
            return false;
        }
        TradeOrderOutstanding tradeOrderOutstanding = (TradeOrderOutstanding) obj;
        if (!tradeOrderOutstanding.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = tradeOrderOutstanding.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String borrowSize2 = getBorrowSize();
        String borrowSize3 = tradeOrderOutstanding.getBorrowSize();
        if (borrowSize2 != null ? !borrowSize2.equals(borrowSize3) : borrowSize3 != null) {
            return false;
        }
        String usdtPoistionValue2 = getUsdtPoistionValue();
        String usdtPoistionValue3 = tradeOrderOutstanding.getUsdtPoistionValue();
        if (usdtPoistionValue2 != null ? !usdtPoistionValue2.equals(usdtPoistionValue3) : usdtPoistionValue3 != null) {
            return false;
        }
        String liquidationPrice2 = getLiquidationPrice();
        String liquidationPrice3 = tradeOrderOutstanding.getLiquidationPrice();
        if (liquidationPrice2 != null ? !liquidationPrice2.equals(liquidationPrice3) : liquidationPrice3 != null) {
            return false;
        }
        String toLiquidationPrice2 = getToLiquidationPrice();
        String toLiquidationPrice3 = tradeOrderOutstanding.getToLiquidationPrice();
        return toLiquidationPrice2 != null ? toLiquidationPrice2.equals(toLiquidationPrice3) : toLiquidationPrice3 == null;
    }

    public String getBorrowSize() {
        return this.borrowSize;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getLiquidationPrice() {
        return this.liquidationPrice;
    }

    public String getToLiquidationPrice() {
        return this.toLiquidationPrice;
    }

    public String getUsdtPoistionValue() {
        return this.usdtPoistionValue;
    }

    public String getViewHandlerName() {
        return TradeOrderOutstandingHandler.class.getName();
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String borrowSize2 = getBorrowSize();
        int hashCode2 = ((hashCode + 59) * 59) + (borrowSize2 == null ? 43 : borrowSize2.hashCode());
        String usdtPoistionValue2 = getUsdtPoistionValue();
        int hashCode3 = (hashCode2 * 59) + (usdtPoistionValue2 == null ? 43 : usdtPoistionValue2.hashCode());
        String liquidationPrice2 = getLiquidationPrice();
        int hashCode4 = (hashCode3 * 59) + (liquidationPrice2 == null ? 43 : liquidationPrice2.hashCode());
        String toLiquidationPrice2 = getToLiquidationPrice();
        int i12 = hashCode4 * 59;
        if (toLiquidationPrice2 != null) {
            i11 = toLiquidationPrice2.hashCode();
        }
        return i12 + i11;
    }

    public void setBorrowSize(String str) {
        this.borrowSize = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setLiquidationPrice(String str) {
        this.liquidationPrice = str;
    }

    public void setToLiquidationPrice(String str) {
        this.toLiquidationPrice = str;
    }

    public void setUsdtPoistionValue(String str) {
        this.usdtPoistionValue = str;
    }

    public String toString() {
        return "TradeOrderOutstanding{currency='" + this.currency + '\'' + ", borrowSize='" + this.borrowSize + '\'' + ", usdtPoistionValue='" + this.usdtPoistionValue + '\'' + ", liquidationPrice='" + this.liquidationPrice + '\'' + ", toLiquidationPrice='" + this.toLiquidationPrice + '\'' + '}';
    }
}
