package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.contract.entity.ContractTriggerOrderRspInfo;
import java.io.Serializable;
import java.util.List;

public class StopOrderRspResult implements Serializable {
    private static final long serialVersionUID = 1472200933908921189L;
    @SerializedName("current_page")
    private int currentPage;
    private List<ContractTriggerOrderRspInfo> orders;
    @SerializedName("total_page")
    private int totalPage;
    @SerializedName("total_size")
    private int totalSize;

    /* renamed from: ts  reason: collision with root package name */
    private long f69226ts;

    public boolean canEqual(Object obj) {
        return obj instanceof StopOrderRspResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StopOrderRspResult)) {
            return false;
        }
        StopOrderRspResult stopOrderRspResult = (StopOrderRspResult) obj;
        if (!stopOrderRspResult.canEqual(this)) {
            return false;
        }
        List<ContractTriggerOrderRspInfo> orders2 = getOrders();
        List<ContractTriggerOrderRspInfo> orders3 = stopOrderRspResult.getOrders();
        if (orders2 != null ? orders2.equals(orders3) : orders3 == null) {
            return getTotalPage() == stopOrderRspResult.getTotalPage() && getCurrentPage() == stopOrderRspResult.getCurrentPage() && getTotalSize() == stopOrderRspResult.getTotalSize() && getTs() == stopOrderRspResult.getTs();
        }
        return false;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public List<ContractTriggerOrderRspInfo> getOrders() {
        return this.orders;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public long getTs() {
        return this.f69226ts;
    }

    public int hashCode() {
        List<ContractTriggerOrderRspInfo> orders2 = getOrders();
        int hashCode = (((((((orders2 == null ? 43 : orders2.hashCode()) + 59) * 59) + getTotalPage()) * 59) + getCurrentPage()) * 59) + getTotalSize();
        long ts2 = getTs();
        return (hashCode * 59) + ((int) ((ts2 >>> 32) ^ ts2));
    }

    public void setCurrentPage(int i11) {
        this.currentPage = i11;
    }

    public void setOrders(List<ContractTriggerOrderRspInfo> list) {
        this.orders = list;
    }

    public void setTotalPage(int i11) {
        this.totalPage = i11;
    }

    public void setTotalSize(int i11) {
        this.totalSize = i11;
    }

    public void setTs(long j11) {
        this.f69226ts = j11;
    }

    public String toString() {
        return "StopOrderRspResult(orders=" + getOrders() + ", totalPage=" + getTotalPage() + ", currentPage=" + getCurrentPage() + ", totalSize=" + getTotalSize() + ", ts=" + getTs() + ")";
    }
}
