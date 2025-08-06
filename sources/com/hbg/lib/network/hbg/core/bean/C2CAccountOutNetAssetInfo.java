package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class C2CAccountOutNetAssetInfo implements Serializable {
    private String balance;
    private String currency;
    private String type;

    public boolean canEqual(Object obj) {
        return obj instanceof C2CAccountOutNetAssetInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2CAccountOutNetAssetInfo)) {
            return false;
        }
        C2CAccountOutNetAssetInfo c2CAccountOutNetAssetInfo = (C2CAccountOutNetAssetInfo) obj;
        if (!c2CAccountOutNetAssetInfo.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = c2CAccountOutNetAssetInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String type2 = getType();
        String type3 = c2CAccountOutNetAssetInfo.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        String balance2 = getBalance();
        String balance3 = c2CAccountOutNetAssetInfo.getBalance();
        return balance2 != null ? balance2.equals(balance3) : balance3 == null;
    }

    public String getBalance() {
        return this.balance;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String type2 = getType();
        int hashCode2 = ((hashCode + 59) * 59) + (type2 == null ? 43 : type2.hashCode());
        String balance2 = getBalance();
        int i12 = hashCode2 * 59;
        if (balance2 != null) {
            i11 = balance2.hashCode();
        }
        return i12 + i11;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "C2CAccountOutNetAssetInfo(currency=" + getCurrency() + ", type=" + getType() + ", balance=" + getBalance() + ")";
    }
}
