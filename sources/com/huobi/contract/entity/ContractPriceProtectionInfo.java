package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractPriceProtectionInfo implements Serializable {
    @SerializedName("price_protect_switch")
    private int price_protect_switch = 1;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractPriceProtectionInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractPriceProtectionInfo)) {
            return false;
        }
        ContractPriceProtectionInfo contractPriceProtectionInfo = (ContractPriceProtectionInfo) obj;
        return contractPriceProtectionInfo.canEqual(this) && getPrice_protect_switch() == contractPriceProtectionInfo.getPrice_protect_switch();
    }

    public int getPrice_protect_switch() {
        return this.price_protect_switch;
    }

    public int hashCode() {
        return 59 + getPrice_protect_switch();
    }

    public boolean isSwitchOn() {
        return this.price_protect_switch == 1;
    }

    public void setPrice_protect_switch(int i11) {
        this.price_protect_switch = i11;
    }

    public String toString() {
        return "ContractPriceProtectionInfo(price_protect_switch=" + getPrice_protect_switch() + ")";
    }
}
