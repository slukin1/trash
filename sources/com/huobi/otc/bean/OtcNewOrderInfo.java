package com.huobi.otc.bean;

import java.io.Serializable;

public class OtcNewOrderInfo implements Serializable {
    private int orderCount;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcNewOrderInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcNewOrderInfo)) {
            return false;
        }
        OtcNewOrderInfo otcNewOrderInfo = (OtcNewOrderInfo) obj;
        return otcNewOrderInfo.canEqual(this) && getOrderCount() == otcNewOrderInfo.getOrderCount();
    }

    public int getOrderCount() {
        return this.orderCount;
    }

    public int hashCode() {
        return 59 + getOrderCount();
    }

    public void setOrderCount(int i11) {
        this.orderCount = i11;
    }

    public String toString() {
        return "OtcNewOrderInfo(orderCount=" + getOrderCount() + ")";
    }
}
