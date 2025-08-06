package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class TradeRiskReminder implements Serializable {
    public static final int VERSION_0 = 0;
    @SerializedName("state")
    private String state;
    private int version;

    public boolean canEqual(Object obj) {
        return obj instanceof TradeRiskReminder;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradeRiskReminder)) {
            return false;
        }
        TradeRiskReminder tradeRiskReminder = (TradeRiskReminder) obj;
        if (!tradeRiskReminder.canEqual(this)) {
            return false;
        }
        String state2 = getState();
        String state3 = tradeRiskReminder.getState();
        if (state2 != null ? state2.equals(state3) : state3 == null) {
            return getVersion() == tradeRiskReminder.getVersion();
        }
        return false;
    }

    public String getState() {
        return this.state;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        String state2 = getState();
        return (((state2 == null ? 43 : state2.hashCode()) + 59) * 59) + getVersion();
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setVersion(int i11) {
        this.version = i11;
    }

    public String toString() {
        return "TradeRiskReminder(state=" + getState() + ", version=" + getVersion() + ")";
    }
}
