package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class SpotAssertInfo implements Serializable {
    private String depositTag;

    public boolean canEqual(Object obj) {
        return obj instanceof SpotAssertInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpotAssertInfo)) {
            return false;
        }
        SpotAssertInfo spotAssertInfo = (SpotAssertInfo) obj;
        if (!spotAssertInfo.canEqual(this)) {
            return false;
        }
        String depositTag2 = getDepositTag();
        String depositTag3 = spotAssertInfo.getDepositTag();
        return depositTag2 != null ? depositTag2.equals(depositTag3) : depositTag3 == null;
    }

    public String getDepositTag() {
        return this.depositTag;
    }

    public int hashCode() {
        String depositTag2 = getDepositTag();
        return 59 + (depositTag2 == null ? 43 : depositTag2.hashCode());
    }

    public void setDepositTag(String str) {
        this.depositTag = str;
    }

    public String toString() {
        return "SpotAssertInfo(depositTag=" + getDepositTag() + ")";
    }
}
