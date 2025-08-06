package com.hbg.lib.network.index.core.bean;

import java.io.Serializable;

public class IndexCurrencyInfo implements Serializable {
    private Double close;
    private String contractCode;
    private String contractShortType;
    private String quoteCurrency;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof IndexCurrencyInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndexCurrencyInfo)) {
            return false;
        }
        IndexCurrencyInfo indexCurrencyInfo = (IndexCurrencyInfo) obj;
        if (!indexCurrencyInfo.canEqual(this)) {
            return false;
        }
        Double close2 = getClose();
        Double close3 = indexCurrencyInfo.getClose();
        if (close2 != null ? !close2.equals(close3) : close3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = indexCurrencyInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = indexCurrencyInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = indexCurrencyInfo.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        String contractShortType2 = getContractShortType();
        String contractShortType3 = indexCurrencyInfo.getContractShortType();
        return contractShortType2 != null ? contractShortType2.equals(contractShortType3) : contractShortType3 == null;
    }

    public Double getClose() {
        return this.close;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractShortType() {
        return this.contractShortType;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        Double close2 = getClose();
        int i11 = 43;
        int hashCode = close2 == null ? 43 : close2.hashCode();
        String symbol2 = getSymbol();
        int hashCode2 = ((hashCode + 59) * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String contractCode2 = getContractCode();
        int hashCode3 = (hashCode2 * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode4 = (hashCode3 * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        String contractShortType2 = getContractShortType();
        int i12 = hashCode4 * 59;
        if (contractShortType2 != null) {
            i11 = contractShortType2.hashCode();
        }
        return i12 + i11;
    }

    public void setClose(Double d11) {
        this.close = d11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractShortType(String str) {
        this.contractShortType = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "IndexCurrencyInfo(close=" + getClose() + ", symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", quoteCurrency=" + getQuoteCurrency() + ", contractShortType=" + getContractShortType() + ")";
    }
}
