package com.hbg.lib.network.pro.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class CancelOpenOrdersResult implements Serializable {
    private static final long serialVersionUID = 3598841108910496856L;
    @SerializedName("failed-count")
    private int failedCount;
    @SerializedName("next-id")
    private long nextId;
    @SerializedName("success-count")
    private int successAount;

    public boolean canEqual(Object obj) {
        return obj instanceof CancelOpenOrdersResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CancelOpenOrdersResult)) {
            return false;
        }
        CancelOpenOrdersResult cancelOpenOrdersResult = (CancelOpenOrdersResult) obj;
        return cancelOpenOrdersResult.canEqual(this) && getSuccessAount() == cancelOpenOrdersResult.getSuccessAount() && getFailedCount() == cancelOpenOrdersResult.getFailedCount() && getNextId() == cancelOpenOrdersResult.getNextId();
    }

    public int getFailedCount() {
        return this.failedCount;
    }

    public long getNextId() {
        return this.nextId;
    }

    public int getSuccessAount() {
        return this.successAount;
    }

    public int hashCode() {
        int successAount2 = ((getSuccessAount() + 59) * 59) + getFailedCount();
        long nextId2 = getNextId();
        return (successAount2 * 59) + ((int) ((nextId2 >>> 32) ^ nextId2));
    }

    public void setFailedCount(int i11) {
        this.failedCount = i11;
    }

    public void setNextId(long j11) {
        this.nextId = j11;
    }

    public void setSuccessAount(int i11) {
        this.successAount = i11;
    }

    public String toString() {
        return "CancelOpenOrdersResult(successAount=" + getSuccessAount() + ", failedCount=" + getFailedCount() + ", nextId=" + getNextId() + ")";
    }
}
