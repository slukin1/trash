package com.huobi.finance.bean;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.currencyconfig.bean.StableCoinHints;
import com.huobi.currencyconfig.bean.StableCurrencyRateBean;
import java.io.Serializable;

public class StableCurrencyBeanInfo implements Serializable {
    private String available;
    private String currency;
    private String fromCurrency;
    private boolean isExchangeIn;
    private String stableAvailable;
    private StableCoinHints stableCoinHints;
    private StableCurrencyRateBean.StableCurrencyBean stableCurrencyBean;
    private String toCurrency;
    private TradeType tradeType;

    public boolean canEqual(Object obj) {
        return obj instanceof StableCurrencyBeanInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StableCurrencyBeanInfo)) {
            return false;
        }
        StableCurrencyBeanInfo stableCurrencyBeanInfo = (StableCurrencyBeanInfo) obj;
        if (!stableCurrencyBeanInfo.canEqual(this)) {
            return false;
        }
        StableCurrencyRateBean.StableCurrencyBean stableCurrencyBean2 = getStableCurrencyBean();
        StableCurrencyRateBean.StableCurrencyBean stableCurrencyBean3 = stableCurrencyBeanInfo.getStableCurrencyBean();
        if (stableCurrencyBean2 != null ? !stableCurrencyBean2.equals(stableCurrencyBean3) : stableCurrencyBean3 != null) {
            return false;
        }
        TradeType tradeType2 = getTradeType();
        TradeType tradeType3 = stableCurrencyBeanInfo.getTradeType();
        if (tradeType2 != null ? !tradeType2.equals(tradeType3) : tradeType3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = stableCurrencyBeanInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String available2 = getAvailable();
        String available3 = stableCurrencyBeanInfo.getAvailable();
        if (available2 != null ? !available2.equals(available3) : available3 != null) {
            return false;
        }
        String stableAvailable2 = getStableAvailable();
        String stableAvailable3 = stableCurrencyBeanInfo.getStableAvailable();
        if (stableAvailable2 != null ? !stableAvailable2.equals(stableAvailable3) : stableAvailable3 != null) {
            return false;
        }
        StableCoinHints stableCoinHints2 = getStableCoinHints();
        StableCoinHints stableCoinHints3 = stableCurrencyBeanInfo.getStableCoinHints();
        if (stableCoinHints2 != null ? !stableCoinHints2.equals(stableCoinHints3) : stableCoinHints3 != null) {
            return false;
        }
        String fromCurrency2 = getFromCurrency();
        String fromCurrency3 = stableCurrencyBeanInfo.getFromCurrency();
        if (fromCurrency2 != null ? !fromCurrency2.equals(fromCurrency3) : fromCurrency3 != null) {
            return false;
        }
        String toCurrency2 = getToCurrency();
        String toCurrency3 = stableCurrencyBeanInfo.getToCurrency();
        if (toCurrency2 != null ? toCurrency2.equals(toCurrency3) : toCurrency3 == null) {
            return isExchangeIn() == stableCurrencyBeanInfo.isExchangeIn();
        }
        return false;
    }

    public String getAvailable() {
        return this.available;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getFromCurrency() {
        return this.fromCurrency;
    }

    public String getStableAvailable() {
        return this.stableAvailable;
    }

    public StableCoinHints getStableCoinHints() {
        return this.stableCoinHints;
    }

    public StableCurrencyRateBean.StableCurrencyBean getStableCurrencyBean() {
        return this.stableCurrencyBean;
    }

    public String getToCurrency() {
        return this.toCurrency;
    }

    public TradeType getTradeType() {
        return this.tradeType;
    }

    public int hashCode() {
        StableCurrencyRateBean.StableCurrencyBean stableCurrencyBean2 = getStableCurrencyBean();
        int i11 = 43;
        int hashCode = stableCurrencyBean2 == null ? 43 : stableCurrencyBean2.hashCode();
        TradeType tradeType2 = getTradeType();
        int hashCode2 = ((hashCode + 59) * 59) + (tradeType2 == null ? 43 : tradeType2.hashCode());
        String currency2 = getCurrency();
        int hashCode3 = (hashCode2 * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String available2 = getAvailable();
        int hashCode4 = (hashCode3 * 59) + (available2 == null ? 43 : available2.hashCode());
        String stableAvailable2 = getStableAvailable();
        int hashCode5 = (hashCode4 * 59) + (stableAvailable2 == null ? 43 : stableAvailable2.hashCode());
        StableCoinHints stableCoinHints2 = getStableCoinHints();
        int hashCode6 = (hashCode5 * 59) + (stableCoinHints2 == null ? 43 : stableCoinHints2.hashCode());
        String fromCurrency2 = getFromCurrency();
        int hashCode7 = (hashCode6 * 59) + (fromCurrency2 == null ? 43 : fromCurrency2.hashCode());
        String toCurrency2 = getToCurrency();
        int i12 = hashCode7 * 59;
        if (toCurrency2 != null) {
            i11 = toCurrency2.hashCode();
        }
        return ((i12 + i11) * 59) + (isExchangeIn() ? 79 : 97);
    }

    public boolean isExchangeIn() {
        return this.isExchangeIn;
    }

    public void setAvailable(String str) {
        this.available = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setExchangeIn(boolean z11) {
        this.isExchangeIn = z11;
    }

    public void setFromCurrency(String str) {
        this.fromCurrency = str;
    }

    public void setStableAvailable(String str) {
        this.stableAvailable = str;
    }

    public void setStableCoinHints(StableCoinHints stableCoinHints2) {
        this.stableCoinHints = stableCoinHints2;
    }

    public void setStableCurrencyBean(StableCurrencyRateBean.StableCurrencyBean stableCurrencyBean2) {
        this.stableCurrencyBean = stableCurrencyBean2;
    }

    public void setToCurrency(String str) {
        this.toCurrency = str;
    }

    public void setTradeType(TradeType tradeType2) {
        this.tradeType = tradeType2;
    }

    public String toString() {
        return "StableCurrencyBeanInfo(stableCurrencyBean=" + getStableCurrencyBean() + ", tradeType=" + getTradeType() + ", currency=" + getCurrency() + ", available=" + getAvailable() + ", stableAvailable=" + getStableAvailable() + ", stableCoinHints=" + getStableCoinHints() + ", fromCurrency=" + getFromCurrency() + ", toCurrency=" + getToCurrency() + ", isExchangeIn=" + isExchangeIn() + ")";
    }
}
