package com.huobi.account.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class KeepTimeData implements Serializable {
    @SerializedName("loginKeepTime")
    private int loginKeepTime;

    public boolean canEqual(Object obj) {
        return obj instanceof KeepTimeData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KeepTimeData)) {
            return false;
        }
        KeepTimeData keepTimeData = (KeepTimeData) obj;
        return keepTimeData.canEqual(this) && getLoginKeepTime() == keepTimeData.getLoginKeepTime();
    }

    public int getLoginKeepTime() {
        return this.loginKeepTime;
    }

    public int hashCode() {
        return 59 + getLoginKeepTime();
    }

    public void setLoginKeepTime(int i11) {
        this.loginKeepTime = i11;
    }

    public String toString() {
        return "KeepTimeData(loginKeepTime=" + getLoginKeepTime() + ")";
    }
}
