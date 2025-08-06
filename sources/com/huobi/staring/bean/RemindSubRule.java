package com.huobi.staring.bean;

import java.io.Serializable;

public class RemindSubRule implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private long f81168id;
    private String ruleName;
    private String symbol;

    public RemindSubRule(long j11, String str, String str2) {
        this.f81168id = j11;
        this.symbol = str;
        this.ruleName = str2;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof RemindSubRule;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RemindSubRule)) {
            return false;
        }
        RemindSubRule remindSubRule = (RemindSubRule) obj;
        if (!remindSubRule.canEqual(this) || getId() != remindSubRule.getId()) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = remindSubRule.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String ruleName2 = getRuleName();
        String ruleName3 = remindSubRule.getRuleName();
        return ruleName2 != null ? ruleName2.equals(ruleName3) : ruleName3 == null;
    }

    public long getId() {
        return this.f81168id;
    }

    public String getRuleName() {
        return this.ruleName;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        long id2 = getId();
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = ((((int) (id2 ^ (id2 >>> 32))) + 59) * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String ruleName2 = getRuleName();
        int i12 = hashCode * 59;
        if (ruleName2 != null) {
            i11 = ruleName2.hashCode();
        }
        return i12 + i11;
    }

    public void setId(long j11) {
        this.f81168id = j11;
    }

    public void setRuleName(String str) {
        this.ruleName = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "RemindSubRule(id=" + getId() + ", symbol=" + getSymbol() + ", ruleName=" + getRuleName() + ")";
    }
}
