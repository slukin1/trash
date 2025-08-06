package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class ServerCurDate implements Serializable {
    private static final long serialVersionUID = 6318556340187588605L;
    private long curDate;

    public boolean canEqual(Object obj) {
        return obj instanceof ServerCurDate;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ServerCurDate)) {
            return false;
        }
        ServerCurDate serverCurDate = (ServerCurDate) obj;
        return serverCurDate.canEqual(this) && getCurDate() == serverCurDate.getCurDate();
    }

    public long getCurDate() {
        return this.curDate;
    }

    public int hashCode() {
        long curDate2 = getCurDate();
        return 59 + ((int) (curDate2 ^ (curDate2 >>> 32)));
    }

    public void setCurDate(long j11) {
        this.curDate = j11;
    }

    public String toString() {
        return "ServerCurDate(curDate=" + getCurDate() + ")";
    }
}
