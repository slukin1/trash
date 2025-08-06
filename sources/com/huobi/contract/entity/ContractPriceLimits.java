package com.huobi.contract.entity;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractPriceLimits implements Serializable {
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_type")
    private String contractType;
    @SerializedName("high_limit")
    private String highLimit;
    @SerializedName("low_limit")
    private String lowLimit;
    private String status;
    private String symbol;

    /* renamed from: ts  reason: collision with root package name */
    private long f43096ts;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractPriceLimits;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractPriceLimits)) {
            return false;
        }
        ContractPriceLimits contractPriceLimits = (ContractPriceLimits) obj;
        if (!contractPriceLimits.canEqual(this)) {
            return false;
        }
        String status2 = getStatus();
        String status3 = contractPriceLimits.getStatus();
        if (status2 != null ? !status2.equals(status3) : status3 != null) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = contractPriceLimits.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String highLimit2 = getHighLimit();
        String highLimit3 = contractPriceLimits.getHighLimit();
        if (highLimit2 != null ? !highLimit2.equals(highLimit3) : highLimit3 != null) {
            return false;
        }
        String lowLimit2 = getLowLimit();
        String lowLimit3 = contractPriceLimits.getLowLimit();
        if (lowLimit2 != null ? !lowLimit2.equals(lowLimit3) : lowLimit3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = contractPriceLimits.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = contractPriceLimits.getContractType();
        if (contractType2 != null ? contractType2.equals(contractType3) : contractType3 == null) {
            return getTs() == contractPriceLimits.getTs();
        }
        return false;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractType() {
        return this.contractType;
    }

    public String getHighLimit() {
        return this.highLimit;
    }

    public String getLowLimit() {
        return this.lowLimit;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public long getTs() {
        return this.f43096ts;
    }

    public int hashCode() {
        String status2 = getStatus();
        int i11 = 43;
        int hashCode = status2 == null ? 43 : status2.hashCode();
        String symbol2 = getSymbol();
        int hashCode2 = ((hashCode + 59) * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
        String highLimit2 = getHighLimit();
        int hashCode3 = (hashCode2 * 59) + (highLimit2 == null ? 43 : highLimit2.hashCode());
        String lowLimit2 = getLowLimit();
        int hashCode4 = (hashCode3 * 59) + (lowLimit2 == null ? 43 : lowLimit2.hashCode());
        String contractCode2 = getContractCode();
        int hashCode5 = (hashCode4 * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String contractType2 = getContractType();
        int i12 = hashCode5 * 59;
        if (contractType2 != null) {
            i11 = contractType2.hashCode();
        }
        long ts2 = getTs();
        return ((i12 + i11) * 59) + ((int) ((ts2 >>> 32) ^ ts2));
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setHighLimit(String str) {
        this.highLimit = str;
    }

    public void setLowLimit(String str) {
        this.lowLimit = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTs(long j11) {
        this.f43096ts = j11;
    }

    public String toString() {
        return "ContractPriceLimits(status=" + getStatus() + ", symbol=" + getSymbol() + ", highLimit=" + getHighLimit() + ", lowLimit=" + getLowLimit() + ", contractCode=" + getContractCode() + ", contractType=" + getContractType() + ", ts=" + getTs() + ")";
    }
}
