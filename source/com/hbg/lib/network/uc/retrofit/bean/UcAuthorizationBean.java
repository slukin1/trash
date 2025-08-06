package com.hbg.lib.network.uc.retrofit.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UcAuthorizationBean implements Serializable {
    @SerializedName("auth_token")
    private String authToken = "";

    public boolean canEqual(Object obj) {
        return obj instanceof UcAuthorizationBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UcAuthorizationBean)) {
            return false;
        }
        UcAuthorizationBean ucAuthorizationBean = (UcAuthorizationBean) obj;
        if (!ucAuthorizationBean.canEqual(this)) {
            return false;
        }
        String authToken2 = getAuthToken();
        String authToken3 = ucAuthorizationBean.getAuthToken();
        return authToken2 != null ? authToken2.equals(authToken3) : authToken3 == null;
    }

    public String getAuthToken() {
        return this.authToken;
    }

    public int hashCode() {
        String authToken2 = getAuthToken();
        return 59 + (authToken2 == null ? 43 : authToken2.hashCode());
    }

    public void setAuthToken(String str) {
        this.authToken = str;
    }

    public String toString() {
        return "UcAuthorizationBean(authToken=" + getAuthToken() + ")";
    }
}
