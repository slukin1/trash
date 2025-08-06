package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class MessageRedDotData implements Serializable {
    private int count;
    private boolean hadRedDot;

    public boolean canEqual(Object obj) {
        return obj instanceof MessageRedDotData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MessageRedDotData)) {
            return false;
        }
        MessageRedDotData messageRedDotData = (MessageRedDotData) obj;
        return messageRedDotData.canEqual(this) && getCount() == messageRedDotData.getCount() && isHadRedDot() == messageRedDotData.isHadRedDot();
    }

    public int getCount() {
        return this.count;
    }

    public int hashCode() {
        return ((getCount() + 59) * 59) + (isHadRedDot() ? 79 : 97);
    }

    public boolean isHadRedDot() {
        return this.hadRedDot;
    }

    public void setCount(int i11) {
        this.count = i11;
    }

    public void setHadRedDot(boolean z11) {
        this.hadRedDot = z11;
    }

    public String toString() {
        return "MessageRedDotData(count=" + getCount() + ", hadRedDot=" + isHadRedDot() + ")";
    }
}
