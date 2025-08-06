package com.hbg.lib.network.newkyc.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class KycTokenInfo implements Serializable {
    private static final long serialVersionUID = -3222490328124000633L;
    @SerializedName("token")
    public String token;

    public boolean canEqual(Object obj) {
        return obj instanceof KycTokenInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KycTokenInfo)) {
            return false;
        }
        KycTokenInfo kycTokenInfo = (KycTokenInfo) obj;
        if (!kycTokenInfo.canEqual(this)) {
            return false;
        }
        String token2 = getToken();
        String token3 = kycTokenInfo.getToken();
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
        return "KycTokenInfo(token=" + getToken() + ")";
    }
}
