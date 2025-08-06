package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearOrderInsertRspInfo implements Serializable {
    @SerializedName("order_id")
    private long orderId;
    @SerializedName("order_id_str")
    private String orderIdStr;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearOrderInsertRspInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearOrderInsertRspInfo)) {
            return false;
        }
        LinearOrderInsertRspInfo linearOrderInsertRspInfo = (LinearOrderInsertRspInfo) obj;
        if (!linearOrderInsertRspInfo.canEqual(this) || getOrderId() != linearOrderInsertRspInfo.getOrderId()) {
            return false;
        }
        String orderIdStr2 = getOrderIdStr();
        String orderIdStr3 = linearOrderInsertRspInfo.getOrderIdStr();
        return orderIdStr2 != null ? orderIdStr2.equals(orderIdStr3) : orderIdStr3 == null;
    }

    public long getOrderId() {
        return this.orderId;
    }

    public String getOrderIdStr() {
        return this.orderIdStr;
    }

    public int hashCode() {
        long orderId2 = getOrderId();
        String orderIdStr2 = getOrderIdStr();
        return ((((int) (orderId2 ^ (orderId2 >>> 32))) + 59) * 59) + (orderIdStr2 == null ? 43 : orderIdStr2.hashCode());
    }

    public void setOrderId(long j11) {
        this.orderId = j11;
    }

    public void setOrderIdStr(String str) {
        this.orderIdStr = str;
    }

    public String toString() {
        return "LinearOrderInsertRspInfo(orderId=" + getOrderId() + ", orderIdStr=" + getOrderIdStr() + ")";
    }
}
