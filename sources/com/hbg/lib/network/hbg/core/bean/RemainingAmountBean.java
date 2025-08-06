package com.hbg.lib.network.hbg.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RemainingAmountBean implements Serializable {
    @SerializedName("currency")
    private String currency;
    @SerializedName("remainingAmount")
    private String remainingAmount;
    @SerializedName("totalAmount")
    private String totalAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof RemainingAmountBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemainingAmountBean)) {
            return false;
        }
        RemainingAmountBean remainingAmountBean = (RemainingAmountBean) obj;
        if (!remainingAmountBean.canEqual(this)) {
            return false;
        }
        String remainingAmount2 = getRemainingAmount();
        String remainingAmount3 = remainingAmountBean.getRemainingAmount();
        if (remainingAmount2 != null ? !remainingAmount2.equals(remainingAmount3) : remainingAmount3 != null) {
            return false;
        }
        String totalAmount2 = getTotalAmount();
        String totalAmount3 = remainingAmountBean.getTotalAmount();
        if (totalAmount2 != null ? !totalAmount2.equals(totalAmount3) : totalAmount3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = remainingAmountBean.getCurrency();
        return currency2 != null ? currency2.equals(currency3) : currency3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getRemainingAmount() {
        return this.remainingAmount;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public int hashCode() {
        String remainingAmount2 = getRemainingAmount();
        int i11 = 43;
        int hashCode = remainingAmount2 == null ? 43 : remainingAmount2.hashCode();
        String totalAmount2 = getTotalAmount();
        int hashCode2 = ((hashCode + 59) * 59) + (totalAmount2 == null ? 43 : totalAmount2.hashCode());
        String currency2 = getCurrency();
        int i12 = hashCode2 * 59;
        if (currency2 != null) {
            i11 = currency2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setRemainingAmount(String str) {
        this.remainingAmount = str;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public String toString() {
        return "RemainingAmountBean(remainingAmount=" + getRemainingAmount() + ", totalAmount=" + getTotalAmount() + ", currency=" + getCurrency() + ")";
    }
}
