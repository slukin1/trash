package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class UserAssetLimitBean implements Serializable {
    private String maxAmount = "";
    private String maxQuantity = "";
    private String minAmount = "";
    private String minQuantity = "";

    public boolean canEqual(Object obj) {
        return obj instanceof UserAssetLimitBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserAssetLimitBean)) {
            return false;
        }
        UserAssetLimitBean userAssetLimitBean = (UserAssetLimitBean) obj;
        if (!userAssetLimitBean.canEqual(this)) {
            return false;
        }
        String minQuantity2 = getMinQuantity();
        String minQuantity3 = userAssetLimitBean.getMinQuantity();
        if (minQuantity2 != null ? !minQuantity2.equals(minQuantity3) : minQuantity3 != null) {
            return false;
        }
        String maxQuantity2 = getMaxQuantity();
        String maxQuantity3 = userAssetLimitBean.getMaxQuantity();
        if (maxQuantity2 != null ? !maxQuantity2.equals(maxQuantity3) : maxQuantity3 != null) {
            return false;
        }
        String minAmount2 = getMinAmount();
        String minAmount3 = userAssetLimitBean.getMinAmount();
        if (minAmount2 != null ? !minAmount2.equals(minAmount3) : minAmount3 != null) {
            return false;
        }
        String maxAmount2 = getMaxAmount();
        String maxAmount3 = userAssetLimitBean.getMaxAmount();
        return maxAmount2 != null ? maxAmount2.equals(maxAmount3) : maxAmount3 == null;
    }

    public String getMaxAmount() {
        return this.maxAmount;
    }

    public String getMaxQuantity() {
        return this.maxQuantity;
    }

    public String getMinAmount() {
        return this.minAmount;
    }

    public String getMinQuantity() {
        return this.minQuantity;
    }

    public int hashCode() {
        String minQuantity2 = getMinQuantity();
        int i11 = 43;
        int hashCode = minQuantity2 == null ? 43 : minQuantity2.hashCode();
        String maxQuantity2 = getMaxQuantity();
        int hashCode2 = ((hashCode + 59) * 59) + (maxQuantity2 == null ? 43 : maxQuantity2.hashCode());
        String minAmount2 = getMinAmount();
        int hashCode3 = (hashCode2 * 59) + (minAmount2 == null ? 43 : minAmount2.hashCode());
        String maxAmount2 = getMaxAmount();
        int i12 = hashCode3 * 59;
        if (maxAmount2 != null) {
            i11 = maxAmount2.hashCode();
        }
        return i12 + i11;
    }

    public void setMaxAmount(String str) {
        this.maxAmount = str;
    }

    public void setMaxQuantity(String str) {
        this.maxQuantity = str;
    }

    public void setMinAmount(String str) {
        this.minAmount = str;
    }

    public void setMinQuantity(String str) {
        this.minQuantity = str;
    }

    public String toString() {
        return "UserAssetLimitBean(minQuantity=" + getMinQuantity() + ", maxQuantity=" + getMaxQuantity() + ", minAmount=" + getMinAmount() + ", maxAmount=" + getMaxAmount() + ")";
    }
}
