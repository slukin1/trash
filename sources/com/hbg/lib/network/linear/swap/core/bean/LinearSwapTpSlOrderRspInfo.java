package com.hbg.lib.network.linear.swap.core.bean;

import java.io.Serializable;

public class LinearSwapTpSlOrderRspInfo implements Serializable {
    private static final long serialVersionUID = -2597582910993558421L;
    public LinearSwapOrderInsertRspInfo slOrder;
    public LinearSwapOrderInsertRspInfo tpOrder;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapTpSlOrderRspInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapTpSlOrderRspInfo)) {
            return false;
        }
        LinearSwapTpSlOrderRspInfo linearSwapTpSlOrderRspInfo = (LinearSwapTpSlOrderRspInfo) obj;
        if (!linearSwapTpSlOrderRspInfo.canEqual(this)) {
            return false;
        }
        LinearSwapOrderInsertRspInfo tpOrder2 = getTpOrder();
        LinearSwapOrderInsertRspInfo tpOrder3 = linearSwapTpSlOrderRspInfo.getTpOrder();
        if (tpOrder2 != null ? !tpOrder2.equals(tpOrder3) : tpOrder3 != null) {
            return false;
        }
        LinearSwapOrderInsertRspInfo slOrder2 = getSlOrder();
        LinearSwapOrderInsertRspInfo slOrder3 = linearSwapTpSlOrderRspInfo.getSlOrder();
        return slOrder2 != null ? slOrder2.equals(slOrder3) : slOrder3 == null;
    }

    public LinearSwapOrderInsertRspInfo getSlOrder() {
        return this.slOrder;
    }

    public LinearSwapOrderInsertRspInfo getTpOrder() {
        return this.tpOrder;
    }

    public int hashCode() {
        LinearSwapOrderInsertRspInfo tpOrder2 = getTpOrder();
        int i11 = 43;
        int hashCode = tpOrder2 == null ? 43 : tpOrder2.hashCode();
        LinearSwapOrderInsertRspInfo slOrder2 = getSlOrder();
        int i12 = (hashCode + 59) * 59;
        if (slOrder2 != null) {
            i11 = slOrder2.hashCode();
        }
        return i12 + i11;
    }

    public void setSlOrder(LinearSwapOrderInsertRspInfo linearSwapOrderInsertRspInfo) {
        this.slOrder = linearSwapOrderInsertRspInfo;
    }

    public void setTpOrder(LinearSwapOrderInsertRspInfo linearSwapOrderInsertRspInfo) {
        this.tpOrder = linearSwapOrderInsertRspInfo;
    }

    public String toString() {
        return "LinearSwapTpSlOrderRspInfo(tpOrder=" + getTpOrder() + ", slOrder=" + getSlOrder() + ")";
    }
}
