package com.huobi.entity;

import android.os.Build;
import com.google.gson.annotations.SerializedName;
import com.hbg.lib.network.hbg.core.bean.AccountNftInfoBean;
import java.io.Serializable;

public class PlatformInfo implements Serializable {
    private static final long serialVersionUID = -4794571276558756718L;
    private String accountName;
    @SerializedName("appVersion")
    private int appVersion = 105400;
    private String avatar = "";
    private int colorRise;
    private String countryCode;
    private String did = "";
    private String email;

    /* renamed from: fp  reason: collision with root package name */
    public String f44608fp;
    public String fpmd5;
    private String fullname;
    @SerializedName("global_api")
    private String globalApi;
    @SerializedName("hbdm_api")
    private String hbdmApi;
    private String ipCountry = "";
    private int isLogin;
    private String kycCountry = "";
    private String language;
    private int navigationBarHeightPx;
    @SerializedName("navigationbarHeight")
    private int navigationbarHeight;
    private AccountNftInfoBean nftInfo;
    @SerializedName("otc_api")
    private String otcApi;
    private boolean passkeyUsable;
    private String phone;
    private String phoneModelName = (Build.BRAND + " " + Build.MODEL);
    @SerializedName("conversion_currency")
    private String quotedCurrency;
    private int statusBarHeightPx;
    private String theme;
    private String uid;
    private String userName = "";
    private int userType;
    private String uuid;
    private String vtoken = "";

    public boolean canEqual(Object obj) {
        return obj instanceof PlatformInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlatformInfo)) {
            return false;
        }
        PlatformInfo platformInfo = (PlatformInfo) obj;
        if (!platformInfo.canEqual(this) || getAppVersion() != platformInfo.getAppVersion()) {
            return false;
        }
        String globalApi2 = getGlobalApi();
        String globalApi3 = platformInfo.getGlobalApi();
        if (globalApi2 != null ? !globalApi2.equals(globalApi3) : globalApi3 != null) {
            return false;
        }
        String otcApi2 = getOtcApi();
        String otcApi3 = platformInfo.getOtcApi();
        if (otcApi2 != null ? !otcApi2.equals(otcApi3) : otcApi3 != null) {
            return false;
        }
        String hbdmApi2 = getHbdmApi();
        String hbdmApi3 = platformInfo.getHbdmApi();
        if (hbdmApi2 != null ? !hbdmApi2.equals(hbdmApi3) : hbdmApi3 != null) {
            return false;
        }
        if (getIsLogin() != platformInfo.getIsLogin()) {
            return false;
        }
        String theme2 = getTheme();
        String theme3 = platformInfo.getTheme();
        if (theme2 != null ? !theme2.equals(theme3) : theme3 != null) {
            return false;
        }
        String uid2 = getUid();
        String uid3 = platformInfo.getUid();
        if (uid2 != null ? !uid2.equals(uid3) : uid3 != null) {
            return false;
        }
        String uuid2 = getUuid();
        String uuid3 = platformInfo.getUuid();
        if (uuid2 != null ? !uuid2.equals(uuid3) : uuid3 != null) {
            return false;
        }
        String fp2 = getFp();
        String fp3 = platformInfo.getFp();
        if (fp2 != null ? !fp2.equals(fp3) : fp3 != null) {
            return false;
        }
        String fpmd52 = getFpmd5();
        String fpmd53 = platformInfo.getFpmd5();
        if (fpmd52 != null ? !fpmd52.equals(fpmd53) : fpmd53 != null) {
            return false;
        }
        String phoneModelName2 = getPhoneModelName();
        String phoneModelName3 = platformInfo.getPhoneModelName();
        if (phoneModelName2 != null ? !phoneModelName2.equals(phoneModelName3) : phoneModelName3 != null) {
            return false;
        }
        if (getColorRise() != platformInfo.getColorRise()) {
            return false;
        }
        String quotedCurrency2 = getQuotedCurrency();
        String quotedCurrency3 = platformInfo.getQuotedCurrency();
        if (quotedCurrency2 != null ? !quotedCurrency2.equals(quotedCurrency3) : quotedCurrency3 != null) {
            return false;
        }
        String language2 = getLanguage();
        String language3 = platformInfo.getLanguage();
        if (language2 != null ? !language2.equals(language3) : language3 != null) {
            return false;
        }
        String email2 = getEmail();
        String email3 = platformInfo.getEmail();
        if (email2 != null ? !email2.equals(email3) : email3 != null) {
            return false;
        }
        String fullname2 = getFullname();
        String fullname3 = platformInfo.getFullname();
        if (fullname2 != null ? !fullname2.equals(fullname3) : fullname3 != null) {
            return false;
        }
        String countryCode2 = getCountryCode();
        String countryCode3 = platformInfo.getCountryCode();
        if (countryCode2 != null ? !countryCode2.equals(countryCode3) : countryCode3 != null) {
            return false;
        }
        String phone2 = getPhone();
        String phone3 = platformInfo.getPhone();
        if (phone2 != null ? !phone2.equals(phone3) : phone3 != null) {
            return false;
        }
        if (getUserType() != platformInfo.getUserType()) {
            return false;
        }
        AccountNftInfoBean nftInfo2 = getNftInfo();
        AccountNftInfoBean nftInfo3 = platformInfo.getNftInfo();
        if (nftInfo2 != null ? !nftInfo2.equals(nftInfo3) : nftInfo3 != null) {
            return false;
        }
        String userName2 = getUserName();
        String userName3 = platformInfo.getUserName();
        if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
            return false;
        }
        String did2 = getDid();
        String did3 = platformInfo.getDid();
        if (did2 != null ? !did2.equals(did3) : did3 != null) {
            return false;
        }
        String avatar2 = getAvatar();
        String avatar3 = platformInfo.getAvatar();
        if (avatar2 != null ? !avatar2.equals(avatar3) : avatar3 != null) {
            return false;
        }
        String kycCountry2 = getKycCountry();
        String kycCountry3 = platformInfo.getKycCountry();
        if (kycCountry2 != null ? !kycCountry2.equals(kycCountry3) : kycCountry3 != null) {
            return false;
        }
        String ipCountry2 = getIpCountry();
        String ipCountry3 = platformInfo.getIpCountry();
        if (ipCountry2 != null ? !ipCountry2.equals(ipCountry3) : ipCountry3 != null) {
            return false;
        }
        String accountName2 = getAccountName();
        String accountName3 = platformInfo.getAccountName();
        if (accountName2 != null ? !accountName2.equals(accountName3) : accountName3 != null) {
            return false;
        }
        if (isPasskeyUsable() != platformInfo.isPasskeyUsable() || getNavigationbarHeight() != platformInfo.getNavigationbarHeight() || getStatusBarHeightPx() != platformInfo.getStatusBarHeightPx() || getNavigationBarHeightPx() != platformInfo.getNavigationBarHeightPx()) {
            return false;
        }
        String vtoken2 = getVtoken();
        String vtoken3 = platformInfo.getVtoken();
        return vtoken2 != null ? vtoken2.equals(vtoken3) : vtoken3 == null;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public int getAppVersion() {
        return this.appVersion;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int getColorRise() {
        return this.colorRise;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getDid() {
        return this.did;
    }

    public String getEmail() {
        return this.email;
    }

    public String getFp() {
        return this.f44608fp;
    }

    public String getFpmd5() {
        return this.fpmd5;
    }

    public String getFullname() {
        return this.fullname;
    }

    public String getGlobalApi() {
        return this.globalApi;
    }

    public String getHbdmApi() {
        return this.hbdmApi;
    }

    public String getIpCountry() {
        return this.ipCountry;
    }

    public int getIsLogin() {
        return this.isLogin;
    }

    public String getKycCountry() {
        return this.kycCountry;
    }

    public String getLanguage() {
        return this.language;
    }

    public int getNavigationBarHeightPx() {
        return this.navigationBarHeightPx;
    }

    public int getNavigationbarHeight() {
        return this.navigationbarHeight;
    }

    public AccountNftInfoBean getNftInfo() {
        return this.nftInfo;
    }

    public String getOtcApi() {
        return this.otcApi;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPhoneModelName() {
        return this.phoneModelName;
    }

    public String getQuotedCurrency() {
        return this.quotedCurrency;
    }

    public int getStatusBarHeightPx() {
        return this.statusBarHeightPx;
    }

    public String getTheme() {
        return this.theme;
    }

    public String getUid() {
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

    public String getVtoken() {
        return this.vtoken;
    }

    public int hashCode() {
        String globalApi2 = getGlobalApi();
        int i11 = 43;
        int appVersion2 = ((getAppVersion() + 59) * 59) + (globalApi2 == null ? 43 : globalApi2.hashCode());
        String otcApi2 = getOtcApi();
        int hashCode = (appVersion2 * 59) + (otcApi2 == null ? 43 : otcApi2.hashCode());
        String hbdmApi2 = getHbdmApi();
        int hashCode2 = (((hashCode * 59) + (hbdmApi2 == null ? 43 : hbdmApi2.hashCode())) * 59) + getIsLogin();
        String theme2 = getTheme();
        int hashCode3 = (hashCode2 * 59) + (theme2 == null ? 43 : theme2.hashCode());
        String uid2 = getUid();
        int hashCode4 = (hashCode3 * 59) + (uid2 == null ? 43 : uid2.hashCode());
        String uuid2 = getUuid();
        int hashCode5 = (hashCode4 * 59) + (uuid2 == null ? 43 : uuid2.hashCode());
        String fp2 = getFp();
        int hashCode6 = (hashCode5 * 59) + (fp2 == null ? 43 : fp2.hashCode());
        String fpmd52 = getFpmd5();
        int hashCode7 = (hashCode6 * 59) + (fpmd52 == null ? 43 : fpmd52.hashCode());
        String phoneModelName2 = getPhoneModelName();
        int hashCode8 = (((hashCode7 * 59) + (phoneModelName2 == null ? 43 : phoneModelName2.hashCode())) * 59) + getColorRise();
        String quotedCurrency2 = getQuotedCurrency();
        int hashCode9 = (hashCode8 * 59) + (quotedCurrency2 == null ? 43 : quotedCurrency2.hashCode());
        String language2 = getLanguage();
        int hashCode10 = (hashCode9 * 59) + (language2 == null ? 43 : language2.hashCode());
        String email2 = getEmail();
        int hashCode11 = (hashCode10 * 59) + (email2 == null ? 43 : email2.hashCode());
        String fullname2 = getFullname();
        int hashCode12 = (hashCode11 * 59) + (fullname2 == null ? 43 : fullname2.hashCode());
        String countryCode2 = getCountryCode();
        int hashCode13 = (hashCode12 * 59) + (countryCode2 == null ? 43 : countryCode2.hashCode());
        String phone2 = getPhone();
        int hashCode14 = (((hashCode13 * 59) + (phone2 == null ? 43 : phone2.hashCode())) * 59) + getUserType();
        AccountNftInfoBean nftInfo2 = getNftInfo();
        int hashCode15 = (hashCode14 * 59) + (nftInfo2 == null ? 43 : nftInfo2.hashCode());
        String userName2 = getUserName();
        int hashCode16 = (hashCode15 * 59) + (userName2 == null ? 43 : userName2.hashCode());
        String did2 = getDid();
        int hashCode17 = (hashCode16 * 59) + (did2 == null ? 43 : did2.hashCode());
        String avatar2 = getAvatar();
        int hashCode18 = (hashCode17 * 59) + (avatar2 == null ? 43 : avatar2.hashCode());
        String kycCountry2 = getKycCountry();
        int hashCode19 = (hashCode18 * 59) + (kycCountry2 == null ? 43 : kycCountry2.hashCode());
        String ipCountry2 = getIpCountry();
        int hashCode20 = (hashCode19 * 59) + (ipCountry2 == null ? 43 : ipCountry2.hashCode());
        String accountName2 = getAccountName();
        int hashCode21 = (((((((((hashCode20 * 59) + (accountName2 == null ? 43 : accountName2.hashCode())) * 59) + (isPasskeyUsable() ? 79 : 97)) * 59) + getNavigationbarHeight()) * 59) + getStatusBarHeightPx()) * 59) + getNavigationBarHeightPx();
        String vtoken2 = getVtoken();
        int i12 = hashCode21 * 59;
        if (vtoken2 != null) {
            i11 = vtoken2.hashCode();
        }
        return i12 + i11;
    }

    public boolean isPasskeyUsable() {
        return this.passkeyUsable;
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setAppVersion(int i11) {
        this.appVersion = i11;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setColorRise(int i11) {
        this.colorRise = i11;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setDid(String str) {
        this.did = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setFp(String str) {
        this.f44608fp = str;
    }

    public void setFpmd5(String str) {
        this.fpmd5 = str;
    }

    public void setFullname(String str) {
        this.fullname = str;
    }

    public void setGlobalApi(String str) {
        this.globalApi = str;
    }

    public void setHbdmApi(String str) {
        this.hbdmApi = str;
    }

    public void setIpCountry(String str) {
        this.ipCountry = str;
    }

    public void setIsLogin(int i11) {
        this.isLogin = i11;
    }

    public void setKycCountry(String str) {
        this.kycCountry = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setNavigationBarHeightPx(int i11) {
        this.navigationBarHeightPx = i11;
    }

    public void setNavigationbarHeight(int i11) {
        this.navigationbarHeight = i11;
    }

    public void setNftInfo(AccountNftInfoBean accountNftInfoBean) {
        this.nftInfo = accountNftInfoBean;
    }

    public void setOtcApi(String str) {
        this.otcApi = str;
    }

    public void setPasskeyUsable(boolean z11) {
        this.passkeyUsable = z11;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setPhoneModelName(String str) {
        this.phoneModelName = str;
    }

    public void setQuotedCurrency(String str) {
        this.quotedCurrency = str;
    }

    public void setStatusBarHeightPx(int i11) {
        this.statusBarHeightPx = i11;
    }

    public void setTheme(String str) {
        this.theme = str;
    }

    public void setUid(String str) {
        this.uid = str;
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

    public void setVtoken(String str) {
        this.vtoken = str;
    }

    public String toString() {
        return "PlatformInfo(appVersion=" + getAppVersion() + ", globalApi=" + getGlobalApi() + ", otcApi=" + getOtcApi() + ", hbdmApi=" + getHbdmApi() + ", isLogin=" + getIsLogin() + ", theme=" + getTheme() + ", uid=" + getUid() + ", uuid=" + getUuid() + ", fp=" + getFp() + ", fpmd5=" + getFpmd5() + ", phoneModelName=" + getPhoneModelName() + ", colorRise=" + getColorRise() + ", quotedCurrency=" + getQuotedCurrency() + ", language=" + getLanguage() + ", email=" + getEmail() + ", fullname=" + getFullname() + ", countryCode=" + getCountryCode() + ", phone=" + getPhone() + ", userType=" + getUserType() + ", nftInfo=" + getNftInfo() + ", userName=" + getUserName() + ", did=" + getDid() + ", avatar=" + getAvatar() + ", kycCountry=" + getKycCountry() + ", ipCountry=" + getIpCountry() + ", accountName=" + getAccountName() + ", passkeyUsable=" + isPasskeyUsable() + ", navigationbarHeight=" + getNavigationbarHeight() + ", statusBarHeightPx=" + getStatusBarHeightPx() + ", navigationBarHeightPx=" + getNavigationBarHeightPx() + ", vtoken=" + getVtoken() + ")";
    }
}
