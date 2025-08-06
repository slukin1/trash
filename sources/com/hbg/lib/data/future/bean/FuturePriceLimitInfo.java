package com.hbg.lib.data.future.bean;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPriceLimitInfo;
import com.hbg.lib.network.option.core.bean.PriceLimitInfo;
import java.io.Serializable;

public class FuturePriceLimitInfo implements Serializable {
    private String contractCode;
    private String contractType;
    private String highLimit;
    private String lowLimit;
    private String optionCode;
    private String symbol;
    private String tradePartition;

    public boolean canEqual(Object obj) {
        return obj instanceof FuturePriceLimitInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FuturePriceLimitInfo)) {
            return false;
        }
        FuturePriceLimitInfo futurePriceLimitInfo = (FuturePriceLimitInfo) obj;
        if (!futurePriceLimitInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = futurePriceLimitInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = futurePriceLimitInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String highLimit2 = getHighLimit();
        String highLimit3 = futurePriceLimitInfo.getHighLimit();
        if (highLimit2 != null ? !highLimit2.equals(highLimit3) : highLimit3 != null) {
            return false;
        }
        String lowLimit2 = getLowLimit();
        String lowLimit3 = futurePriceLimitInfo.getLowLimit();
        if (lowLimit2 != null ? !lowLimit2.equals(lowLimit3) : lowLimit3 != null) {
            return false;
        }
        String tradePartition2 = getTradePartition();
        String tradePartition3 = futurePriceLimitInfo.getTradePartition();
        if (tradePartition2 != null ? !tradePartition2.equals(tradePartition3) : tradePartition3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = futurePriceLimitInfo.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String optionCode2 = getOptionCode();
        String optionCode3 = futurePriceLimitInfo.getOptionCode();
        return optionCode2 != null ? optionCode2.equals(optionCode3) : optionCode3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractType() {
        return this.contractType;
    }

    public String getHighLimit() {
        return this.highLimit;
    }

    public String getLowLimit() {
        return this.lowLimit;
    }

    public String getOptionCode() {
        return this.optionCode;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTradePartition() {
        return this.tradePartition;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String contractCode2 = getContractCode();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String highLimit2 = getHighLimit();
        int hashCode3 = (hashCode2 * 59) + (highLimit2 == null ? 43 : highLimit2.hashCode());
        String lowLimit2 = getLowLimit();
        int hashCode4 = (hashCode3 * 59) + (lowLimit2 == null ? 43 : lowLimit2.hashCode());
        String tradePartition2 = getTradePartition();
        int hashCode5 = (hashCode4 * 59) + (tradePartition2 == null ? 43 : tradePartition2.hashCode());
        String contractType2 = getContractType();
        int hashCode6 = (hashCode5 * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String optionCode2 = getOptionCode();
        int i12 = hashCode6 * 59;
        if (optionCode2 != null) {
            i11 = optionCode2.hashCode();
        }
        return i12 + i11;
    }

    public FuturePriceLimitInfo linearSwapConvert(FuturePriceLimitInfo futurePriceLimitInfo, LinearSwapPriceLimitInfo linearSwapPriceLimitInfo) {
        futurePriceLimitInfo.setSymbol(linearSwapPriceLimitInfo.getSymbol());
        futurePriceLimitInfo.setContractCode(linearSwapPriceLimitInfo.getContractCode());
        futurePriceLimitInfo.setHighLimit(linearSwapPriceLimitInfo.getHighLimit());
        futurePriceLimitInfo.setLowLimit(linearSwapPriceLimitInfo.getLowLimit());
        return futurePriceLimitInfo;
    }

    public FuturePriceLimitInfo optionConvert(FuturePriceLimitInfo futurePriceLimitInfo, PriceLimitInfo priceLimitInfo) {
        futurePriceLimitInfo.setSymbol(priceLimitInfo.getSymbol());
        futurePriceLimitInfo.setContractCode(priceLimitInfo.getContractCode());
        futurePriceLimitInfo.setHighLimit(priceLimitInfo.getHighLimit());
        futurePriceLimitInfo.setLowLimit(priceLimitInfo.getLowLimit());
        futurePriceLimitInfo.setTradePartition(priceLimitInfo.getTradePartition());
        futurePriceLimitInfo.setContractType(priceLimitInfo.getContractType());
        futurePriceLimitInfo.setOptionCode(priceLimitInfo.getOptionCode());
        return futurePriceLimitInfo;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setHighLimit(String str) {
        this.highLimit = str;
    }

    public void setLowLimit(String str) {
        this.lowLimit = str;
    }

    public void setOptionCode(String str) {
        this.optionCode = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradePartition(String str) {
        this.tradePartition = str;
    }

    public String toString() {
        return "FuturePriceLimitInfo(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", highLimit=" + getHighLimit() + ", lowLimit=" + getLowLimit() + ", tradePartition=" + getTradePartition() + ", contractType=" + getContractType() + ", optionCode=" + getOptionCode() + ")";
    }
}
