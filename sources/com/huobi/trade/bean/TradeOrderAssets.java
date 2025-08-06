package com.huobi.trade.bean;

import androidx.annotation.Keep;
import com.huobi.trade.handler.TradeOrderAssetsHandler;
import java.io.Serializable;
import s9.a;

@Keep
public class TradeOrderAssets implements Serializable, a {
    private String avaiable;
    private String balance;
    private String currency;
    private String head;
    private String liquidationPrice;
    private String maxAvaiable;
    private String toLiquidationPrice;
    private String usdtPoistionValue;

    public boolean canEqual(Object obj) {
        return obj instanceof TradeOrderAssets;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradeOrderAssets)) {
            return false;
        }
        TradeOrderAssets tradeOrderAssets = (TradeOrderAssets) obj;
        if (!tradeOrderAssets.canEqual(this)) {
            return false;
        }
        String head2 = getHead();
        String head3 = tradeOrderAssets.getHead();
        if (head2 != null ? !head2.equals(head3) : head3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = tradeOrderAssets.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String balance2 = getBalance();
        String balance3 = tradeOrderAssets.getBalance();
        if (balance2 != null ? !balance2.equals(balance3) : balance3 != null) {
            return false;
        }
        String usdtPoistionValue2 = getUsdtPoistionValue();
        String usdtPoistionValue3 = tradeOrderAssets.getUsdtPoistionValue();
        if (usdtPoistionValue2 != null ? !usdtPoistionValue2.equals(usdtPoistionValue3) : usdtPoistionValue3 != null) {
            return false;
        }
        String maxAvaiable2 = getMaxAvaiable();
        String maxAvaiable3 = tradeOrderAssets.getMaxAvaiable();
        if (maxAvaiable2 != null ? !maxAvaiable2.equals(maxAvaiable3) : maxAvaiable3 != null) {
            return false;
        }
        String avaiable2 = getAvaiable();
        String avaiable3 = tradeOrderAssets.getAvaiable();
        if (avaiable2 != null ? !avaiable2.equals(avaiable3) : avaiable3 != null) {
            return false;
        }
        String liquidationPrice2 = getLiquidationPrice();
        String liquidationPrice3 = tradeOrderAssets.getLiquidationPrice();
        if (liquidationPrice2 != null ? !liquidationPrice2.equals(liquidationPrice3) : liquidationPrice3 != null) {
            return false;
        }
        String toLiquidationPrice2 = getToLiquidationPrice();
        String toLiquidationPrice3 = tradeOrderAssets.getToLiquidationPrice();
        return toLiquidationPrice2 != null ? toLiquidationPrice2.equals(toLiquidationPrice3) : toLiquidationPrice3 == null;
    }

    public String getAvaiable() {
        return this.avaiable;
    }

    public String getBalance() {
        return this.balance;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getHead() {
        return this.head;
    }

    public String getLiquidationPrice() {
        return this.liquidationPrice;
    }

    public String getMaxAvaiable() {
        return this.maxAvaiable;
    }

    public String getToLiquidationPrice() {
        return this.toLiquidationPrice;
    }

    public String getUsdtPoistionValue() {
        return this.usdtPoistionValue;
    }

    public String getViewHandlerName() {
        return TradeOrderAssetsHandler.class.getName();
    }

    public int hashCode() {
        String head2 = getHead();
        int i11 = 43;
        int hashCode = head2 == null ? 43 : head2.hashCode();
        String currency2 = getCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String balance2 = getBalance();
        int hashCode3 = (hashCode2 * 59) + (balance2 == null ? 43 : balance2.hashCode());
        String usdtPoistionValue2 = getUsdtPoistionValue();
        int hashCode4 = (hashCode3 * 59) + (usdtPoistionValue2 == null ? 43 : usdtPoistionValue2.hashCode());
        String maxAvaiable2 = getMaxAvaiable();
        int hashCode5 = (hashCode4 * 59) + (maxAvaiable2 == null ? 43 : maxAvaiable2.hashCode());
        String avaiable2 = getAvaiable();
        int hashCode6 = (hashCode5 * 59) + (avaiable2 == null ? 43 : avaiable2.hashCode());
        String liquidationPrice2 = getLiquidationPrice();
        int hashCode7 = (hashCode6 * 59) + (liquidationPrice2 == null ? 43 : liquidationPrice2.hashCode());
        String toLiquidationPrice2 = getToLiquidationPrice();
        int i12 = hashCode7 * 59;
        if (toLiquidationPrice2 != null) {
            i11 = toLiquidationPrice2.hashCode();
        }
        return i12 + i11;
    }

    public void setAvaiable(String str) {
        this.avaiable = str;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setHead(String str) {
        this.head = str;
    }

    public void setLiquidationPrice(String str) {
        this.liquidationPrice = str;
    }

    public void setMaxAvaiable(String str) {
        this.maxAvaiable = str;
    }

    public void setToLiquidationPrice(String str) {
        this.toLiquidationPrice = str;
    }

    public void setUsdtPoistionValue(String str) {
        this.usdtPoistionValue = str;
    }

    public String toString() {
        return "TradeOrderAssets{head='" + this.head + '\'' + "currency='" + this.currency + '\'' + ", balance='" + this.balance + '\'' + ", usdtPoistionValue='" + this.usdtPoistionValue + '\'' + ", maxAvaiable='" + this.maxAvaiable + '\'' + ", avaiable='" + this.avaiable + '\'' + ", liquidationPrice='" + this.liquidationPrice + '\'' + ", toLiquidationPrice='" + this.toLiquidationPrice + '\'' + '}';
    }
}
