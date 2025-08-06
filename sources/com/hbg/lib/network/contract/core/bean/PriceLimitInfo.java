package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PriceLimitInfo implements Serializable {
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("high_limit")
    private String highLimit;
    @SerializedName("low_limit")
    private String lowLimit;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof PriceLimitInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PriceLimitInfo)) {
            return false;
        }
        PriceLimitInfo priceLimitInfo = (PriceLimitInfo) obj;
        if (!priceLimitInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = priceLimitInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = priceLimitInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String highLimit2 = getHighLimit();
        String highLimit3 = priceLimitInfo.getHighLimit();
        if (highLimit2 != null ? !highLimit2.equals(highLimit3) : highLimit3 != null) {
            return false;
        }
        String lowLimit2 = getLowLimit();
        String lowLimit3 = priceLimitInfo.getLowLimit();
        return lowLimit2 != null ? lowLimit2.equals(lowLimit3) : lowLimit3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getHighLimit() {
        return this.highLimit;
    }

    public String getLowLimit() {
        return this.lowLimit;
    }

    public String getSymbol() {
        return this.symbol;
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
        int i12 = hashCode3 * 59;
        if (lowLimit2 != null) {
            i11 = lowLimit2.hashCode();
        }
        return i12 + i11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setHighLimit(String str) {
        this.highLimit = str;
    }

    public void setLowLimit(String str) {
        this.lowLimit = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "PriceLimitInfo(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", highLimit=" + getHighLimit() + ", lowLimit=" + getLowLimit() + ")";
    }
}
