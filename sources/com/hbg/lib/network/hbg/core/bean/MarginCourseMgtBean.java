package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class MarginCourseMgtBean implements Serializable {
    public static final int SHOW = 1;
    @SerializedName("isShow")
    private int isShow;
    @SerializedName("jumpUrl")
    private String jumpUrl;

    public boolean canEqual(Object obj) {
        return obj instanceof MarginCourseMgtBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarginCourseMgtBean)) {
            return false;
        }
        MarginCourseMgtBean marginCourseMgtBean = (MarginCourseMgtBean) obj;
        if (!marginCourseMgtBean.canEqual(this) || getIsShow() != marginCourseMgtBean.getIsShow()) {
            return false;
        }
        String jumpUrl2 = getJumpUrl();
        String jumpUrl3 = marginCourseMgtBean.getJumpUrl();
        return jumpUrl2 != null ? jumpUrl2.equals(jumpUrl3) : jumpUrl3 == null;
    }

    public int getIsShow() {
        return this.isShow;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public int hashCode() {
        String jumpUrl2 = getJumpUrl();
        return ((getIsShow() + 59) * 59) + (jumpUrl2 == null ? 43 : jumpUrl2.hashCode());
    }

    public void setIsShow(int i11) {
        this.isShow = i11;
    }

    public void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public String toString() {
        return "MarginCourseMgtBean{isShow=" + this.isShow + ", jumpUrl='" + this.jumpUrl + '\'' + '}';
    }
}
