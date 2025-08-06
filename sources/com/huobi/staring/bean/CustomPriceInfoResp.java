package com.huobi.staring.bean;

import java.io.Serializable;
import java.util.List;

public class CustomPriceInfoResp implements Serializable {
    private List<CustomPriceResp> prices;
    private long ruleId;

    public boolean canEqual(Object obj) {
        return obj instanceof CustomPriceInfoResp;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomPriceInfoResp)) {
            return false;
        }
        CustomPriceInfoResp customPriceInfoResp = (CustomPriceInfoResp) obj;
        if (!customPriceInfoResp.canEqual(this) || getRuleId() != customPriceInfoResp.getRuleId()) {
            return false;
        }
        List<CustomPriceResp> prices2 = getPrices();
        List<CustomPriceResp> prices3 = customPriceInfoResp.getPrices();
        return prices2 != null ? prices2.equals(prices3) : prices3 == null;
    }

    public List<CustomPriceResp> getPrices() {
        return this.prices;
    }

    public long getRuleId() {
        return this.ruleId;
    }

    public int hashCode() {
        long ruleId2 = getRuleId();
        List<CustomPriceResp> prices2 = getPrices();
        return ((((int) (ruleId2 ^ (ruleId2 >>> 32))) + 59) * 59) + (prices2 == null ? 43 : prices2.hashCode());
    }

    public void setPrices(List<CustomPriceResp> list) {
        this.prices = list;
    }

    public void setRuleId(long j11) {
        this.ruleId = j11;
    }

    public String toString() {
        return "CustomPriceInfoResp(ruleId=" + getRuleId() + ", prices=" + getPrices() + ")";
    }
}
