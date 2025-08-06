package com.huobi.strategy.bean;

import java.io.Serializable;

public class StrategyDetailConfig implements Serializable {
    private String orderId;

    public boolean canEqual(Object obj) {
        return obj instanceof StrategyDetailConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StrategyDetailConfig)) {
            return false;
        }
        StrategyDetailConfig strategyDetailConfig = (StrategyDetailConfig) obj;
        if (!strategyDetailConfig.canEqual(this)) {
            return false;
        }
        String orderId2 = getOrderId();
        String orderId3 = strategyDetailConfig.getOrderId();
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
        return "StrategyDetailConfig(orderId=" + getOrderId() + ")";
    }
}
