package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SecurityStrategy implements Serializable {
    private static final long serialVersionUID = 7627710463928732461L;
    @SerializedName("verify_passkey")
    public boolean verifyPasskey;
    @SerializedName("verify_password")
    private boolean verifyPassword;
    private boolean verify_assets_password;
    private boolean verify_email;
    private boolean verify_ga;
    private boolean verify_phone;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public boolean isVerifyPassword() {
        return this.verifyPassword;
    }

    public boolean isVerify_assets_password() {
        return this.verify_assets_password;
    }

    public boolean isVerify_email() {
        return this.verify_email;
    }

    public boolean isVerify_ga() {
        return this.verify_ga;
    }

    public boolean isVerify_phone() {
        return this.verify_phone;
    }

    public void setVerifyPassword(boolean z11) {
        this.verifyPassword = z11;
    }

    public void setVerify_assets_password(boolean z11) {
        this.verify_assets_password = z11;
    }

    public void setVerify_email(boolean z11) {
        this.verify_email = z11;
    }

    public void setVerify_ga(boolean z11) {
        this.verify_ga = z11;
    }

    public void setVerify_phone(boolean z11) {
        this.verify_phone = z11;
    }

    public String toString() {
        return "SecurityStrategy{verify_phone=" + this.verify_phone + ", verify_assets_password=" + this.verify_assets_password + ", verify_ga=" + this.verify_ga + ", verify_email=" + this.verify_email + '}';
    }
}
