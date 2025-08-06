package com.huobi.otc.bean;

import java.io.Serializable;

public class TradeBean implements Serializable {
    private boolean isPayCode;

    public boolean canEqual(Object obj) {
        return obj instanceof TradeBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TradeBean)) {
            return false;
        }
        TradeBean tradeBean = (TradeBean) obj;
        return tradeBean.canEqual(this) && isPayCode() == tradeBean.isPayCode();
    }

    public int hashCode() {
        return 59 + (isPayCode() ? 79 : 97);
    }

    public boolean isPayCode() {
        return this.isPayCode;
    }

    public void setPayCode(boolean z11) {
        this.isPayCode = z11;
    }

    public String toString() {
        return "TradeBean(isPayCode=" + isPayCode() + ")";
    }
}
