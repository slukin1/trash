package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UserSecurityInfoData implements Serializable {
    private static final long serialVersionUID = 242209798208590710L;
    @SerializedName("asset_ga")
    private int assetGa;
    @SerializedName("asset_ga_state")
    private int assetGaState;
    @SerializedName("asset_password")
    private int assetPassword;
    @SerializedName("asset_password_level")
    private int assetPasswordLevel;
    @SerializedName("country_code")
    private String countryCode;
    @SerializedName("email")
    private String email;
    @SerializedName("email_state")
    private int emailState;
    @SerializedName("login_ga")
    private int loginGa;
    @SerializedName("login_password_level")
    private int loginPasswordLevel;
    @SerializedName("bind_pass_key")
    private int passkey;
    @SerializedName("phone")
    private String phone;

    public int getAssetGa() {
        return this.assetGa;
    }

    public int getAssetGaState() {
        return this.assetGaState;
    }

    public int getAssetPassword() {
        return this.assetPassword;
    }

    public int getAssetPasswordLevel() {
        return this.assetPasswordLevel;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getEmail() {
        return this.email;
    }

    public int getEmailState() {
        return this.emailState;
    }

    public int getLoginGa() {
        return this.loginGa;
    }

    public int getLoginPasswordLevel() {
        return this.loginPasswordLevel;
    }

    public int getPasskey() {
        return this.passkey;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setAssetGa(int i11) {
        this.assetGa = i11;
    }

    public void setAssetGaState(int i11) {
        this.assetGaState = i11;
    }

    public void setAssetPassword(int i11) {
        this.assetPassword = i11;
    }

    public void setAssetPasswordLevel(int i11) {
        this.assetPasswordLevel = i11;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setEmailState(int i11) {
        this.emailState = i11;
    }

    public void setLoginGa(int i11) {
        this.loginGa = i11;
    }

    public void setLoginPasswordLevel(int i11) {
        this.loginPasswordLevel = i11;
    }

    public void setPasskey(int i11) {
        this.passkey = i11;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public String toString() {
        return "UserSecurityInfoData{countryCode='" + this.countryCode + '\'' + ", phone='" + this.phone + '\'' + ", email='" + this.email + '\'' + ", emailState=" + this.emailState + ", assetGa=" + this.assetGa + ", assetGaState=" + this.assetGaState + ", loginGa=" + this.loginGa + ", assetPassword=" + this.assetPassword + ", assetPasswordLevel=" + this.assetPasswordLevel + ", loginPasswordLevel=" + this.loginPasswordLevel + '}';
    }
}
