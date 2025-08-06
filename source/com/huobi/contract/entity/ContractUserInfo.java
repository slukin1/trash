package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractUserInfo implements Serializable {
    private static final long serialVersionUID = -2759048871546134381L;
    private String hbsession;
    private UserBean user;

    public static class UserBean implements Serializable {
        public static final int ACTIVE_STATE_CLOSE = 0;
        public static final int ACTIVE_STATE_OPEN = 1;
        public static final int IS_AGREE = 1;
        public static final int IS_NOT_AGREE = 0;
        @SerializedName("active_state")
        private int activeState;
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
        private int uid;
        @SerializedName("user_id")
        private String userId;
        @SerializedName("user_name")
        private String userName;
        @SerializedName("user_type")
        private int userType;
        @SerializedName("vip_expired")
        private int vipExpired;
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
            if (getUserType() != userBean.getUserType() || getVipLevel() != userBean.getVipLevel() || getVipExpired() != userBean.getVipExpired() || getOpenState() != userBean.getOpenState() || getCloseState() != userBean.getCloseState() || getIsAgree() != userBean.getIsAgree() || getMoneyinState() != userBean.getMoneyinState() || getMoneyoutState() != userBean.getMoneyoutState() || getActiveState() != userBean.getActiveState()) {
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
            if (getIsAgreeV2() != userBean.getIsAgreeV2() || isOffSite() != userBean.isOffSite()) {
                return false;
            }
            String kycCountry2 = getKycCountry();
            String kycCountry3 = userBean.getKycCountry();
            if (kycCountry2 != null ? kycCountry2.equals(kycCountry3) : kycCountry3 == null) {
                return getKycState() == userBean.getKycState();
            }
            return false;
        }

        public int getActiveState() {
            return this.activeState;
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

        public int getVipExpired() {
            return this.vipExpired;
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
            int hashCode3 = (((((((((((((((((((hashCode2 * 59) + (createDate2 == null ? 43 : createDate2.hashCode())) * 59) + getUserType()) * 59) + getVipLevel()) * 59) + getVipExpired()) * 59) + getOpenState()) * 59) + getCloseState()) * 59) + getIsAgree()) * 59) + getMoneyinState()) * 59) + getMoneyoutState()) * 59) + getActiveState();
            String telephone2 = getTelephone();
            int hashCode4 = (hashCode3 * 59) + (telephone2 == null ? 43 : telephone2.hashCode());
            String email2 = getEmail();
            int hashCode5 = (((hashCode4 * 59) + (email2 == null ? 43 : email2.hashCode())) * 59) + getCountryCode();
            String telephoneCountryCode2 = getTelephoneCountryCode();
            int hashCode6 = (((((hashCode5 * 59) + (telephoneCountryCode2 == null ? 43 : telephoneCountryCode2.hashCode())) * 59) + getIsAgreeV2()) * 59) + (isOffSite() ? 79 : 97);
            String kycCountry2 = getKycCountry();
            int i12 = hashCode6 * 59;
            if (kycCountry2 != null) {
                i11 = kycCountry2.hashCode();
            }
            return ((i12 + i11) * 59) + getKycState();
        }

        public boolean isActiveStateOpen() {
            return this.activeState == 1;
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

        public void setVipExpired(int i11) {
            this.vipExpired = i11;
        }

        public void setVipLevel(int i11) {
            this.vipLevel = i11;
        }

        public String toString() {
            return "ContractUserInfo.UserBean(userName=" + getUserName() + ", uid=" + getUid() + ", userId=" + getUserId() + ", createDate=" + getCreateDate() + ", userType=" + getUserType() + ", vipLevel=" + getVipLevel() + ", vipExpired=" + getVipExpired() + ", openState=" + getOpenState() + ", closeState=" + getCloseState() + ", isAgree=" + getIsAgree() + ", moneyinState=" + getMoneyinState() + ", moneyoutState=" + getMoneyoutState() + ", activeState=" + getActiveState() + ", telephone=" + getTelephone() + ", email=" + getEmail() + ", countryCode=" + getCountryCode() + ", telephoneCountryCode=" + getTelephoneCountryCode() + ", isAgreeV2=" + getIsAgreeV2() + ", offSite=" + isOffSite() + ", kycCountry=" + getKycCountry() + ", kycState=" + getKycState() + ")";
        }
    }

    public boolean canEqual(Object obj) {
        return obj instanceof ContractUserInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractUserInfo)) {
            return false;
        }
        ContractUserInfo contractUserInfo = (ContractUserInfo) obj;
        if (!contractUserInfo.canEqual(this)) {
            return false;
        }
        UserBean user2 = getUser();
        UserBean user3 = contractUserInfo.getUser();
        if (user2 != null ? !user2.equals(user3) : user3 != null) {
            return false;
        }
        String hbsession2 = getHbsession();
        String hbsession3 = contractUserInfo.getHbsession();
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
        return "ContractUserInfo(user=" + getUser() + ", hbsession=" + getHbsession() + ")";
    }
}
