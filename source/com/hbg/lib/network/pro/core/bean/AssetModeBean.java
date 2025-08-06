package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;

public class AssetModeBean implements Serializable {
    public Boolean isSuccess;
    public Boolean isUnion;

    public AssetModeBean(Boolean bool, Boolean bool2) {
        this.isUnion = bool;
        this.isSuccess = bool2;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof AssetModeBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AssetModeBean)) {
            return false;
        }
        AssetModeBean assetModeBean = (AssetModeBean) obj;
        if (!assetModeBean.canEqual(this)) {
            return false;
        }
        Boolean isUnion2 = getIsUnion();
        Boolean isUnion3 = assetModeBean.getIsUnion();
        if (isUnion2 != null ? !isUnion2.equals(isUnion3) : isUnion3 != null) {
            return false;
        }
        Boolean isSuccess2 = getIsSuccess();
        Boolean isSuccess3 = assetModeBean.getIsSuccess();
        return isSuccess2 != null ? isSuccess2.equals(isSuccess3) : isSuccess3 == null;
    }

    public Boolean getIsSuccess() {
        return this.isSuccess;
    }

    public Boolean getIsUnion() {
        return this.isUnion;
    }

    public int hashCode() {
        Boolean isUnion2 = getIsUnion();
        int i11 = 43;
        int hashCode = isUnion2 == null ? 43 : isUnion2.hashCode();
        Boolean isSuccess2 = getIsSuccess();
        int i12 = (hashCode + 59) * 59;
        if (isSuccess2 != null) {
            i11 = isSuccess2.hashCode();
        }
        return i12 + i11;
    }

    public void setIsSuccess(Boolean bool) {
        this.isSuccess = bool;
    }

    public void setIsUnion(Boolean bool) {
        this.isUnion = bool;
    }

    public String toString() {
        return "AssetModeBean(isUnion=" + getIsUnion() + ", isSuccess=" + getIsSuccess() + ")";
    }
}
