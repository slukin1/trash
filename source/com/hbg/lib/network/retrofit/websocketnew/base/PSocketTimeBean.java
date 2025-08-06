package com.hbg.lib.network.retrofit.websocketnew.base;

import java.io.Serializable;

public class PSocketTimeBean implements Serializable {
    private static final long serialVersionUID = -8190805387584897199L;
    private int resendTimes;
    private IPSocketSend socketSend;
    private long time;

    public boolean canEqual(Object obj) {
        return obj instanceof PSocketTimeBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PSocketTimeBean)) {
            return false;
        }
        PSocketTimeBean pSocketTimeBean = (PSocketTimeBean) obj;
        if (!pSocketTimeBean.canEqual(this)) {
            return false;
        }
        IPSocketSend socketSend2 = getSocketSend();
        IPSocketSend socketSend3 = pSocketTimeBean.getSocketSend();
        if (socketSend2 != null ? socketSend2.equals(socketSend3) : socketSend3 == null) {
            return getTime() == pSocketTimeBean.getTime() && getResendTimes() == pSocketTimeBean.getResendTimes();
        }
        return false;
    }

    public int getResendTimes() {
        return this.resendTimes;
    }

    public IPSocketSend getSocketSend() {
        return this.socketSend;
    }

    public long getTime() {
        return this.time;
    }

    public int hashCode() {
        IPSocketSend socketSend2 = getSocketSend();
        int hashCode = socketSend2 == null ? 43 : socketSend2.hashCode();
        long time2 = getTime();
        return ((((hashCode + 59) * 59) + ((int) (time2 ^ (time2 >>> 32)))) * 59) + getResendTimes();
    }

    public void setResendTimes(int i11) {
        this.resendTimes = i11;
    }

    public void setSocketSend(IPSocketSend iPSocketSend) {
        this.socketSend = iPSocketSend;
    }

    public void setTime(long j11) {
        this.time = j11;
    }

    public String toString() {
        return "PSocketTimeBean(socketSend=" + getSocketSend() + ", time=" + getTime() + ", resendTimes=" + getResendTimes() + ")";
    }
}
