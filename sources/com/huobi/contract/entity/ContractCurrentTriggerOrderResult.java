package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ContractCurrentTriggerOrderResult implements Serializable {
    private static final long serialVersionUID = -6694445640046208838L;
    @SerializedName("current_page")
    private int currentPage;
    private List<ContractCurrentTriggerOrderInfo> orders;
    @SerializedName("total_page")
    private int totalPage;
    @SerializedName("total_size")
    private int totalSize;

    /* renamed from: ts  reason: collision with root package name */
    private long f43065ts;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractCurrentTriggerOrderResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractCurrentTriggerOrderResult)) {
            return false;
        }
        ContractCurrentTriggerOrderResult contractCurrentTriggerOrderResult = (ContractCurrentTriggerOrderResult) obj;
        if (!contractCurrentTriggerOrderResult.canEqual(this)) {
            return false;
        }
        List<ContractCurrentTriggerOrderInfo> orders2 = getOrders();
        List<ContractCurrentTriggerOrderInfo> orders3 = contractCurrentTriggerOrderResult.getOrders();
        if (orders2 != null ? orders2.equals(orders3) : orders3 == null) {
            return getTotalPage() == contractCurrentTriggerOrderResult.getTotalPage() && getCurrentPage() == contractCurrentTriggerOrderResult.getCurrentPage() && getTotalSize() == contractCurrentTriggerOrderResult.getTotalSize() && getTs() == contractCurrentTriggerOrderResult.getTs();
        }
        return false;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public List<ContractCurrentTriggerOrderInfo> getOrders() {
        return this.orders;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public long getTs() {
        return this.f43065ts;
    }

    public int hashCode() {
        List<ContractCurrentTriggerOrderInfo> orders2 = getOrders();
        int hashCode = (((((((orders2 == null ? 43 : orders2.hashCode()) + 59) * 59) + getTotalPage()) * 59) + getCurrentPage()) * 59) + getTotalSize();
        long ts2 = getTs();
        return (hashCode * 59) + ((int) ((ts2 >>> 32) ^ ts2));
    }

    public void setCurrentPage(int i11) {
        this.currentPage = i11;
    }

    public void setOrders(List<ContractCurrentTriggerOrderInfo> list) {
        this.orders = list;
    }

    public void setTotalPage(int i11) {
        this.totalPage = i11;
    }

    public void setTotalSize(int i11) {
        this.totalSize = i11;
    }

    public void setTs(long j11) {
        this.f43065ts = j11;
    }

    public String toString() {
        return "ContractCurrentTriggerOrderResult(orders=" + getOrders() + ", totalPage=" + getTotalPage() + ", currentPage=" + getCurrentPage() + ", totalSize=" + getTotalSize() + ", ts=" + getTs() + ")";
    }
}
