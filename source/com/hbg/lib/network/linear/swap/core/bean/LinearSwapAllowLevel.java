package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapAllowLevel implements Serializable {
    private static final long serialVersionUID = -7926673411932712212L;
    @SerializedName("available_level_rate")
    private String availableLevelRate;
    @SerializedName("contract_code")
    private String contractCode;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapAllowLevel;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapAllowLevel)) {
            return false;
        }
        LinearSwapAllowLevel linearSwapAllowLevel = (LinearSwapAllowLevel) obj;
        if (!linearSwapAllowLevel.canEqual(this)) {
            return false;
        }
        String availableLevelRate2 = getAvailableLevelRate();
        String availableLevelRate3 = linearSwapAllowLevel.getAvailableLevelRate();
        if (availableLevelRate2 != null ? !availableLevelRate2.equals(availableLevelRate3) : availableLevelRate3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = linearSwapAllowLevel.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = linearSwapAllowLevel.getContractCode();
        return contractCode2 != null ? contractCode2.equals(contractCode3) : contractCode3 == null;
    }

    public String getAvailableLevelRate() {
        return this.availableLevelRate;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String availableLevelRate2 = getAvailableLevelRate();
        int i11 = 43;
        int hashCode = availableLevelRate2 == null ? 43 : availableLevelRate2.hashCode();
        String symbol2 = getSymbol();
        int hashCode2 = ((hashCode + 59) * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String contractCode2 = getContractCode();
        int i12 = hashCode2 * 59;
        if (contractCode2 != null) {
            i11 = contractCode2.hashCode();
        }
        return i12 + i11;
    }

    public void setAvailableLevelRate(String str) {
        this.availableLevelRate = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "LinearSwapAllowLevel(availableLevelRate=" + getAvailableLevelRate() + ", symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ")";
    }
}
