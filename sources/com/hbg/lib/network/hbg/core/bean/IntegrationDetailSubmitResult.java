package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class IntegrationDetailSubmitResult implements Serializable {
    private boolean isDetain;
    private long pointAmount;

    public boolean canEqual(Object obj) {
        return obj instanceof IntegrationDetailSubmitResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntegrationDetailSubmitResult)) {
            return false;
        }
        IntegrationDetailSubmitResult integrationDetailSubmitResult = (IntegrationDetailSubmitResult) obj;
        return integrationDetailSubmitResult.canEqual(this) && isDetain() == integrationDetailSubmitResult.isDetain() && getPointAmount() == integrationDetailSubmitResult.getPointAmount();
    }

    public long getPointAmount() {
        return this.pointAmount;
    }

    public int hashCode() {
        int i11 = isDetain() ? 79 : 97;
        long pointAmount2 = getPointAmount();
        return ((i11 + 59) * 59) + ((int) ((pointAmount2 >>> 32) ^ pointAmount2));
    }

    public boolean isDetain() {
        return this.isDetain;
    }

    public void setDetain(boolean z11) {
        this.isDetain = z11;
    }

    public void setPointAmount(long j11) {
        this.pointAmount = j11;
    }

    public String toString() {
        return "IntegrationDetailSubmitResult(isDetain=" + isDetain() + ", pointAmount=" + getPointAmount() + ")";
    }
}
