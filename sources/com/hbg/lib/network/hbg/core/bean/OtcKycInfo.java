package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class OtcKycInfo implements Serializable {
    public String kycData;
    public String uId;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcKycInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcKycInfo)) {
            return false;
        }
        OtcKycInfo otcKycInfo = (OtcKycInfo) obj;
        if (!otcKycInfo.canEqual(this)) {
            return false;
        }
        String uId2 = getUId();
        String uId3 = otcKycInfo.getUId();
        if (uId2 != null ? !uId2.equals(uId3) : uId3 != null) {
            return false;
        }
        String kycData2 = getKycData();
        String kycData3 = otcKycInfo.getKycData();
        return kycData2 != null ? kycData2.equals(kycData3) : kycData3 == null;
    }

    public String getKycData() {
        return this.kycData;
    }

    public String getUId() {
        return this.uId;
    }

    public int hashCode() {
        String uId2 = getUId();
        int i11 = 43;
        int hashCode = uId2 == null ? 43 : uId2.hashCode();
        String kycData2 = getKycData();
        int i12 = (hashCode + 59) * 59;
        if (kycData2 != null) {
            i11 = kycData2.hashCode();
        }
        return i12 + i11;
    }

    public void setKycData(String str) {
        this.kycData = str;
    }

    public void setUId(String str) {
        this.uId = str;
    }

    public String toString() {
        return "OtcKycInfo(uId=" + getUId() + ", kycData=" + getKycData() + ")";
    }
}
