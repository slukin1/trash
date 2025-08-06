package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UnionModeData implements Serializable {
    @SerializedName("asset_mode")
    private int assetMode;

    public boolean canEqual(Object obj) {
        return obj instanceof UnionModeData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnionModeData)) {
            return false;
        }
        UnionModeData unionModeData = (UnionModeData) obj;
        return unionModeData.canEqual(this) && getAssetMode() == unionModeData.getAssetMode();
    }

    public int getAssetMode() {
        return this.assetMode;
    }

    public int hashCode() {
        return 59 + getAssetMode();
    }

    public boolean isUnionMode() {
        return 1 == this.assetMode;
    }

    public void setAssetMode(int i11) {
        this.assetMode = i11;
    }

    public String toString() {
        return "UnionModeData(assetMode=" + getAssetMode() + ")";
    }
}
