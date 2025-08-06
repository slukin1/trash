package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractOpenCountInfo implements Serializable {
    @SerializedName("total_orders")
    private int totalOrders;
    @SerializedName("total_positions")
    private int totalPositions;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractOpenCountInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractOpenCountInfo)) {
            return false;
        }
        ContractOpenCountInfo contractOpenCountInfo = (ContractOpenCountInfo) obj;
        return contractOpenCountInfo.canEqual(this) && getTotalOrders() == contractOpenCountInfo.getTotalOrders() && getTotalPositions() == contractOpenCountInfo.getTotalPositions();
    }

    public int getTotalOrders() {
        return this.totalOrders;
    }

    public int getTotalPositions() {
        return this.totalPositions;
    }

    public int hashCode() {
        return ((getTotalOrders() + 59) * 59) + getTotalPositions();
    }

    public void setTotalOrders(int i11) {
        this.totalOrders = i11;
    }

    public void setTotalPositions(int i11) {
        this.totalPositions = i11;
    }

    public String toString() {
        return "ContractOpenCountInfo(totalOrders=" + getTotalOrders() + ", totalPositions=" + getTotalPositions() + ")";
    }
}
