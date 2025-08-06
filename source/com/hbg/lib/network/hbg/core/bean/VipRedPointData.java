package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class VipRedPointData implements Serializable {
    private boolean hasRedPoint;
    private int pointType;

    public boolean canEqual(Object obj) {
        return obj instanceof VipRedPointData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VipRedPointData)) {
            return false;
        }
        VipRedPointData vipRedPointData = (VipRedPointData) obj;
        return vipRedPointData.canEqual(this) && isHasRedPoint() == vipRedPointData.isHasRedPoint() && getPointType() == vipRedPointData.getPointType();
    }

    public int getPointType() {
        return this.pointType;
    }

    public int hashCode() {
        return (((isHasRedPoint() ? 79 : 97) + 59) * 59) + getPointType();
    }

    public boolean isHasRedPoint() {
        return this.hasRedPoint;
    }

    public void setHasRedPoint(boolean z11) {
        this.hasRedPoint = z11;
    }

    public void setPointType(int i11) {
        this.pointType = i11;
    }

    public String toString() {
        return "VipRedPointData(hasRedPoint=" + isHasRedPoint() + ", pointType=" + getPointType() + ")";
    }
}
