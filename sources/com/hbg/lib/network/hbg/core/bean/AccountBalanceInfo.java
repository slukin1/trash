package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class AccountBalanceInfo implements Serializable {
    private static final long serialVersionUID = 6370763075588824921L;
    private String accountBalance;

    public boolean canEqual(Object obj) {
        return obj instanceof AccountBalanceInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountBalanceInfo)) {
            return false;
        }
        AccountBalanceInfo accountBalanceInfo = (AccountBalanceInfo) obj;
        if (!accountBalanceInfo.canEqual(this)) {
            return false;
        }
        String accountBalance2 = getAccountBalance();
        String accountBalance3 = accountBalanceInfo.getAccountBalance();
        return accountBalance2 != null ? accountBalance2.equals(accountBalance3) : accountBalance3 == null;
    }

    public String getAccountBalance() {
        return this.accountBalance;
    }

    public int hashCode() {
        String accountBalance2 = getAccountBalance();
        return 59 + (accountBalance2 == null ? 43 : accountBalance2.hashCode());
    }

    public void setAccountBalance(String str) {
        this.accountBalance = str;
    }

    public String toString() {
        return "AccountBalanceInfo(accountBalance=" + getAccountBalance() + ")";
    }
}
