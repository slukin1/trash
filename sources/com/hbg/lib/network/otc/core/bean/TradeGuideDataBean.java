package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class TradeGuideDataBean implements Serializable {
    private boolean isNewcomer;

    public boolean canEqual(Object obj) {
        return obj instanceof TradeGuideDataBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradeGuideDataBean)) {
            return false;
        }
        TradeGuideDataBean tradeGuideDataBean = (TradeGuideDataBean) obj;
        return tradeGuideDataBean.canEqual(this) && isNewcomer() == tradeGuideDataBean.isNewcomer();
    }

    public int hashCode() {
        return 59 + (isNewcomer() ? 79 : 97);
    }

    public boolean isNewcomer() {
        return this.isNewcomer;
    }

    public void setNewcomer(boolean z11) {
        this.isNewcomer = z11;
    }

    public String toString() {
        return "TradeGuideDataBean(isNewcomer=" + isNewcomer() + ")";
    }
}
