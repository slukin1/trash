package com.hbg.lib.network.hbg.grid.bean;

import java.io.Serializable;

public class GridSymbolDetail implements Serializable {
    private static final long serialVersionUID = 6812503484750667926L;
    private String baseCurrency;
    private String basePrecision;
    private String maxPutPrice;
    private String minBaseAmount;
    private String minPutPrice;
    private String minQuoteAmount;
    private String perAmount;
    private String perLimit;
    private String quoteCurrency;
    private String quotePrecision;
    private String remain;
    private String totalLimit;
    private String userFeeRate;

    public boolean canEqual(Object obj) {
        return obj instanceof GridSymbolDetail;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridSymbolDetail)) {
            return false;
        }
        GridSymbolDetail gridSymbolDetail = (GridSymbolDetail) obj;
        if (!gridSymbolDetail.canEqual(this)) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = gridSymbolDetail.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = gridSymbolDetail.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        String basePrecision2 = getBasePrecision();
        String basePrecision3 = gridSymbolDetail.getBasePrecision();
        if (basePrecision2 != null ? !basePrecision2.equals(basePrecision3) : basePrecision3 != null) {
            return false;
        }
        String quotePrecision2 = getQuotePrecision();
        String quotePrecision3 = gridSymbolDetail.getQuotePrecision();
        if (quotePrecision2 != null ? !quotePrecision2.equals(quotePrecision3) : quotePrecision3 != null) {
            return false;
        }
        String userFeeRate2 = getUserFeeRate();
        String userFeeRate3 = gridSymbolDetail.getUserFeeRate();
        if (userFeeRate2 != null ? !userFeeRate2.equals(userFeeRate3) : userFeeRate3 != null) {
            return false;
        }
        String perLimit2 = getPerLimit();
        String perLimit3 = gridSymbolDetail.getPerLimit();
        if (perLimit2 != null ? !perLimit2.equals(perLimit3) : perLimit3 != null) {
            return false;
        }
        String totalLimit2 = getTotalLimit();
        String totalLimit3 = gridSymbolDetail.getTotalLimit();
        if (totalLimit2 != null ? !totalLimit2.equals(totalLimit3) : totalLimit3 != null) {
            return false;
        }
        String remain2 = getRemain();
        String remain3 = gridSymbolDetail.getRemain();
        if (remain2 != null ? !remain2.equals(remain3) : remain3 != null) {
            return false;
        }
        String perAmount2 = getPerAmount();
        String perAmount3 = gridSymbolDetail.getPerAmount();
        if (perAmount2 != null ? !perAmount2.equals(perAmount3) : perAmount3 != null) {
            return false;
        }
        String minBaseAmount2 = getMinBaseAmount();
        String minBaseAmount3 = gridSymbolDetail.getMinBaseAmount();
        if (minBaseAmount2 != null ? !minBaseAmount2.equals(minBaseAmount3) : minBaseAmount3 != null) {
            return false;
        }
        String minQuoteAmount2 = getMinQuoteAmount();
        String minQuoteAmount3 = gridSymbolDetail.getMinQuoteAmount();
        if (minQuoteAmount2 != null ? !minQuoteAmount2.equals(minQuoteAmount3) : minQuoteAmount3 != null) {
            return false;
        }
        String minPutPrice2 = getMinPutPrice();
        String minPutPrice3 = gridSymbolDetail.getMinPutPrice();
        if (minPutPrice2 != null ? !minPutPrice2.equals(minPutPrice3) : minPutPrice3 != null) {
            return false;
        }
        String maxPutPrice2 = getMaxPutPrice();
        String maxPutPrice3 = gridSymbolDetail.getMaxPutPrice();
        return maxPutPrice2 != null ? maxPutPrice2.equals(maxPutPrice3) : maxPutPrice3 == null;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public String getBasePrecision() {
        return this.basePrecision;
    }

    public String getMaxPutPrice() {
        return this.maxPutPrice;
    }

    public String getMinBaseAmount() {
        return this.minBaseAmount;
    }

    public String getMinPutPrice() {
        return this.minPutPrice;
    }

    public String getMinQuoteAmount() {
        return this.minQuoteAmount;
    }

    public String getPerAmount() {
        return this.perAmount;
    }

    public String getPerLimit() {
        return this.perLimit;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getQuotePrecision() {
        return this.quotePrecision;
    }

    public String getRemain() {
        return this.remain;
    }

    public String getTotalLimit() {
        return this.totalLimit;
    }

    public String getUserFeeRate() {
        return this.userFeeRate;
    }

    public int hashCode() {
        String baseCurrency2 = getBaseCurrency();
        int i11 = 43;
        int hashCode = baseCurrency2 == null ? 43 : baseCurrency2.hashCode();
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        String basePrecision2 = getBasePrecision();
        int hashCode3 = (hashCode2 * 59) + (basePrecision2 == null ? 43 : basePrecision2.hashCode());
        String quotePrecision2 = getQuotePrecision();
        int hashCode4 = (hashCode3 * 59) + (quotePrecision2 == null ? 43 : quotePrecision2.hashCode());
        String userFeeRate2 = getUserFeeRate();
        int hashCode5 = (hashCode4 * 59) + (userFeeRate2 == null ? 43 : userFeeRate2.hashCode());
        String perLimit2 = getPerLimit();
        int hashCode6 = (hashCode5 * 59) + (perLimit2 == null ? 43 : perLimit2.hashCode());
        String totalLimit2 = getTotalLimit();
        int hashCode7 = (hashCode6 * 59) + (totalLimit2 == null ? 43 : totalLimit2.hashCode());
        String remain2 = getRemain();
        int hashCode8 = (hashCode7 * 59) + (remain2 == null ? 43 : remain2.hashCode());
        String perAmount2 = getPerAmount();
        int hashCode9 = (hashCode8 * 59) + (perAmount2 == null ? 43 : perAmount2.hashCode());
        String minBaseAmount2 = getMinBaseAmount();
        int hashCode10 = (hashCode9 * 59) + (minBaseAmount2 == null ? 43 : minBaseAmount2.hashCode());
        String minQuoteAmount2 = getMinQuoteAmount();
        int hashCode11 = (hashCode10 * 59) + (minQuoteAmount2 == null ? 43 : minQuoteAmount2.hashCode());
        String minPutPrice2 = getMinPutPrice();
        int hashCode12 = (hashCode11 * 59) + (minPutPrice2 == null ? 43 : minPutPrice2.hashCode());
        String maxPutPrice2 = getMaxPutPrice();
        int i12 = hashCode12 * 59;
        if (maxPutPrice2 != null) {
            i11 = maxPutPrice2.hashCode();
        }
        return i12 + i11;
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setBasePrecision(String str) {
        this.basePrecision = str;
    }

    public void setMaxPutPrice(String str) {
        this.maxPutPrice = str;
    }

    public void setMinBaseAmount(String str) {
        this.minBaseAmount = str;
    }

    public void setMinPutPrice(String str) {
        this.minPutPrice = str;
    }

    public void setMinQuoteAmount(String str) {
        this.minQuoteAmount = str;
    }

    public void setPerAmount(String str) {
        this.perAmount = str;
    }

    public void setPerLimit(String str) {
        this.perLimit = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setQuotePrecision(String str) {
        this.quotePrecision = str;
    }

    public void setRemain(String str) {
        this.remain = str;
    }

    public void setTotalLimit(String str) {
        this.totalLimit = str;
    }

    public void setUserFeeRate(String str) {
        this.userFeeRate = str;
    }

    public String toString() {
        return "GridSymbolDetail(baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", basePrecision=" + getBasePrecision() + ", quotePrecision=" + getQuotePrecision() + ", userFeeRate=" + getUserFeeRate() + ", perLimit=" + getPerLimit() + ", totalLimit=" + getTotalLimit() + ", remain=" + getRemain() + ", perAmount=" + getPerAmount() + ", minBaseAmount=" + getMinBaseAmount() + ", minQuoteAmount=" + getMinQuoteAmount() + ", minPutPrice=" + getMinPutPrice() + ", maxPutPrice=" + getMaxPutPrice() + ")";
    }
}
