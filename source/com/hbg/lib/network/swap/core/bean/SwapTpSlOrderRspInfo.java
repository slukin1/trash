package com.hbg.lib.network.swap.core.bean;

import java.io.Serializable;

public class SwapTpSlOrderRspInfo implements Serializable {
    private static final long serialVersionUID = -2597582910993558421L;
    public OrderInsertRspInfo slOrder;
    public OrderInsertRspInfo tpOrder;

    public boolean canEqual(Object obj) {
        return obj instanceof SwapTpSlOrderRspInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapTpSlOrderRspInfo)) {
            return false;
        }
        SwapTpSlOrderRspInfo swapTpSlOrderRspInfo = (SwapTpSlOrderRspInfo) obj;
        if (!swapTpSlOrderRspInfo.canEqual(this)) {
            return false;
        }
        OrderInsertRspInfo tpOrder2 = getTpOrder();
        OrderInsertRspInfo tpOrder3 = swapTpSlOrderRspInfo.getTpOrder();
        if (tpOrder2 != null ? !tpOrder2.equals(tpOrder3) : tpOrder3 != null) {
            return false;
        }
        OrderInsertRspInfo slOrder2 = getSlOrder();
        OrderInsertRspInfo slOrder3 = swapTpSlOrderRspInfo.getSlOrder();
        return slOrder2 != null ? slOrder2.equals(slOrder3) : slOrder3 == null;
    }

    public OrderInsertRspInfo getSlOrder() {
        return this.slOrder;
    }

    public OrderInsertRspInfo getTpOrder() {
        return this.tpOrder;
    }

    public int hashCode() {
        OrderInsertRspInfo tpOrder2 = getTpOrder();
        int i11 = 43;
        int hashCode = tpOrder2 == null ? 43 : tpOrder2.hashCode();
        OrderInsertRspInfo slOrder2 = getSlOrder();
        int i12 = (hashCode + 59) * 59;
        if (slOrder2 != null) {
            i11 = slOrder2.hashCode();
        }
        return i12 + i11;
    }

    public void setSlOrder(OrderInsertRspInfo orderInsertRspInfo) {
        this.slOrder = orderInsertRspInfo;
    }

    public void setTpOrder(OrderInsertRspInfo orderInsertRspInfo) {
        this.tpOrder = orderInsertRspInfo;
    }

    public String toString() {
        return "SwapTpSlOrderRspInfo(tpOrder=" + getTpOrder() + ", slOrder=" + getSlOrder() + ")";
    }
}
