package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OptionLightningClosePositionResult implements Serializable {
    private static final long serialVersionUID = -8723262099154134122L;
    @SerializedName("client_order_id")
    private int clientOrderId;
    @SerializedName("order_id")
    private long orderId;
    @SerializedName("order_id_str")
    private String orderIdStr;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionLightningClosePositionResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionLightningClosePositionResult)) {
            return false;
        }
        OptionLightningClosePositionResult optionLightningClosePositionResult = (OptionLightningClosePositionResult) obj;
        if (!optionLightningClosePositionResult.canEqual(this) || getOrderId() != optionLightningClosePositionResult.getOrderId()) {
            return false;
        }
        String orderIdStr2 = getOrderIdStr();
        String orderIdStr3 = optionLightningClosePositionResult.getOrderIdStr();
        if (orderIdStr2 != null ? orderIdStr2.equals(orderIdStr3) : orderIdStr3 == null) {
            return getClientOrderId() == optionLightningClosePositionResult.getClientOrderId();
        }
        return false;
    }

    public int getClientOrderId() {
        return this.clientOrderId;
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
        return ((((((int) (orderId2 ^ (orderId2 >>> 32))) + 59) * 59) + (orderIdStr2 == null ? 43 : orderIdStr2.hashCode())) * 59) + getClientOrderId();
    }

    public void setClientOrderId(int i11) {
        this.clientOrderId = i11;
    }

    public void setOrderId(long j11) {
        this.orderId = j11;
    }

    public void setOrderIdStr(String str) {
        this.orderIdStr = str;
    }

    public String toString() {
        return "OptionLightningClosePositionResult(orderId=" + getOrderId() + ", orderIdStr=" + getOrderIdStr() + ", clientOrderId=" + getClientOrderId() + ")";
    }
}
