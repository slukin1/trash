package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcBalanceConfigInfo implements Serializable {
    public OtcAppIdConfigInfo balanceAppId;
    public OtcAppIdConfigInfo balanceDepositAppId;
    public String privacyAgreement;
    public String userAgreement;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcBalanceConfigInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcBalanceConfigInfo)) {
            return false;
        }
        OtcBalanceConfigInfo otcBalanceConfigInfo = (OtcBalanceConfigInfo) obj;
        if (!otcBalanceConfigInfo.canEqual(this)) {
            return false;
        }
        String userAgreement2 = getUserAgreement();
        String userAgreement3 = otcBalanceConfigInfo.getUserAgreement();
        if (userAgreement2 != null ? !userAgreement2.equals(userAgreement3) : userAgreement3 != null) {
            return false;
        }
        String privacyAgreement2 = getPrivacyAgreement();
        String privacyAgreement3 = otcBalanceConfigInfo.getPrivacyAgreement();
        if (privacyAgreement2 != null ? !privacyAgreement2.equals(privacyAgreement3) : privacyAgreement3 != null) {
            return false;
        }
        OtcAppIdConfigInfo balanceAppId2 = getBalanceAppId();
        OtcAppIdConfigInfo balanceAppId3 = otcBalanceConfigInfo.getBalanceAppId();
        if (balanceAppId2 != null ? !balanceAppId2.equals(balanceAppId3) : balanceAppId3 != null) {
            return false;
        }
        OtcAppIdConfigInfo balanceDepositAppId2 = getBalanceDepositAppId();
        OtcAppIdConfigInfo balanceDepositAppId3 = otcBalanceConfigInfo.getBalanceDepositAppId();
        return balanceDepositAppId2 != null ? balanceDepositAppId2.equals(balanceDepositAppId3) : balanceDepositAppId3 == null;
    }

    public OtcAppIdConfigInfo getBalanceAppId() {
        return this.balanceAppId;
    }

    public OtcAppIdConfigInfo getBalanceDepositAppId() {
        return this.balanceDepositAppId;
    }

    public String getPrivacyAgreement() {
        return this.privacyAgreement;
    }

    public String getUserAgreement() {
        return this.userAgreement;
    }

    public int hashCode() {
        String userAgreement2 = getUserAgreement();
        int i11 = 43;
        int hashCode = userAgreement2 == null ? 43 : userAgreement2.hashCode();
        String privacyAgreement2 = getPrivacyAgreement();
        int hashCode2 = ((hashCode + 59) * 59) + (privacyAgreement2 == null ? 43 : privacyAgreement2.hashCode());
        OtcAppIdConfigInfo balanceAppId2 = getBalanceAppId();
        int hashCode3 = (hashCode2 * 59) + (balanceAppId2 == null ? 43 : balanceAppId2.hashCode());
        OtcAppIdConfigInfo balanceDepositAppId2 = getBalanceDepositAppId();
        int i12 = hashCode3 * 59;
        if (balanceDepositAppId2 != null) {
            i11 = balanceDepositAppId2.hashCode();
        }
        return i12 + i11;
    }

    public void setBalanceAppId(OtcAppIdConfigInfo otcAppIdConfigInfo) {
        this.balanceAppId = otcAppIdConfigInfo;
    }

    public void setBalanceDepositAppId(OtcAppIdConfigInfo otcAppIdConfigInfo) {
        this.balanceDepositAppId = otcAppIdConfigInfo;
    }

    public void setPrivacyAgreement(String str) {
        this.privacyAgreement = str;
    }

    public void setUserAgreement(String str) {
        this.userAgreement = str;
    }

    public String toString() {
        return "OtcBalanceConfigInfo(userAgreement=" + getUserAgreement() + ", privacyAgreement=" + getPrivacyAgreement() + ", balanceAppId=" + getBalanceAppId() + ", balanceDepositAppId=" + getBalanceDepositAppId() + ")";
    }
}
