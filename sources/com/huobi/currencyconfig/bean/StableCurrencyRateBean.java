package com.huobi.currencyconfig.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class StableCurrencyRateBean implements Serializable {
    @SerializedName("stable-currency")
    private List<StableCurrencyBean> stableCurrency;
    @SerializedName("trade-currency")
    private TradeCurrencyBean tradeCurrency;

    public static class StableCurrencyBean implements Serializable {
        @SerializedName("ask-rate")
        private BigDecimal askRate;
        private String benchmark;
        @SerializedName("bid-rate")
        private BigDecimal bidRate;
        private String currency;
        @SerializedName("exchange-enable")
        private boolean exchangeEnable;
        @SerializedName("in-exchange-enable")
        private boolean inExchangeEnable;
        @SerializedName("in-max-amount")
        private String inMaxAmount;
        @SerializedName("max-amount")
        private BigDecimal maxAmount;
        @SerializedName("out-exchange-enable")
        private boolean outExchangeEnable;
        @SerializedName("out-max-amount")
        private String outMaxAmount;

        public boolean canEqual(Object obj) {
            return obj instanceof StableCurrencyBean;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof StableCurrencyBean)) {
                return false;
            }
            StableCurrencyBean stableCurrencyBean = (StableCurrencyBean) obj;
            if (!stableCurrencyBean.canEqual(this)) {
                return false;
            }
            String currency2 = getCurrency();
            String currency3 = stableCurrencyBean.getCurrency();
            if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
                return false;
            }
            String benchmark2 = getBenchmark();
            String benchmark3 = stableCurrencyBean.getBenchmark();
            if (benchmark2 != null ? !benchmark2.equals(benchmark3) : benchmark3 != null) {
                return false;
            }
            if (isExchangeEnable() != stableCurrencyBean.isExchangeEnable() || isInExchangeEnable() != stableCurrencyBean.isInExchangeEnable() || isOutExchangeEnable() != stableCurrencyBean.isOutExchangeEnable()) {
                return false;
            }
            BigDecimal bidRate2 = getBidRate();
            BigDecimal bidRate3 = stableCurrencyBean.getBidRate();
            if (bidRate2 != null ? !bidRate2.equals(bidRate3) : bidRate3 != null) {
                return false;
            }
            BigDecimal askRate2 = getAskRate();
            BigDecimal askRate3 = stableCurrencyBean.getAskRate();
            if (askRate2 != null ? !askRate2.equals(askRate3) : askRate3 != null) {
                return false;
            }
            BigDecimal maxAmount2 = getMaxAmount();
            BigDecimal maxAmount3 = stableCurrencyBean.getMaxAmount();
            if (maxAmount2 != null ? !maxAmount2.equals(maxAmount3) : maxAmount3 != null) {
                return false;
            }
            String inMaxAmount2 = getInMaxAmount();
            String inMaxAmount3 = stableCurrencyBean.getInMaxAmount();
            if (inMaxAmount2 != null ? !inMaxAmount2.equals(inMaxAmount3) : inMaxAmount3 != null) {
                return false;
            }
            String outMaxAmount2 = getOutMaxAmount();
            String outMaxAmount3 = stableCurrencyBean.getOutMaxAmount();
            return outMaxAmount2 != null ? outMaxAmount2.equals(outMaxAmount3) : outMaxAmount3 == null;
        }

        public BigDecimal getAskRate() {
            return this.askRate;
        }

        public String getBenchmark() {
            return this.benchmark;
        }

        public BigDecimal getBidRate() {
            return this.bidRate;
        }

        public String getCurrency() {
            return this.currency;
        }

        public String getInMaxAmount() {
            return this.inMaxAmount;
        }

        public BigDecimal getMaxAmount() {
            return this.maxAmount;
        }

        public String getOutMaxAmount() {
            return this.outMaxAmount;
        }

        public int hashCode() {
            String currency2 = getCurrency();
            int i11 = 43;
            int hashCode = currency2 == null ? 43 : currency2.hashCode();
            String benchmark2 = getBenchmark();
            int i12 = 79;
            int hashCode2 = (((((((hashCode + 59) * 59) + (benchmark2 == null ? 43 : benchmark2.hashCode())) * 59) + (isExchangeEnable() ? 79 : 97)) * 59) + (isInExchangeEnable() ? 79 : 97)) * 59;
            if (!isOutExchangeEnable()) {
                i12 = 97;
            }
            BigDecimal bidRate2 = getBidRate();
            int hashCode3 = ((hashCode2 + i12) * 59) + (bidRate2 == null ? 43 : bidRate2.hashCode());
            BigDecimal askRate2 = getAskRate();
            int hashCode4 = (hashCode3 * 59) + (askRate2 == null ? 43 : askRate2.hashCode());
            BigDecimal maxAmount2 = getMaxAmount();
            int hashCode5 = (hashCode4 * 59) + (maxAmount2 == null ? 43 : maxAmount2.hashCode());
            String inMaxAmount2 = getInMaxAmount();
            int hashCode6 = (hashCode5 * 59) + (inMaxAmount2 == null ? 43 : inMaxAmount2.hashCode());
            String outMaxAmount2 = getOutMaxAmount();
            int i13 = hashCode6 * 59;
            if (outMaxAmount2 != null) {
                i11 = outMaxAmount2.hashCode();
            }
            return i13 + i11;
        }

        public boolean isExchangeEnable() {
            return this.exchangeEnable;
        }

        public boolean isInExchangeEnable() {
            return this.inExchangeEnable;
        }

        public boolean isOutExchangeEnable() {
            return this.outExchangeEnable;
        }

        public void setAskRate(BigDecimal bigDecimal) {
            this.askRate = bigDecimal;
        }

        public void setBenchmark(String str) {
            this.benchmark = str;
        }

        public void setBidRate(BigDecimal bigDecimal) {
            this.bidRate = bigDecimal;
        }

        public void setCurrency(String str) {
            this.currency = str;
        }

        public void setExchangeEnable(boolean z11) {
            this.exchangeEnable = z11;
        }

        public void setInExchangeEnable(boolean z11) {
            this.inExchangeEnable = z11;
        }

        public void setInMaxAmount(String str) {
            this.inMaxAmount = str;
        }

        public void setMaxAmount(BigDecimal bigDecimal) {
            this.maxAmount = bigDecimal;
        }

        public void setOutExchangeEnable(boolean z11) {
            this.outExchangeEnable = z11;
        }

        public void setOutMaxAmount(String str) {
            this.outMaxAmount = str;
        }

        public String toString() {
            return "StableCurrencyRateBean.StableCurrencyBean(currency=" + getCurrency() + ", benchmark=" + getBenchmark() + ", exchangeEnable=" + isExchangeEnable() + ", inExchangeEnable=" + isInExchangeEnable() + ", outExchangeEnable=" + isOutExchangeEnable() + ", bidRate=" + getBidRate() + ", askRate=" + getAskRate() + ", maxAmount=" + getMaxAmount() + ", inMaxAmount=" + getInMaxAmount() + ", outMaxAmount=" + getOutMaxAmount() + ")";
        }
    }

    public static class TradeCurrencyBean implements Serializable {
        private String currency;

        public boolean canEqual(Object obj) {
            return obj instanceof TradeCurrencyBean;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TradeCurrencyBean)) {
                return false;
            }
            TradeCurrencyBean tradeCurrencyBean = (TradeCurrencyBean) obj;
            if (!tradeCurrencyBean.canEqual(this)) {
                return false;
            }
            String currency2 = getCurrency();
            String currency3 = tradeCurrencyBean.getCurrency();
            return currency2 != null ? currency2.equals(currency3) : currency3 == null;
        }

        public String getCurrency() {
            return this.currency;
        }

        public int hashCode() {
            String currency2 = getCurrency();
            return 59 + (currency2 == null ? 43 : currency2.hashCode());
        }

        public void setCurrency(String str) {
            this.currency = str;
        }

        public String toString() {
            return "StableCurrencyRateBean.TradeCurrencyBean(currency=" + getCurrency() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof StableCurrencyRateBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StableCurrencyRateBean)) {
            return false;
        }
        StableCurrencyRateBean stableCurrencyRateBean = (StableCurrencyRateBean) obj;
        if (!stableCurrencyRateBean.canEqual(this)) {
            return false;
        }
        TradeCurrencyBean tradeCurrency2 = getTradeCurrency();
        TradeCurrencyBean tradeCurrency3 = stableCurrencyRateBean.getTradeCurrency();
        if (tradeCurrency2 != null ? !tradeCurrency2.equals(tradeCurrency3) : tradeCurrency3 != null) {
            return false;
        }
        List<StableCurrencyBean> stableCurrency2 = getStableCurrency();
        List<StableCurrencyBean> stableCurrency3 = stableCurrencyRateBean.getStableCurrency();
        return stableCurrency2 != null ? stableCurrency2.equals(stableCurrency3) : stableCurrency3 == null;
    }

    public List<StableCurrencyBean> getStableCurrency() {
        return this.stableCurrency;
    }

    public TradeCurrencyBean getTradeCurrency() {
        return this.tradeCurrency;
    }

    public int hashCode() {
        TradeCurrencyBean tradeCurrency2 = getTradeCurrency();
        int i11 = 43;
        int hashCode = tradeCurrency2 == null ? 43 : tradeCurrency2.hashCode();
        List<StableCurrencyBean> stableCurrency2 = getStableCurrency();
        int i12 = (hashCode + 59) * 59;
        if (stableCurrency2 != null) {
            i11 = stableCurrency2.hashCode();
        }
        return i12 + i11;
    }

    public void setStableCurrency(List<StableCurrencyBean> list) {
        this.stableCurrency = list;
    }

    public void setTradeCurrency(TradeCurrencyBean tradeCurrencyBean) {
        this.tradeCurrency = tradeCurrencyBean;
    }

    public String toString() {
        return "StableCurrencyRateBean(tradeCurrency=" + getTradeCurrency() + ", stableCurrency=" + getStableCurrency() + ")";
    }
}
