package com.huobi.staring.bean;

import java.io.Serializable;
import java.util.List;

public class CustomRuleListResult implements Serializable {
    private List<CustomPriceResp> customPrice;

    public boolean canEqual(Object obj) {
        return obj instanceof CustomRuleListResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomRuleListResult)) {
            return false;
        }
        CustomRuleListResult customRuleListResult = (CustomRuleListResult) obj;
        if (!customRuleListResult.canEqual(this)) {
            return false;
        }
        List<CustomPriceResp> customPrice2 = getCustomPrice();
        List<CustomPriceResp> customPrice3 = customRuleListResult.getCustomPrice();
        return customPrice2 != null ? customPrice2.equals(customPrice3) : customPrice3 == null;
    }

    public List<CustomPriceResp> getCustomPrice() {
        return this.customPrice;
    }

    public int hashCode() {
        List<CustomPriceResp> customPrice2 = getCustomPrice();
        return 59 + (customPrice2 == null ? 43 : customPrice2.hashCode());
    }

    public void setCustomPrice(List<CustomPriceResp> list) {
        this.customPrice = list;
    }

    public String toString() {
        return "CustomRuleListResult(customPrice=" + getCustomPrice() + ")";
    }
}
