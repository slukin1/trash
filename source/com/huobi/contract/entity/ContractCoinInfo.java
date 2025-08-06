package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractCoinInfo implements Serializable {
    @SerializedName("amount_precision")
    private int amountPrecision;
    @SerializedName("contract_size")
    private int contractFace;
    private String currency;
    @SerializedName("fee_amount_precision")
    private int feeAmountPrecision;
    @SerializedName("financial_amount_precision")
    private int financialAmountPrecision = 8;
    @SerializedName("is_debit")
    private int isDebit;
    private boolean isSelected;
    @SerializedName("is_trade")
    private int isTrade;
    @SerializedName("other_amount_precision")
    private int otherAmountPrecision;
    @SerializedName("price_precision")
    private int pricePrecision;
    @SerializedName("price_tick")
    private String priceTick;
    @SerializedName("real_time_settlement")
    private int realTimeSettlement;
    private String symbol;
    @SerializedName("underlying_currency")
    private String underlyingCurrency;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractCoinInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractCoinInfo)) {
            return false;
        }
        ContractCoinInfo contractCoinInfo = (ContractCoinInfo) obj;
        if (!contractCoinInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = contractCoinInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = contractCoinInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String underlyingCurrency2 = getUnderlyingCurrency();
        String underlyingCurrency3 = contractCoinInfo.getUnderlyingCurrency();
        if (underlyingCurrency2 != null ? !underlyingCurrency2.equals(underlyingCurrency3) : underlyingCurrency3 != null) {
            return false;
        }
        if (getContractFace() != contractCoinInfo.getContractFace() || getAmountPrecision() != contractCoinInfo.getAmountPrecision() || getFeeAmountPrecision() != contractCoinInfo.getFeeAmountPrecision() || getFinancialAmountPrecision() != contractCoinInfo.getFinancialAmountPrecision() || getOtherAmountPrecision() != contractCoinInfo.getOtherAmountPrecision() || getPricePrecision() != contractCoinInfo.getPricePrecision()) {
            return false;
        }
        String priceTick2 = getPriceTick();
        String priceTick3 = contractCoinInfo.getPriceTick();
        if (priceTick2 != null ? priceTick2.equals(priceTick3) : priceTick3 == null) {
            return getIsDebit() == contractCoinInfo.getIsDebit() && getIsTrade() == contractCoinInfo.getIsTrade() && getRealTimeSettlement() == contractCoinInfo.getRealTimeSettlement() && isSelected() == contractCoinInfo.isSelected();
        }
        return false;
    }

    public int getAmountPrecision() {
        return this.amountPrecision;
    }

    public int getContractFace() {
        return this.contractFace;
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

    public int getIsDebit() {
        return this.isDebit;
    }

    public int getIsTrade() {
        return this.isTrade;
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
        int hashCode3 = (((((((((((((hashCode2 * 59) + (underlyingCurrency2 == null ? 43 : underlyingCurrency2.hashCode())) * 59) + getContractFace()) * 59) + getAmountPrecision()) * 59) + getFeeAmountPrecision()) * 59) + getFinancialAmountPrecision()) * 59) + getOtherAmountPrecision()) * 59) + getPricePrecision();
        String priceTick2 = getPriceTick();
        int i12 = hashCode3 * 59;
        if (priceTick2 != null) {
            i11 = priceTick2.hashCode();
        }
        return ((((((((i12 + i11) * 59) + getIsDebit()) * 59) + getIsTrade()) * 59) + getRealTimeSettlement()) * 59) + (isSelected() ? 79 : 97);
    }

    public boolean isRealTimeSettlement() {
        return this.realTimeSettlement == 1;
    }

    public boolean isSelected() {
        return this.isSelected;
    }

    public void setAmountPrecision(int i11) {
        this.amountPrecision = i11;
    }

    public void setContractFace(int i11) {
        this.contractFace = i11;
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

    public void setIsDebit(int i11) {
        this.isDebit = i11;
    }

    public void setIsTrade(int i11) {
        this.isTrade = i11;
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

    public void setRealTimeSettlement(int i11) {
        this.realTimeSettlement = i11;
    }

    public void setSelected(boolean z11) {
        this.isSelected = z11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setUnderlyingCurrency(String str) {
        this.underlyingCurrency = str;
    }

    public String toString() {
        return "ContractCoinInfo(symbol=" + getSymbol() + ", currency=" + getCurrency() + ", underlyingCurrency=" + getUnderlyingCurrency() + ", contractFace=" + getContractFace() + ", amountPrecision=" + getAmountPrecision() + ", feeAmountPrecision=" + getFeeAmountPrecision() + ", financialAmountPrecision=" + getFinancialAmountPrecision() + ", otherAmountPrecision=" + getOtherAmountPrecision() + ", pricePrecision=" + getPricePrecision() + ", priceTick=" + getPriceTick() + ", isDebit=" + getIsDebit() + ", isTrade=" + getIsTrade() + ", realTimeSettlement=" + getRealTimeSettlement() + ", isSelected=" + isSelected() + ")";
    }
}
