package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractAllowLevel implements Serializable {
    private static final long serialVersionUID = -7926673411932712212L;
    @SerializedName("available_level_rate")
    private String availableLevelRate;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractAllowLevel;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractAllowLevel)) {
            return false;
        }
        ContractAllowLevel contractAllowLevel = (ContractAllowLevel) obj;
        if (!contractAllowLevel.canEqual(this)) {
            return false;
        }
        String availableLevelRate2 = getAvailableLevelRate();
        String availableLevelRate3 = contractAllowLevel.getAvailableLevelRate();
        if (availableLevelRate2 != null ? !availableLevelRate2.equals(availableLevelRate3) : availableLevelRate3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = contractAllowLevel.getSymbol();
        return symbol2 != null ? symbol2.equals(symbol3) : symbol3 == null;
    }

    public String getAvailableLevelRate() {
        return this.availableLevelRate;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String availableLevelRate2 = getAvailableLevelRate();
        int i11 = 43;
        int hashCode = availableLevelRate2 == null ? 43 : availableLevelRate2.hashCode();
        String symbol2 = getSymbol();
        int i12 = (hashCode + 59) * 59;
        if (symbol2 != null) {
            i11 = symbol2.hashCode();
        }
        return i12 + i11;
    }

    public void setAvailableLevelRate(String str) {
        this.availableLevelRate = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "ContractAllowLevel(availableLevelRate=" + getAvailableLevelRate() + ", symbol=" + getSymbol() + ")";
    }
}
