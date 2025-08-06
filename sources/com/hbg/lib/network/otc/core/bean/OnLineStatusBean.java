package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OnLineStatusBean implements Serializable {
    private boolean isOnline;
    private long serverTime;

    public boolean canEqual(Object obj) {
        return obj instanceof OnLineStatusBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OnLineStatusBean)) {
            return false;
        }
        OnLineStatusBean onLineStatusBean = (OnLineStatusBean) obj;
        return onLineStatusBean.canEqual(this) && getServerTime() == onLineStatusBean.getServerTime() && isOnline() == onLineStatusBean.isOnline();
    }

    public long getServerTime() {
        return this.serverTime;
    }

    public int hashCode() {
        long serverTime2 = getServerTime();
        return ((((int) (serverTime2 ^ (serverTime2 >>> 32))) + 59) * 59) + (isOnline() ? 79 : 97);
    }

    public boolean isOnline() {
        return this.isOnline;
    }

    public void setOnline(boolean z11) {
        this.isOnline = z11;
    }

    public void setServerTime(long j11) {
        this.serverTime = j11;
    }

    public String toString() {
        return "OnLineStatusBean(serverTime=" + getServerTime() + ", isOnline=" + isOnline() + ")";
    }
}
