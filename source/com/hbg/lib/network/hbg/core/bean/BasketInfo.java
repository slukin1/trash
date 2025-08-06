package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class BasketInfo implements Serializable {
    private static final long serialVersionUID = 4356261782140266093L;
    private String amount;
    private String currency;

    public boolean canEqual(Object obj) {
        return obj instanceof BasketInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BasketInfo)) {
            return false;
        }
        BasketInfo basketInfo = (BasketInfo) obj;
        if (!basketInfo.canEqual(this)) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = basketInfo.getAmount();
        if (amount2 != null ? !amount2.equals(amount3) : amount3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = basketInfo.getCurrency();
        return currency2 != null ? currency2.equals(currency3) : currency3 == null;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int hashCode() {
        String amount2 = getAmount();
        int i11 = 43;
        int hashCode = amount2 == null ? 43 : amount2.hashCode();
        String currency2 = getCurrency();
        int i12 = (hashCode + 59) * 59;
        if (currency2 != null) {
            i11 = currency2.hashCode();
        }
        return i12 + i11;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String toString() {
        return "BasketInfo(amount=" + getAmount() + ", currency=" + getCurrency() + ")";
    }
}
