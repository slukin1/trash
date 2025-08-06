package com.hbg.lib.network.hbg.core.bean;

public class AccountRiskInfo {
    private String availableDeposit;
    private String effectiveDeposit;
    private int riskLevel;
    private String riskRate;
    private String usedDeposit;

    public boolean canEqual(Object obj) {
        return obj instanceof AccountRiskInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountRiskInfo)) {
            return false;
        }
        AccountRiskInfo accountRiskInfo = (AccountRiskInfo) obj;
        if (!accountRiskInfo.canEqual(this)) {
            return false;
        }
        String riskRate2 = getRiskRate();
        String riskRate3 = accountRiskInfo.getRiskRate();
        if (riskRate2 != null ? !riskRate2.equals(riskRate3) : riskRate3 != null) {
            return false;
        }
        if (getRiskLevel() != accountRiskInfo.getRiskLevel()) {
            return false;
        }
        String effectiveDeposit2 = getEffectiveDeposit();
        String effectiveDeposit3 = accountRiskInfo.getEffectiveDeposit();
        if (effectiveDeposit2 != null ? !effectiveDeposit2.equals(effectiveDeposit3) : effectiveDeposit3 != null) {
            return false;
        }
        String usedDeposit2 = getUsedDeposit();
        String usedDeposit3 = accountRiskInfo.getUsedDeposit();
        if (usedDeposit2 != null ? !usedDeposit2.equals(usedDeposit3) : usedDeposit3 != null) {
            return false;
        }
        String availableDeposit2 = getAvailableDeposit();
        String availableDeposit3 = accountRiskInfo.getAvailableDeposit();
        return availableDeposit2 != null ? availableDeposit2.equals(availableDeposit3) : availableDeposit3 == null;
    }

    public String getAvailableDeposit() {
        return this.availableDeposit;
    }

    public String getEffectiveDeposit() {
        return this.effectiveDeposit;
    }

    public int getRiskLevel() {
        return this.riskLevel;
    }

    public String getRiskRate() {
        return this.riskRate;
    }

    public String getUsedDeposit() {
        return this.usedDeposit;
    }

    public int hashCode() {
        String riskRate2 = getRiskRate();
        int i11 = 43;
        int hashCode = (((riskRate2 == null ? 43 : riskRate2.hashCode()) + 59) * 59) + getRiskLevel();
        String effectiveDeposit2 = getEffectiveDeposit();
        int hashCode2 = (hashCode * 59) + (effectiveDeposit2 == null ? 43 : effectiveDeposit2.hashCode());
        String usedDeposit2 = getUsedDeposit();
        int hashCode3 = (hashCode2 * 59) + (usedDeposit2 == null ? 43 : usedDeposit2.hashCode());
        String availableDeposit2 = getAvailableDeposit();
        int i12 = hashCode3 * 59;
        if (availableDeposit2 != null) {
            i11 = availableDeposit2.hashCode();
        }
        return i12 + i11;
    }

    public void setAvailableDeposit(String str) {
        this.availableDeposit = str;
    }

    public void setEffectiveDeposit(String str) {
        this.effectiveDeposit = str;
    }

    public void setRiskLevel(int i11) {
        this.riskLevel = i11;
    }

    public void setRiskRate(String str) {
        this.riskRate = str;
    }

    public void setUsedDeposit(String str) {
        this.usedDeposit = str;
    }

    public String toString() {
        return "AccountRiskInfo(riskRate=" + getRiskRate() + ", riskLevel=" + getRiskLevel() + ", effectiveDeposit=" + getEffectiveDeposit() + ", usedDeposit=" + getUsedDeposit() + ", availableDeposit=" + getAvailableDeposit() + ")";
    }
}
