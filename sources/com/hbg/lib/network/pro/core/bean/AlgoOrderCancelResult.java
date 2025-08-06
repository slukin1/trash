package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;
import java.util.List;

public class AlgoOrderCancelResult implements Serializable {
    private List<String> accepted;
    private List<String> rejected;

    public boolean canEqual(Object obj) {
        return obj instanceof AlgoOrderCancelResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AlgoOrderCancelResult)) {
            return false;
        }
        AlgoOrderCancelResult algoOrderCancelResult = (AlgoOrderCancelResult) obj;
        if (!algoOrderCancelResult.canEqual(this)) {
            return false;
        }
        List<String> accepted2 = getAccepted();
        List<String> accepted3 = algoOrderCancelResult.getAccepted();
        if (accepted2 != null ? !accepted2.equals(accepted3) : accepted3 != null) {
            return false;
        }
        List<String> rejected2 = getRejected();
        List<String> rejected3 = algoOrderCancelResult.getRejected();
        return rejected2 != null ? rejected2.equals(rejected3) : rejected3 == null;
    }

    public List<String> getAccepted() {
        return this.accepted;
    }

    public List<String> getRejected() {
        return this.rejected;
    }

    public int hashCode() {
        List<String> accepted2 = getAccepted();
        int i11 = 43;
        int hashCode = accepted2 == null ? 43 : accepted2.hashCode();
        List<String> rejected2 = getRejected();
        int i12 = (hashCode + 59) * 59;
        if (rejected2 != null) {
            i11 = rejected2.hashCode();
        }
        return i12 + i11;
    }

    public void setAccepted(List<String> list) {
        this.accepted = list;
    }

    public void setRejected(List<String> list) {
        this.rejected = list;
    }

    public String toString() {
        return "AlgoOrderCancelResult(accepted=" + getAccepted() + ", rejected=" + getRejected() + ")";
    }
}
