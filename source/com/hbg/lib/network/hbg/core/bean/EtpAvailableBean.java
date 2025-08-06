package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class EtpAvailableBean implements Serializable {
    private String coefficient;
    private String currency;
    private String remainingAmount;
    private String totalAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof EtpAvailableBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EtpAvailableBean)) {
            return false;
        }
        EtpAvailableBean etpAvailableBean = (EtpAvailableBean) obj;
        if (!etpAvailableBean.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = etpAvailableBean.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String coefficient2 = getCoefficient();
        String coefficient3 = etpAvailableBean.getCoefficient();
        if (coefficient2 != null ? !coefficient2.equals(coefficient3) : coefficient3 != null) {
            return false;
        }
        String remainingAmount2 = getRemainingAmount();
        String remainingAmount3 = etpAvailableBean.getRemainingAmount();
        if (remainingAmount2 != null ? !remainingAmount2.equals(remainingAmount3) : remainingAmount3 != null) {
            return false;
        }
        String totalAmount2 = getTotalAmount();
        String totalAmount3 = etpAvailableBean.getTotalAmount();
        return totalAmount2 != null ? totalAmount2.equals(totalAmount3) : totalAmount3 == null;
    }

    public String getCoefficient() {
        return this.coefficient;
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
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String coefficient2 = getCoefficient();
        int hashCode2 = ((hashCode + 59) * 59) + (coefficient2 == null ? 43 : coefficient2.hashCode());
        String remainingAmount2 = getRemainingAmount();
        int hashCode3 = (hashCode2 * 59) + (remainingAmount2 == null ? 43 : remainingAmount2.hashCode());
        String totalAmount2 = getTotalAmount();
        int i12 = hashCode3 * 59;
        if (totalAmount2 != null) {
            i11 = totalAmount2.hashCode();
        }
        return i12 + i11;
    }

    public void setCoefficient(String str) {
        this.coefficient = str;
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
        return "EtpAvailableBean(currency=" + getCurrency() + ", coefficient=" + getCoefficient() + ", remainingAmount=" + getRemainingAmount() + ", totalAmount=" + getTotalAmount() + ")";
    }
}
