package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;

public class PlanCancelOpenOrdersResult implements Serializable {
    private static final long serialVersionUID = 3598841108910496856L;
    private int failed;
    private int nextId;
    private int success;

    public boolean canEqual(Object obj) {
        return obj instanceof PlanCancelOpenOrdersResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PlanCancelOpenOrdersResult)) {
            return false;
        }
        PlanCancelOpenOrdersResult planCancelOpenOrdersResult = (PlanCancelOpenOrdersResult) obj;
        return planCancelOpenOrdersResult.canEqual(this) && getSuccess() == planCancelOpenOrdersResult.getSuccess() && getFailed() == planCancelOpenOrdersResult.getFailed() && getNextId() == planCancelOpenOrdersResult.getNextId();
    }

    public int getFailed() {
        return this.failed;
    }

    public int getNextId() {
        return this.nextId;
    }

    public int getSuccess() {
        return this.success;
    }

    public int hashCode() {
        return ((((getSuccess() + 59) * 59) + getFailed()) * 59) + getNextId();
    }

    public void setFailed(int i11) {
        this.failed = i11;
    }

    public void setNextId(int i11) {
        this.nextId = i11;
    }

    public void setSuccess(int i11) {
        this.success = i11;
    }

    public String toString() {
        return "PlanCancelOpenOrdersResult(success=" + getSuccess() + ", failed=" + getFailed() + ", nextId=" + getNextId() + ")";
    }
}
