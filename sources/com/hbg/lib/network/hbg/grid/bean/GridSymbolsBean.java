package com.hbg.lib.network.hbg.grid.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class GridSymbolsBean implements Serializable {
    private static final long serialVersionUID = 3656302914725461853L;
    @SerializedName("base_currency")
    private String baseCurrency;
    @SerializedName("quote_currency")
    private String quoteCurrency;
    @SerializedName("symbol_code")
    private String symbolCode;
    @SerializedName("trade_price_precision")
    private int tradePricePrecision;

    public boolean canEqual(Object obj) {
        return obj instanceof GridSymbolsBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GridSymbolsBean)) {
            return false;
        }
        GridSymbolsBean gridSymbolsBean = (GridSymbolsBean) obj;
        if (!gridSymbolsBean.canEqual(this)) {
            return false;
        }
        String symbolCode2 = getSymbolCode();
        String symbolCode3 = gridSymbolsBean.getSymbolCode();
        if (symbolCode2 != null ? !symbolCode2.equals(symbolCode3) : symbolCode3 != null) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = gridSymbolsBean.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = gridSymbolsBean.getQuoteCurrency();
        if (quoteCurrency2 != null ? quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 == null) {
            return getTradePricePrecision() == gridSymbolsBean.getTradePricePrecision();
        }
        return false;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getSymbolCode() {
        return this.symbolCode;
    }

    public int getTradePricePrecision() {
        return this.tradePricePrecision;
    }

    public int hashCode() {
        String symbolCode2 = getSymbolCode();
        int i11 = 43;
        int hashCode = symbolCode2 == null ? 43 : symbolCode2.hashCode();
        String baseCurrency2 = getBaseCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int i12 = hashCode2 * 59;
        if (quoteCurrency2 != null) {
            i11 = quoteCurrency2.hashCode();
        }
        return ((i12 + i11) * 59) + getTradePricePrecision();
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setSymbolCode(String str) {
        this.symbolCode = str;
    }

    public void setTradePricePrecision(int i11) {
        this.tradePricePrecision = i11;
    }

    public String toString() {
        return "GridSymbolsBean(symbolCode=" + getSymbolCode() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", tradePricePrecision=" + getTradePricePrecision() + ")";
    }
}
