package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ContractCurrentTrackOrderResult implements Serializable {
    private static final long serialVersionUID = -6694445640046208838L;
    @SerializedName("current_page")
    private int currentPage;
    private List<ContractTrackOrderInfo> orders;
    @SerializedName("total_page")
    private int totalPage;
    @SerializedName("total_size")
    private int totalSize;

    /* renamed from: ts  reason: collision with root package name */
    private long f43064ts;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractCurrentTrackOrderResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractCurrentTrackOrderResult)) {
            return false;
        }
        ContractCurrentTrackOrderResult contractCurrentTrackOrderResult = (ContractCurrentTrackOrderResult) obj;
        if (!contractCurrentTrackOrderResult.canEqual(this)) {
            return false;
        }
        List<ContractTrackOrderInfo> orders2 = getOrders();
        List<ContractTrackOrderInfo> orders3 = contractCurrentTrackOrderResult.getOrders();
        if (orders2 != null ? orders2.equals(orders3) : orders3 == null) {
            return getTotalPage() == contractCurrentTrackOrderResult.getTotalPage() && getCurrentPage() == contractCurrentTrackOrderResult.getCurrentPage() && getTotalSize() == contractCurrentTrackOrderResult.getTotalSize() && getTs() == contractCurrentTrackOrderResult.getTs();
        }
        return false;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public List<ContractTrackOrderInfo> getOrders() {
        return this.orders;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public long getTs() {
        return this.f43064ts;
    }

    public int hashCode() {
        List<ContractTrackOrderInfo> orders2 = getOrders();
        int hashCode = (((((((orders2 == null ? 43 : orders2.hashCode()) + 59) * 59) + getTotalPage()) * 59) + getCurrentPage()) * 59) + getTotalSize();
        long ts2 = getTs();
        return (hashCode * 59) + ((int) ((ts2 >>> 32) ^ ts2));
    }

    public void setCurrentPage(int i11) {
        this.currentPage = i11;
    }

    public void setOrders(List<ContractTrackOrderInfo> list) {
        this.orders = list;
    }

    public void setTotalPage(int i11) {
        this.totalPage = i11;
    }

    public void setTotalSize(int i11) {
        this.totalSize = i11;
    }

    public void setTs(long j11) {
        this.f43064ts = j11;
    }

    public String toString() {
        return "ContractCurrentTrackOrderResult(orders=" + getOrders() + ", totalPage=" + getTotalPage() + ", currentPage=" + getCurrentPage() + ", totalSize=" + getTotalSize() + ", ts=" + getTs() + ")";
    }
}
