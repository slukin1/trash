package com.huobi.login.v3.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class LoginParamsBean implements Serializable {
    private HashMap<String, Object> aliVerifyResult;
    private String countryCode;
    private String countryId;
    private String email;
    private boolean isGaOpen;
    private String loginName;
    private Map<String, Object> params2FA;
    private String phone;
    private String pwd;
    private String token;
    private String token2FA;

    public LoginParamsBean(String str, HashMap<String, Object> hashMap, String str2, String str3) {
        this.loginName = str;
        this.aliVerifyResult = hashMap;
        this.countryCode = str2;
        this.token = str3;
    }

    public Map<String, Object> get2FAParams() {
        return this.params2FA;
    }

    public String get2FAToken() {
        return this.token2FA;
    }

    public HashMap<String, Object> getAliVerifyResult() {
        return this.aliVerifyResult;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCountryId() {
        return this.countryId;
    }

    public String getEmail() {
        return this.email;
    }

    public String getLoginName() {
        return this.loginName;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPwd() {
        return this.pwd;
    }

    public String getToken() {
        return this.token;
    }

    public boolean isGaOpen() {
        return this.isGaOpen;
    }

    public void set2FAParams(Map<String, Object> map) {
        this.params2FA = map;
    }

    public void set2FAToken(String str) {
        this.token2FA = str;
    }

    public void setAliVerifyResult(HashMap<String, Object> hashMap) {
        this.aliVerifyResult = hashMap;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setCountryId(String str) {
        this.countryId = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setGaOpen(boolean z11) {
        this.isGaOpen = z11;
    }

    public void setLoginName(String str) {
        this.loginName = str;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setPwd(String str) {
        this.pwd = str;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
