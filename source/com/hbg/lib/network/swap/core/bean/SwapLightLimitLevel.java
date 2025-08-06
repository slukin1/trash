package com.hbg.lib.network.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SwapLightLimitLevel implements Serializable {
    private static final long serialVersionUID = 8022057565578412135L;
    @SerializedName("contract_code")
    private String contractCode;
    private String step;

    public boolean canEqual(Object obj) {
        return obj instanceof SwapLightLimitLevel;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapLightLimitLevel)) {
            return false;
        }
        SwapLightLimitLevel swapLightLimitLevel = (SwapLightLimitLevel) obj;
        if (!swapLightLimitLevel.canEqual(this)) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = swapLightLimitLevel.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String step2 = getStep();
        String step3 = swapLightLimitLevel.getStep();
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
        return "SwapLightLimitLevel(contractCode=" + getContractCode() + ", step=" + getStep() + ")";
    }
}
