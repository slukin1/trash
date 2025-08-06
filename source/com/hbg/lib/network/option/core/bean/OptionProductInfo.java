package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OptionProductInfo implements Serializable {
    public static final int NOT_TRADE = 0;
    public static final int TRADE = 1;
    @SerializedName("amount_precision")
    private int amountPrecision;
    @SerializedName("contract_size")
    private String contractSize;
    @Expose
    private String currency;
    @SerializedName("fee_amount_precision")
    private int feeAmountPrecision;
    @SerializedName("financial_amount_precision")
    private int financialAmountPrecision = 8;
    @SerializedName("index_price_tick")
    private String indexPriceTick;
    @SerializedName("is_trade")
    private int isTrade;
    @SerializedName("option_price_precision")
    private int optionPricePrecision;
    @SerializedName("other_amount_precision")
    private int otherAmountPrecision;
    @SerializedName("price_precision")
    private int pricePrecision;
    @SerializedName("price_tick")
    private String priceTick;
    @SerializedName("product_label")
    private int productLabel;
    @SerializedName("quote_currency")
    private String quoteCurrency;
    private int sort;
    @Expose
    private String symbol;
    @SerializedName("underlying_currency")
    private String underlyingCurrency;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionProductInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionProductInfo)) {
            return false;
        }
        OptionProductInfo optionProductInfo = (OptionProductInfo) obj;
        if (!optionProductInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = optionProductInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = optionProductInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String underlyingCurrency2 = getUnderlyingCurrency();
        String underlyingCurrency3 = optionProductInfo.getUnderlyingCurrency();
        if (underlyingCurrency2 != null ? !underlyingCurrency2.equals(underlyingCurrency3) : underlyingCurrency3 != null) {
            return false;
        }
        String contractSize2 = getContractSize();
        String contractSize3 = optionProductInfo.getContractSize();
        if (contractSize2 != null ? !contractSize2.equals(contractSize3) : contractSize3 != null) {
            return false;
        }
        if (getAmountPrecision() != optionProductInfo.getAmountPrecision() || getFeeAmountPrecision() != optionProductInfo.getFeeAmountPrecision() || getFinancialAmountPrecision() != optionProductInfo.getFinancialAmountPrecision() || getOtherAmountPrecision() != optionProductInfo.getOtherAmountPrecision() || getOptionPricePrecision() != optionProductInfo.getOptionPricePrecision()) {
            return false;
        }
        String indexPriceTick2 = getIndexPriceTick();
        String indexPriceTick3 = optionProductInfo.getIndexPriceTick();
        if (indexPriceTick2 != null ? !indexPriceTick2.equals(indexPriceTick3) : indexPriceTick3 != null) {
            return false;
        }
        String priceTick2 = getPriceTick();
        String priceTick3 = optionProductInfo.getPriceTick();
        if (priceTick2 != null ? !priceTick2.equals(priceTick3) : priceTick3 != null) {
            return false;
        }
        if (getProductLabel() != optionProductInfo.getProductLabel() || getPricePrecision() != optionProductInfo.getPricePrecision()) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = optionProductInfo.getQuoteCurrency();
        if (quoteCurrency2 != null ? quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 == null) {
            return getIsTrade() == optionProductInfo.getIsTrade() && getSort() == optionProductInfo.getSort();
        }
        return false;
    }

    public int getAmountPrecision() {
        return this.amountPrecision;
    }

    public String getContractSize() {
        return this.contractSize;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getFeeAmountPrecision() {
        return this.feeAmountPrecision;
    }

    public int getFinancialAmountPrecision() {
        return this.financialAmountPrecision;
    }

    public String getIndexPriceTick() {
        return this.indexPriceTick;
    }

    public int getIsTrade() {
        return this.isTrade;
    }

    public int getOptionPricePrecision() {
        return this.optionPricePrecision;
    }

    public int getOtherAmountPrecision() {
        return this.otherAmountPrecision;
    }

    public int getPricePrecision() {
        return this.pricePrecision;
    }

    public String getPriceTick() {
        return this.priceTick;
    }

    public int getProductLabel() {
        return this.productLabel;
    }

    public String getQuoteCurrency() {
        return this.quoteCurrency;
    }

    public int getSort() {
        return this.sort;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getUnderlyingCurrency() {
        return this.underlyingCurrency;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String currency2 = getCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String underlyingCurrency2 = getUnderlyingCurrency();
        int hashCode3 = (hashCode2 * 59) + (underlyingCurrency2 == null ? 43 : underlyingCurrency2.hashCode());
        String contractSize2 = getContractSize();
        int hashCode4 = (((((((((((hashCode3 * 59) + (contractSize2 == null ? 43 : contractSize2.hashCode())) * 59) + getAmountPrecision()) * 59) + getFeeAmountPrecision()) * 59) + getFinancialAmountPrecision()) * 59) + getOtherAmountPrecision()) * 59) + getOptionPricePrecision();
        String indexPriceTick2 = getIndexPriceTick();
        int hashCode5 = (hashCode4 * 59) + (indexPriceTick2 == null ? 43 : indexPriceTick2.hashCode());
        String priceTick2 = getPriceTick();
        int hashCode6 = (((((hashCode5 * 59) + (priceTick2 == null ? 43 : priceTick2.hashCode())) * 59) + getProductLabel()) * 59) + getPricePrecision();
        String quoteCurrency2 = getQuoteCurrency();
        int i12 = hashCode6 * 59;
        if (quoteCurrency2 != null) {
            i11 = quoteCurrency2.hashCode();
        }
        return ((((i12 + i11) * 59) + getIsTrade()) * 59) + getSort();
    }

    public void setAmountPrecision(int i11) {
        this.amountPrecision = i11;
    }

    public void setContractSize(String str) {
        this.contractSize = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setFeeAmountPrecision(int i11) {
        this.feeAmountPrecision = i11;
    }

    public void setFinancialAmountPrecision(int i11) {
        this.financialAmountPrecision = i11;
    }

    public void setIndexPriceTick(String str) {
        this.indexPriceTick = str;
    }

    public void setIsTrade(int i11) {
        this.isTrade = i11;
    }

    public void setOptionPricePrecision(int i11) {
        this.optionPricePrecision = i11;
    }

    public void setOtherAmountPrecision(int i11) {
        this.otherAmountPrecision = i11;
    }

    public void setPricePrecision(int i11) {
        this.pricePrecision = i11;
    }

    public void setPriceTick(String str) {
        this.priceTick = str;
    }

    public void setProductLabel(int i11) {
        this.productLabel = i11;
    }

    public void setQuoteCurrency(String str) {
        this.quoteCurrency = str;
    }

    public void setSort(int i11) {
        this.sort = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setUnderlyingCurrency(String str) {
        this.underlyingCurrency = str;
    }

    public String toString() {
        return "OptionProductInfo(symbol=" + getSymbol() + ", currency=" + getCurrency() + ", underlyingCurrency=" + getUnderlyingCurrency() + ", contractSize=" + getContractSize() + ", amountPrecision=" + getAmountPrecision() + ", feeAmountPrecision=" + getFeeAmountPrecision() + ", financialAmountPrecision=" + getFinancialAmountPrecision() + ", otherAmountPrecision=" + getOtherAmountPrecision() + ", optionPricePrecision=" + getOptionPricePrecision() + ", indexPriceTick=" + getIndexPriceTick() + ", priceTick=" + getPriceTick() + ", productLabel=" + getProductLabel() + ", pricePrecision=" + getPricePrecision() + ", quoteCurrency=" + getQuoteCurrency() + ", isTrade=" + getIsTrade() + ", sort=" + getSort() + ")";
    }
}
