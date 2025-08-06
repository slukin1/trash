package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class OtcAuthJumioBean implements Serializable {
    public int authLevel;
    public int authState;
    public String userId;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcAuthJumioBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcAuthJumioBean)) {
            return false;
        }
        OtcAuthJumioBean otcAuthJumioBean = (OtcAuthJumioBean) obj;
        if (!otcAuthJumioBean.canEqual(this)) {
            return false;
        }
        String userId2 = getUserId();
        String userId3 = otcAuthJumioBean.getUserId();
        if (userId2 != null ? userId2.equals(userId3) : userId3 == null) {
            return getAuthState() == otcAuthJumioBean.getAuthState() && getAuthLevel() == otcAuthJumioBean.getAuthLevel();
        }
        return false;
    }

    public int getAuthLevel() {
        return this.authLevel;
    }

    public int getAuthState() {
        return this.authState;
    }

    public String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String userId2 = getUserId();
        return (((((userId2 == null ? 43 : userId2.hashCode()) + 59) * 59) + getAuthState()) * 59) + getAuthLevel();
    }

    public void setAuthLevel(int i11) {
        this.authLevel = i11;
    }

    public void setAuthState(int i11) {
        this.authState = i11;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        return "OtcAuthJumioBean(userId=" + getUserId() + ", authState=" + getAuthState() + ", authLevel=" + getAuthLevel() + ")";
    }
}
