package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcChatOnlineCheck implements Serializable {
    private boolean status;
    private long userId;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcChatOnlineCheck;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcChatOnlineCheck)) {
            return false;
        }
        OtcChatOnlineCheck otcChatOnlineCheck = (OtcChatOnlineCheck) obj;
        return otcChatOnlineCheck.canEqual(this) && getUserId() == otcChatOnlineCheck.getUserId() && isStatus() == otcChatOnlineCheck.isStatus();
    }

    public long getUserId() {
        return this.userId;
    }

    public int hashCode() {
        long userId2 = getUserId();
        return ((((int) (userId2 ^ (userId2 >>> 32))) + 59) * 59) + (isStatus() ? 79 : 97);
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setStatus(boolean z11) {
        this.status = z11;
    }

    public void setUserId(long j11) {
        this.userId = j11;
    }

    public String toString() {
        return "OtcChatOnlineCheck(userId=" + getUserId() + ", status=" + isStatus() + ")";
    }
}
