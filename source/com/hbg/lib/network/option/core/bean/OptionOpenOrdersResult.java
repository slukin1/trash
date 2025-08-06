package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class OptionOpenOrdersResult implements Serializable {
    private static final long serialVersionUID = -5775134148208472433L;
    @SerializedName("current_page")
    private int currentPage;
    private List<OptionOrderInfo> orders;
    @SerializedName("total_page")
    private int totalPage;
    @SerializedName("total_size")
    private int totalSize;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionOpenOrdersResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionOpenOrdersResult)) {
            return false;
        }
        OptionOpenOrdersResult optionOpenOrdersResult = (OptionOpenOrdersResult) obj;
        if (!optionOpenOrdersResult.canEqual(this) || getCurrentPage() != optionOpenOrdersResult.getCurrentPage() || getTotalPage() != optionOpenOrdersResult.getTotalPage() || getTotalSize() != optionOpenOrdersResult.getTotalSize()) {
            return false;
        }
        List<OptionOrderInfo> orders2 = getOrders();
        List<OptionOrderInfo> orders3 = optionOpenOrdersResult.getOrders();
        return orders2 != null ? orders2.equals(orders3) : orders3 == null;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public List<OptionOrderInfo> getOrders() {
        return this.orders;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public int getTotalSize() {
        return this.totalSize;
    }

    public int hashCode() {
        int currentPage2 = ((((getCurrentPage() + 59) * 59) + getTotalPage()) * 59) + getTotalSize();
        List<OptionOrderInfo> orders2 = getOrders();
        return (currentPage2 * 59) + (orders2 == null ? 43 : orders2.hashCode());
    }

    public void setCurrentPage(int i11) {
        this.currentPage = i11;
    }

    public void setOrders(List<OptionOrderInfo> list) {
        this.orders = list;
    }

    public void setTotalPage(int i11) {
        this.totalPage = i11;
    }

    public void setTotalSize(int i11) {
        this.totalSize = i11;
    }

    public String toString() {
        return "OptionOpenOrdersResult(currentPage=" + getCurrentPage() + ", totalPage=" + getTotalPage() + ", totalSize=" + getTotalSize() + ", orders=" + getOrders() + ")";
    }
}
