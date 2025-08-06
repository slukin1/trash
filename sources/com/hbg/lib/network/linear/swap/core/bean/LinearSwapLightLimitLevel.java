package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapLightLimitLevel implements Serializable {
    private static final long serialVersionUID = 8022057565578412135L;
    @SerializedName("contract_code")
    private String contractCode;
    private String step;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapLightLimitLevel;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapLightLimitLevel)) {
            return false;
        }
        LinearSwapLightLimitLevel linearSwapLightLimitLevel = (LinearSwapLightLimitLevel) obj;
        if (!linearSwapLightLimitLevel.canEqual(this)) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = linearSwapLightLimitLevel.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String step2 = getStep();
        String step3 = linearSwapLightLimitLevel.getStep();
        return step2 != null ? step2.equals(step3) : step3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getStep() {
        return this.step;
    }

    public int hashCode() {
        String contractCode2 = getContractCode();
        int i11 = 43;
        int hashCode = contractCode2 == null ? 43 : contractCode2.hashCode();
        String step2 = getStep();
        int i12 = (hashCode + 59) * 59;
        if (step2 != null) {
            i11 = step2.hashCode();
        }
        return i12 + i11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setStep(String str) {
        this.step = str;
    }

    public String toString() {
        return "LinearSwapLightLimitLevel(contractCode=" + getContractCode() + ", step=" + getStep() + ")";
    }
}
