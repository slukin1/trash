package com.huobi.login.bean;

import java.io.Serializable;

public class AccountVerifyBean implements Serializable {
    private static final long serialVersionUID = -7136197752688957742L;
    private String account_name;
    private String email;
    private String phone;
    private boolean registered;
    private String token;
    private boolean verify_email;
    private boolean verify_ga;
    private boolean verify_phone;

    public String getAccount_name() {
        return this.account_name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isRegistered() {
        return this.registered;
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

    public void setAccount_name(String str) {
        this.account_name = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setRegistered(boolean z11) {
        this.registered = z11;
    }

    public void setToken(String str) {
        this.token = str;
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
}
