package com.hbg.lib.network.contract.core.bean;

import java.io.Serializable;

public class ContractTpSlOrderRspInfo implements Serializable {
    private static final long serialVersionUID = -2597582910993558421L;
    public ContractOrderInsertRspInfo slOrder;
    public ContractOrderInsertRspInfo tpOrder;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractTpSlOrderRspInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractTpSlOrderRspInfo)) {
            return false;
        }
        ContractTpSlOrderRspInfo contractTpSlOrderRspInfo = (ContractTpSlOrderRspInfo) obj;
        if (!contractTpSlOrderRspInfo.canEqual(this)) {
            return false;
        }
        ContractOrderInsertRspInfo tpOrder2 = getTpOrder();
        ContractOrderInsertRspInfo tpOrder3 = contractTpSlOrderRspInfo.getTpOrder();
        if (tpOrder2 != null ? !tpOrder2.equals(tpOrder3) : tpOrder3 != null) {
            return false;
        }
        ContractOrderInsertRspInfo slOrder2 = getSlOrder();
        ContractOrderInsertRspInfo slOrder3 = contractTpSlOrderRspInfo.getSlOrder();
        return slOrder2 != null ? slOrder2.equals(slOrder3) : slOrder3 == null;
    }

    public ContractOrderInsertRspInfo getSlOrder() {
        return this.slOrder;
    }

    public ContractOrderInsertRspInfo getTpOrder() {
        return this.tpOrder;
    }

    public int hashCode() {
        ContractOrderInsertRspInfo tpOrder2 = getTpOrder();
        int i11 = 43;
        int hashCode = tpOrder2 == null ? 43 : tpOrder2.hashCode();
        ContractOrderInsertRspInfo slOrder2 = getSlOrder();
        int i12 = (hashCode + 59) * 59;
        if (slOrder2 != null) {
            i11 = slOrder2.hashCode();
        }
        return i12 + i11;
    }

    public void setSlOrder(ContractOrderInsertRspInfo contractOrderInsertRspInfo) {
        this.slOrder = contractOrderInsertRspInfo;
    }

    public void setTpOrder(ContractOrderInsertRspInfo contractOrderInsertRspInfo) {
        this.tpOrder = contractOrderInsertRspInfo;
    }

    public String toString() {
        return "ContractTpSlOrderRspInfo(tpOrder=" + getTpOrder() + ", slOrder=" + getSlOrder() + ")";
    }
}
