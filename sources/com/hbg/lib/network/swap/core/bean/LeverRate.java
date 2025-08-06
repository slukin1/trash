package com.hbg.lib.network.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LeverRate implements Serializable {
    private boolean available;
    @SerializedName("lever_rate")
    private String leverRate;

    public boolean canEqual(Object obj) {
        return obj instanceof LeverRate;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LeverRate)) {
            return false;
        }
        LeverRate leverRate2 = (LeverRate) obj;
        if (!leverRate2.canEqual(this) || isAvailable() != leverRate2.isAvailable()) {
            return false;
        }
        String leverRate3 = getLeverRate();
        String leverRate4 = leverRate2.getLeverRate();
        return leverRate3 != null ? leverRate3.equals(leverRate4) : leverRate4 == null;
    }

    public String getLeverRate() {
        return this.leverRate;
    }

    public int hashCode() {
        int i11 = isAvailable() ? 79 : 97;
        String leverRate2 = getLeverRate();
        return ((i11 + 59) * 59) + (leverRate2 == null ? 43 : leverRate2.hashCode());
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean z11) {
        this.available = z11;
    }

    public void setLeverRate(String str) {
        this.leverRate = str;
    }

    public String toString() {
        return "LeverRate(available=" + isAvailable() + ", leverRate=" + getLeverRate() + ")";
    }
}
