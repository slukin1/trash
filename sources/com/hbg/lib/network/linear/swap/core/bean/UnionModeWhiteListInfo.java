package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UnionModeWhiteListInfo implements Serializable {
    @SerializedName("front_switch")
    private String showUnionPattern;

    public boolean canEqual(Object obj) {
        return obj instanceof UnionModeWhiteListInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnionModeWhiteListInfo)) {
            return false;
        }
        UnionModeWhiteListInfo unionModeWhiteListInfo = (UnionModeWhiteListInfo) obj;
        if (!unionModeWhiteListInfo.canEqual(this)) {
            return false;
        }
        String showUnionPattern2 = getShowUnionPattern();
        String showUnionPattern3 = unionModeWhiteListInfo.getShowUnionPattern();
        return showUnionPattern2 != null ? showUnionPattern2.equals(showUnionPattern3) : showUnionPattern3 == null;
    }

    public String getShowUnionPattern() {
        return this.showUnionPattern;
    }

    public int hashCode() {
        String showUnionPattern2 = getShowUnionPattern();
        return 59 + (showUnionPattern2 == null ? 43 : showUnionPattern2.hashCode());
    }

    public boolean isUnionUser() {
        return "1".equals(this.showUnionPattern);
    }

    public void setShowUnionPattern(String str) {
        this.showUnionPattern = str;
    }

    public String toString() {
        return "UnionModeWhiteListInfo(showUnionPattern=" + getShowUnionPattern() + ")";
    }
}
