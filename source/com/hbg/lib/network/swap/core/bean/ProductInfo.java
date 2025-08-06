package com.hbg.lib.network.swap.core.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ProductInfo implements Serializable {
    @SerializedName("amount_precision")
    private int amountPrecision;
    @SerializedName("contract_size")
    private int contractSize;
    @Expose
    private String currency;
    @SerializedName("fee_amount_precision")
    private int feeAmountPrecision;
    @SerializedName("financial_amount_precision")
    private int financialAmountPrecision = 8;
    @SerializedName("is_trade")
    private int isTrade;
    @SerializedName("other_amount_precision")
    private int otherAmountPrecision;
    @SerializedName("price_estimated")
    private List<PriceEstimated> priceEstimated;
    @SerializedName("price_precision")
    private int pricePrecision;
    @SerializedName("price_tick")
    private String priceTick;
    @SerializedName("product_label")
    private int productLabel;
    @SerializedName("real_time_settlement")
    private int realTimeSettlement;
    @Expose
    private String symbol;
    @SerializedName("underlying_currency")
    private String underlyingCurrency;

    public boolean canEqual(Object obj) {
        return obj instanceof ProductInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProductInfo)) {
            return false;
        }
        ProductInfo productInfo = (ProductInfo) obj;
        if (!productInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = productInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = productInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String underlyingCurrency2 = getUnderlyingCurrency();
        String underlyingCurrency3 = productInfo.getUnderlyingCurrency();
        if (underlyingCurrency2 != null ? !underlyingCurrency2.equals(underlyingCurrency3) : underlyingCurrency3 != null) {
            return false;
        }
        if (getContractSize() != productInfo.getContractSize() || getAmountPrecision() != productInfo.getAmountPrecision() || getFeeAmountPrecision() != productInfo.getFeeAmountPrecision() || getFinancialAmountPrecision() != productInfo.getFinancialAmountPrecision() || getOtherAmountPrecision() != productInfo.getOtherAmountPrecision()) {
            return false;
        }
        String priceTick2 = getPriceTick();
        String priceTick3 = productInfo.getPriceTick();
        if (priceTick2 != null ? !priceTick2.equals(priceTick3) : priceTick3 != null) {
            return false;
        }
        if (getProductLabel() != productInfo.getProductLabel() || getPricePrecision() != productInfo.getPricePrecision()) {
            return false;
        }
        List<PriceEstimated> priceEstimated2 = getPriceEstimated();
        List<PriceEstimated> priceEstimated3 = productInfo.getPriceEstimated();
        if (priceEstimated2 != null ? priceEstimated2.equals(priceEstimated3) : priceEstimated3 == null) {
            return getIsTrade() == productInfo.getIsTrade() && getRealTimeSettlement() == productInfo.getRealTimeSettlement();
        }
        return false;
    }

    public int getAmountPrecision() {
        return this.amountPrecision;
    }

    public int getContractSize() {
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

    public int getIsTrade() {
        return this.isTrade;
    }

    public int getOtherAmountPrecision() {
        return this.otherAmountPrecision;
    }

    public List<PriceEstimated> getPriceEstimated() {
        return this.priceEstimated;
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

    public int getRealTimeSettlement() {
        return this.realTimeSettlement;
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
        int hashCode3 = (((((((((((hashCode2 * 59) + (underlyingCurrency2 == null ? 43 : underlyingCurrency2.hashCode())) * 59) + getContractSize()) * 59) + getAmountPrecision()) * 59) + getFeeAmountPrecision()) * 59) + getFinancialAmountPrecision()) * 59) + getOtherAmountPrecision();
        String priceTick2 = getPriceTick();
        int hashCode4 = (((((hashCode3 * 59) + (priceTick2 == null ? 43 : priceTick2.hashCode())) * 59) + getProductLabel()) * 59) + getPricePrecision();
        List<PriceEstimated> priceEstimated2 = getPriceEstimated();
        int i12 = hashCode4 * 59;
        if (priceEstimated2 != null) {
            i11 = priceEstimated2.hashCode();
        }
        return ((((i12 + i11) * 59) + getIsTrade()) * 59) + getRealTimeSettlement();
    }

    public boolean isRealTimeSettlement() {
        return this.realTimeSettlement == 1;
    }

    public void setAmountPrecision(int i11) {
        this.amountPrecision = i11;
    }

    public void setContractSize(int i11) {
        this.contractSize = i11;
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

    public void setIsTrade(int i11) {
        this.isTrade = i11;
    }

    public void setOtherAmountPrecision(int i11) {
        this.otherAmountPrecision = i11;
    }

    public void setPriceEstimated(List<PriceEstimated> list) {
        this.priceEstimated = list;
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

    public void setRealTimeSettlement(int i11) {
        this.realTimeSettlement = i11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setUnderlyingCurrency(String str) {
        this.underlyingCurrency = str;
    }

    public String toString() {
        return "ProductInfo(symbol=" + getSymbol() + ", currency=" + getCurrency() + ", underlyingCurrency=" + getUnderlyingCurrency() + ", contractSize=" + getContractSize() + ", amountPrecision=" + getAmountPrecision() + ", feeAmountPrecision=" + getFeeAmountPrecision() + ", financialAmountPrecision=" + getFinancialAmountPrecision() + ", otherAmountPrecision=" + getOtherAmountPrecision() + ", priceTick=" + getPriceTick() + ", productLabel=" + getProductLabel() + ", pricePrecision=" + getPricePrecision() + ", priceEstimated=" + getPriceEstimated() + ", isTrade=" + getIsTrade() + ", realTimeSettlement=" + getRealTimeSettlement() + ")";
    }
}
