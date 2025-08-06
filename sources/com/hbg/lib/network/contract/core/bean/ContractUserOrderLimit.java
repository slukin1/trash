package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class ContractUserOrderLimit implements Serializable {
    private static final long serialVersionUID = -3651559902843778545L;
    private List<ContractUserOrderLimitSymbol> list;
    @SerializedName("order_price_type")
    private String orderPriceType;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractUserOrderLimit;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractUserOrderLimit)) {
            return false;
        }
        ContractUserOrderLimit contractUserOrderLimit = (ContractUserOrderLimit) obj;
        if (!contractUserOrderLimit.canEqual(this)) {
            return false;
        }
        String orderPriceType2 = getOrderPriceType();
        String orderPriceType3 = contractUserOrderLimit.getOrderPriceType();
        if (orderPriceType2 != null ? !orderPriceType2.equals(orderPriceType3) : orderPriceType3 != null) {
            return false;
        }
        List<ContractUserOrderLimitSymbol> list2 = getList();
        List<ContractUserOrderLimitSymbol> list3 = contractUserOrderLimit.getList();
        return list2 != null ? list2.equals(list3) : list3 == null;
    }

    public List<ContractUserOrderLimitSymbol> getList() {
        return this.list;
    }

    public String getOrderPriceType() {
        return this.orderPriceType;
    }

    public int hashCode() {
        String orderPriceType2 = getOrderPriceType();
        int i11 = 43;
        int hashCode = orderPriceType2 == null ? 43 : orderPriceType2.hashCode();
        List<ContractUserOrderLimitSymbol> list2 = getList();
        int i12 = (hashCode + 59) * 59;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return i12 + i11;
    }

    public void setList(List<ContractUserOrderLimitSymbol> list2) {
        this.list = list2;
    }

    public void setOrderPriceType(String str) {
        this.orderPriceType = str;
    }

    public String toString() {
        return "ContractUserOrderLimit(orderPriceType=" + getOrderPriceType() + ", list=" + getList() + ")";
    }
}
