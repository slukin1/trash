package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OptionLightningLimitInfo implements Serializable {
    private static final long serialVersionUID = -5945878076033043800L;
    @SerializedName("contract_code")
    private String contractCode;
    private String step;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionLightningLimitInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionLightningLimitInfo)) {
            return false;
        }
        OptionLightningLimitInfo optionLightningLimitInfo = (OptionLightningLimitInfo) obj;
        if (!optionLightningLimitInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = optionLightningLimitInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = optionLightningLimitInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String step2 = getStep();
        String step3 = optionLightningLimitInfo.getStep();
        return step2 != null ? step2.equals(step3) : step3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
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
        String contractCode2 = getContractCode();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String step2 = getStep();
        int i12 = hashCode2 * 59;
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

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "OptionLightningLimitInfo(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", step=" + getStep() + ")";
    }
}
