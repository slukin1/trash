package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class OtcAuthBean implements Serializable {
    public int code;
    public String message;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcAuthBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcAuthBean)) {
            return false;
        }
        OtcAuthBean otcAuthBean = (OtcAuthBean) obj;
        if (!otcAuthBean.canEqual(this)) {
            return false;
        }
        String message2 = getMessage();
        String message3 = otcAuthBean.getMessage();
        if (message2 != null ? message2.equals(message3) : message3 == null) {
            return getCode() == otcAuthBean.getCode();
        }
        return false;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        String message2 = getMessage();
        return (((message2 == null ? 43 : message2.hashCode()) + 59) * 59) + getCode();
    }

    public void setCode(int i11) {
        this.code = i11;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "OtcAuthBean(message=" + getMessage() + ", code=" + getCode() + ")";
    }
}
