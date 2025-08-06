package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class AdvertVerifyCapitalConfigBean implements Serializable {
    private String currency;
    private String orderAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof AdvertVerifyCapitalConfigBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdvertVerifyCapitalConfigBean)) {
            return false;
        }
        AdvertVerifyCapitalConfigBean advertVerifyCapitalConfigBean = (AdvertVerifyCapitalConfigBean) obj;
        if (!advertVerifyCapitalConfigBean.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = advertVerifyCapitalConfigBean.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String orderAmount2 = getOrderAmount();
        String orderAmount3 = advertVerifyCapitalConfigBean.getOrderAmount();
        return orderAmount2 != null ? orderAmount2.equals(orderAmount3) : orderAmount3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getOrderAmount() {
        return this.orderAmount;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String orderAmount2 = getOrderAmount();
        int i12 = (hashCode + 59) * 59;
        if (orderAmount2 != null) {
            i11 = orderAmount2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setOrderAmount(String str) {
        this.orderAmount = str;
    }

    public String toString() {
        return "AdvertVerifyCapitalConfigBean(currency=" + getCurrency() + ", orderAmount=" + getOrderAmount() + ")";
    }
}
