package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapUserInfo implements Serializable {
    public static final int ACTIVE_STATE_CLOSE = 0;
    public static final int ACTIVE_STATE_OPEN = 1;
    public static final int IS_AGREE = 1;
    public static final int IS_HIGH_LEVER_AGREE = 1;
    public static final int IS_HIGH_LEVER_NOT_AGREE = 0;
    public static final int IS_NOT_AGREE = 0;
    private static final long serialVersionUID = -2759048871546134381L;
    @SerializedName("account_name")
    private String accountName;
    @SerializedName("active_state")
    private int activeState;
    @SerializedName("agree_high_lever")
    private int agreeHighLever;
    @SerializedName("assets_mode")
    private int assetsMode;
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
    @SerializedName("off_site")
    public boolean offSite;
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
    private int uc_user_type;
    private int uid;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("user_name")
    private String userName;
    @SerializedName("user_type")
    private int userType;
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
        return obj instanceof LinearSwapUserInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapUserInfo)) {
            return false;
        }
        LinearSwapUserInfo linearSwapUserInfo = (LinearSwapUserInfo) obj;
        if (!linearSwapUserInfo.canEqual(this)) {
            return false;
        }
        String userName2 = getUserName();
        String userName3 = linearSwapUserInfo.getUserName();
        if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
            return false;
        }
        if (getUid() != linearSwapUserInfo.getUid()) {
            return false;
        }
        String uuid2 = getUuid();
        String uuid3 = linearSwapUserInfo.getUuid();
        if (uuid2 != null ? !uuid2.equals(uuid3) : uuid3 != null) {
            return false;
        }
        String userId2 = getUserId();
        String userId3 = linearSwapUserInfo.getUserId();
        if (userId2 != null ? !userId2.equals(userId3) : userId3 != null) {
            return false;
        }
        String createDate2 = getCreateDate();
        String createDate3 = linearSwapUserInfo.getCreateDate();
        if (createDate2 != null ? !createDate2.equals(createDate3) : createDate3 != null) {
            return false;
        }
        if (getUserType() != linearSwapUserInfo.getUserType() || getVipLevel() != linearSwapUserInfo.getVipLevel() || getVipExpired() != linearSwapUserInfo.getVipExpired()) {
            return false;
        }
        String vipExpiryDate2 = getVipExpiryDate();
        String vipExpiryDate3 = linearSwapUserInfo.getVipExpiryDate();
        if (vipExpiryDate2 != null ? !vipExpiryDate2.equals(vipExpiryDate3) : vipExpiryDate3 != null) {
            return false;
        }
        if (getOpenState() != linearSwapUserInfo.getOpenState() || getCloseState() != linearSwapUserInfo.getCloseState() || getIsAgree() != linearSwapUserInfo.getIsAgree() || getMoneyinState() != linearSwapUserInfo.getMoneyinState() || getMoneyoutState() != linearSwapUserInfo.getMoneyoutState() || getActiveState() != linearSwapUserInfo.getActiveState() || getAssetsMode() != linearSwapUserInfo.getAssetsMode()) {
            return false;
        }
        String telephone2 = getTelephone();
        String telephone3 = linearSwapUserInfo.getTelephone();
        if (telephone2 != null ? !telephone2.equals(telephone3) : telephone3 != null) {
            return false;
        }
        String email2 = getEmail();
        String email3 = linearSwapUserInfo.getEmail();
        if (email2 != null ? !email2.equals(email3) : email3 != null) {
            return false;
        }
        if (getCountryCode() != linearSwapUserInfo.getCountryCode()) {
            return false;
        }
        String telephoneCountryCode2 = getTelephoneCountryCode();
        String telephoneCountryCode3 = linearSwapUserInfo.getTelephoneCountryCode();
        if (telephoneCountryCode2 != null ? !telephoneCountryCode2.equals(telephoneCountryCode3) : telephoneCountryCode3 != null) {
            return false;
        }
        String availableLevelRate2 = getAvailableLevelRate();
        String availableLevelRate3 = linearSwapUserInfo.getAvailableLevelRate();
        if (availableLevelRate2 != null ? !availableLevelRate2.equals(availableLevelRate3) : availableLevelRate3 != null) {
            return false;
        }
        String kycCountry2 = getKycCountry();
        String kycCountry3 = linearSwapUserInfo.getKycCountry();
        if (kycCountry2 != null ? !kycCountry2.equals(kycCountry3) : kycCountry3 != null) {
            return false;
        }
        if (getKycState() != linearSwapUserInfo.getKycState() || getIsWhiteUser() != linearSwapUserInfo.getIsWhiteUser() || getVideoAuthState() != linearSwapUserInfo.getVideoAuthState() || getUc_user_type() != linearSwapUserInfo.getUc_user_type() || getAgreeHighLever() != linearSwapUserInfo.getAgreeHighLever()) {
            return false;
        }
        String parentId2 = getParentId();
        String parentId3 = linearSwapUserInfo.getParentId();
        if (parentId2 != null ? !parentId2.equals(parentId3) : parentId3 != null) {
            return false;
        }
        String accountName2 = getAccountName();
        String accountName3 = linearSwapUserInfo.getAccountName();
        if (accountName2 != null ? accountName2.equals(accountName3) : accountName3 == null) {
            return getSubAuth() == linearSwapUserInfo.getSubAuth() && getIsSubWhiteUser() == linearSwapUserInfo.getIsSubWhiteUser() && getIsAgreeV2() == linearSwapUserInfo.getIsAgreeV2() && isOffSite() == linearSwapUserInfo.isOffSite();
        }
        return false;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public int getActiveState() {
        return this.activeState;
    }

    public int getAgreeHighLever() {
        return this.agreeHighLever;
    }

    public int getAssetsMode() {
        return this.assetsMode;
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

    public int getUc_user_type() {
        return this.uc_user_type;
    }

    public int getUid() {
        return this.uid;
    }

    public String getUserId() {
        return this.userId;
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
        String userId2 = getUserId();
        int hashCode3 = (hashCode2 * 59) + (userId2 == null ? 43 : userId2.hashCode());
        String createDate2 = getCreateDate();
        int hashCode4 = (((((((hashCode3 * 59) + (createDate2 == null ? 43 : createDate2.hashCode())) * 59) + getUserType()) * 59) + getVipLevel()) * 59) + getVipExpired();
        String vipExpiryDate2 = getVipExpiryDate();
        int hashCode5 = (((((((((((((((hashCode4 * 59) + (vipExpiryDate2 == null ? 43 : vipExpiryDate2.hashCode())) * 59) + getOpenState()) * 59) + getCloseState()) * 59) + getIsAgree()) * 59) + getMoneyinState()) * 59) + getMoneyoutState()) * 59) + getActiveState()) * 59) + getAssetsMode();
        String telephone2 = getTelephone();
        int hashCode6 = (hashCode5 * 59) + (telephone2 == null ? 43 : telephone2.hashCode());
        String email2 = getEmail();
        int hashCode7 = (((hashCode6 * 59) + (email2 == null ? 43 : email2.hashCode())) * 59) + getCountryCode();
        String telephoneCountryCode2 = getTelephoneCountryCode();
        int hashCode8 = (hashCode7 * 59) + (telephoneCountryCode2 == null ? 43 : telephoneCountryCode2.hashCode());
        String availableLevelRate2 = getAvailableLevelRate();
        int hashCode9 = (hashCode8 * 59) + (availableLevelRate2 == null ? 43 : availableLevelRate2.hashCode());
        String kycCountry2 = getKycCountry();
        int hashCode10 = (((((((((((hashCode9 * 59) + (kycCountry2 == null ? 43 : kycCountry2.hashCode())) * 59) + getKycState()) * 59) + getIsWhiteUser()) * 59) + getVideoAuthState()) * 59) + getUc_user_type()) * 59) + getAgreeHighLever();
        String parentId2 = getParentId();
        int hashCode11 = (hashCode10 * 59) + (parentId2 == null ? 43 : parentId2.hashCode());
        String accountName2 = getAccountName();
        int i12 = hashCode11 * 59;
        if (accountName2 != null) {
            i11 = accountName2.hashCode();
        }
        return ((((((((i12 + i11) * 59) + getSubAuth()) * 59) + getIsSubWhiteUser()) * 59) + getIsAgreeV2()) * 59) + (isOffSite() ? 79 : 97);
    }

    public boolean isKycVerified() {
        return this.kycState == 2;
    }

    public boolean isOffSite() {
        return this.offSite;
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setActiveState(int i11) {
        this.activeState = i11;
    }

    public void setAgreeHighLever(int i11) {
        this.agreeHighLever = i11;
    }

    public void setAssetsMode(int i11) {
        this.assetsMode = i11;
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

    public void setOffSite(boolean z11) {
        this.offSite = z11;
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

    public void setUc_user_type(int i11) {
        this.uc_user_type = i11;
    }

    public void setUid(int i11) {
        this.uid = i11;
    }

    public void setUserId(String str) {
        this.userId = str;
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
        return "LinearSwapUserInfo(userName=" + getUserName() + ", uid=" + getUid() + ", uuid=" + getUuid() + ", userId=" + getUserId() + ", createDate=" + getCreateDate() + ", userType=" + getUserType() + ", vipLevel=" + getVipLevel() + ", vipExpired=" + getVipExpired() + ", vipExpiryDate=" + getVipExpiryDate() + ", openState=" + getOpenState() + ", closeState=" + getCloseState() + ", isAgree=" + getIsAgree() + ", moneyinState=" + getMoneyinState() + ", moneyoutState=" + getMoneyoutState() + ", activeState=" + getActiveState() + ", assetsMode=" + getAssetsMode() + ", telephone=" + getTelephone() + ", email=" + getEmail() + ", countryCode=" + getCountryCode() + ", telephoneCountryCode=" + getTelephoneCountryCode() + ", availableLevelRate=" + getAvailableLevelRate() + ", kycCountry=" + getKycCountry() + ", kycState=" + getKycState() + ", isWhiteUser=" + getIsWhiteUser() + ", videoAuthState=" + getVideoAuthState() + ", uc_user_type=" + getUc_user_type() + ", agreeHighLever=" + getAgreeHighLever() + ", parentId=" + getParentId() + ", accountName=" + getAccountName() + ", subAuth=" + getSubAuth() + ", isSubWhiteUser=" + getIsSubWhiteUser() + ", isAgreeV2=" + getIsAgreeV2() + ", offSite=" + isOffSite() + ")";
    }
}
