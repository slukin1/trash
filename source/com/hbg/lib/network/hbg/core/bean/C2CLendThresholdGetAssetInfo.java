package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class C2CLendThresholdGetAssetInfo implements Serializable {
    private String currency;
    private String lendedAmount;
    private String lendedUnRepayAmount;
    private String maxLendAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof C2CLendThresholdGetAssetInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2CLendThresholdGetAssetInfo)) {
            return false;
        }
        C2CLendThresholdGetAssetInfo c2CLendThresholdGetAssetInfo = (C2CLendThresholdGetAssetInfo) obj;
        if (!c2CLendThresholdGetAssetInfo.canEqual(this)) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = c2CLendThresholdGetAssetInfo.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String maxLendAmount2 = getMaxLendAmount();
        String maxLendAmount3 = c2CLendThresholdGetAssetInfo.getMaxLendAmount();
        if (maxLendAmount2 != null ? !maxLendAmount2.equals(maxLendAmount3) : maxLendAmount3 != null) {
            return false;
        }
        String lendedAmount2 = getLendedAmount();
        String lendedAmount3 = c2CLendThresholdGetAssetInfo.getLendedAmount();
        if (lendedAmount2 != null ? !lendedAmount2.equals(lendedAmount3) : lendedAmount3 != null) {
            return false;
        }
        String lendedUnRepayAmount2 = getLendedUnRepayAmount();
        String lendedUnRepayAmount3 = c2CLendThresholdGetAssetInfo.getLendedUnRepayAmount();
        return lendedUnRepayAmount2 != null ? lendedUnRepayAmount2.equals(lendedUnRepayAmount3) : lendedUnRepayAmount3 == null;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getLendedAmount() {
        return this.lendedAmount;
    }

    public String getLendedUnRepayAmount() {
        return this.lendedUnRepayAmount;
    }

    public String getMaxLendAmount() {
        return this.maxLendAmount;
    }

    public int hashCode() {
        String currency2 = getCurrency();
        int i11 = 43;
        int hashCode = currency2 == null ? 43 : currency2.hashCode();
        String maxLendAmount2 = getMaxLendAmount();
        int hashCode2 = ((hashCode + 59) * 59) + (maxLendAmount2 == null ? 43 : maxLendAmount2.hashCode());
        String lendedAmount2 = getLendedAmount();
        int hashCode3 = (hashCode2 * 59) + (lendedAmount2 == null ? 43 : lendedAmount2.hashCode());
        String lendedUnRepayAmount2 = getLendedUnRepayAmount();
        int i12 = hashCode3 * 59;
        if (lendedUnRepayAmount2 != null) {
            i11 = lendedUnRepayAmount2.hashCode();
        }
        return i12 + i11;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setLendedAmount(String str) {
        this.lendedAmount = str;
    }

    public void setLendedUnRepayAmount(String str) {
        this.lendedUnRepayAmount = str;
    }

    public void setMaxLendAmount(String str) {
        this.maxLendAmount = str;
    }

    public String toString() {
        return "C2CLendThresholdGetAssetInfo(currency=" + getCurrency() + ", maxLendAmount=" + getMaxLendAmount() + ", lendedAmount=" + getLendedAmount() + ", lendedUnRepayAmount=" + getLendedUnRepayAmount() + ")";
    }
}
