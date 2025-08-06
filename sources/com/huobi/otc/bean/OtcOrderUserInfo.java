package com.huobi.otc.bean;

import java.io.Serializable;

public class OtcOrderUserInfo implements Serializable {
    private static final long serialVersionUID = 1220021548525778065L;
    private String realName;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcOrderUserInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcOrderUserInfo)) {
            return false;
        }
        OtcOrderUserInfo otcOrderUserInfo = (OtcOrderUserInfo) obj;
        if (!otcOrderUserInfo.canEqual(this)) {
            return false;
        }
        String realName2 = getRealName();
        String realName3 = otcOrderUserInfo.getRealName();
        return realName2 != null ? realName2.equals(realName3) : realName3 == null;
    }

    public String getRealName() {
        return this.realName;
    }

    public int hashCode() {
        String realName2 = getRealName();
        return 59 + (realName2 == null ? 43 : realName2.hashCode());
    }

    public void setRealName(String str) {
        this.realName = str;
    }

    public String toString() {
        return "OtcOrderUserInfo(realName=" + getRealName() + ")";
    }
}
