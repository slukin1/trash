package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class ProfitUserInfo implements Serializable {
    private static final int ACTIVE_STATE = 1;
    private int activation;
    private long activationTime;

    public boolean canEqual(Object obj) {
        return obj instanceof ProfitUserInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProfitUserInfo)) {
            return false;
        }
        ProfitUserInfo profitUserInfo = (ProfitUserInfo) obj;
        return profitUserInfo.canEqual(this) && getActivation() == profitUserInfo.getActivation() && getActivationTime() == profitUserInfo.getActivationTime();
    }

    public int getActivation() {
        return this.activation;
    }

    public long getActivationTime() {
        return this.activationTime;
    }

    public int hashCode() {
        long activationTime2 = getActivationTime();
        return ((getActivation() + 59) * 59) + ((int) ((activationTime2 >>> 32) ^ activationTime2));
    }

    public boolean isActive() {
        return this.activation == 1;
    }

    public void setActivation(int i11) {
        this.activation = i11;
    }

    public void setActivationTime(long j11) {
        this.activationTime = j11;
    }

    public String toString() {
        return "ProfitUserInfo(activation=" + getActivation() + ", activationTime=" + getActivationTime() + ")";
    }
}
