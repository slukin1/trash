package com.huobi.contract.entity;

import java.io.Serializable;

public class ContractProBalanceInfo implements Serializable {
    private static final long serialVersionUID = -2759048871546134381L;
    private String balance;
    private String currency;
    private String state;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractProBalanceInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractProBalanceInfo)) {
            return false;
        }
        ContractProBalanceInfo contractProBalanceInfo = (ContractProBalanceInfo) obj;
        if (!contractProBalanceInfo.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = contractProBalanceInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String balance2 = getBalance();
        String balance3 = contractProBalanceInfo.getBalance();
        if (balance2 != null ? !balance2.equals(balance3) : balance3 != null) {
            return false;
        }
        String state2 = getState();
        String state3 = contractProBalanceInfo.getState();
        return state2 != null ? state2.equals(state3) : state3 == null;
    }

    public String getBalance() {
        return this.balance;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getState() {
        return this.state;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String balance2 = getBalance();
        int hashCode2 = ((hashCode + 59) * 59) + (balance2 == null ? 43 : balance2.hashCode());
        String state2 = getState();
        int i12 = hashCode2 * 59;
        if (state2 != null) {
            i11 = state2.hashCode();
        }
        return i12 + i11;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String toString() {
        return "ContractProBalanceInfo(currency=" + getCurrency() + ", balance=" + getBalance() + ", state=" + getState() + ")";
    }
}
