package com.huobi.finance.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractTransferResult implements Serializable {
    @SerializedName("transaction_id")
    private String transactionId;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractTransferResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractTransferResult)) {
            return false;
        }
        ContractTransferResult contractTransferResult = (ContractTransferResult) obj;
        if (!contractTransferResult.canEqual(this)) {
            return false;
        }
        String transactionId2 = getTransactionId();
        String transactionId3 = contractTransferResult.getTransactionId();
        return transactionId2 != null ? transactionId2.equals(transactionId3) : transactionId3 == null;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public int hashCode() {
        String transactionId2 = getTransactionId();
        return 59 + (transactionId2 == null ? 43 : transactionId2.hashCode());
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public String toString() {
        return "ContractTransferResult(transactionId=" + getTransactionId() + ")";
    }
}
