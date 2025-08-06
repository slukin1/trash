package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class OtcKycDataInfo implements Serializable {
    public String addressLine1;
    public String postcode;
    public String residenceCity;
    public String residenceCountry;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcKycDataInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcKycDataInfo)) {
            return false;
        }
        OtcKycDataInfo otcKycDataInfo = (OtcKycDataInfo) obj;
        if (!otcKycDataInfo.canEqual(this)) {
            return false;
        }
        String addressLine12 = getAddressLine1();
        String addressLine13 = otcKycDataInfo.getAddressLine1();
        if (addressLine12 != null ? !addressLine12.equals(addressLine13) : addressLine13 != null) {
            return false;
        }
        String postcode2 = getPostcode();
        String postcode3 = otcKycDataInfo.getPostcode();
        if (postcode2 != null ? !postcode2.equals(postcode3) : postcode3 != null) {
            return false;
        }
        String residenceCity2 = getResidenceCity();
        String residenceCity3 = otcKycDataInfo.getResidenceCity();
        if (residenceCity2 != null ? !residenceCity2.equals(residenceCity3) : residenceCity3 != null) {
            return false;
        }
        String residenceCountry2 = getResidenceCountry();
        String residenceCountry3 = otcKycDataInfo.getResidenceCountry();
        return residenceCountry2 != null ? residenceCountry2.equals(residenceCountry3) : residenceCountry3 == null;
    }

    public String getAddressLine1() {
        return this.addressLine1;
    }

    public String getPostcode() {
        return this.postcode;
    }

    public String getResidenceCity() {
        return this.residenceCity;
    }

    public String getResidenceCountry() {
        return this.residenceCountry;
    }

    public int hashCode() {
        String addressLine12 = getAddressLine1();
        int i11 = 43;
        int hashCode = addressLine12 == null ? 43 : addressLine12.hashCode();
        String postcode2 = getPostcode();
        int hashCode2 = ((hashCode + 59) * 59) + (postcode2 == null ? 43 : postcode2.hashCode());
        String residenceCity2 = getResidenceCity();
        int hashCode3 = (hashCode2 * 59) + (residenceCity2 == null ? 43 : residenceCity2.hashCode());
        String residenceCountry2 = getResidenceCountry();
        int i12 = hashCode3 * 59;
        if (residenceCountry2 != null) {
            i11 = residenceCountry2.hashCode();
        }
        return i12 + i11;
    }

    public void setAddressLine1(String str) {
        this.addressLine1 = str;
    }

    public void setPostcode(String str) {
        this.postcode = str;
    }

    public void setResidenceCity(String str) {
        this.residenceCity = str;
    }

    public void setResidenceCountry(String str) {
        this.residenceCountry = str;
    }

    public String toString() {
        return "OtcKycDataInfo(addressLine1=" + getAddressLine1() + ", postcode=" + getPostcode() + ", residenceCity=" + getResidenceCity() + ", residenceCountry=" + getResidenceCountry() + ")";
    }
}
