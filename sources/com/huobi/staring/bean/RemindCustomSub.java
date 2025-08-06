package com.huobi.staring.bean;

import java.io.Serializable;

public class RemindCustomSub implements Serializable {
    private boolean customSub;

    public RemindCustomSub(boolean z11) {
        this.customSub = z11;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof RemindCustomSub;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemindCustomSub)) {
            return false;
        }
        RemindCustomSub remindCustomSub = (RemindCustomSub) obj;
        return remindCustomSub.canEqual(this) && isCustomSub() == remindCustomSub.isCustomSub();
    }

    public int hashCode() {
        return 59 + (isCustomSub() ? 79 : 97);
    }

    public boolean isCustomSub() {
        return this.customSub;
    }

    public void setCustomSub(boolean z11) {
        this.customSub = z11;
    }

    public String toString() {
        return "RemindCustomSub(customSub=" + isCustomSub() + ")";
    }
}
