package com.hbg.lib.data.future.bean;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserInfo;
import com.hbg.lib.network.option.core.bean.OptionUserInfo;
import java.io.Serializable;

public class FutureUserInfo implements Serializable {
    public static final int ACTIVE_STATE_CLOSE = 0;
    public static final int ACTIVE_STATE_OPEN = 1;
    public static final int IS_AGREE = 1;
    public static final int IS_HIGH_LEVER_AGREE = 1;
    public static final int IS_HIGH_LEVER_NOT_AGREE = 0;
    public static final int IS_NOT_AGREE = 0;
    private String accountName;
    private int activeState;
    private int agreeHighLever;
    private String availableLevelRate;
    private int closeState;
    private int countryCode;
    private String createDate;
    private String email;
    private int isAgree;
    private int isAgreeV2;
    private int isSubWhiteUser;
    private int isWhiteUser;
    private String kycCountry;
    private int kycState;
    private int moneyinState;
    private int moneyoutState;
    private int openState;
    private String parentId;
    private int subAuth;
    private String telephone;
    private String telephoneCountryCode;
    private int ucUserType;
    private int uid;
    private String userName;
    private int userType;
    private String uuid;
    private int videoAuthState;
    private int vipExpired;
    private String vipExpiryDate;
    private int vipLevel;

    public boolean canEqual(Object obj) {
        return obj instanceof FutureUserInfo;
    }

    public FutureUserInfo convert(FutureUserInfo futureUserInfo, LinearSwapUserInfo linearSwapUserInfo) {
        futureUserInfo.setUserName(linearSwapUserInfo.getUserName());
        futureUserInfo.setUid(linearSwapUserInfo.getUid());
        futureUserInfo.setUuid(linearSwapUserInfo.getUuid());
        futureUserInfo.setCreateDate(linearSwapUserInfo.getCreateDate());
        futureUserInfo.setUserType(linearSwapUserInfo.getUserType());
        futureUserInfo.setVipLevel(linearSwapUserInfo.getVipLevel());
        futureUserInfo.setVipExpired(linearSwapUserInfo.getVipExpired());
        futureUserInfo.setVipExpiryDate(linearSwapUserInfo.getVipExpiryDate());
        futureUserInfo.setOpenState(linearSwapUserInfo.getOpenState());
        futureUserInfo.setCloseState(linearSwapUserInfo.getCloseState());
        futureUserInfo.setMoneyinState(linearSwapUserInfo.getMoneyinState());
        futureUserInfo.setMoneyoutState(linearSwapUserInfo.getMoneyoutState());
        futureUserInfo.setActiveState(linearSwapUserInfo.getActiveState());
        futureUserInfo.setTelephone(linearSwapUserInfo.getTelephone());
        futureUserInfo.setEmail(linearSwapUserInfo.getEmail());
        futureUserInfo.setCountryCode(linearSwapUserInfo.getCountryCode());
        futureUserInfo.setTelephoneCountryCode(linearSwapUserInfo.getTelephoneCountryCode());
        futureUserInfo.setKycCountry(linearSwapUserInfo.getKycCountry());
        futureUserInfo.setKycState(linearSwapUserInfo.getKycState());
        futureUserInfo.setAvailableLevelRate(linearSwapUserInfo.getAvailableLevelRate());
        futureUserInfo.setIsAgree(linearSwapUserInfo.getIsAgree());
        futureUserInfo.setIsAgreeV2(linearSwapUserInfo.getIsAgreeV2());
        futureUserInfo.setIsWhiteUser(linearSwapUserInfo.getIsWhiteUser());
        futureUserInfo.setVideoAuthState(linearSwapUserInfo.getVideoAuthState());
        futureUserInfo.setParentId(linearSwapUserInfo.getParentId());
        futureUserInfo.setAccountName(linearSwapUserInfo.getAccountName());
        futureUserInfo.setSubAuth(linearSwapUserInfo.getSubAuth());
        futureUserInfo.setIsSubWhiteUser(linearSwapUserInfo.getIsSubWhiteUser());
        return futureUserInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FutureUserInfo)) {
            return false;
        }
        FutureUserInfo futureUserInfo = (FutureUserInfo) obj;
        if (!futureUserInfo.canEqual(this)) {
            return false;
        }
        String userName2 = getUserName();
        String userName3 = futureUserInfo.getUserName();
        if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
            return false;
        }
        if (getUid() != futureUserInfo.getUid()) {
            return false;
        }
        String uuid2 = getUuid();
        String uuid3 = futureUserInfo.getUuid();
        if (uuid2 != null ? !uuid2.equals(uuid3) : uuid3 != null) {
            return false;
        }
        String createDate2 = getCreateDate();
        String createDate3 = futureUserInfo.getCreateDate();
        if (createDate2 != null ? !createDate2.equals(createDate3) : createDate3 != null) {
            return false;
        }
        if (getUserType() != futureUserInfo.getUserType() || getVipLevel() != futureUserInfo.getVipLevel() || getVipExpired() != futureUserInfo.getVipExpired()) {
            return false;
        }
        String vipExpiryDate2 = getVipExpiryDate();
        String vipExpiryDate3 = futureUserInfo.getVipExpiryDate();
        if (vipExpiryDate2 != null ? !vipExpiryDate2.equals(vipExpiryDate3) : vipExpiryDate3 != null) {
            return false;
        }
        if (getOpenState() != futureUserInfo.getOpenState() || getCloseState() != futureUserInfo.getCloseState() || getMoneyinState() != futureUserInfo.getMoneyinState() || getMoneyoutState() != futureUserInfo.getMoneyoutState() || getActiveState() != futureUserInfo.getActiveState()) {
            return false;
        }
        String telephone2 = getTelephone();
        String telephone3 = futureUserInfo.getTelephone();
        if (telephone2 != null ? !telephone2.equals(telephone3) : telephone3 != null) {
            return false;
        }
        String email2 = getEmail();
        String email3 = futureUserInfo.getEmail();
        if (email2 != null ? !email2.equals(email3) : email3 != null) {
            return false;
        }
        if (getCountryCode() != futureUserInfo.getCountryCode()) {
            return false;
        }
        String telephoneCountryCode2 = getTelephoneCountryCode();
        String telephoneCountryCode3 = futureUserInfo.getTelephoneCountryCode();
        if (telephoneCountryCode2 != null ? !telephoneCountryCode2.equals(telephoneCountryCode3) : telephoneCountryCode3 != null) {
            return false;
        }
        String kycCountry2 = getKycCountry();
        String kycCountry3 = futureUserInfo.getKycCountry();
        if (kycCountry2 != null ? !kycCountry2.equals(kycCountry3) : kycCountry3 != null) {
            return false;
        }
        if (getKycState() != futureUserInfo.getKycState()) {
            return false;
        }
        String availableLevelRate2 = getAvailableLevelRate();
        String availableLevelRate3 = futureUserInfo.getAvailableLevelRate();
        if (availableLevelRate2 != null ? !availableLevelRate2.equals(availableLevelRate3) : availableLevelRate3 != null) {
            return false;
        }
        if (getIsAgree() != futureUserInfo.getIsAgree() || getIsAgreeV2() != futureUserInfo.getIsAgreeV2() || getIsWhiteUser() != futureUserInfo.getIsWhiteUser() || getVideoAuthState() != futureUserInfo.getVideoAuthState() || getUcUserType() != futureUserInfo.getUcUserType()) {
            return false;
        }
        String parentId2 = getParentId();
        String parentId3 = futureUserInfo.getParentId();
        if (parentId2 != null ? !parentId2.equals(parentId3) : parentId3 != null) {
            return false;
        }
        String accountName2 = getAccountName();
        String accountName3 = futureUserInfo.getAccountName();
        if (accountName2 != null ? accountName2.equals(accountName3) : accountName3 == null) {
            return getSubAuth() == futureUserInfo.getSubAuth() && getIsSubWhiteUser() == futureUserInfo.getIsSubWhiteUser() && getAgreeHighLever() == futureUserInfo.getAgreeHighLever();
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
        int hashCode9 = (((((((((((hashCode8 * 59) + (availableLevelRate2 == null ? 43 : availableLevelRate2.hashCode())) * 59) + getIsAgree()) * 59) + getIsAgreeV2()) * 59) + getIsWhiteUser()) * 59) + getVideoAuthState()) * 59) + getUcUserType();
        String parentId2 = getParentId();
        int hashCode10 = (hashCode9 * 59) + (parentId2 == null ? 43 : parentId2.hashCode());
        String accountName2 = getAccountName();
        int i12 = hashCode10 * 59;
        if (accountName2 != null) {
            i11 = accountName2.hashCode();
        }
        return ((((((i12 + i11) * 59) + getSubAuth()) * 59) + getIsSubWhiteUser()) * 59) + getAgreeHighLever();
    }

    public FutureUserInfo optionConvert(FutureUserInfo futureUserInfo, OptionUserInfo optionUserInfo) {
        futureUserInfo.setUserName(optionUserInfo.getUserName());
        futureUserInfo.setUid(optionUserInfo.getUid());
        futureUserInfo.setUuid(optionUserInfo.getUuid());
        futureUserInfo.setCreateDate(optionUserInfo.getCreateDate());
        futureUserInfo.setUserType(optionUserInfo.getUserType());
        futureUserInfo.setVipLevel(optionUserInfo.getVipLevel());
        futureUserInfo.setVipExpired(optionUserInfo.getVipExpired());
        futureUserInfo.setVipExpiryDate(optionUserInfo.getVipExpiryDate());
        futureUserInfo.setOpenState(optionUserInfo.getOpenState());
        futureUserInfo.setCloseState(optionUserInfo.getCloseState());
        futureUserInfo.setMoneyinState(optionUserInfo.getMoneyinState());
        futureUserInfo.setMoneyoutState(optionUserInfo.getMoneyoutState());
        futureUserInfo.setActiveState(optionUserInfo.getActiveState());
        futureUserInfo.setTelephone(optionUserInfo.getTelephone());
        futureUserInfo.setEmail(optionUserInfo.getEmail());
        futureUserInfo.setCountryCode(optionUserInfo.getCountryCode());
        futureUserInfo.setTelephoneCountryCode(optionUserInfo.getTelephoneCountryCode());
        futureUserInfo.setKycCountry(optionUserInfo.getKycCountry());
        futureUserInfo.setKycState(optionUserInfo.getKycState());
        futureUserInfo.setAvailableLevelRate(optionUserInfo.getAvailableLevelRate());
        futureUserInfo.setIsAgree(optionUserInfo.getIsAgree());
        futureUserInfo.setIsAgreeV2(optionUserInfo.getIsAgreeV2());
        futureUserInfo.setIsWhiteUser(optionUserInfo.getIsWhiteUser());
        futureUserInfo.setVideoAuthState(optionUserInfo.getVideoAuthState());
        futureUserInfo.setUcUserType(optionUserInfo.getUcUserType());
        futureUserInfo.setParentId(optionUserInfo.getParentId());
        futureUserInfo.setAccountName(optionUserInfo.getAccountName());
        futureUserInfo.setSubAuth(optionUserInfo.getSubAuth());
        futureUserInfo.setIsSubWhiteUser(optionUserInfo.getIsSubWhiteUser());
        return futureUserInfo;
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
        return "FutureUserInfo(userName=" + getUserName() + ", uid=" + getUid() + ", uuid=" + getUuid() + ", createDate=" + getCreateDate() + ", userType=" + getUserType() + ", vipLevel=" + getVipLevel() + ", vipExpired=" + getVipExpired() + ", vipExpiryDate=" + getVipExpiryDate() + ", openState=" + getOpenState() + ", closeState=" + getCloseState() + ", moneyinState=" + getMoneyinState() + ", moneyoutState=" + getMoneyoutState() + ", activeState=" + getActiveState() + ", telephone=" + getTelephone() + ", email=" + getEmail() + ", countryCode=" + getCountryCode() + ", telephoneCountryCode=" + getTelephoneCountryCode() + ", kycCountry=" + getKycCountry() + ", kycState=" + getKycState() + ", availableLevelRate=" + getAvailableLevelRate() + ", isAgree=" + getIsAgree() + ", isAgreeV2=" + getIsAgreeV2() + ", isWhiteUser=" + getIsWhiteUser() + ", videoAuthState=" + getVideoAuthState() + ", ucUserType=" + getUcUserType() + ", parentId=" + getParentId() + ", accountName=" + getAccountName() + ", subAuth=" + getSubAuth() + ", isSubWhiteUser=" + getIsSubWhiteUser() + ", agreeHighLever=" + getAgreeHighLever() + ")";
    }
}
