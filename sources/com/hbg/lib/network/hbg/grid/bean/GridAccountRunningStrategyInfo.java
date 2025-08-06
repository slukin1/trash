package com.hbg.lib.network.hbg.grid.bean;

import java.io.Serializable;

public class GridAccountRunningStrategyInfo implements Serializable {
    private static final long serialVersionUID = -6860166581145515242L;
    private String baseAmount;
    private String baseCurrency;

    /* renamed from: id  reason: collision with root package name */
    private long f70281id;
    private long name;
    private String perEstimateBtc;
    private String quoteAmount;
    private String quoteCurrency;

    public boolean canEqual(Object obj) {
        return obj instanceof GridAccountRunningStrategyInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridAccountRunningStrategyInfo)) {
            return false;
        }
        GridAccountRunningStrategyInfo gridAccountRunningStrategyInfo = (GridAccountRunningStrategyInfo) obj;
        if (!gridAccountRunningStrategyInfo.canEqual(this) || getId() != gridAccountRunningStrategyInfo.getId() || getName() != gridAccountRunningStrategyInfo.getName()) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = gridAccountRunningStrategyInfo.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = gridAccountRunningStrategyInfo.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        String baseAmount2 = getBaseAmount();
        String baseAmount3 = gridAccountRunningStrategyInfo.getBaseAmount();
        if (baseAmount2 != null ? !baseAmount2.equals(baseAmount3) : baseAmount3 != null) {
            return false;
        }
        String quoteAmount2 = getQuoteAmount();
        String quoteAmount3 = gridAccountRunningStrategyInfo.getQuoteAmount();
        if (quoteAmount2 != null ? !quoteAmount2.equals(quoteAmount3) : quoteAmount3 != null) {
            return false;
        }
        String perEstimateBtc2 = getPerEstimateBtc();
        String perEstimateBtc3 = gridAccountRunningStrategyInfo.getPerEstimateBtc();
        return perEstimateBtc2 != null ? perEstimateBtc2.equals(perEstimateBtc3) : perEstimateBtc3 == null;
    }

    public String getBaseAmount() {
        return this.baseAmount;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public long getId() {
        return this.f70281id;
    }

    public long getName() {
        return this.name;
    }

    public String getPerEstimateBtc() {
        return this.perEstimateBtc;
    }

    public String getQuoteAmount() {
        return this.quoteAmount;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public int hashCode() {
        long id2 = getId();
        long name2 = getName();
        String baseCurrency2 = getBaseCurrency();
        int i11 = (((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + ((int) ((name2 >>> 32) ^ name2))) * 59;
        int i12 = 43;
        int hashCode = i11 + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode2 = (hashCode * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        String baseAmount2 = getBaseAmount();
        int hashCode3 = (hashCode2 * 59) + (baseAmount2 == null ? 43 : baseAmount2.hashCode());
        String quoteAmount2 = getQuoteAmount();
        int hashCode4 = (hashCode3 * 59) + (quoteAmount2 == null ? 43 : quoteAmount2.hashCode());
        String perEstimateBtc2 = getPerEstimateBtc();
        int i13 = hashCode4 * 59;
        if (perEstimateBtc2 != null) {
            i12 = perEstimateBtc2.hashCode();
        }
        return i13 + i12;
    }

    public void setBaseAmount(String str) {
        this.baseAmount = str;
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setId(long j11) {
        this.f70281id = j11;
    }

    public void setName(long j11) {
        this.name = j11;
    }

    public void setPerEstimateBtc(String str) {
        this.perEstimateBtc = str;
    }

    public void setQuoteAmount(String str) {
        this.quoteAmount = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public String toString() {
        return "GridAccountRunningStrategyInfo(id=" + getId() + ", name=" + getName() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", baseAmount=" + getBaseAmount() + ", quoteAmount=" + getQuoteAmount() + ", perEstimateBtc=" + getPerEstimateBtc() + ")";
    }
}
