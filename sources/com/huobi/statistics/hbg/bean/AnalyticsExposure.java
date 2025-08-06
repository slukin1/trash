package com.huobi.statistics.hbg.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class AnalyticsExposure implements Serializable {
    private static final long serialVersionUID = -6674862115680812486L;
    @SerializedName("list")
    private List<AnalyticsExposureItem> exposureList;

    public boolean canEqual(Object obj) {
        return obj instanceof AnalyticsExposure;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AnalyticsExposure)) {
            return false;
        }
        AnalyticsExposure analyticsExposure = (AnalyticsExposure) obj;
        if (!analyticsExposure.canEqual(this)) {
            return false;
        }
        List<AnalyticsExposureItem> exposureList2 = getExposureList();
        List<AnalyticsExposureItem> exposureList3 = analyticsExposure.getExposureList();
        return exposureList2 != null ? exposureList2.equals(exposureList3) : exposureList3 == null;
    }

    public List<AnalyticsExposureItem> getExposureList() {
        return this.exposureList;
    }

    public int hashCode() {
        List<AnalyticsExposureItem> exposureList2 = getExposureList();
        return 59 + (exposureList2 == null ? 43 : exposureList2.hashCode());
    }

    public void setExposureList(List<AnalyticsExposureItem> list) {
        this.exposureList = list;
    }

    public String toString() {
        return "AnalyticsExposure(exposureList=" + getExposureList() + ")";
    }
}
