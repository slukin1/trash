package com.huobi.contract.entity;

import java.io.Serializable;

public class ContractLightLimitLevel implements Serializable {
    private static final long serialVersionUID = 8022057565578412135L;
    private String step;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractLightLimitLevel;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractLightLimitLevel)) {
            return false;
        }
        ContractLightLimitLevel contractLightLimitLevel = (ContractLightLimitLevel) obj;
        if (!contractLightLimitLevel.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = contractLightLimitLevel.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String step2 = getStep();
        String step3 = contractLightLimitLevel.getStep();
        return step2 != null ? step2.equals(step3) : step3 == null;
    }

    public String getStep() {
        return this.step;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String step2 = getStep();
        int i12 = (hashCode + 59) * 59;
        if (step2 != null) {
            i11 = step2.hashCode();
        }
        return i12 + i11;
    }

    public void setStep(String str) {
        this.step = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "ContractLightLimitLevel(symbol=" + getSymbol() + ", step=" + getStep() + ")";
    }
}
