package com.huobi.staring.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class RemindSettingResult implements Serializable {
    @SerializedName("symbol")
    private List<RemindSettingRule> rules;

    public boolean canEqual(Object obj) {
        return obj instanceof RemindSettingResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemindSettingResult)) {
            return false;
        }
        RemindSettingResult remindSettingResult = (RemindSettingResult) obj;
        if (!remindSettingResult.canEqual(this)) {
            return false;
        }
        List<RemindSettingRule> rules2 = getRules();
        List<RemindSettingRule> rules3 = remindSettingResult.getRules();
        return rules2 != null ? rules2.equals(rules3) : rules3 == null;
    }

    public List<RemindSettingRule> getRules() {
        return this.rules;
    }

    public int hashCode() {
        List<RemindSettingRule> rules2 = getRules();
        return 59 + (rules2 == null ? 43 : rules2.hashCode());
    }

    public void setRules(List<RemindSettingRule> list) {
        this.rules = list;
    }

    public String toString() {
        return "RemindSettingResult(rules=" + getRules() + ")";
    }
}
