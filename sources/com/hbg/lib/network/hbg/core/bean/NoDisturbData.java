package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class NoDisturbData implements Serializable {
    @SerializedName("disturbType")
    private int disturbType;
    @SerializedName("endTime")
    private String endTime;
    @SerializedName("startTime")
    private String startTime;

    public boolean canEqual(Object obj) {
        return obj instanceof NoDisturbData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NoDisturbData)) {
            return false;
        }
        NoDisturbData noDisturbData = (NoDisturbData) obj;
        if (!noDisturbData.canEqual(this)) {
            return false;
        }
        String startTime2 = getStartTime();
        String startTime3 = noDisturbData.getStartTime();
        if (startTime2 != null ? !startTime2.equals(startTime3) : startTime3 != null) {
            return false;
        }
        String endTime2 = getEndTime();
        String endTime3 = noDisturbData.getEndTime();
        if (endTime2 != null ? endTime2.equals(endTime3) : endTime3 == null) {
            return getDisturbType() == noDisturbData.getDisturbType();
        }
        return false;
    }

    public int getDisturbType() {
        return this.disturbType;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public int hashCode() {
        String startTime2 = getStartTime();
        int i11 = 43;
        int hashCode = startTime2 == null ? 43 : startTime2.hashCode();
        String endTime2 = getEndTime();
        int i12 = (hashCode + 59) * 59;
        if (endTime2 != null) {
            i11 = endTime2.hashCode();
        }
        return ((i12 + i11) * 59) + getDisturbType();
    }

    public void setDisturbType(int i11) {
        this.disturbType = i11;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public String toString() {
        return "NoDisturbData(startTime=" + getStartTime() + ", endTime=" + getEndTime() + ", disturbType=" + getDisturbType() + ")";
    }
}
