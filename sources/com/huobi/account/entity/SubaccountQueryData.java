package com.huobi.account.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SubaccountQueryData implements Serializable {
    public static final String TYPE_TRADE = "trade";
    private static final long serialVersionUID = 6551166704374584865L;
    private String available;
    private String balance;
    private String currency;
    @SerializedName("max-balance")
    private String maxBalance;
    private String suspense;
    private String type;

    public boolean canEqual(Object obj) {
        return obj instanceof SubaccountQueryData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SubaccountQueryData)) {
            return false;
        }
        SubaccountQueryData subaccountQueryData = (SubaccountQueryData) obj;
        if (!subaccountQueryData.canEqual(this)) {
            return false;
        }
        String balance2 = getBalance();
        String balance3 = subaccountQueryData.getBalance();
        if (balance2 != null ? !balance2.equals(balance3) : balance3 != null) {
            return false;
        }
        String available2 = getAvailable();
        String available3 = subaccountQueryData.getAvailable();
        if (available2 != null ? !available2.equals(available3) : available3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = subaccountQueryData.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String suspense2 = getSuspense();
        String suspense3 = subaccountQueryData.getSuspense();
        if (suspense2 != null ? !suspense2.equals(suspense3) : suspense3 != null) {
            return false;
        }
        String type2 = getType();
        String type3 = subaccountQueryData.getType();
        if (type2 != null ? !type2.equals(type3) : type3 != null) {
            return false;
        }
        String maxBalance2 = getMaxBalance();
        String maxBalance3 = subaccountQueryData.getMaxBalance();
        return maxBalance2 != null ? maxBalance2.equals(maxBalance3) : maxBalance3 == null;
    }

    public String getAvailable() {
        return this.available;
    }

    public String getBalance() {
        return this.balance;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getMaxBalance() {
        return this.maxBalance;
    }

    public String getSuspense() {
        return this.suspense;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        String balance2 = getBalance();
        int i11 = 43;
        int hashCode = balance2 == null ? 43 : balance2.hashCode();
        String available2 = getAvailable();
        int hashCode2 = ((hashCode + 59) * 59) + (available2 == null ? 43 : available2.hashCode());
        String currency2 = getCurrency();
        int hashCode3 = (hashCode2 * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String suspense2 = getSuspense();
        int hashCode4 = (hashCode3 * 59) + (suspense2 == null ? 43 : suspense2.hashCode());
        String type2 = getType();
        int hashCode5 = (hashCode4 * 59) + (type2 == null ? 43 : type2.hashCode());
        String maxBalance2 = getMaxBalance();
        int i12 = hashCode5 * 59;
        if (maxBalance2 != null) {
            i11 = maxBalance2.hashCode();
        }
        return i12 + i11;
    }

    public void setAvailable(String str) {
        this.available = str;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setMaxBalance(String str) {
        this.maxBalance = str;
    }

    public void setSuspense(String str) {
        this.suspense = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        return "SubaccountQueryData(balance=" + getBalance() + ", available=" + getAvailable() + ", currency=" + getCurrency() + ", suspense=" + getSuspense() + ", type=" + getType() + ", maxBalance=" + getMaxBalance() + ")";
    }
}
