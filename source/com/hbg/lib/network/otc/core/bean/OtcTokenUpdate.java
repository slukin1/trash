package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcTokenUpdate implements Serializable {
    public String otcToken;

    public OtcTokenUpdate(String str) {
        this.otcToken = str;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcTokenUpdate;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcTokenUpdate)) {
            return false;
        }
        OtcTokenUpdate otcTokenUpdate = (OtcTokenUpdate) obj;
        if (!otcTokenUpdate.canEqual(this)) {
            return false;
        }
        String otcToken2 = getOtcToken();
        String otcToken3 = otcTokenUpdate.getOtcToken();
        return otcToken2 != null ? otcToken2.equals(otcToken3) : otcToken3 == null;
    }

    public String getOtcToken() {
        return this.otcToken;
    }

    public int hashCode() {
        String otcToken2 = getOtcToken();
        return 59 + (otcToken2 == null ? 43 : otcToken2.hashCode());
    }

    public void setOtcToken(String str) {
        this.otcToken = str;
    }

    public String toString() {
        return "OtcTokenUpdate(otcToken=" + getOtcToken() + ")";
    }
}
