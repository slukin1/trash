package com.hbg.lib.network.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class SwapCurrentTrackOrderResult implements Serializable {
    private static final long serialVersionUID = -6694445640046208838L;
    @SerializedName("current_page")
    private int currentPage;
    private List<SwapTrackOrderInfo> orders;
    @SerializedName("total_page")
    private int totalPage;
    @SerializedName("total_size")
    private int totalSize;

    /* renamed from: ts  reason: collision with root package name */
    private long f70755ts;

    public boolean canEqual(Object obj) {
        return obj instanceof SwapCurrentTrackOrderResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapCurrentTrackOrderResult)) {
            return false;
        }
        SwapCurrentTrackOrderResult swapCurrentTrackOrderResult = (SwapCurrentTrackOrderResult) obj;
        if (!swapCurrentTrackOrderResult.canEqual(this)) {
            return false;
        }
        List<SwapTrackOrderInfo> orders2 = getOrders();
        List<SwapTrackOrderInfo> orders3 = swapCurrentTrackOrderResult.getOrders();
        if (orders2 != null ? orders2.equals(orders3) : orders3 == null) {
            return getTotalPage() == swapCurrentTrackOrderResult.getTotalPage() && getCurrentPage() == swapCurrentTrackOrderResult.getCurrentPage() && getTotalSize() == swapCurrentTrackOrderResult.getTotalSize() && getTs() == swapCurrentTrackOrderResult.getTs();
        }
        return false;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public List<SwapTrackOrderInfo> getOrders() {
        return this.orders;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public long getTs() {
        return this.f70755ts;
    }

    public int hashCode() {
        List<SwapTrackOrderInfo> orders2 = getOrders();
        int hashCode = (((((((orders2 == null ? 43 : orders2.hashCode()) + 59) * 59) + getTotalPage()) * 59) + getCurrentPage()) * 59) + getTotalSize();
        long ts2 = getTs();
        return (hashCode * 59) + ((int) ((ts2 >>> 32) ^ ts2));
    }

    public void setCurrentPage(int i11) {
        this.currentPage = i11;
    }

    public void setOrders(List<SwapTrackOrderInfo> list) {
        this.orders = list;
    }

    public void setTotalPage(int i11) {
        this.totalPage = i11;
    }

    public void setTotalSize(int i11) {
        this.totalSize = i11;
    }

    public void setTs(long j11) {
        this.f70755ts = j11;
    }

    public String toString() {
        return "SwapCurrentTrackOrderResult(orders=" + getOrders() + ", totalPage=" + getTotalPage() + ", currentPage=" + getCurrentPage() + ", totalSize=" + getTotalSize() + ", ts=" + getTs() + ")";
    }
}
