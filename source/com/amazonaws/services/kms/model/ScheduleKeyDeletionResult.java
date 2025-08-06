package com.amazonaws.services.kms.model;

import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.Date;

public class ScheduleKeyDeletionResult implements Serializable {
    private Date deletionDate;
    private String keyId;
    private String keyState;
    private Integer pendingWindowInDays;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ScheduleKeyDeletionResult)) {
            return false;
        }
        ScheduleKeyDeletionResult scheduleKeyDeletionResult = (ScheduleKeyDeletionResult) obj;
        if ((scheduleKeyDeletionResult.getKeyId() == null) ^ (getKeyId() == null)) {
            return false;
        }
        if (scheduleKeyDeletionResult.getKeyId() != null && !scheduleKeyDeletionResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if ((scheduleKeyDeletionResult.getDeletionDate() == null) ^ (getDeletionDate() == null)) {
            return false;
        }
        if (scheduleKeyDeletionResult.getDeletionDate() != null && !scheduleKeyDeletionResult.getDeletionDate().equals(getDeletionDate())) {
            return false;
        }
        if ((scheduleKeyDeletionResult.getKeyState() == null) ^ (getKeyState() == null)) {
            return false;
        }
        if (scheduleKeyDeletionResult.getKeyState() != null && !scheduleKeyDeletionResult.getKeyState().equals(getKeyState())) {
            return false;
        }
        if ((scheduleKeyDeletionResult.getPendingWindowInDays() == null) ^ (getPendingWindowInDays() == null)) {
            return false;
        }
        return scheduleKeyDeletionResult.getPendingWindowInDays() == null || scheduleKeyDeletionResult.getPendingWindowInDays().equals(getPendingWindowInDays());
    }

    public Date getDeletionDate() {
        return this.deletionDate;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getKeyState() {
        return this.keyState;
    }

    public Integer getPendingWindowInDays() {
        return this.pendingWindowInDays;
    }

    public int hashCode() {
        int i11 = 0;
        int hashCode = ((((((getKeyId() == null ? 0 : getKeyId().hashCode()) + 31) * 31) + (getDeletionDate() == null ? 0 : getDeletionDate().hashCode())) * 31) + (getKeyState() == null ? 0 : getKeyState().hashCode())) * 31;
        if (getPendingWindowInDays() != null) {
            i11 = getPendingWindowInDays().hashCode();
        }
        return hashCode + i11;
    }

    public void setDeletionDate(Date date) {
        this.deletionDate = date;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setKeyState(String str) {
        this.keyState = str;
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
        if (getDeletionDate() != null) {
            sb2.append("DeletionDate: " + getDeletionDate() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getKeyState() != null) {
            sb2.append("KeyState: " + getKeyState() + Constants.ACCEPT_TIME_SEPARATOR_SP);
        }
        if (getPendingWindowInDays() != null) {
            sb2.append("PendingWindowInDays: " + getPendingWindowInDays());
        }
        sb2.append("}");
        return sb2.toString();
    }

    public ScheduleKeyDeletionResult withDeletionDate(Date date) {
        this.deletionDate = date;
        return this;
    }

    public ScheduleKeyDeletionResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ScheduleKeyDeletionResult withKeyState(String str) {
        this.keyState = str;
        return this;
    }

    public ScheduleKeyDeletionResult withPendingWindowInDays(Integer num) {
        this.pendingWindowInDays = num;
        return this;
    }

    public void setKeyState(KeyState keyState2) {
        this.keyState = keyState2.toString();
    }

    public ScheduleKeyDeletionResult withKeyState(KeyState keyState2) {
        this.keyState = keyState2.toString();
        return this;
    }
}
