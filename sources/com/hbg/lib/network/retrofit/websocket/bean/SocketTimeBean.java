package com.hbg.lib.network.retrofit.websocket.bean;

import java.io.Serializable;

public class SocketTimeBean implements Serializable {
    private static final long serialVersionUID = -8190805387584897199L;
    private int resendTimes;
    private ISocketSend socketSend;
    private long time;

    public boolean canEqual(Object obj) {
        return obj instanceof SocketTimeBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SocketTimeBean)) {
            return false;
        }
        SocketTimeBean socketTimeBean = (SocketTimeBean) obj;
        if (!socketTimeBean.canEqual(this)) {
            return false;
        }
        ISocketSend socketSend2 = getSocketSend();
        ISocketSend socketSend3 = socketTimeBean.getSocketSend();
        if (socketSend2 != null ? socketSend2.equals(socketSend3) : socketSend3 == null) {
            return getTime() == socketTimeBean.getTime() && getResendTimes() == socketTimeBean.getResendTimes();
        }
        return false;
    }

    public int getResendTimes() {
        return this.resendTimes;
    }

    public ISocketSend getSocketSend() {
        return this.socketSend;
    }

    public long getTime() {
        return this.time;
    }

    public int hashCode() {
        ISocketSend socketSend2 = getSocketSend();
        int hashCode = socketSend2 == null ? 43 : socketSend2.hashCode();
        long time2 = getTime();
        return ((((hashCode + 59) * 59) + ((int) (time2 ^ (time2 >>> 32)))) * 59) + getResendTimes();
    }

    public void setResendTimes(int i11) {
        this.resendTimes = i11;
    }

    public void setSocketSend(ISocketSend iSocketSend) {
        this.socketSend = iSocketSend;
    }

    public void setTime(long j11) {
        this.time = j11;
    }

    public String toString() {
        return "SocketTimeBean(socketSend=" + getSocketSend() + ", time=" + getTime() + ", resendTimes=" + getResendTimes() + ")";
    }
}
