package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class UnreadCountData implements Serializable {
    private int activityCount;
    private int systemCount;

    public boolean canEqual(Object obj) {
        return obj instanceof UnreadCountData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UnreadCountData)) {
            return false;
        }
        UnreadCountData unreadCountData = (UnreadCountData) obj;
        return unreadCountData.canEqual(this) && getActivityCount() == unreadCountData.getActivityCount() && getSystemCount() == unreadCountData.getSystemCount();
    }

    public int getActivityCount() {
        return this.activityCount;
    }

    public int getSystemCount() {
        return this.systemCount;
    }

    public int hashCode() {
        return ((getActivityCount() + 59) * 59) + getSystemCount();
    }

    public void setActivityCount(int i11) {
        this.activityCount = i11;
    }

    public void setSystemCount(int i11) {
        this.systemCount = i11;
    }

    public String toString() {
        return "UnreadCountData(activityCount=" + getActivityCount() + ", systemCount=" + getSystemCount() + ")";
    }
}
