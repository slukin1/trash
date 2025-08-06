package com.huobi.setting.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class FlutterSettingConfig implements Serializable {
    @SerializedName("fingerprint")
    private String fingerprint;
    @SerializedName("isSubAccountType")
    private boolean isSubAccountType;
    @SerializedName("uid")
    private String uid;
    @SerializedName("userName")
    private String userName;
    @SerializedName("vToken")
    private String vToken;

    public boolean canEqual(Object obj) {
        return obj instanceof FlutterSettingConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlutterSettingConfig)) {
            return false;
        }
        FlutterSettingConfig flutterSettingConfig = (FlutterSettingConfig) obj;
        if (!flutterSettingConfig.canEqual(this)) {
            return false;
        }
        String uid2 = getUid();
        String uid3 = flutterSettingConfig.getUid();
        if (uid2 != null ? !uid2.equals(uid3) : uid3 != null) {
            return false;
        }
        String userName2 = getUserName();
        String userName3 = flutterSettingConfig.getUserName();
        if (userName2 != null ? !userName2.equals(userName3) : userName3 != null) {
            return false;
        }
        String fingerprint2 = getFingerprint();
        String fingerprint3 = flutterSettingConfig.getFingerprint();
        if (fingerprint2 != null ? !fingerprint2.equals(fingerprint3) : fingerprint3 != null) {
            return false;
        }
        String str = getvToken();
        String str2 = flutterSettingConfig.getvToken();
        if (str != null ? str.equals(str2) : str2 == null) {
            return getSubAccountType() == flutterSettingConfig.getSubAccountType();
        }
        return false;
    }

    public String getFingerprint() {
        return this.fingerprint;
    }

    public boolean getSubAccountType() {
        return this.isSubAccountType;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getvToken() {
        return this.vToken;
    }

    public int hashCode() {
        String uid2 = getUid();
        int i11 = 43;
        int hashCode = uid2 == null ? 43 : uid2.hashCode();
        String userName2 = getUserName();
        int hashCode2 = ((hashCode + 59) * 59) + (userName2 == null ? 43 : userName2.hashCode());
        String fingerprint2 = getFingerprint();
        int hashCode3 = (hashCode2 * 59) + (fingerprint2 == null ? 43 : fingerprint2.hashCode());
        String str = getvToken();
        int i12 = hashCode3 * 59;
        if (str != null) {
            i11 = str.hashCode();
        }
        return ((i12 + i11) * 59) + (getSubAccountType() ? 79 : 97);
    }

    public void setFingerprint(String str) {
        this.fingerprint = str;
    }

    public void setSubAccountType(boolean z11) {
        this.isSubAccountType = z11;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setvToken(String str) {
        this.vToken = str;
    }

    public String toString() {
        return "FlutterSettingConfig(uid=" + getUid() + ", userName=" + getUserName() + ", fingerprint=" + getFingerprint() + ", vToken=" + getvToken() + ", isSubAccountType=" + getSubAccountType() + ")";
    }
}
