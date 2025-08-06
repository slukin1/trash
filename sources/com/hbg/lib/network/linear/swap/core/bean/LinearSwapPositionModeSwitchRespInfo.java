package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapPositionModeSwitchRespInfo implements Serializable {
    @SerializedName("margin_account")
    private String marginAccount;
    @SerializedName("position_mode")
    private String positionMode;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapPositionModeSwitchRespInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapPositionModeSwitchRespInfo)) {
            return false;
        }
        LinearSwapPositionModeSwitchRespInfo linearSwapPositionModeSwitchRespInfo = (LinearSwapPositionModeSwitchRespInfo) obj;
        if (!linearSwapPositionModeSwitchRespInfo.canEqual(this)) {
            return false;
        }
        String marginAccount2 = getMarginAccount();
        String marginAccount3 = linearSwapPositionModeSwitchRespInfo.getMarginAccount();
        if (marginAccount2 != null ? !marginAccount2.equals(marginAccount3) : marginAccount3 != null) {
            return false;
        }
        String positionMode2 = getPositionMode();
        String positionMode3 = linearSwapPositionModeSwitchRespInfo.getPositionMode();
        return positionMode2 != null ? positionMode2.equals(positionMode3) : positionMode3 == null;
    }

    public String getMarginAccount() {
        return this.marginAccount;
    }

    public String getPositionMode() {
        return this.positionMode;
    }

    public int hashCode() {
        String marginAccount2 = getMarginAccount();
        int i11 = 43;
        int hashCode = marginAccount2 == null ? 43 : marginAccount2.hashCode();
        String positionMode2 = getPositionMode();
        int i12 = (hashCode + 59) * 59;
        if (positionMode2 != null) {
            i11 = positionMode2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isSideSingleMode() {
        return "single_side".equals(this.positionMode);
    }

    public void setMarginAccount(String str) {
        this.marginAccount = str;
    }

    public void setPositionMode(String str) {
        this.positionMode = str;
    }

    public String toString() {
        return "LinearSwapPositionModeSwitchRespInfo(marginAccount=" + getMarginAccount() + ", positionMode=" + getPositionMode() + ")";
    }
}
