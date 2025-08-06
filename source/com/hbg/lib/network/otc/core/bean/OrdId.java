package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OrdId implements Serializable {
    public String acceptOrder;
    public String orderId;

    public boolean canEqual(Object obj) {
        return obj instanceof OrdId;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrdId)) {
            return false;
        }
        OrdId ordId = (OrdId) obj;
        if (!ordId.canEqual(this)) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = ordId.getOrderId();
        if (orderId2 != null ? !orderId2.equals(orderId3) : orderId3 != null) {
            return false;
        }
        String acceptOrder2 = getAcceptOrder();
        String acceptOrder3 = ordId.getAcceptOrder();
        return acceptOrder2 != null ? acceptOrder2.equals(acceptOrder3) : acceptOrder3 == null;
    }

    public String getAcceptOrder() {
        return this.acceptOrder;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public int hashCode() {
        String orderId2 = getOrderId();
        int i11 = 43;
        int hashCode = orderId2 == null ? 43 : orderId2.hashCode();
        String acceptOrder2 = getAcceptOrder();
        int i12 = (hashCode + 59) * 59;
        if (acceptOrder2 != null) {
            i11 = acceptOrder2.hashCode();
        }
        return i12 + i11;
    }

    public void setAcceptOrder(String str) {
        this.acceptOrder = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String toString() {
        return "OrdId(orderId=" + getOrderId() + ", acceptOrder=" + getAcceptOrder() + ")";
    }
}
