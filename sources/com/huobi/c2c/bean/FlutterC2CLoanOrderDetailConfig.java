package com.huobi.c2c.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.c2c.lend.bean.C2CLendOrderHistoryItem;
import java.io.Serializable;

public class FlutterC2CLoanOrderDetailConfig implements Serializable {
    @SerializedName("loan_history")
    public C2CLendOrderHistoryItem loanHistory;

    public boolean canEqual(Object obj) {
        return obj instanceof FlutterC2CLoanOrderDetailConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FlutterC2CLoanOrderDetailConfig)) {
            return false;
        }
        FlutterC2CLoanOrderDetailConfig flutterC2CLoanOrderDetailConfig = (FlutterC2CLoanOrderDetailConfig) obj;
        if (!flutterC2CLoanOrderDetailConfig.canEqual(this)) {
            return false;
        }
        C2CLendOrderHistoryItem loanHistory2 = getLoanHistory();
        C2CLendOrderHistoryItem loanHistory3 = flutterC2CLoanOrderDetailConfig.getLoanHistory();
        return loanHistory2 != null ? loanHistory2.equals(loanHistory3) : loanHistory3 == null;
    }

    public C2CLendOrderHistoryItem getLoanHistory() {
        return this.loanHistory;
    }

    public int hashCode() {
        C2CLendOrderHistoryItem loanHistory2 = getLoanHistory();
        return 59 + (loanHistory2 == null ? 43 : loanHistory2.hashCode());
    }

    public void setLoanHistory(C2CLendOrderHistoryItem c2CLendOrderHistoryItem) {
        this.loanHistory = c2CLendOrderHistoryItem;
    }

    public String toString() {
        return "FlutterC2CLoanOrderDetailConfig(loanHistory=" + getLoanHistory() + ")";
    }
}
