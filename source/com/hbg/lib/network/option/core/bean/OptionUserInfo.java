package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OptionUserInfo implements Serializable {
    @SerializedName("account_name")
    private String accountName;
    @SerializedName("active_state")
    private int activeState;
    @SerializedName("available_level_rate")
    private String availableLevelRate;
    @SerializedName("close_state")
    private int closeState;
    @SerializedName("country_code")
    private int countryCode;
    @SerializedName("create_date")
    private String createDate;
    private String email;
    @SerializedName("is_agree")
    private int isAgree;
    private int isAgreeV2;
    @SerializedName("is_sub_white_user")
    private int isSubWhiteUser;
    @SerializedName("is_whiteuser")
    private int isWhiteUser;
    @SerializedName("kyc_country")
    private String kycCountry;
    @SerializedName("kyc_state")
    private int kycState;
    @SerializedName("moneyin_state")
    private int moneyinState;
    @SerializedName("moneyout_state")
    private int moneyoutState;
    @SerializedName("open_state")
    private int openState;
    @SerializedName("parent_id")
    private String parentId;
    @SerializedName("sub_auth")
    private int subAuth;
    private String telephone;
    @SerializedName("telephone_country_code")
    private String telephoneCountryCode;
    @SerializedName("uc_user_type")
    private int ucUserType;
    private int uid;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("user_type")
    private int userType;
    @SerializedName("uuid")
    private String uuid;
    @SerializedName("video_auth_state")
    private int videoAuthState;
    @SerializedName("vip_expired")
    private int vipExpired;
    @SerializedName("vip_expiry_date")
    private String vipExpiryDate;
    @SerializedName("vip_level")
    private int vipLevel;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionUserInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionUserInfo)) {
            return false;
        }
        OptionUserInfo optionUserInfo = (OptionUserInfo) obj;
        if (!optionUserInfo.canEqual(this)) {
            return false;
        }
        String userName2 = getUserName();
        String userName3 = optionUserInfo.getUserName();
        if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
            return false;
        }
        if (getUid() != optionUserInfo.getUid()) {
            return false;
        }
        String uuid2 = getUuid();
        String uuid3 = optionUserInfo.getUuid();
        if (uuid2 != null ? !uuid2.equals(uuid3) : uuid3 != null) {
            return false;
        }
        String createDate2 = getCreateDate();
        String createDate3 = optionUserInfo.getCreateDate();
        if (createDate2 != null ? !createDate2.equals(createDate3) : createDate3 != null) {
            return false;
        }
        if (getUserType() != optionUserInfo.getUserType() || getVipLevel() != optionUserInfo.getVipLevel() || getVipExpired() != optionUserInfo.getVipExpired()) {
            return false;
        }
        String vipExpiryDate2 = getVipExpiryDate();
        String vipExpiryDate3 = optionUserInfo.getVipExpiryDate();
        if (vipExpiryDate2 != null ? !vipExpiryDate2.equals(vipExpiryDate3) : vipExpiryDate3 != null) {
            return false;
        }
        if (getOpenState() != optionUserInfo.getOpenState() || getCloseState() != optionUserInfo.getCloseState() || getMoneyinState() != optionUserInfo.getMoneyinState() || getMoneyoutState() != optionUserInfo.getMoneyoutState() || getActiveState() != optionUserInfo.getActiveState()) {
            return false;
        }
        String telephone2 = getTelephone();
        String telephone3 = optionUserInfo.getTelephone();
        if (telephone2 != null ? !telephone2.equals(telephone3) : telephone3 != null) {
            return false;
        }
        String email2 = getEmail();
        String email3 = optionUserInfo.getEmail();
        if (email2 != null ? !email2.equals(email3) : email3 != null) {
            return false;
        }
        if (getCountryCode() != optionUserInfo.getCountryCode()) {
            return false;
        }
        String telephoneCountryCode2 = getTelephoneCountryCode();
        String telephoneCountryCode3 = optionUserInfo.getTelephoneCountryCode();
        if (telephoneCountryCode2 != null ? !telephoneCountryCode2.equals(telephoneCountryCode3) : telephoneCountryCode3 != null) {
            return false;
        }
        String kycCountry2 = getKycCountry();
        String kycCountry3 = optionUserInfo.getKycCountry();
        if (kycCountry2 != null ? !kycCountry2.equals(kycCountry3) : kycCountry3 != null) {
            return false;
        }
        if (getKycState() != optionUserInfo.getKycState()) {
            return false;
        }
        String availableLevelRate2 = getAvailableLevelRate();
        String availableLevelRate3 = optionUserInfo.getAvailableLevelRate();
        if (availableLevelRate2 != null ? !availableLevelRate2.equals(availableLevelRate3) : availableLevelRate3 != null) {
            return false;
        }
        if (getIsAgree() != optionUserInfo.getIsAgree() || getIsWhiteUser() != optionUserInfo.getIsWhiteUser() || getVideoAuthState() != optionUserInfo.getVideoAuthState() || getUcUserType() != optionUserInfo.getUcUserType()) {
            return false;
        }
        String parentId2 = getParentId();
        String parentId3 = optionUserInfo.getParentId();
        if (parentId2 != null ? !parentId2.equals(parentId3) : parentId3 != null) {
            return false;
        }
        String accountName2 = getAccountName();
        String accountName3 = optionUserInfo.getAccountName();
        if (accountName2 != null ? accountName2.equals(accountName3) : accountName3 == null) {
            return getSubAuth() == optionUserInfo.getSubAuth() && getIsSubWhiteUser() == optionUserInfo.getIsSubWhiteUser() && getIsAgreeV2() == optionUserInfo.getIsAgreeV2();
        }
        return false;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public int getActiveState() {
        return this.activeState;
    }

    public String getAvailableLevelRate() {
        return this.availableLevelRate;
    }

    public int getCloseState() {
        return this.closeState;
    }

    public int getCountryCode() {
        return this.countryCode;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public String getEmail() {
        return this.email;
    }

    public int getIsAgree() {
        return this.isAgree;
    }

    public int getIsAgreeV2() {
        return this.isAgreeV2;
    }

    public int getIsSubWhiteUser() {
        return this.isSubWhiteUser;
    }

    public int getIsWhiteUser() {
        return this.isWhiteUser;
    }

    public String getKycCountry() {
        return this.kycCountry;
    }

    public int getKycState() {
        return this.kycState;
    }

    public int getMoneyinState() {
        return this.moneyinState;
    }

    public int getMoneyoutState() {
        return this.moneyoutState;
    }

    public int getOpenState() {
        return this.openState;
    }

    public String getParentId() {
        return this.parentId;
    }

    public int getSubAuth() {
        return this.subAuth;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public String getTelephoneCountryCode() {
        return this.telephoneCountryCode;
    }

    public int getUcUserType() {
        return this.ucUserType;
    }

    public int getUid() {
        return this.uid;
    }

    public String getUserName() {
        return this.userName;
    }

    public int getUserType() {
        return this.userType;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getVideoAuthState() {
        return this.videoAuthState;
    }

    public int getVipExpired() {
        return this.vipExpired;
    }

    public String getVipExpiryDate() {
        return this.vipExpiryDate;
    }

    public int getVipLevel() {
        return this.vipLevel;
    }

    public int hashCode() {
        String userName2 = getUserName();
        int i11 = 43;
        int hashCode = (((userName2 == null ? 43 : userName2.hashCode()) + 59) * 59) + getUid();
        String uuid2 = getUuid();
        int hashCode2 = (hashCode * 59) + (uuid2 == null ? 43 : uuid2.hashCode());
        String createDate2 = getCreateDate();
        int hashCode3 = (((((((hashCode2 * 59) + (createDate2 == null ? 43 : createDate2.hashCode())) * 59) + getUserType()) * 59) + getVipLevel()) * 59) + getVipExpired();
        String vipExpiryDate2 = getVipExpiryDate();
        int hashCode4 = (((((((((((hashCode3 * 59) + (vipExpiryDate2 == null ? 43 : vipExpiryDate2.hashCode())) * 59) + getOpenState()) * 59) + getCloseState()) * 59) + getMoneyinState()) * 59) + getMoneyoutState()) * 59) + getActiveState();
        String telephone2 = getTelephone();
        int hashCode5 = (hashCode4 * 59) + (telephone2 == null ? 43 : telephone2.hashCode());
        String email2 = getEmail();
        int hashCode6 = (((hashCode5 * 59) + (email2 == null ? 43 : email2.hashCode())) * 59) + getCountryCode();
        String telephoneCountryCode2 = getTelephoneCountryCode();
        int hashCode7 = (hashCode6 * 59) + (telephoneCountryCode2 == null ? 43 : telephoneCountryCode2.hashCode());
        String kycCountry2 = getKycCountry();
        int hashCode8 = (((hashCode7 * 59) + (kycCountry2 == null ? 43 : kycCountry2.hashCode())) * 59) + getKycState();
        String availableLevelRate2 = getAvailableLevelRate();
        int hashCode9 = (((((((((hashCode8 * 59) + (availableLevelRate2 == null ? 43 : availableLevelRate2.hashCode())) * 59) + getIsAgree()) * 59) + getIsWhiteUser()) * 59) + getVideoAuthState()) * 59) + getUcUserType();
        String parentId2 = getParentId();
        int hashCode10 = (hashCode9 * 59) + (parentId2 == null ? 43 : parentId2.hashCode());
        String accountName2 = getAccountName();
        int i12 = hashCode10 * 59;
        if (accountName2 != null) {
            i11 = accountName2.hashCode();
        }
        return ((((((i12 + i11) * 59) + getSubAuth()) * 59) + getIsSubWhiteUser()) * 59) + getIsAgreeV2();
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setActiveState(int i11) {
        this.activeState = i11;
    }

    public void setAvailableLevelRate(String str) {
        this.availableLevelRate = str;
    }

    public void setCloseState(int i11) {
        this.closeState = i11;
    }

    public void setCountryCode(int i11) {
        this.countryCode = i11;
    }

    public void setCreateDate(String str) {
        this.createDate = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setIsAgree(int i11) {
        this.isAgree = i11;
    }

    public void setIsAgreeV2(int i11) {
        this.isAgreeV2 = i11;
    }

    public void setIsSubWhiteUser(int i11) {
        this.isSubWhiteUser = i11;
    }

    public void setIsWhiteUser(int i11) {
        this.isWhiteUser = i11;
    }

    public void setKycCountry(String str) {
        this.kycCountry = str;
    }

    public void setKycState(int i11) {
        this.kycState = i11;
    }

    public void setMoneyinState(int i11) {
        this.moneyinState = i11;
    }

    public void setMoneyoutState(int i11) {
        this.moneyoutState = i11;
    }

    public void setOpenState(int i11) {
        this.openState = i11;
    }

    public void setParentId(String str) {
        this.parentId = str;
    }

    public void setSubAuth(int i11) {
        this.subAuth = i11;
    }

    public void setTelephone(String str) {
        this.telephone = str;
    }

    public void setTelephoneCountryCode(String str) {
        this.telephoneCountryCode = str;
    }

    public void setUcUserType(int i11) {
        this.ucUserType = i11;
    }

    public void setUid(int i11) {
        this.uid = i11;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setUserType(int i11) {
        this.userType = i11;
    }

    public void setUuid(String str) {
        this.uuid = str;
    }

    public void setVideoAuthState(int i11) {
        this.videoAuthState = i11;
    }

    public void setVipExpired(int i11) {
        this.vipExpired = i11;
    }

    public void setVipExpiryDate(String str) {
        this.vipExpiryDate = str;
    }

    public void setVipLevel(int i11) {
        this.vipLevel = i11;
    }

    public String toString() {
        return "OptionUserInfo(userName=" + getUserName() + ", uid=" + getUid() + ", uuid=" + getUuid() + ", createDate=" + getCreateDate() + ", userType=" + getUserType() + ", vipLevel=" + getVipLevel() + ", vipExpired=" + getVipExpired() + ", vipExpiryDate=" + getVipExpiryDate() + ", openState=" + getOpenState() + ", closeState=" + getCloseState() + ", moneyinState=" + getMoneyinState() + ", moneyoutState=" + getMoneyoutState() + ", activeState=" + getActiveState() + ", telephone=" + getTelephone() + ", email=" + getEmail() + ", countryCode=" + getCountryCode() + ", telephoneCountryCode=" + getTelephoneCountryCode() + ", kycCountry=" + getKycCountry() + ", kycState=" + getKycState() + ", availableLevelRate=" + getAvailableLevelRate() + ", isAgree=" + getIsAgree() + ", isWhiteUser=" + getIsWhiteUser() + ", videoAuthState=" + getVideoAuthState() + ", ucUserType=" + getUcUserType() + ", parentId=" + getParentId() + ", accountName=" + getAccountName() + ", subAuth=" + getSubAuth() + ", isSubWhiteUser=" + getIsSubWhiteUser() + ", isAgreeV2=" + getIsAgreeV2() + ")";
    }
}
