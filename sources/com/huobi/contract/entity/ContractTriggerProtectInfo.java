package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractTriggerProtectInfo implements Serializable {
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("trigger_protect")
    private Double triggerProtect;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractTriggerProtectInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractTriggerProtectInfo)) {
            return false;
        }
        ContractTriggerProtectInfo contractTriggerProtectInfo = (ContractTriggerProtectInfo) obj;
        if (!contractTriggerProtectInfo.canEqual(this)) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = contractTriggerProtectInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        Double triggerProtect2 = getTriggerProtect();
        Double triggerProtect3 = contractTriggerProtectInfo.getTriggerProtect();
        return triggerProtect2 != null ? triggerProtect2.equals(triggerProtect3) : triggerProtect3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public Double getTriggerProtect() {
        return this.triggerProtect;
    }

    public int hashCode() {
        String contractCode2 = getContractCode();
        int i11 = 43;
        int hashCode = contractCode2 == null ? 43 : contractCode2.hashCode();
        Double triggerProtect2 = getTriggerProtect();
        int i12 = (hashCode + 59) * 59;
        if (triggerProtect2 != null) {
            i11 = triggerProtect2.hashCode();
        }
        return i12 + i11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setTriggerProtect(Double d11) {
        this.triggerProtect = d11;
    }

    public String toString() {
        return "ContractTriggerProtectInfo(contractCode=" + getContractCode() + ", triggerProtect=" + getTriggerProtect() + ")";
    }
}
