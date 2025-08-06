package com.hbg.lib.network.pro.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class MaxOrderAmountBean implements Serializable {
    private String currency;
    @SerializedName("max-order-amount")
    private String maxOrderAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof MaxOrderAmountBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MaxOrderAmountBean)) {
            return false;
        }
        MaxOrderAmountBean maxOrderAmountBean = (MaxOrderAmountBean) obj;
        if (!maxOrderAmountBean.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = maxOrderAmountBean.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String maxOrderAmount2 = getMaxOrderAmount();
        String maxOrderAmount3 = maxOrderAmountBean.getMaxOrderAmount();
        return maxOrderAmount2 != null ? maxOrderAmount2.equals(maxOrderAmount3) : maxOrderAmount3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getMaxOrderAmount() {
        return this.maxOrderAmount;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String maxOrderAmount2 = getMaxOrderAmount();
        int i12 = (hashCode + 59) * 59;
        if (maxOrderAmount2 != null) {
            i11 = maxOrderAmount2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setMaxOrderAmount(String str) {
        this.maxOrderAmount = str;
    }

    public String toString() {
        return "MaxOrderAmountBean(currency=" + getCurrency() + ", maxOrderAmount=" + getMaxOrderAmount() + ")";
    }
}
