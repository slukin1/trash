package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class CheckInviteCodeResult implements Serializable {
    public boolean valid;

    public boolean canEqual(Object obj) {
        return obj instanceof CheckInviteCodeResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CheckInviteCodeResult)) {
            return false;
        }
        CheckInviteCodeResult checkInviteCodeResult = (CheckInviteCodeResult) obj;
        return checkInviteCodeResult.canEqual(this) && isValid() == checkInviteCodeResult.isValid();
    }

    public int hashCode() {
        return 59 + (isValid() ? 79 : 97);
    }

    public boolean isValid() {
        return this.valid;
    }

    public void setValid(boolean z11) {
        this.valid = z11;
    }

    public String toString() {
        return "CheckInviteCodeResult(valid=" + isValid() + ")";
    }
}
