package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class TradingStatus implements Serializable {
    private int status;

    public boolean canEqual(Object obj) {
        return obj instanceof TradingStatus;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradingStatus)) {
            return false;
        }
        TradingStatus tradingStatus = (TradingStatus) obj;
        return tradingStatus.canEqual(this) && getStatus() == tradingStatus.getStatus();
    }

    public int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return 59 + getStatus();
    }

    public void setStatus(int i11) {
        this.status = i11;
    }

    public String toString() {
        return "TradingStatus(status=" + getStatus() + ")";
    }
}
