package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class BizTipRecord implements Serializable {
    public static final int STATE_COMPLETE = 1;
    public static final int STATE_INCOMPLETE = 0;
    public static final int STATE_SKIP = 2;
    private int closedAt;
    private int closedCount;
    private int state;

    public boolean canEqual(Object obj) {
        return obj instanceof BizTipRecord;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BizTipRecord)) {
            return false;
        }
        BizTipRecord bizTipRecord = (BizTipRecord) obj;
        return bizTipRecord.canEqual(this) && getState() == bizTipRecord.getState() && getClosedCount() == bizTipRecord.getClosedCount() && getClosedAt() == bizTipRecord.getClosedAt();
    }

    public int getClosedAt() {
        return this.closedAt;
    }

    public int getClosedCount() {
        return this.closedCount;
    }

    public int getState() {
        return this.state;
    }

    public int hashCode() {
        return ((((getState() + 59) * 59) + getClosedCount()) * 59) + getClosedAt();
    }

    public void setClosedAt(int i11) {
        this.closedAt = i11;
    }

    public void setClosedCount(int i11) {
        this.closedCount = i11;
    }

    public void setState(int i11) {
        this.state = i11;
    }

    public String toString() {
        return "BizTipRecord(state=" + getState() + ", closedCount=" + getClosedCount() + ", closedAt=" + getClosedAt() + ")";
    }
}
