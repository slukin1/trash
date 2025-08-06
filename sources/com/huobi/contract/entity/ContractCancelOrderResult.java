package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ContractCancelOrderResult implements Serializable {
    private static final long serialVersionUID = -6694445640046208838L;
    @SerializedName("cancel_failure_list")
    private List<String> orders;
    @SerializedName("trade_partition")
    private int tradePartition;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractCancelOrderResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractCancelOrderResult)) {
            return false;
        }
        ContractCancelOrderResult contractCancelOrderResult = (ContractCancelOrderResult) obj;
        if (!contractCancelOrderResult.canEqual(this) || getTradePartition() != contractCancelOrderResult.getTradePartition()) {
            return false;
        }
        List<String> orders2 = getOrders();
        List<String> orders3 = contractCancelOrderResult.getOrders();
        return orders2 != null ? orders2.equals(orders3) : orders3 == null;
    }

    public List<String> getOrders() {
        return this.orders;
    }

    public int getTradePartition() {
        return this.tradePartition;
    }

    public int hashCode() {
        List<String> orders2 = getOrders();
        return ((getTradePartition() + 59) * 59) + (orders2 == null ? 43 : orders2.hashCode());
    }

    public void setOrders(List<String> list) {
        this.orders = list;
    }

    public void setTradePartition(int i11) {
        this.tradePartition = i11;
    }

    public String toString() {
        return "ContractCancelOrderResult(tradePartition=" + getTradePartition() + ", orders=" + getOrders() + ")";
    }
}
