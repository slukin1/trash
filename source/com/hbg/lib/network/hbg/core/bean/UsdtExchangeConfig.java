package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class UsdtExchangeConfig implements Serializable {
    private int clearUser;
    private String currency = "btc";
    private String feeRate = "0.02";
    private int tag = 0;
    private String totalAmount = "0.001";

    public boolean canEqual(Object obj) {
        return obj instanceof UsdtExchangeConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UsdtExchangeConfig)) {
            return false;
        }
        UsdtExchangeConfig usdtExchangeConfig = (UsdtExchangeConfig) obj;
        if (!usdtExchangeConfig.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = usdtExchangeConfig.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        if (getTag() != usdtExchangeConfig.getTag()) {
            return false;
        }
        String feeRate2 = getFeeRate();
        String feeRate3 = usdtExchangeConfig.getFeeRate();
        if (feeRate2 != null ? !feeRate2.equals(feeRate3) : feeRate3 != null) {
            return false;
        }
        String totalAmount2 = getTotalAmount();
        String totalAmount3 = usdtExchangeConfig.getTotalAmount();
        if (totalAmount2 != null ? totalAmount2.equals(totalAmount3) : totalAmount3 == null) {
            return getClearUser() == usdtExchangeConfig.getClearUser();
        }
        return false;
    }

    public int getClearUser() {
        return this.clearUser;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getFeeRate() {
        return this.feeRate;
    }

    public int getTag() {
        return this.tag;
    }

    public String getTotalAmount() {
        return this.totalAmount;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = (((currency2 == null ? 43 : currency2.hashCode()) + 59) * 59) + getTag();
        String feeRate2 = getFeeRate();
        int hashCode2 = (hashCode * 59) + (feeRate2 == null ? 43 : feeRate2.hashCode());
        String totalAmount2 = getTotalAmount();
        int i12 = hashCode2 * 59;
        if (totalAmount2 != null) {
            i11 = totalAmount2.hashCode();
        }
        return ((i12 + i11) * 59) + getClearUser();
    }

    public boolean isClearedUser() {
        return this.clearUser == 1;
    }

    public void setClearUser(int i11) {
        this.clearUser = i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setFeeRate(String str) {
        this.feeRate = str;
    }

    public void setTag(int i11) {
        this.tag = i11;
    }

    public void setTotalAmount(String str) {
        this.totalAmount = str;
    }

    public String toString() {
        return "UsdtExchangeConfig(currency=" + getCurrency() + ", tag=" + getTag() + ", feeRate=" + getFeeRate() + ", totalAmount=" + getTotalAmount() + ", clearUser=" + getClearUser() + ")";
    }
}
