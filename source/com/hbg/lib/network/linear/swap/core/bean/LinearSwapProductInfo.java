package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class LinearSwapProductInfo implements Serializable {
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
    @SerializedName("is_trade")
    private int isTrade;
    @SerializedName("other_amount_precision")
    private int otherAmountPrecision;
    @SerializedName("price_estimated")
    private List<LinearSwapPriceEstimated> priceEstimated;
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
    @SerializedName("trade_partition")
    private String tradePartition;
    @SerializedName("underlying_currency")
    private String underlyingCurrency;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapProductInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapProductInfo)) {
            return false;
        }
        LinearSwapProductInfo linearSwapProductInfo = (LinearSwapProductInfo) obj;
        if (!linearSwapProductInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = linearSwapProductInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = linearSwapProductInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String underlyingCurrency2 = getUnderlyingCurrency();
        String underlyingCurrency3 = linearSwapProductInfo.getUnderlyingCurrency();
        if (underlyingCurrency2 != null ? !underlyingCurrency2.equals(underlyingCurrency3) : underlyingCurrency3 != null) {
            return false;
        }
        String contractSize2 = getContractSize();
        String contractSize3 = linearSwapProductInfo.getContractSize();
        if (contractSize2 != null ? !contractSize2.equals(contractSize3) : contractSize3 != null) {
            return false;
        }
        if (getAmountPrecision() != linearSwapProductInfo.getAmountPrecision() || getFeeAmountPrecision() != linearSwapProductInfo.getFeeAmountPrecision() || getOtherAmountPrecision() != linearSwapProductInfo.getOtherAmountPrecision()) {
            return false;
        }
        String priceTick2 = getPriceTick();
        String priceTick3 = linearSwapProductInfo.getPriceTick();
        if (priceTick2 != null ? !priceTick2.equals(priceTick3) : priceTick3 != null) {
            return false;
        }
        if (getProductLabel() != linearSwapProductInfo.getProductLabel() || getPricePrecision() != linearSwapProductInfo.getPricePrecision()) {
            return false;
        }
        List<LinearSwapPriceEstimated> priceEstimated2 = getPriceEstimated();
        List<LinearSwapPriceEstimated> priceEstimated3 = linearSwapProductInfo.getPriceEstimated();
        if (priceEstimated2 != null ? !priceEstimated2.equals(priceEstimated3) : priceEstimated3 != null) {
            return false;
        }
        if (getIsTrade() != linearSwapProductInfo.getIsTrade() || getFinancialAmountPrecision() != linearSwapProductInfo.getFinancialAmountPrecision() || getRealTimeSettlement() != linearSwapProductInfo.getRealTimeSettlement()) {
            return false;
        }
        String tradePartition2 = getTradePartition();
        String tradePartition3 = linearSwapProductInfo.getTradePartition();
        return tradePartition2 != null ? tradePartition2.equals(tradePartition3) : tradePartition3 == null;
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

    public int getIsTrade() {
        return this.isTrade;
    }

    public int getOtherAmountPrecision() {
        return this.otherAmountPrecision;
    }

    public List<LinearSwapPriceEstimated> getPriceEstimated() {
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

    public String getTradePartition() {
        return this.tradePartition;
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
        int hashCode4 = (((((((hashCode3 * 59) + (contractSize2 == null ? 43 : contractSize2.hashCode())) * 59) + getAmountPrecision()) * 59) + getFeeAmountPrecision()) * 59) + getOtherAmountPrecision();
        String priceTick2 = getPriceTick();
        int hashCode5 = (((((hashCode4 * 59) + (priceTick2 == null ? 43 : priceTick2.hashCode())) * 59) + getProductLabel()) * 59) + getPricePrecision();
        List<LinearSwapPriceEstimated> priceEstimated2 = getPriceEstimated();
        int hashCode6 = (((((((hashCode5 * 59) + (priceEstimated2 == null ? 43 : priceEstimated2.hashCode())) * 59) + getIsTrade()) * 59) + getFinancialAmountPrecision()) * 59) + getRealTimeSettlement();
        String tradePartition2 = getTradePartition();
        int i12 = hashCode6 * 59;
        if (tradePartition2 != null) {
            i11 = tradePartition2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isRealTimeSettlement() {
        return this.realTimeSettlement == 1;
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

    public void setIsTrade(int i11) {
        this.isTrade = i11;
    }

    public void setOtherAmountPrecision(int i11) {
        this.otherAmountPrecision = i11;
    }

    public void setPriceEstimated(List<LinearSwapPriceEstimated> list) {
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

    public void setTradePartition(String str) {
        this.tradePartition = str;
    }

    public void setUnderlyingCurrency(String str) {
        this.underlyingCurrency = str;
    }

    public String toString() {
        return "LinearSwapProductInfo(symbol=" + getSymbol() + ", currency=" + getCurrency() + ", underlyingCurrency=" + getUnderlyingCurrency() + ", contractSize=" + getContractSize() + ", amountPrecision=" + getAmountPrecision() + ", feeAmountPrecision=" + getFeeAmountPrecision() + ", otherAmountPrecision=" + getOtherAmountPrecision() + ", priceTick=" + getPriceTick() + ", productLabel=" + getProductLabel() + ", pricePrecision=" + getPricePrecision() + ", priceEstimated=" + getPriceEstimated() + ", isTrade=" + getIsTrade() + ", financialAmountPrecision=" + getFinancialAmountPrecision() + ", realTimeSettlement=" + getRealTimeSettlement() + ", tradePartition=" + getTradePartition() + ")";
    }
}
