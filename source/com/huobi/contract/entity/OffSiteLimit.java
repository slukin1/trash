package com.huobi.contract.entity;

import java.io.Serializable;

public class OffSiteLimit implements Serializable {
    public boolean tipFlag;
    public String tipMsg;

    public boolean canEqual(Object obj) {
        return obj instanceof OffSiteLimit;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OffSiteLimit)) {
            return false;
        }
        OffSiteLimit offSiteLimit = (OffSiteLimit) obj;
        if (!offSiteLimit.canEqual(this) || isTipFlag() != offSiteLimit.isTipFlag()) {
            return false;
        }
        String tipMsg2 = getTipMsg();
        String tipMsg3 = offSiteLimit.getTipMsg();
        return tipMsg2 != null ? tipMsg2.equals(tipMsg3) : tipMsg3 == null;
    }

    public String getTipMsg() {
        return this.tipMsg;
    }

    public int hashCode() {
        int i11 = isTipFlag() ? 79 : 97;
        String tipMsg2 = getTipMsg();
        return ((i11 + 59) * 59) + (tipMsg2 == null ? 43 : tipMsg2.hashCode());
    }

    public boolean isTipFlag() {
        return this.tipFlag;
    }

    public void setTipFlag(boolean z11) {
        this.tipFlag = z11;
    }

    public void setTipMsg(String str) {
        this.tipMsg = str;
    }

    public String toString() {
        return "OffSiteLimit(tipFlag=" + isTipFlag() + ", tipMsg=" + getTipMsg() + ")";
    }
}
