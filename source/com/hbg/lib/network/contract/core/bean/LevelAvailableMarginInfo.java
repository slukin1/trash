package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LevelAvailableMarginInfo implements Serializable {
    @SerializedName("available_margin")
    private String availableMargin;
    private String level;

    public boolean canEqual(Object obj) {
        return obj instanceof LevelAvailableMarginInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LevelAvailableMarginInfo)) {
            return false;
        }
        LevelAvailableMarginInfo levelAvailableMarginInfo = (LevelAvailableMarginInfo) obj;
        if (!levelAvailableMarginInfo.canEqual(this)) {
            return false;
        }
        String level2 = getLevel();
        String level3 = levelAvailableMarginInfo.getLevel();
        if (level2 != null ? !level2.equals(level3) : level3 != null) {
            return false;
        }
        String availableMargin2 = getAvailableMargin();
        String availableMargin3 = levelAvailableMarginInfo.getAvailableMargin();
        return availableMargin2 != null ? availableMargin2.equals(availableMargin3) : availableMargin3 == null;
    }

    public String getAvailableMargin() {
        return this.availableMargin;
    }

    public String getLevel() {
        return this.level;
    }

    public int hashCode() {
        String level2 = getLevel();
        int i11 = 43;
        int hashCode = level2 == null ? 43 : level2.hashCode();
        String availableMargin2 = getAvailableMargin();
        int i12 = (hashCode + 59) * 59;
        if (availableMargin2 != null) {
            i11 = availableMargin2.hashCode();
        }
        return i12 + i11;
    }

    public void setAvailableMargin(String str) {
        this.availableMargin = str;
    }

    public void setLevel(String str) {
        this.level = str;
    }

    public String toString() {
        return "LevelAvailableMarginInfo(level=" + getLevel() + ", availableMargin=" + getAvailableMargin() + ")";
    }
}
