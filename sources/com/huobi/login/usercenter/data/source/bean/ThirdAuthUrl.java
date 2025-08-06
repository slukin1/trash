package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ThirdAuthUrl implements Serializable {
    @SerializedName("auth_url")
    private String authUrl;
    @SerializedName("state")
    private String state;

    public boolean canEqual(Object obj) {
        return obj instanceof ThirdAuthUrl;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ThirdAuthUrl)) {
            return false;
        }
        ThirdAuthUrl thirdAuthUrl = (ThirdAuthUrl) obj;
        if (!thirdAuthUrl.canEqual(this)) {
            return false;
        }
        String authUrl2 = getAuthUrl();
        String authUrl3 = thirdAuthUrl.getAuthUrl();
        if (authUrl2 != null ? !authUrl2.equals(authUrl3) : authUrl3 != null) {
            return false;
        }
        String state2 = getState();
        String state3 = thirdAuthUrl.getState();
        return state2 != null ? state2.equals(state3) : state3 == null;
    }

    public String getAuthUrl() {
        return this.authUrl;
    }

    public String getState() {
        return this.state;
    }

    public int hashCode() {
        String authUrl2 = getAuthUrl();
        int i11 = 43;
        int hashCode = authUrl2 == null ? 43 : authUrl2.hashCode();
        String state2 = getState();
        int i12 = (hashCode + 59) * 59;
        if (state2 != null) {
            i11 = state2.hashCode();
        }
        return i12 + i11;
    }

    public void setAuthUrl(String str) {
        this.authUrl = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String toString() {
        return "ThirdAuthUrl(authUrl=" + getAuthUrl() + ", state=" + getState() + ")";
    }
}
