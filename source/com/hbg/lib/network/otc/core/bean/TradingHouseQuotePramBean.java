package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class TradingHouseQuotePramBean implements Serializable {
    private String amount;
    private String cryptoAsset;
    private String currency;
    private String quoteAsset;
    private String side;
    private String type;

    public boolean canEqual(Object obj) {
        return obj instanceof TradingHouseQuotePramBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradingHouseQuotePramBean)) {
            return false;
        }
        TradingHouseQuotePramBean tradingHouseQuotePramBean = (TradingHouseQuotePramBean) obj;
        if (!tradingHouseQuotePramBean.canEqual(this)) {
            return false;
        }
        String side2 = getSide();
        String side3 = tradingHouseQuotePramBean.getSide();
        if (side2 != null ? !side2.equals(side3) : side3 != null) {
            return false;
        }
        String type2 = getType();
        String type3 = tradingHouseQuotePramBean.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = tradingHouseQuotePramBean.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String cryptoAsset2 = getCryptoAsset();
        String cryptoAsset3 = tradingHouseQuotePramBean.getCryptoAsset();
        if (cryptoAsset2 != null ? !cryptoAsset2.equals(cryptoAsset3) : cryptoAsset3 != null) {
            return false;
        }
        String quoteAsset2 = getQuoteAsset();
        String quoteAsset3 = tradingHouseQuotePramBean.getQuoteAsset();
        if (quoteAsset2 != null ? !quoteAsset2.equals(quoteAsset3) : quoteAsset3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = tradingHouseQuotePramBean.getCurrency();
        return currency2 != null ? currency2.equals(currency3) : currency3 == null;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getCryptoAsset() {
        return this.cryptoAsset;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getQuoteAsset() {
        return this.quoteAsset;
    }

    public String getSide() {
        return this.side;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        String side2 = getSide();
        int i11 = 43;
        int hashCode = side2 == null ? 43 : side2.hashCode();
        String type2 = getType();
        int hashCode2 = ((hashCode + 59) * 59) + (type2 == null ? 43 : type2.hashCode());
        String amount2 = getAmount();
        int hashCode3 = (hashCode2 * 59) + (amount2 == null ? 43 : amount2.hashCode());
        String cryptoAsset2 = getCryptoAsset();
        int hashCode4 = (hashCode3 * 59) + (cryptoAsset2 == null ? 43 : cryptoAsset2.hashCode());
        String quoteAsset2 = getQuoteAsset();
        int hashCode5 = (hashCode4 * 59) + (quoteAsset2 == null ? 43 : quoteAsset2.hashCode());
        String currency2 = getCurrency();
        int i12 = hashCode5 * 59;
        if (currency2 != null) {
            i11 = currency2.hashCode();
        }
        return i12 + i11;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCryptoAsset(String str) {
        this.cryptoAsset = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setQuoteAsset(String str) {
        this.quoteAsset = str;
    }

    public void setSide(String str) {
        this.side = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "TradingHouseQuotePramBean(side=" + getSide() + ", type=" + getType() + ", amount=" + getAmount() + ", cryptoAsset=" + getCryptoAsset() + ", quoteAsset=" + getQuoteAsset() + ", currency=" + getCurrency() + ")";
    }
}
