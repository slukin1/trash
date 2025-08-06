package com.huobi.otcoption.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class OtcOptionsIndexData implements Serializable {
    private static final long serialVersionUID = -4305280382134634907L;
    @SerializedName("base_currency")
    private String baseCurrency;
    @SerializedName("base_currency_displayName")
    public String baseCurrencyDisplayName;
    @SerializedName("currency")
    public String currency;
    @SerializedName("currency_list")
    private List<String> currencyList;
    @SerializedName("cycle")
    public String cycle;
    @SerializedName("open_order_loss")
    public String openOrderLoss;
    @SerializedName("productType")
    public int productType;
    @SerializedName("quote_currency")
    public String quoteCurrency;
    @SerializedName("quote_currency_displayName")
    public String quoteCurrencyDisplayName;
    private String source;
    private String symbol;
    @SerializedName("symbol_name")
    public String symbolName;
    @SerializedName("trade_amount_precision")
    public int tradeAmountPrecision;
    @SerializedName("trade_price_precision")
    public int tradePricePrecision;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcOptionsIndexData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcOptionsIndexData)) {
            return false;
        }
        OtcOptionsIndexData otcOptionsIndexData = (OtcOptionsIndexData) obj;
        if (!otcOptionsIndexData.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = otcOptionsIndexData.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String source2 = getSource();
        String source3 = otcOptionsIndexData.getSource();
        if (source2 != null ? !source2.equals(source3) : source3 != null) {
            return false;
        }
        List<String> currencyList2 = getCurrencyList();
        List<String> currencyList3 = otcOptionsIndexData.getCurrencyList();
        if (currencyList2 != null ? !currencyList2.equals(currencyList3) : currencyList3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = otcOptionsIndexData.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String baseCurrency2 = getBaseCurrency();
        String baseCurrency3 = otcOptionsIndexData.getBaseCurrency();
        if (baseCurrency2 != null ? !baseCurrency2.equals(baseCurrency3) : baseCurrency3 != null) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = otcOptionsIndexData.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        String baseCurrencyDisplayName2 = getBaseCurrencyDisplayName();
        String baseCurrencyDisplayName3 = otcOptionsIndexData.getBaseCurrencyDisplayName();
        if (baseCurrencyDisplayName2 != null ? !baseCurrencyDisplayName2.equals(baseCurrencyDisplayName3) : baseCurrencyDisplayName3 != null) {
            return false;
        }
        String quoteCurrencyDisplayName2 = getQuoteCurrencyDisplayName();
        String quoteCurrencyDisplayName3 = otcOptionsIndexData.getQuoteCurrencyDisplayName();
        if (quoteCurrencyDisplayName2 != null ? !quoteCurrencyDisplayName2.equals(quoteCurrencyDisplayName3) : quoteCurrencyDisplayName3 != null) {
            return false;
        }
        String symbolName2 = getSymbolName();
        String symbolName3 = otcOptionsIndexData.getSymbolName();
        if (symbolName2 != null ? !symbolName2.equals(symbolName3) : symbolName3 != null) {
            return false;
        }
        if (getTradeAmountPrecision() != otcOptionsIndexData.getTradeAmountPrecision() || getTradePricePrecision() != otcOptionsIndexData.getTradePricePrecision()) {
            return false;
        }
        String cycle2 = getCycle();
        String cycle3 = otcOptionsIndexData.getCycle();
        if (cycle2 != null ? !cycle2.equals(cycle3) : cycle3 != null) {
            return false;
        }
        String openOrderLoss2 = getOpenOrderLoss();
        String openOrderLoss3 = otcOptionsIndexData.getOpenOrderLoss();
        if (openOrderLoss2 != null ? openOrderLoss2.equals(openOrderLoss3) : openOrderLoss3 == null) {
            return getProductType() == otcOptionsIndexData.getProductType();
        }
        return false;
    }

    public String getBaseCurrency() {
        return this.baseCurrency;
    }

    public String getBaseCurrencyDisplayName() {
        return this.baseCurrencyDisplayName;
    }

    public String getCurrency() {
        return this.currency;
    }

    public List<String> getCurrencyList() {
        return this.currencyList;
    }

    public String getCycle() {
        return this.cycle;
    }

    public String getOpenOrderLoss() {
        return this.openOrderLoss;
    }

    public int getProductType() {
        return this.productType;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public String getQuoteCurrencyDisplayName() {
        return this.quoteCurrencyDisplayName;
    }

    public String getSource() {
        return this.source;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getSymbolName() {
        return this.symbolName;
    }

    public int getTradeAmountPrecision() {
        return this.tradeAmountPrecision;
    }

    public int getTradePricePrecision() {
        return this.tradePricePrecision;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String source2 = getSource();
        int hashCode2 = ((hashCode + 59) * 59) + (source2 == null ? 43 : source2.hashCode());
        List<String> currencyList2 = getCurrencyList();
        int hashCode3 = (hashCode2 * 59) + (currencyList2 == null ? 43 : currencyList2.hashCode());
        String currency2 = getCurrency();
        int hashCode4 = (hashCode3 * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String baseCurrency2 = getBaseCurrency();
        int hashCode5 = (hashCode4 * 59) + (baseCurrency2 == null ? 43 : baseCurrency2.hashCode());
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode6 = (hashCode5 * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode());
        String baseCurrencyDisplayName2 = getBaseCurrencyDisplayName();
        int hashCode7 = (hashCode6 * 59) + (baseCurrencyDisplayName2 == null ? 43 : baseCurrencyDisplayName2.hashCode());
        String quoteCurrencyDisplayName2 = getQuoteCurrencyDisplayName();
        int hashCode8 = (hashCode7 * 59) + (quoteCurrencyDisplayName2 == null ? 43 : quoteCurrencyDisplayName2.hashCode());
        String symbolName2 = getSymbolName();
        int hashCode9 = (((((hashCode8 * 59) + (symbolName2 == null ? 43 : symbolName2.hashCode())) * 59) + getTradeAmountPrecision()) * 59) + getTradePricePrecision();
        String cycle2 = getCycle();
        int hashCode10 = (hashCode9 * 59) + (cycle2 == null ? 43 : cycle2.hashCode());
        String openOrderLoss2 = getOpenOrderLoss();
        int i12 = hashCode10 * 59;
        if (openOrderLoss2 != null) {
            i11 = openOrderLoss2.hashCode();
        }
        return ((i12 + i11) * 59) + getProductType();
    }

    public void setBaseCurrency(String str) {
        this.baseCurrency = str;
    }

    public void setBaseCurrencyDisplayName(String str) {
        this.baseCurrencyDisplayName = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setCurrencyList(List<String> list) {
        this.currencyList = list;
    }

    public void setCycle(String str) {
        this.cycle = str;
    }

    public void setOpenOrderLoss(String str) {
        this.openOrderLoss = str;
    }

    public void setProductType(int i11) {
        this.productType = i11;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setQuoteCurrencyDisplayName(String str) {
        this.quoteCurrencyDisplayName = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setSymbolName(String str) {
        this.symbolName = str;
    }

    public void setTradeAmountPrecision(int i11) {
        this.tradeAmountPrecision = i11;
    }

    public void setTradePricePrecision(int i11) {
        this.tradePricePrecision = i11;
    }

    public String toString() {
        return "OtcOptionsIndexData(symbol=" + getSymbol() + ", source=" + getSource() + ", currencyList=" + getCurrencyList() + ", currency=" + getCurrency() + ", baseCurrency=" + getBaseCurrency() + ", quoteCurrency=" + getQuoteCurrency() + ", baseCurrencyDisplayName=" + getBaseCurrencyDisplayName() + ", quoteCurrencyDisplayName=" + getQuoteCurrencyDisplayName() + ", symbolName=" + getSymbolName() + ", tradeAmountPrecision=" + getTradeAmountPrecision() + ", tradePricePrecision=" + getTradePricePrecision() + ", cycle=" + getCycle() + ", openOrderLoss=" + getOpenOrderLoss() + ", productType=" + getProductType() + ")";
    }
}
