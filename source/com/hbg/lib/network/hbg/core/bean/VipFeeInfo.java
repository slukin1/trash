package com.hbg.lib.network.hbg.core.bean;

import java.io.Serializable;

public class VipFeeInfo implements Serializable {
    private static final long serialVersionUID = 4094925203006187116L;
    private String tradingFee;

    public boolean canEqual(Object obj) {
        return obj instanceof VipFeeInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof VipFeeInfo)) {
            return false;
        }
        VipFeeInfo vipFeeInfo = (VipFeeInfo) obj;
        if (!vipFeeInfo.canEqual(this)) {
            return false;
        }
        String tradingFee2 = getTradingFee();
        String tradingFee3 = vipFeeInfo.getTradingFee();
        return tradingFee2 != null ? tradingFee2.equals(tradingFee3) : tradingFee3 == null;
    }

    public String getTradingFee() {
        return this.tradingFee;
    }

    public int hashCode() {
        String tradingFee2 = getTradingFee();
        return 59 + (tradingFee2 == null ? 43 : tradingFee2.hashCode());
    }

    public void setTradingFee(String str) {
        this.tradingFee = str;
    }

    public String toString() {
        return "VipFeeInfo(tradingFee=" + getTradingFee() + ")";
    }
}
