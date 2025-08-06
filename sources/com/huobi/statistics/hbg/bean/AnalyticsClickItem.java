package com.huobi.statistics.hbg.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AnalyticsClickItem implements Serializable {
    private static final long serialVersionUID = -8795995625960201824L;
    @SerializedName("event_id")
    private String eventId;
    @SerializedName("page_id")
    private String pageId;

    public boolean canEqual(Object obj) {
        return obj instanceof AnalyticsClickItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AnalyticsClickItem)) {
            return false;
        }
        AnalyticsClickItem analyticsClickItem = (AnalyticsClickItem) obj;
        if (!analyticsClickItem.canEqual(this)) {
            return false;
        }
        String pageId2 = getPageId();
        String pageId3 = analyticsClickItem.getPageId();
        if (pageId2 != null ? !pageId2.equals(pageId3) : pageId3 != null) {
            return false;
        }
        String eventId2 = getEventId();
        String eventId3 = analyticsClickItem.getEventId();
        return eventId2 != null ? eventId2.equals(eventId3) : eventId3 == null;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getPageId() {
        return this.pageId;
    }

    public int hashCode() {
        String pageId2 = getPageId();
        int i11 = 43;
        int hashCode = pageId2 == null ? 43 : pageId2.hashCode();
        String eventId2 = getEventId();
        int i12 = (hashCode + 59) * 59;
        if (eventId2 != null) {
            i11 = eventId2.hashCode();
        }
        return i12 + i11;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setPageId(String str) {
        this.pageId = str;
    }

    public String toString() {
        return "AnalyticsClickItem(pageId=" + getPageId() + ", eventId=" + getEventId() + ")";
    }
}
