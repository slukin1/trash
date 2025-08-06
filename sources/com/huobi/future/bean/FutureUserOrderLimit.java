package com.huobi.future.bean;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserOrderLimit;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapUserOrderLimitType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FutureUserOrderLimit implements Serializable {
    private static final long serialVersionUID = -3651559902843778545L;
    private List<FutureUserOrderLimitType> list;
    private String orderPriceType;

    public boolean canEqual(Object obj) {
        return obj instanceof FutureUserOrderLimit;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FutureUserOrderLimit)) {
            return false;
        }
        FutureUserOrderLimit futureUserOrderLimit = (FutureUserOrderLimit) obj;
        if (!futureUserOrderLimit.canEqual(this)) {
            return false;
        }
        String orderPriceType2 = getOrderPriceType();
        String orderPriceType3 = futureUserOrderLimit.getOrderPriceType();
        if (orderPriceType2 != null ? !orderPriceType2.equals(orderPriceType3) : orderPriceType3 != null) {
            return false;
        }
        List<FutureUserOrderLimitType> list2 = getList();
        List<FutureUserOrderLimitType> list3 = futureUserOrderLimit.getList();
        return list2 != null ? list2.equals(list3) : list3 == null;
    }

    public List<FutureUserOrderLimitType> getList() {
        return this.list;
    }

    public String getOrderPriceType() {
        return this.orderPriceType;
    }

    public int hashCode() {
        String orderPriceType2 = getOrderPriceType();
        int i11 = 43;
        int hashCode = orderPriceType2 == null ? 43 : orderPriceType2.hashCode();
        List<FutureUserOrderLimitType> list2 = getList();
        int i12 = (hashCode + 59) * 59;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return i12 + i11;
    }

    public FutureUserOrderLimit linearSwapConvert(FutureUserOrderLimit futureUserOrderLimit, LinearSwapUserOrderLimit linearSwapUserOrderLimit) {
        ArrayList arrayList = new ArrayList();
        List<LinearSwapUserOrderLimitType> list2 = linearSwapUserOrderLimit.getList();
        if (list2 != null) {
            for (LinearSwapUserOrderLimitType linearSwapConvert : list2) {
                FutureUserOrderLimitType futureUserOrderLimitType = new FutureUserOrderLimitType();
                arrayList.add(futureUserOrderLimitType.linearSwapConvert(futureUserOrderLimitType, linearSwapConvert));
            }
            futureUserOrderLimit.setList(arrayList);
        }
        futureUserOrderLimit.setOrderPriceType(linearSwapUserOrderLimit.getOrderPriceType());
        return futureUserOrderLimit;
    }

    public void setList(List<FutureUserOrderLimitType> list2) {
        this.list = list2;
    }

    public void setOrderPriceType(String str) {
        this.orderPriceType = str;
    }

    public String toString() {
        return "FutureUserOrderLimit(orderPriceType=" + getOrderPriceType() + ", list=" + getList() + ")";
    }
}
