package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractActive implements Serializable {
    private static final long serialVersionUID = 4510330758664106475L;
    @SerializedName("is_active")
    private int active;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractActive;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractActive)) {
            return false;
        }
        ContractActive contractActive = (ContractActive) obj;
        return contractActive.canEqual(this) && getActive() == contractActive.getActive();
    }

    public int getActive() {
        return this.active;
    }

    public int hashCode() {
        return 59 + getActive();
    }

    public void setActive(int i11) {
        this.active = i11;
    }

    public String toString() {
        return "ContractActive(active=" + getActive() + ")";
    }
}
