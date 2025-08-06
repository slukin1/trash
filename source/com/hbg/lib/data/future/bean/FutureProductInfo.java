package com.hbg.lib.data.future.bean;

import com.google.gson.annotations.Expose;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapProductInfo;
import com.hbg.lib.network.option.core.bean.OptionProductInfo;
import java.io.Serializable;

public class FutureProductInfo implements Serializable {
    private int amountPrecision;
    private String contractSize;
    @Expose
    private String currency;
    private int feeAmountPrecision;
    private int financialAmountPrecision;
    private String indexPriceTick;
    private int isTrade;
    private int optionPricePrecision;
    private int otherAmountPrecision;
    private int pricePrecision;
    private String priceTick;
    private int productLabel;
    private String quoteCurrency;
    @Expose
    private String symbol;
    private String tradePartition;
    private String underlyingCurrency;

    public boolean canEqual(Object obj) {
        return obj instanceof FutureProductInfo;
    }

    public FutureProductInfo convert(FutureProductInfo futureProductInfo, LinearSwapProductInfo linearSwapProductInfo) {
        futureProductInfo.setSymbol(linearSwapProductInfo.getSymbol());
        futureProductInfo.setCurrency(linearSwapProductInfo.getCurrency());
        futureProductInfo.setUnderlyingCurrency(linearSwapProductInfo.getUnderlyingCurrency());
        futureProductInfo.setContractSize(linearSwapProductInfo.getContractSize());
        futureProductInfo.setAmountPrecision(linearSwapProductInfo.getAmountPrecision());
        futureProductInfo.setFeeAmountPrecision(linearSwapProductInfo.getFeeAmountPrecision());
        futureProductInfo.setFinancialAmountPrecision(linearSwapProductInfo.getFinancialAmountPrecision());
        futureProductInfo.setOtherAmountPrecision(linearSwapProductInfo.getOtherAmountPrecision());
        futureProductInfo.setPriceTick(linearSwapProductInfo.getPriceTick());
        futureProductInfo.setProductLabel(linearSwapProductInfo.getProductLabel());
        futureProductInfo.setPricePrecision(linearSwapProductInfo.getPricePrecision());
        futureProductInfo.setQuoteCurrency(linearSwapProductInfo.getCurrency());
        futureProductInfo.setIsTrade(linearSwapProductInfo.getIsTrade());
        futureProductInfo.setTradePartition(linearSwapProductInfo.getTradePartition());
        return futureProductInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FutureProductInfo)) {
            return false;
        }
        FutureProductInfo futureProductInfo = (FutureProductInfo) obj;
        if (!futureProductInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = futureProductInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = futureProductInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String underlyingCurrency2 = getUnderlyingCurrency();
        String underlyingCurrency3 = futureProductInfo.getUnderlyingCurrency();
        if (underlyingCurrency2 != null ? !underlyingCurrency2.equals(underlyingCurrency3) : underlyingCurrency3 != null) {
            return false;
        }
        String contractSize2 = getContractSize();
        String contractSize3 = futureProductInfo.getContractSize();
        if (contractSize2 != null ? !contractSize2.equals(contractSize3) : contractSize3 != null) {
            return false;
        }
        if (getAmountPrecision() != futureProductInfo.getAmountPrecision() || getFeeAmountPrecision() != futureProductInfo.getFeeAmountPrecision() || getFinancialAmountPrecision() != futureProductInfo.getFinancialAmountPrecision() || getOtherAmountPrecision() != futureProductInfo.getOtherAmountPrecision() || getOptionPricePrecision() != futureProductInfo.getOptionPricePrecision()) {
            return false;
        }
        String indexPriceTick2 = getIndexPriceTick();
        String indexPriceTick3 = futureProductInfo.getIndexPriceTick();
        if (indexPriceTick2 != null ? !indexPriceTick2.equals(indexPriceTick3) : indexPriceTick3 != null) {
            return false;
        }
        String priceTick2 = getPriceTick();
        String priceTick3 = futureProductInfo.getPriceTick();
        if (priceTick2 != null ? !priceTick2.equals(priceTick3) : priceTick3 != null) {
            return false;
        }
        if (getProductLabel() != futureProductInfo.getProductLabel() || getPricePrecision() != futureProductInfo.getPricePrecision()) {
            return false;
        }
        String quoteCurrency2 = getQuoteCurrency();
        String quoteCurrency3 = futureProductInfo.getQuoteCurrency();
        if (quoteCurrency2 != null ? !quoteCurrency2.equals(quoteCurrency3) : quoteCurrency3 != null) {
            return false;
        }
        if (getIsTrade() != futureProductInfo.getIsTrade()) {
            return false;
        }
        String tradePartition2 = getTradePartition();
        String tradePartition3 = futureProductInfo.getTradePartition();
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
        int hashCode4 = (((((((((((hashCode3 * 59) + (contractSize2 == null ? 43 : contractSize2.hashCode())) * 59) + getAmountPrecision()) * 59) + getFeeAmountPrecision()) * 59) + getFinancialAmountPrecision()) * 59) + getOtherAmountPrecision()) * 59) + getOptionPricePrecision();
        String indexPriceTick2 = getIndexPriceTick();
        int hashCode5 = (hashCode4 * 59) + (indexPriceTick2 == null ? 43 : indexPriceTick2.hashCode());
        String priceTick2 = getPriceTick();
        int hashCode6 = (((((hashCode5 * 59) + (priceTick2 == null ? 43 : priceTick2.hashCode())) * 59) + getProductLabel()) * 59) + getPricePrecision();
        String quoteCurrency2 = getQuoteCurrency();
        int hashCode7 = (((hashCode6 * 59) + (quoteCurrency2 == null ? 43 : quoteCurrency2.hashCode())) * 59) + getIsTrade();
        String tradePartition2 = getTradePartition();
        int i12 = hashCode7 * 59;
        if (tradePartition2 != null) {
            i11 = tradePartition2.hashCode();
        }
        return i12 + i11;
    }

    public FutureProductInfo optionConvert(FutureProductInfo futureProductInfo, OptionProductInfo optionProductInfo) {
        futureProductInfo.setSymbol(optionProductInfo.getSymbol());
        futureProductInfo.setCurrency(optionProductInfo.getCurrency());
        futureProductInfo.setUnderlyingCurrency(optionProductInfo.getUnderlyingCurrency());
        futureProductInfo.setContractSize(optionProductInfo.getContractSize());
        futureProductInfo.setAmountPrecision(optionProductInfo.getAmountPrecision());
        futureProductInfo.setFeeAmountPrecision(optionProductInfo.getFeeAmountPrecision());
        futureProductInfo.setFinancialAmountPrecision(optionProductInfo.getFinancialAmountPrecision());
        futureProductInfo.setOtherAmountPrecision(optionProductInfo.getOtherAmountPrecision());
        futureProductInfo.setOptionPricePrecision(optionProductInfo.getOptionPricePrecision());
        futureProductInfo.setPriceTick(optionProductInfo.getPriceTick());
        futureProductInfo.setProductLabel(optionProductInfo.getProductLabel());
        futureProductInfo.setPricePrecision(optionProductInfo.getPricePrecision());
        futureProductInfo.setQuoteCurrency(optionProductInfo.getQuoteCurrency());
        futureProductInfo.setIsTrade(optionProductInfo.getIsTrade());
        return futureProductInfo;
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
        return "FutureProductInfo(symbol=" + getSymbol() + ", currency=" + getCurrency() + ", underlyingCurrency=" + getUnderlyingCurrency() + ", contractSize=" + getContractSize() + ", amountPrecision=" + getAmountPrecision() + ", feeAmountPrecision=" + getFeeAmountPrecision() + ", financialAmountPrecision=" + getFinancialAmountPrecision() + ", otherAmountPrecision=" + getOtherAmountPrecision() + ", optionPricePrecision=" + getOptionPricePrecision() + ", indexPriceTick=" + getIndexPriceTick() + ", priceTick=" + getPriceTick() + ", productLabel=" + getProductLabel() + ", pricePrecision=" + getPricePrecision() + ", quoteCurrency=" + getQuoteCurrency() + ", isTrade=" + getIsTrade() + ", tradePartition=" + getTradePartition() + ")";
    }
}
