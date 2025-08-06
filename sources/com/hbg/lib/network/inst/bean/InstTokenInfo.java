package com.hbg.lib.network.inst.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class InstTokenInfo implements Serializable {
    private static final long serialVersionUID = 7484096245925542225L;
    @SerializedName("token")
    public String token;

    public boolean canEqual(Object obj) {
        return obj instanceof InstTokenInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstTokenInfo)) {
            return false;
        }
        InstTokenInfo instTokenInfo = (InstTokenInfo) obj;
        if (!instTokenInfo.canEqual(this)) {
            return false;
        }
        String token2 = getToken();
        String token3 = instTokenInfo.getToken();
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
        return "InstTokenInfo(token=" + getToken() + ")";
    }
}
