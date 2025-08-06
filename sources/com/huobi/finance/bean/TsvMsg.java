package com.huobi.finance.bean;

import java.io.Serializable;

public class TsvMsg implements Serializable {
    public String tsvMsg;

    public boolean canEqual(Object obj) {
        return obj instanceof TsvMsg;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TsvMsg)) {
            return false;
        }
        TsvMsg tsvMsg2 = (TsvMsg) obj;
        if (!tsvMsg2.canEqual(this)) {
            return false;
        }
        String tsvMsg3 = getTsvMsg();
        String tsvMsg4 = tsvMsg2.getTsvMsg();
        return tsvMsg3 != null ? tsvMsg3.equals(tsvMsg4) : tsvMsg4 == null;
    }

    public String getTsvMsg() {
        return this.tsvMsg;
    }

    public int hashCode() {
        String tsvMsg2 = getTsvMsg();
        return 59 + (tsvMsg2 == null ? 43 : tsvMsg2.hashCode());
    }

    public void setTsvMsg(String str) {
        this.tsvMsg = str;
    }

    public String toString() {
        return "TsvMsg(tsvMsg=" + getTsvMsg() + ")";
    }
}
