package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

public class ScheduleKeyDeletionRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private Integer pendingWindowInDays;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ScheduleKeyDeletionRequest)) {
            return false;
        }
        ScheduleKeyDeletionRequest scheduleKeyDeletionRequest = (ScheduleKeyDeletionRequest) obj;
        if ((scheduleKeyDeletionRequest.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (scheduleKeyDeletionRequest.getKeyId() != null && !scheduleKeyDeletionRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((scheduleKeyDeletionRequest.getPendingWindowInDays() == null) ^ (getPendingWindowInDays() == null)) {
            return false;
        }
        return scheduleKeyDeletionRequest.getPendingWindowInDays() == null || scheduleKeyDeletionRequest.getPendingWindowInDays().equals(getPendingWindowInDays());
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Integer getPendingWindowInDays() {
        return this.pendingWindowInDays;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31;
        if (getPendingWindowInDays() != null) {
            i11 = getPendingWindowInDays().hashCode();
        }
        return hashCode + i11;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setPendingWindowInDays(Integer num) {
        this.pendingWindowInDays = num;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("{");
        if (getKeyId() != null) {
            sb2.append("KeyId: " + getKeyId() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPendingWindowInDays() != null) {
            sb2.append("PendingWindowInDays: " + getPendingWindowInDays());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ScheduleKeyDeletionRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ScheduleKeyDeletionRequest withPendingWindowInDays(Integer num) {
        this.pendingWindowInDays = num;
        return this;
    }
}
