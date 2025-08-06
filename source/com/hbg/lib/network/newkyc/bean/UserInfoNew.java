package com.hbg.lib.network.newkyc.bean;

import java.io.Serializable;
import java.util.Map;

public class UserInfoNew implements Serializable {
    public static final String KO_AUTH_COUNTRY = "4";
    public static final String MAIN_AUTH_COUNTRY = "1";
    public static final String PRO_AUTH_COUNTRY = "2";
    private boolean asset_pwd_set;
    private Map<Object, String> auth_country;
    private String countryName;
    private String email;
    private boolean is_older_than_60;
    private String phone;
    private String uid;
    private String user_id;
    private boolean white;

    public Map<Object, String> getAuth_country() {
        return this.auth_country;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getUid() {
        return this.uid;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public boolean isAsset_pwd_set() {
        return this.asset_pwd_set;
    }

    public boolean isWhite() {
        return this.white;
    }

    public boolean is_older_than_60() {
        return this.is_older_than_60;
    }

    public void setAsset_pwd_set(boolean z11) {
        this.asset_pwd_set = z11;
    }

    public void setAuth_country(Map<Object, String> map) {
        this.auth_country = map;
    }

    public void setCountryName(String str) {
        this.countryName = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setIs_older_than_60(boolean z11) {
        this.is_older_than_60 = z11;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }

    public void setWhite(boolean z11) {
        this.white = z11;
    }
}
