package com.hbg.lib.network.linear.swap.core.bean;

import java.io.Serializable;

public class LinearSwapBondAdjustResult implements Serializable {
    private String clientOrderId;
    private String orderId;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapBondAdjustResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapBondAdjustResult)) {
            return false;
        }
        LinearSwapBondAdjustResult linearSwapBondAdjustResult = (LinearSwapBondAdjustResult) obj;
        if (!linearSwapBondAdjustResult.canEqual(this)) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = linearSwapBondAdjustResult.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        String clientOrderId2 = getClientOrderId();
        String clientOrderId3 = linearSwapBondAdjustResult.getClientOrderId();
        return clientOrderId2 != null ? clientOrderId2.equals(clientOrderId3) : clientOrderId3 == null;
    }

    public String getClientOrderId() {
        return this.clientOrderId;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public int hashCode() {
        String orderId2 = getOrderId();
        int i11 = 43;
        int hashCode = orderId2 == null ? 43 : orderId2.hashCode();
        String clientOrderId2 = getClientOrderId();
        int i12 = (hashCode + 59) * 59;
        if (clientOrderId2 != null) {
            i11 = clientOrderId2.hashCode();
        }
        return i12 + i11;
    }

    public void setClientOrderId(String str) {
        this.clientOrderId = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String toString() {
        return "LinearSwapBondAdjustResult{orderId='" + this.orderId + '\'' + ", clientOrderId='" + this.clientOrderId + '\'' + '}';
    }
}
