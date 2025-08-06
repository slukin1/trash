package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OrderCreateBean implements Serializable {
    private String orderId;

    public boolean canEqual(Object obj) {
        return obj instanceof OrderCreateBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderCreateBean)) {
            return false;
        }
        OrderCreateBean orderCreateBean = (OrderCreateBean) obj;
        if (!orderCreateBean.canEqual(this)) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = orderCreateBean.getOrderId();
        return orderId2 != null ? orderId2.equals(orderId3) : orderId3 == null;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public int hashCode() {
        String orderId2 = getOrderId();
        return 59 + (orderId2 == null ? 43 : orderId2.hashCode());
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String toString() {
        return "OrderCreateBean(orderId=" + getOrderId() + ")";
    }
}
