package com.huobi.staring.bean;

import java.io.Serializable;

public class CustomRuleResp implements Serializable {
    private CustomPriceInfoResp priceInfo;

    public boolean canEqual(Object obj) {
        return obj instanceof CustomRuleResp;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomRuleResp)) {
            return false;
        }
        CustomRuleResp customRuleResp = (CustomRuleResp) obj;
        if (!customRuleResp.canEqual(this)) {
            return false;
        }
        CustomPriceInfoResp priceInfo2 = getPriceInfo();
        CustomPriceInfoResp priceInfo3 = customRuleResp.getPriceInfo();
        return priceInfo2 != null ? priceInfo2.equals(priceInfo3) : priceInfo3 == null;
    }

    public CustomPriceInfoResp getPriceInfo() {
        return this.priceInfo;
    }

    public int hashCode() {
        CustomPriceInfoResp priceInfo2 = getPriceInfo();
        return 59 + (priceInfo2 == null ? 43 : priceInfo2.hashCode());
    }

    public void setPriceInfo(CustomPriceInfoResp customPriceInfoResp) {
        this.priceInfo = customPriceInfoResp;
    }

    public String toString() {
        return "CustomRuleResp(priceInfo=" + getPriceInfo() + ")";
    }
}
