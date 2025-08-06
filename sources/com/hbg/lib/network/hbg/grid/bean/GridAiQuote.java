package com.hbg.lib.network.hbg.grid.bean;

import java.io.Serializable;

public class GridAiQuote implements Serializable {
    private static final long serialVersionUID = 21743533259236846L;
    private String baseCurrency;
    private int gridNum;
    private String maxPrice;
    private String minInvest;
    private String minPrice;
    private String perMaxProfitRate;
    private String perMinProfitRate;
    private String quoteCurrency;
    private int runType;
    private String symbol;
    private String yieldRate;

    public boolean canEqual(Object obj) {
        return obj instanceof GridAiQuote;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridAiQuote)) {
            return false;
        }
        GridAiQuote gridAiQuote = (GridAiQuote) obj;
        if (!gridAiQuote.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = gridAiQuote.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = gridAiQuote.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = gridAiQuote.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        if (getRunType() != gridAiQuote.getRunType()) {
            return false;
        }
        String minPrice2 = getMinPrice();
        String minPrice3 = gridAiQuote.getMinPrice();
        if (minPrice2 != null ? !minPrice2.equals(minPrice3) : minPrice3 != null) {
            return false;
        }
        String maxPrice2 = getMaxPrice();
        String maxPrice3 = gridAiQuote.getMaxPrice();
        if (maxPrice2 != null ? !maxPrice2.equals(maxPrice3) : maxPrice3 != null) {
            return false;
        }
        String minInvest2 = getMinInvest();
        String minInvest3 = gridAiQuote.getMinInvest();
        if (minInvest2 != null ? !minInvest2.equals(minInvest3) : minInvest3 != null) {
            return false;
        }
        if (getGridNum() != gridAiQuote.getGridNum()) {
            return false;
        }
        String yieldRate2 = getYieldRate();
        String yieldRate3 = gridAiQuote.getYieldRate();
        if (yieldRate2 != null ? !yieldRate2.equals(yieldRate3) : yieldRate3 != null) {
            return false;
        }
        String perMinProfitRate2 = getPerMinProfitRate();
        String perMinProfitRate3 = gridAiQuote.getPerMinProfitRate();
        if (perMinProfitRate2 != null ? !perMinProfitRate2.equals(perMinProfitRate3) : perMinProfitRate3 != null) {
            return false;
        }
        String perMaxProfitRate2 = getPerMaxProfitRate();
        String perMaxProfitRate3 = gridAiQuote.getPerMaxProfitRate();
        return perMaxProfitRate2 != null ? perMaxProfitRate2.equals(perMaxProfitRate3) : perMaxProfitRate3 == null;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public int getGridNum() {
        return this.gridNum;
    }

    public String getMaxPrice() {
        return this.maxPrice;
    }

    public String getMinInvest() {
        return this.minInvest;
    }

    public String getMinPrice() {
        return this.minPrice;
    }

    public String getPerMaxProfitRate() {
        return this.perMaxProfitRate;
    }

    public String getPerMinProfitRate() {
        return this.perMinProfitRate;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public int getRunType() {
        return this.runType;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getYieldRate() {
        return this.yieldRate;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String baseCurrency2 = getBaseCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode3 = (((hashCode2 * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode())) * 59) + getRunType();
        String minPrice2 = getMinPrice();
        int hashCode4 = (hashCode3 * 59) + (minPrice2 == null ? 43 : minPrice2.hashCode());
        String maxPrice2 = getMaxPrice();
        int hashCode5 = (hashCode4 * 59) + (maxPrice2 == null ? 43 : maxPrice2.hashCode());
        String minInvest2 = getMinInvest();
        int hashCode6 = (((hashCode5 * 59) + (minInvest2 == null ? 43 : minInvest2.hashCode())) * 59) + getGridNum();
        String yieldRate2 = getYieldRate();
        int hashCode7 = (hashCode6 * 59) + (yieldRate2 == null ? 43 : yieldRate2.hashCode());
        String perMinProfitRate2 = getPerMinProfitRate();
        int hashCode8 = (hashCode7 * 59) + (perMinProfitRate2 == null ? 43 : perMinProfitRate2.hashCode());
        String perMaxProfitRate2 = getPerMaxProfitRate();
        int i12 = hashCode8 * 59;
        if (perMaxProfitRate2 != null) {
            i11 = perMaxProfitRate2.hashCode();
        }
        return i12 + i11;
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setGridNum(int i11) {
        this.gridNum = i11;
    }

    public void setMaxPrice(String str) {
        this.maxPrice = str;
    }

    public void setMinInvest(String str) {
        this.minInvest = str;
    }

    public void setMinPrice(String str) {
        this.minPrice = str;
    }

    public void setPerMaxProfitRate(String str) {
        this.perMaxProfitRate = str;
    }

    public void setPerMinProfitRate(String str) {
        this.perMinProfitRate = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setRunType(int i11) {
        this.runType = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setYieldRate(String str) {
        this.yieldRate = str;
    }

    public String toString() {
        return "GridAiQuote(symbol=" + getSymbol() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", runType=" + getRunType() + ", minPrice=" + getMinPrice() + ", maxPrice=" + getMaxPrice() + ", minInvest=" + getMinInvest() + ", gridNum=" + getGridNum() + ", yieldRate=" + getYieldRate() + ", perMinProfitRate=" + getPerMinProfitRate() + ", perMaxProfitRate=" + getPerMaxProfitRate() + ")";
    }
}
