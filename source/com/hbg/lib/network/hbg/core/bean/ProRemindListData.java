package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class ProRemindListData implements Serializable {
    public String baseCurrency;
    public String quoteCurrency;
    public int status;
    public String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof ProRemindListData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProRemindListData)) {
            return false;
        }
        ProRemindListData proRemindListData = (ProRemindListData) obj;
        if (!proRemindListData.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = proRemindListData.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = proRemindListData.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = proRemindListData.getQuoteCurrency();
        if (quoteCurrency2 != null ? quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 == null) {
            return getStatus() == proRemindListData.getStatus();
        }
        return false;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public int getStatus() {
        return this.status;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String baseCurrency2 = getBaseCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int i12 = hashCode2 * 59;
        if (quoteCurrency2 != null) {
            i11 = quoteCurrency2.hashCode();
        }
        return ((i12 + i11) * 59) + getStatus();
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "ProRemindListData(symbol=" + getSymbol() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", status=" + getStatus() + ")";
    }
}
