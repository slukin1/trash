package com.huobi.finance.bean;

import java.io.Serializable;

public class FiatChannelConfig implements Serializable {
    private String currency;
    private int entrance;
    private String orderCode;
    private int type;

    public boolean canEqual(Object obj) {
        return obj instanceof FiatChannelConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FiatChannelConfig)) {
            return false;
        }
        FiatChannelConfig fiatChannelConfig = (FiatChannelConfig) obj;
        if (!fiatChannelConfig.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = fiatChannelConfig.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        if (getType() != fiatChannelConfig.getType()) {
            return false;
        }
        String orderCode2 = getOrderCode();
        String orderCode3 = fiatChannelConfig.getOrderCode();
        if (orderCode2 != null ? orderCode2.equals(orderCode3) : orderCode3 == null) {
            return getEntrance() == fiatChannelConfig.getEntrance();
        }
        return false;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getEntrance() {
        return this.entrance;
    }

    public String getOrderCode() {
        return this.orderCode;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = (((currency2 == null ? 43 : currency2.hashCode()) + 59) * 59) + getType();
        String orderCode2 = getOrderCode();
        int i12 = hashCode * 59;
        if (orderCode2 != null) {
            i11 = orderCode2.hashCode();
        }
        return ((i12 + i11) * 59) + getEntrance();
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setEntrance(int i11) {
        this.entrance = i11;
    }

    public void setOrderCode(String str) {
        this.orderCode = str;
    }

    public void setType(int i11) {
        this.type = i11;
    }

    public String toString() {
        return "FiatChannelConfig(currency=" + getCurrency() + ", type=" + getType() + ", orderCode=" + getOrderCode() + ", entrance=" + getEntrance() + ")";
    }
}
