package com.huobi.statistics.hbg.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AnalyticsInfo implements Serializable {
    private static final long serialVersionUID = -6674862115680812486L;
    @SerializedName("click")
    private AnalyticsClick click;
    @SerializedName("exposure")
    private AnalyticsExposure exposure;

    public boolean canEqual(Object obj) {
        return obj instanceof AnalyticsInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AnalyticsInfo)) {
            return false;
        }
        AnalyticsInfo analyticsInfo = (AnalyticsInfo) obj;
        if (!analyticsInfo.canEqual(this)) {
            return false;
        }
        AnalyticsExposure exposure2 = getExposure();
        AnalyticsExposure exposure3 = analyticsInfo.getExposure();
        if (exposure2 != null ? !exposure2.equals(exposure3) : exposure3 != null) {
            return false;
        }
        AnalyticsClick click2 = getClick();
        AnalyticsClick click3 = analyticsInfo.getClick();
        return click2 != null ? click2.equals(click3) : click3 == null;
    }

    public AnalyticsClick getClick() {
        return this.click;
    }

    public AnalyticsExposure getExposure() {
        return this.exposure;
    }

    public int hashCode() {
        AnalyticsExposure exposure2 = getExposure();
        int i11 = 43;
        int hashCode = exposure2 == null ? 43 : exposure2.hashCode();
        AnalyticsClick click2 = getClick();
        int i12 = (hashCode + 59) * 59;
        if (click2 != null) {
            i11 = click2.hashCode();
        }
        return i12 + i11;
    }

    public void setClick(AnalyticsClick analyticsClick) {
        this.click = analyticsClick;
    }

    public void setExposure(AnalyticsExposure analyticsExposure) {
        this.exposure = analyticsExposure;
    }

    public String toString() {
        return "AnalyticsInfo(exposure=" + getExposure() + ", click=" + getClick() + ")";
    }
}
