package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PositionSlippageInfo implements Serializable {
    @SerializedName("market_closing_slippage")
    private String closingSlippage;

    public boolean canEqual(Object obj) {
        return obj instanceof PositionSlippageInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PositionSlippageInfo)) {
            return false;
        }
        PositionSlippageInfo positionSlippageInfo = (PositionSlippageInfo) obj;
        if (!positionSlippageInfo.canEqual(this)) {
            return false;
        }
        String closingSlippage2 = getClosingSlippage();
        String closingSlippage3 = positionSlippageInfo.getClosingSlippage();
        return closingSlippage2 != null ? closingSlippage2.equals(closingSlippage3) : closingSlippage3 == null;
    }

    public String getClosingSlippage() {
        return this.closingSlippage;
    }

    public int hashCode() {
        String closingSlippage2 = getClosingSlippage();
        return 59 + (closingSlippage2 == null ? 43 : closingSlippage2.hashCode());
    }

    public void setClosingSlippage(String str) {
        this.closingSlippage = str;
    }

    public String toString() {
        return "PositionSlippageInfo(closingSlippage=" + getClosingSlippage() + ")";
    }
}
