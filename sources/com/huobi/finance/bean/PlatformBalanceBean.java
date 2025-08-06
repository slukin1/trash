package com.huobi.finance.bean;

import java.io.Serializable;

public class PlatformBalanceBean implements Serializable {
    private String currency;
    private int loan;

    public boolean canEqual(Object obj) {
        return obj instanceof PlatformBalanceBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlatformBalanceBean)) {
            return false;
        }
        PlatformBalanceBean platformBalanceBean = (PlatformBalanceBean) obj;
        if (!platformBalanceBean.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = platformBalanceBean.getCurrency();
        if (currency2 != null ? currency2.equals(currency3) : currency3 == null) {
            return getLoan() == platformBalanceBean.getLoan();
        }
        return false;
    }

    public String getCurrency() {
        return this.currency;
    }

    public int getLoan() {
        return this.loan;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        return (((currency2 == null ? 43 : currency2.hashCode()) + 59) * 59) + getLoan();
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setLoan(int i11) {
        this.loan = i11;
    }

    public String toString() {
        return "PlatformBalanceBean(currency=" + getCurrency() + ", loan=" + getLoan() + ")";
    }
}
