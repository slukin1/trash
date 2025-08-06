package com.huobi.staring.bean;

import java.io.Serializable;
import java.util.List;

public class AllRulesResult implements Serializable {
    private CustomRuleResp custom;
    private List<RuleItemResp> symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof AllRulesResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AllRulesResult)) {
            return false;
        }
        AllRulesResult allRulesResult = (AllRulesResult) obj;
        if (!allRulesResult.canEqual(this)) {
            return false;
        }
        List<RuleItemResp> symbol2 = getSymbol();
        List<RuleItemResp> symbol3 = allRulesResult.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        CustomRuleResp custom2 = getCustom();
        CustomRuleResp custom3 = allRulesResult.getCustom();
        return custom2 != null ? custom2.equals(custom3) : custom3 == null;
    }

    public CustomRuleResp getCustom() {
        return this.custom;
    }

    public List<RuleItemResp> getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        List<RuleItemResp> symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        CustomRuleResp custom2 = getCustom();
        int i12 = (hashCode + 59) * 59;
        if (custom2 != null) {
            i11 = custom2.hashCode();
        }
        return i12 + i11;
    }

    public void setCustom(CustomRuleResp customRuleResp) {
        this.custom = customRuleResp;
    }

    public void setSymbol(List<RuleItemResp> list) {
        this.symbol = list;
    }

    public String toString() {
        return "AllRulesResult(symbol=" + getSymbol() + ", custom=" + getCustom() + ")";
    }
}
