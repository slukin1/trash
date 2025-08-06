package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class TradingHoseQuoteBean implements Serializable {
    private String amount;
    private int baseCoinId;
    private String convertAmount;
    private String convertPrice;
    private long expireTime;
    private String price;
    private String quantity;
    private int quoteCoinId;
    private String token;

    public boolean canEqual(Object obj) {
        return obj instanceof TradingHoseQuoteBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradingHoseQuoteBean)) {
            return false;
        }
        TradingHoseQuoteBean tradingHoseQuoteBean = (TradingHoseQuoteBean) obj;
        if (!tradingHoseQuoteBean.canEqual(this)) {
            return false;
        }
        String token2 = getToken();
        String token3 = tradingHoseQuoteBean.getToken();
        if (token2 != null ? !token2.equals(token3) : token3 != null) {
            return false;
        }
        String price2 = getPrice();
        String price3 = tradingHoseQuoteBean.getPrice();
        if (price2 != null ? !price2.equals(price3) : price3 != null) {
            return false;
        }
        String quantity2 = getQuantity();
        String quantity3 = tradingHoseQuoteBean.getQuantity();
        if (quantity2 != null ? !quantity2.equals(quantity3) : quantity3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = tradingHoseQuoteBean.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        if (getExpireTime() != tradingHoseQuoteBean.getExpireTime()) {
            return false;
        }
        String convertAmount2 = getConvertAmount();
        String convertAmount3 = tradingHoseQuoteBean.getConvertAmount();
        if (convertAmount2 != null ? !convertAmount2.equals(convertAmount3) : convertAmount3 != null) {
            return false;
        }
        String convertPrice2 = getConvertPrice();
        String convertPrice3 = tradingHoseQuoteBean.getConvertPrice();
        if (convertPrice2 != null ? convertPrice2.equals(convertPrice3) : convertPrice3 == null) {
            return getQuoteCoinId() == tradingHoseQuoteBean.getQuoteCoinId() && getBaseCoinId() == tradingHoseQuoteBean.getBaseCoinId();
        }
        return false;
    }

    public String getAmount() {
        return this.amount;
    }

    public int getBaseCoinId() {
        return this.baseCoinId;
    }

    public String getConvertAmount() {
        return this.convertAmount;
    }

    public String getConvertPrice() {
        return this.convertPrice;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getPrice() {
        return this.price;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public int getQuoteCoinId() {
        return this.quoteCoinId;
    }

    public String getToken() {
        return this.token;
    }

    public int hashCode() {
        String token2 = getToken();
        int i11 = 43;
        int hashCode = token2 == null ? 43 : token2.hashCode();
        String price2 = getPrice();
        int hashCode2 = ((hashCode + 59) * 59) + (price2 == null ? 43 : price2.hashCode());
        String quantity2 = getQuantity();
        int hashCode3 = (hashCode2 * 59) + (quantity2 == null ? 43 : quantity2.hashCode());
        String amount2 = getAmount();
        int hashCode4 = (hashCode3 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        long expireTime2 = getExpireTime();
        int i12 = (hashCode4 * 59) + ((int) (expireTime2 ^ (expireTime2 >>> 32)));
        String convertAmount2 = getConvertAmount();
        int hashCode5 = (i12 * 59) + (convertAmount2 == null ? 43 : convertAmount2.hashCode());
        String convertPrice2 = getConvertPrice();
        int i13 = hashCode5 * 59;
        if (convertPrice2 != null) {
            i11 = convertPrice2.hashCode();
        }
        return ((((i13 + i11) * 59) + getQuoteCoinId()) * 59) + getBaseCoinId();
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setBaseCoinId(int i11) {
        this.baseCoinId = i11;
    }

    public void setConvertAmount(String str) {
        this.convertAmount = str;
    }

    public void setConvertPrice(String str) {
        this.convertPrice = str;
    }

    public void setExpireTime(long j11) {
        this.expireTime = j11;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setQuantity(String str) {
        this.quantity = str;
    }

    public void setQuoteCoinId(int i11) {
        this.quoteCoinId = i11;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        return "TradingHoseQuoteBean(token=" + getToken() + ", price=" + getPrice() + ", quantity=" + getQuantity() + ", amount=" + getAmount() + ", expireTime=" + getExpireTime() + ", convertAmount=" + getConvertAmount() + ", convertPrice=" + getConvertPrice() + ", quoteCoinId=" + getQuoteCoinId() + ", baseCoinId=" + getBaseCoinId() + ")";
    }
}
