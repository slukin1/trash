package com.huobi.setting.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class FlutterSettingVerifyToken implements Serializable {
    @SerializedName("token")
    private String token;

    public boolean canEqual(Object obj) {
        return obj instanceof FlutterSettingVerifyToken;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlutterSettingVerifyToken)) {
            return false;
        }
        FlutterSettingVerifyToken flutterSettingVerifyToken = (FlutterSettingVerifyToken) obj;
        if (!flutterSettingVerifyToken.canEqual(this)) {
            return false;
        }
        String token2 = getToken();
        String token3 = flutterSettingVerifyToken.getToken();
        return token2 != null ? token2.equals(token3) : token3 == null;
    }

    public String getToken() {
        return this.token;
    }

    public int hashCode() {
        String token2 = getToken();
        return 59 + (token2 == null ? 43 : token2.hashCode());
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        return "FlutterSettingVerifyToken(token=" + getToken() + ")";
    }
}
