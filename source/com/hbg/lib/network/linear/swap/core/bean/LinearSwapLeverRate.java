package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapLeverRate implements Serializable {
    private boolean available;
    @SerializedName("lever_rate")
    private String leverRate;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapLeverRate;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapLeverRate)) {
            return false;
        }
        LinearSwapLeverRate linearSwapLeverRate = (LinearSwapLeverRate) obj;
        if (!linearSwapLeverRate.canEqual(this) || isAvailable() != linearSwapLeverRate.isAvailable()) {
            return false;
        }
        String leverRate2 = getLeverRate();
        String leverRate3 = linearSwapLeverRate.getLeverRate();
        return leverRate2 != null ? leverRate2.equals(leverRate3) : leverRate3 == null;
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
        return "LinearSwapLeverRate(available=" + isAvailable() + ", leverRate=" + getLeverRate() + ")";
    }
}
