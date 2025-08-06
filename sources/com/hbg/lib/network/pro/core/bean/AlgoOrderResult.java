package com.hbg.lib.network.pro.core.bean;

import java.io.Serializable;

public class AlgoOrderResult implements Serializable {
    private String clientOrderId;

    public boolean canEqual(Object obj) {
        return obj instanceof AlgoOrderResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AlgoOrderResult)) {
            return false;
        }
        AlgoOrderResult algoOrderResult = (AlgoOrderResult) obj;
        if (!algoOrderResult.canEqual(this)) {
            return false;
        }
        String clientOrderId2 = getClientOrderId();
        String clientOrderId3 = algoOrderResult.getClientOrderId();
        return clientOrderId2 != null ? clientOrderId2.equals(clientOrderId3) : clientOrderId3 == null;
    }

    public String getClientOrderId() {
        return this.clientOrderId;
    }

    public int hashCode() {
        String clientOrderId2 = getClientOrderId();
        return 59 + (clientOrderId2 == null ? 43 : clientOrderId2.hashCode());
    }

    public void setClientOrderId(String str) {
        this.clientOrderId = str;
    }

    public String toString() {
        return "AlgoOrderResult(clientOrderId=" + getClientOrderId() + ")";
    }
}
