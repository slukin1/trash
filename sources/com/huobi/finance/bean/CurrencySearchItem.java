package com.huobi.finance.bean;

import java.io.Serializable;

public class CurrencySearchItem implements Serializable {
    private static final long serialVersionUID = -743560086676900383L;
    private String currency;
    private boolean depositEnabled;
    private String fullName;
    private boolean withdrawEnable;

    public boolean canEqual(Object obj) {
        return obj instanceof CurrencySearchItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencySearchItem)) {
            return false;
        }
        CurrencySearchItem currencySearchItem = (CurrencySearchItem) obj;
        if (!currencySearchItem.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = currencySearchItem.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        if (isDepositEnabled() != currencySearchItem.isDepositEnabled() || isWithdrawEnable() != currencySearchItem.isWithdrawEnable()) {
            return false;
        }
        String fullName2 = getFullName();
        String fullName3 = currencySearchItem.getFullName();
        return fullName2 != null ? fullName2.equals(fullName3) : fullName3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int i12 = 79;
        int hashCode = ((((currency2 == null ? 43 : currency2.hashCode()) + 59) * 59) + (isDepositEnabled() ? 79 : 97)) * 59;
        if (!isWithdrawEnable()) {
            i12 = 97;
        }
        String fullName2 = getFullName();
        int i13 = (hashCode + i12) * 59;
        if (fullName2 != null) {
            i11 = fullName2.hashCode();
        }
        return i13 + i11;
    }

    public boolean isDepositEnabled() {
        return this.depositEnabled;
    }

    public boolean isWithdrawEnable() {
        return this.withdrawEnable;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setDepositEnabled(boolean z11) {
        this.depositEnabled = z11;
    }

    public void setFullName(String str) {
        this.fullName = str;
    }

    public void setWithdrawEnable(boolean z11) {
        this.withdrawEnable = z11;
    }

    public String toString() {
        return "CurrencySearchItem(currency=" + getCurrency() + ", depositEnabled=" + isDepositEnabled() + ", withdrawEnable=" + isWithdrawEnable() + ", fullName=" + getFullName() + ")";
    }
}
