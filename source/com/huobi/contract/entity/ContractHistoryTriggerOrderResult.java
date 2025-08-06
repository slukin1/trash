package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ContractHistoryTriggerOrderResult implements Serializable {
    private static final long serialVersionUID = 8678208252909877307L;
    @SerializedName("current_page")
    private int currentPage;
    private List<ContractHistoryTriggerOrderInfo> orders;
    @SerializedName("total_page")
    private int totalPage;
    @SerializedName("total_size")
    private int totalSize;

    /* renamed from: ts  reason: collision with root package name */
    private long f43067ts;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractHistoryTriggerOrderResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractHistoryTriggerOrderResult)) {
            return false;
        }
        ContractHistoryTriggerOrderResult contractHistoryTriggerOrderResult = (ContractHistoryTriggerOrderResult) obj;
        if (!contractHistoryTriggerOrderResult.canEqual(this)) {
            return false;
        }
        List<ContractHistoryTriggerOrderInfo> orders2 = getOrders();
        List<ContractHistoryTriggerOrderInfo> orders3 = contractHistoryTriggerOrderResult.getOrders();
        if (orders2 != null ? orders2.equals(orders3) : orders3 == null) {
            return getTotalPage() == contractHistoryTriggerOrderResult.getTotalPage() && getCurrentPage() == contractHistoryTriggerOrderResult.getCurrentPage() && getTotalSize() == contractHistoryTriggerOrderResult.getTotalSize() && getTs() == contractHistoryTriggerOrderResult.getTs();
        }
        return false;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public List<ContractHistoryTriggerOrderInfo> getOrders() {
        return this.orders;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public long getTs() {
        return this.f43067ts;
    }

    public int hashCode() {
        List<ContractHistoryTriggerOrderInfo> orders2 = getOrders();
        int hashCode = (((((((orders2 == null ? 43 : orders2.hashCode()) + 59) * 59) + getTotalPage()) * 59) + getCurrentPage()) * 59) + getTotalSize();
        long ts2 = getTs();
        return (hashCode * 59) + ((int) ((ts2 >>> 32) ^ ts2));
    }

    public void setCurrentPage(int i11) {
        this.currentPage = i11;
    }

    public void setOrders(List<ContractHistoryTriggerOrderInfo> list) {
        this.orders = list;
    }

    public void setTotalPage(int i11) {
        this.totalPage = i11;
    }

    public void setTotalSize(int i11) {
        this.totalSize = i11;
    }

    public void setTs(long j11) {
        this.f43067ts = j11;
    }

    public String toString() {
        return "ContractHistoryTriggerOrderResult(orders=" + getOrders() + ", totalPage=" + getTotalPage() + ", currentPage=" + getCurrentPage() + ", totalSize=" + getTotalSize() + ", ts=" + getTs() + ")";
    }
}
