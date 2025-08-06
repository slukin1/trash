package com.huobi.account.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OTCKycInfo implements Serializable {
    private static final long serialVersionUID = -5418090044923724178L;
    @SerializedName("authLevel")
    private int authLevel;
    @SerializedName("country")
    private int country;
    @SerializedName("countryName")
    private String countryName;
    @SerializedName("deniedReason")
    private String deniedReason;
    @SerializedName("identityName")
    private String identityName;
    @SerializedName("identityNo")
    private String identityNo;
    @SerializedName("isChange")
    private boolean isChange;
    @SerializedName("status")
    private int status;

    public boolean canEqual(Object obj) {
        return obj instanceof OTCKycInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OTCKycInfo)) {
            return false;
        }
        OTCKycInfo oTCKycInfo = (OTCKycInfo) obj;
        if (!oTCKycInfo.canEqual(this)) {
            return false;
        }
        String identityName2 = getIdentityName();
        String identityName3 = oTCKycInfo.getIdentityName();
        if (identityName2 != null ? !identityName2.equals(identityName3) : identityName3 != null) {
            return false;
        }
        String identityNo2 = getIdentityNo();
        String identityNo3 = oTCKycInfo.getIdentityNo();
        if (identityNo2 != null ? !identityNo2.equals(identityNo3) : identityNo3 != null) {
            return false;
        }
        if (getAuthLevel() != oTCKycInfo.getAuthLevel() || getStatus() != oTCKycInfo.getStatus() || isChange() != oTCKycInfo.isChange()) {
            return false;
        }
        String deniedReason2 = getDeniedReason();
        String deniedReason3 = oTCKycInfo.getDeniedReason();
        if (deniedReason2 != null ? !deniedReason2.equals(deniedReason3) : deniedReason3 != null) {
            return false;
        }
        String countryName2 = getCountryName();
        String countryName3 = oTCKycInfo.getCountryName();
        if (countryName2 != null ? countryName2.equals(countryName3) : countryName3 == null) {
            return getCountry() == oTCKycInfo.getCountry();
        }
        return false;
    }

    public int getAuthLevel() {
        return this.authLevel;
    }

    public int getCountry() {
        return this.country;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public String getDeniedReason() {
        return this.deniedReason;
    }

    public String getIdentityName() {
        return this.identityName;
    }

    public String getIdentityNo() {
        return this.identityNo;
    }

    public int getStatus() {
        return this.status;
    }

    public int hashCode() {
        String identityName2 = getIdentityName();
        int i11 = 43;
        int hashCode = identityName2 == null ? 43 : identityName2.hashCode();
        String identityNo2 = getIdentityNo();
        int hashCode2 = ((((((((hashCode + 59) * 59) + (identityNo2 == null ? 43 : identityNo2.hashCode())) * 59) + getAuthLevel()) * 59) + getStatus()) * 59) + (isChange() ? 79 : 97);
        String deniedReason2 = getDeniedReason();
        int hashCode3 = (hashCode2 * 59) + (deniedReason2 == null ? 43 : deniedReason2.hashCode());
        String countryName2 = getCountryName();
        int i12 = hashCode3 * 59;
        if (countryName2 != null) {
            i11 = countryName2.hashCode();
        }
        return ((i12 + i11) * 59) + getCountry();
    }

    public boolean isChange() {
        return this.isChange;
    }

    public void setAuthLevel(int i11) {
        this.authLevel = i11;
    }

    public void setChange(boolean z11) {
        this.isChange = z11;
    }

    public void setCountry(int i11) {
        this.country = i11;
    }

    public void setCountryName(String str) {
        this.countryName = str;
    }

    public void setDeniedReason(String str) {
        this.deniedReason = str;
    }

    public void setIdentityName(String str) {
        this.identityName = str;
    }

    public void setIdentityNo(String str) {
        this.identityNo = str;
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public String toString() {
        return "OTCKycInfo(identityName=" + getIdentityName() + ", identityNo=" + getIdentityNo() + ", authLevel=" + getAuthLevel() + ", status=" + getStatus() + ", isChange=" + isChange() + ", deniedReason=" + getDeniedReason() + ", countryName=" + getCountryName() + ", country=" + getCountry() + ")";
    }
}
