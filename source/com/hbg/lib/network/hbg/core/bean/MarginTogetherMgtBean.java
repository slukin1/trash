package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class MarginTogetherMgtBean implements Serializable {
    public static final int NEW = 1;
    public static final int OLD = 0;
    private int exvalue;
    @SerializedName("useridfirNum")
    private int userIdFirNum;
    @SerializedName("useridsecNum")
    private int userIdSecNum;

    public boolean canEqual(Object obj) {
        return obj instanceof MarginTogetherMgtBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarginTogetherMgtBean)) {
            return false;
        }
        MarginTogetherMgtBean marginTogetherMgtBean = (MarginTogetherMgtBean) obj;
        return marginTogetherMgtBean.canEqual(this) && getUserIdFirNum() == marginTogetherMgtBean.getUserIdFirNum() && getUserIdSecNum() == marginTogetherMgtBean.getUserIdSecNum() && getExvalue() == marginTogetherMgtBean.getExvalue();
    }

    public int getExvalue() {
        return this.exvalue;
    }

    public int getUserIdFirNum() {
        return this.userIdFirNum;
    }

    public int getUserIdSecNum() {
        return this.userIdSecNum;
    }

    public int hashCode() {
        return ((((getUserIdFirNum() + 59) * 59) + getUserIdSecNum()) * 59) + getExvalue();
    }

    public void setExvalue(int i11) {
        this.exvalue = i11;
    }

    public void setUserIdFirNum(int i11) {
        this.userIdFirNum = i11;
    }

    public void setUserIdSecNum(int i11) {
        this.userIdSecNum = i11;
    }

    public String toString() {
        return "MarginTogetherMgtBean(userIdFirNum=" + getUserIdFirNum() + ", userIdSecNum=" + getUserIdSecNum() + ", exvalue=" + getExvalue() + ")";
    }
}
