package com.hbg.lib.network.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SwapUserInfo implements Serializable {
    private static final long serialVersionUID = -2759048871546134381L;
    private String hbsession;
    private UserBean user;

    public static class UserBean implements Serializable {
        public static final int ACTIVE_STATE_CLOSE = 0;
        public static final int ACTIVE_STATE_OPEN = 1;
        public static final int IS_AGREE = 1;
        public static final int IS_HIGH_LEVER_AGREE = 1;
        public static final int IS_HIGH_LEVER_NOT_AGREE = 0;
        public static final int IS_NOT_AGREE = 0;
        @SerializedName("active_state")
        private int activeState;
        @SerializedName("agree_high_lever")
        private int agreeHighLever;
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
        @SerializedName("video_auth_state")
        private int videoAuthState;
        @SerializedName("vip_expired")
        private int vipExpired;
        @SerializedName("vip_expiry_date")
        private String vipExpiryDate;
        @SerializedName("vip_level")
        private int vipLevel;

        public boolean canEqual(Object obj) {
            return obj instanceof UserBean;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UserBean)) {
                return false;
            }
            UserBean userBean = (UserBean) obj;
            if (!userBean.canEqual(this)) {
                return false;
            }
            String userName2 = getUserName();
            String userName3 = userBean.getUserName();
            if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
                return false;
            }
            if (getUid() != userBean.getUid()) {
                return false;
            }
            String userId2 = getUserId();
            String userId3 = userBean.getUserId();
            if (userId2 != null ? !userId2.equals(userId3) : userId3 != null) {
                return false;
            }
            String createDate2 = getCreateDate();
            String createDate3 = userBean.getCreateDate();
            if (createDate2 != null ? !createDate2.equals(createDate3) : createDate3 != null) {
                return false;
            }
            if (getUserType() != userBean.getUserType() || getVipLevel() != userBean.getVipLevel() || getVipExpired() != userBean.getVipExpired()) {
                return false;
            }
            String vipExpiryDate2 = getVipExpiryDate();
            String vipExpiryDate3 = userBean.getVipExpiryDate();
            if (vipExpiryDate2 != null ? !vipExpiryDate2.equals(vipExpiryDate3) : vipExpiryDate3 != null) {
                return false;
            }
            if (getOpenState() != userBean.getOpenState() || getCloseState() != userBean.getCloseState() || getIsAgree() != userBean.getIsAgree() || getMoneyinState() != userBean.getMoneyinState() || getMoneyoutState() != userBean.getMoneyoutState() || getActiveState() != userBean.getActiveState()) {
                return false;
            }
            String telephone2 = getTelephone();
            String telephone3 = userBean.getTelephone();
            if (telephone2 != null ? !telephone2.equals(telephone3) : telephone3 != null) {
                return false;
            }
            String email2 = getEmail();
            String email3 = userBean.getEmail();
            if (email2 != null ? !email2.equals(email3) : email3 != null) {
                return false;
            }
            if (getCountryCode() != userBean.getCountryCode()) {
                return false;
            }
            String telephoneCountryCode2 = getTelephoneCountryCode();
            String telephoneCountryCode3 = userBean.getTelephoneCountryCode();
            if (telephoneCountryCode2 != null ? !telephoneCountryCode2.equals(telephoneCountryCode3) : telephoneCountryCode3 != null) {
                return false;
            }
            String availableLevelRate2 = getAvailableLevelRate();
            String availableLevelRate3 = userBean.getAvailableLevelRate();
            if (availableLevelRate2 != null ? !availableLevelRate2.equals(availableLevelRate3) : availableLevelRate3 != null) {
                return false;
            }
            String kycCountry2 = getKycCountry();
            String kycCountry3 = userBean.getKycCountry();
            if (kycCountry2 != null ? kycCountry2.equals(kycCountry3) : kycCountry3 == null) {
                return getKycState() == userBean.getKycState() && getIsWhiteUser() == userBean.getIsWhiteUser() && getVideoAuthState() == userBean.getVideoAuthState() && getUc_user_type() == userBean.getUc_user_type() && getAgreeHighLever() == userBean.getAgreeHighLever() && getIsAgreeV2() == userBean.getIsAgreeV2() && isOffSite() == userBean.isOffSite();
            }
            return false;
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
            String userId2 = getUserId();
            int hashCode2 = (hashCode * 59) + (userId2 == null ? 43 : userId2.hashCode());
            String createDate2 = getCreateDate();
            int hashCode3 = (((((((hashCode2 * 59) + (createDate2 == null ? 43 : createDate2.hashCode())) * 59) + getUserType()) * 59) + getVipLevel()) * 59) + getVipExpired();
            String vipExpiryDate2 = getVipExpiryDate();
            int hashCode4 = (((((((((((((hashCode3 * 59) + (vipExpiryDate2 == null ? 43 : vipExpiryDate2.hashCode())) * 59) + getOpenState()) * 59) + getCloseState()) * 59) + getIsAgree()) * 59) + getMoneyinState()) * 59) + getMoneyoutState()) * 59) + getActiveState();
            String telephone2 = getTelephone();
            int hashCode5 = (hashCode4 * 59) + (telephone2 == null ? 43 : telephone2.hashCode());
            String email2 = getEmail();
            int hashCode6 = (((hashCode5 * 59) + (email2 == null ? 43 : email2.hashCode())) * 59) + getCountryCode();
            String telephoneCountryCode2 = getTelephoneCountryCode();
            int hashCode7 = (hashCode6 * 59) + (telephoneCountryCode2 == null ? 43 : telephoneCountryCode2.hashCode());
            String availableLevelRate2 = getAvailableLevelRate();
            int hashCode8 = (hashCode7 * 59) + (availableLevelRate2 == null ? 43 : availableLevelRate2.hashCode());
            String kycCountry2 = getKycCountry();
            int i12 = hashCode8 * 59;
            if (kycCountry2 != null) {
                i11 = kycCountry2.hashCode();
            }
            return ((((((((((((((i12 + i11) * 59) + getKycState()) * 59) + getIsWhiteUser()) * 59) + getVideoAuthState()) * 59) + getUc_user_type()) * 59) + getAgreeHighLever()) * 59) + getIsAgreeV2()) * 59) + (isOffSite() ? 79 : 97);
        }

        public boolean isKycVerified() {
            return this.kycState == 2;
        }

        public boolean isOffSite() {
            return this.offSite;
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
            return "SwapUserInfo.UserBean(userName=" + getUserName() + ", uid=" + getUid() + ", userId=" + getUserId() + ", createDate=" + getCreateDate() + ", userType=" + getUserType() + ", vipLevel=" + getVipLevel() + ", vipExpired=" + getVipExpired() + ", vipExpiryDate=" + getVipExpiryDate() + ", openState=" + getOpenState() + ", closeState=" + getCloseState() + ", isAgree=" + getIsAgree() + ", moneyinState=" + getMoneyinState() + ", moneyoutState=" + getMoneyoutState() + ", activeState=" + getActiveState() + ", telephone=" + getTelephone() + ", email=" + getEmail() + ", countryCode=" + getCountryCode() + ", telephoneCountryCode=" + getTelephoneCountryCode() + ", availableLevelRate=" + getAvailableLevelRate() + ", kycCountry=" + getKycCountry() + ", kycState=" + getKycState() + ", isWhiteUser=" + getIsWhiteUser() + ", videoAuthState=" + getVideoAuthState() + ", uc_user_type=" + getUc_user_type() + ", agreeHighLever=" + getAgreeHighLever() + ", isAgreeV2=" + getIsAgreeV2() + ", offSite=" + isOffSite() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof SwapUserInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapUserInfo)) {
            return false;
        }
        SwapUserInfo swapUserInfo = (SwapUserInfo) obj;
        if (!swapUserInfo.canEqual(this)) {
            return false;
        }
        UserBean user2 = getUser();
        UserBean user3 = swapUserInfo.getUser();
        if (user2 != null ? !user2.equals(user3) : user3 != null) {
            return false;
        }
        String hbsession2 = getHbsession();
        String hbsession3 = swapUserInfo.getHbsession();
        return hbsession2 != null ? hbsession2.equals(hbsession3) : hbsession3 == null;
    }

    public String getHbsession() {
        return this.hbsession;
    }

    public UserBean getUser() {
        return this.user;
    }

    public int hashCode() {
        UserBean user2 = getUser();
        int i11 = 43;
        int hashCode = user2 == null ? 43 : user2.hashCode();
        String hbsession2 = getHbsession();
        int i12 = (hashCode + 59) * 59;
        if (hbsession2 != null) {
            i11 = hbsession2.hashCode();
        }
        return i12 + i11;
    }

    public void setHbsession(String str) {
        this.hbsession = str;
    }

    public void setUser(UserBean userBean) {
        this.user = userBean;
    }

    public String toString() {
        return "SwapUserInfo(user=" + getUser() + ", hbsession=" + getHbsession() + ")";
    }
}
