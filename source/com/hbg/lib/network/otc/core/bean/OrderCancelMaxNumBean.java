package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OrderCancelMaxNumBean implements Serializable {
    private int cancleConsultMaxinum;
    private int cancleMaxinum;

    public boolean canEqual(Object obj) {
        return obj instanceof OrderCancelMaxNumBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OrderCancelMaxNumBean)) {
            return false;
        }
        OrderCancelMaxNumBean orderCancelMaxNumBean = (OrderCancelMaxNumBean) obj;
        return orderCancelMaxNumBean.canEqual(this) && getCancleConsultMaxinum() == orderCancelMaxNumBean.getCancleConsultMaxinum() && getCancleMaxinum() == orderCancelMaxNumBean.getCancleMaxinum();
    }

    public int getCancleConsultMaxinum() {
        return this.cancleConsultMaxinum;
    }

    public int getCancleMaxinum() {
        return this.cancleMaxinum;
    }

    public int hashCode() {
        return ((getCancleConsultMaxinum() + 59) * 59) + getCancleMaxinum();
    }

    public void setCancleConsultMaxinum(int i11) {
        this.cancleConsultMaxinum = i11;
    }

    public void setCancleMaxinum(int i11) {
        this.cancleMaxinum = i11;
    }

    public String toString() {
        return "OrderCancelMaxNumBean(cancleConsultMaxinum=" + getCancleConsultMaxinum() + ", cancleMaxinum=" + getCancleMaxinum() + ")";
    }
}
