package com.huobi.staring.bean;

import java.io.Serializable;

public class RuleConfigResult implements Serializable {
    private CustomConfig custom;
    private StareConfig marketStare;
    private int symbolLimit;
    private SystemConfig system;

    public boolean canEqual(Object obj) {
        return obj instanceof RuleConfigResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RuleConfigResult)) {
            return false;
        }
        RuleConfigResult ruleConfigResult = (RuleConfigResult) obj;
        if (!ruleConfigResult.canEqual(this)) {
            return false;
        }
        SystemConfig system2 = getSystem();
        SystemConfig system3 = ruleConfigResult.getSystem();
        if (system2 != null ? !system2.equals(system3) : system3 != null) {
            return false;
        }
        CustomConfig custom2 = getCustom();
        CustomConfig custom3 = ruleConfigResult.getCustom();
        if (custom2 != null ? !custom2.equals(custom3) : custom3 != null) {
            return false;
        }
        StareConfig marketStare2 = getMarketStare();
        StareConfig marketStare3 = ruleConfigResult.getMarketStare();
        if (marketStare2 != null ? marketStare2.equals(marketStare3) : marketStare3 == null) {
            return getSymbolLimit() == ruleConfigResult.getSymbolLimit();
        }
        return false;
    }

    public CustomConfig getCustom() {
        return this.custom;
    }

    public StareConfig getMarketStare() {
        return this.marketStare;
    }

    public int getSymbolLimit() {
        return this.symbolLimit;
    }

    public SystemConfig getSystem() {
        return this.system;
    }

    public int hashCode() {
        SystemConfig system2 = getSystem();
        int i11 = 43;
        int hashCode = system2 == null ? 43 : system2.hashCode();
        CustomConfig custom2 = getCustom();
        int hashCode2 = ((hashCode + 59) * 59) + (custom2 == null ? 43 : custom2.hashCode());
        StareConfig marketStare2 = getMarketStare();
        int i12 = hashCode2 * 59;
        if (marketStare2 != null) {
            i11 = marketStare2.hashCode();
        }
        return ((i12 + i11) * 59) + getSymbolLimit();
    }

    public void setCustom(CustomConfig customConfig) {
        this.custom = customConfig;
    }

    public void setMarketStare(StareConfig stareConfig) {
        this.marketStare = stareConfig;
    }

    public void setSymbolLimit(int i11) {
        this.symbolLimit = i11;
    }

    public void setSystem(SystemConfig systemConfig) {
        this.system = systemConfig;
    }

    public String toString() {
        return "RuleConfigResult(system=" + getSystem() + ", custom=" + getCustom() + ", marketStare=" + getMarketStare() + ", symbolLimit=" + getSymbolLimit() + ")";
    }
}
