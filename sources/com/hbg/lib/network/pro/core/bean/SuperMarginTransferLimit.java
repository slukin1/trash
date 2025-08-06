package com.hbg.lib.network.pro.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SuperMarginTransferLimit implements Serializable {
    @SerializedName("margin-limit-available")
    private String marginLimitAvailable;
    @SerializedName("position-limit-available")
    private String positionLimitAvailable;

    public boolean canEqual(Object obj) {
        return obj instanceof SuperMarginTransferLimit;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SuperMarginTransferLimit)) {
            return false;
        }
        SuperMarginTransferLimit superMarginTransferLimit = (SuperMarginTransferLimit) obj;
        if (!superMarginTransferLimit.canEqual(this)) {
            return false;
        }
        String marginLimitAvailable2 = getMarginLimitAvailable();
        String marginLimitAvailable3 = superMarginTransferLimit.getMarginLimitAvailable();
        if (marginLimitAvailable2 != null ? !marginLimitAvailable2.equals(marginLimitAvailable3) : marginLimitAvailable3 != null) {
            return false;
        }
        String positionLimitAvailable2 = getPositionLimitAvailable();
        String positionLimitAvailable3 = superMarginTransferLimit.getPositionLimitAvailable();
        return positionLimitAvailable2 != null ? positionLimitAvailable2.equals(positionLimitAvailable3) : positionLimitAvailable3 == null;
    }

    public String getMarginLimitAvailable() {
        return this.marginLimitAvailable;
    }

    public String getPositionLimitAvailable() {
        return this.positionLimitAvailable;
    }

    public int hashCode() {
        String marginLimitAvailable2 = getMarginLimitAvailable();
        int i11 = 43;
        int hashCode = marginLimitAvailable2 == null ? 43 : marginLimitAvailable2.hashCode();
        String positionLimitAvailable2 = getPositionLimitAvailable();
        int i12 = (hashCode + 59) * 59;
        if (positionLimitAvailable2 != null) {
            i11 = positionLimitAvailable2.hashCode();
        }
        return i12 + i11;
    }

    public void setMarginLimitAvailable(String str) {
        this.marginLimitAvailable = str;
    }

    public void setPositionLimitAvailable(String str) {
        this.positionLimitAvailable = str;
    }

    public String toString() {
        return "SuperMarginTransferLimit(marginLimitAvailable=" + getMarginLimitAvailable() + ", positionLimitAvailable=" + getPositionLimitAvailable() + ")";
    }
}
