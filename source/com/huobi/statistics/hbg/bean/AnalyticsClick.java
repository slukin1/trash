package com.huobi.statistics.hbg.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class AnalyticsClick implements Serializable {
    private static final long serialVersionUID = 6832451545785798312L;
    @SerializedName("list")
    private List<AnalyticsClickItem> clickList;

    public boolean canEqual(Object obj) {
        return obj instanceof AnalyticsClick;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AnalyticsClick)) {
            return false;
        }
        AnalyticsClick analyticsClick = (AnalyticsClick) obj;
        if (!analyticsClick.canEqual(this)) {
            return false;
        }
        List<AnalyticsClickItem> clickList2 = getClickList();
        List<AnalyticsClickItem> clickList3 = analyticsClick.getClickList();
        return clickList2 != null ? clickList2.equals(clickList3) : clickList3 == null;
    }

    public List<AnalyticsClickItem> getClickList() {
        return this.clickList;
    }

    public int hashCode() {
        List<AnalyticsClickItem> clickList2 = getClickList();
        return 59 + (clickList2 == null ? 43 : clickList2.hashCode());
    }

    public void setClickList(List<AnalyticsClickItem> list) {
        this.clickList = list;
    }

    public String toString() {
        return "AnalyticsClick(clickList=" + getClickList() + ")";
    }
}
