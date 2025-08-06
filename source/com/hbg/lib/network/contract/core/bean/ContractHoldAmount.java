package com.hbg.lib.network.contract.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class ContractHoldAmount implements Serializable {
    private static final long serialVersionUID = -3009452060690675685L;
    private String amount;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("contract_type")
    private String contractType;
    private String symbol;
    private long volume;

    public boolean canEqual(Object obj) {
        return obj instanceof ContractHoldAmount;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ContractHoldAmount)) {
            return false;
        }
        ContractHoldAmount contractHoldAmount = (ContractHoldAmount) obj;
        if (!contractHoldAmount.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = contractHoldAmount.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractType2 = getContractType();
        String contractType3 = contractHoldAmount.getContractType();
        if (contractType2 != null ? !contractType2.equals(contractType3) : contractType3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = contractHoldAmount.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        if (getVolume() != contractHoldAmount.getVolume()) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = contractHoldAmount.getAmount();
        return amount2 != null ? amount2.equals(amount3) : amount3 == null;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractType() {
        return this.contractType;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public long getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String contractType2 = getContractType();
        int hashCode2 = ((hashCode + 59) * 59) + (contractType2 == null ? 43 : contractType2.hashCode());
        String contractCode2 = getContractCode();
        int hashCode3 = (hashCode2 * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        long volume2 = getVolume();
        int i12 = (hashCode3 * 59) + ((int) (volume2 ^ (volume2 >>> 32)));
        String amount2 = getAmount();
        int i13 = i12 * 59;
        if (amount2 != null) {
            i11 = amount2.hashCode();
        }
        return i13 + i11;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractType(String str) {
        this.contractType = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setVolume(long j11) {
        this.volume = j11;
    }

    public String toString() {
        return "ContractHoldAmount(symbol=" + getSymbol() + ", contractType=" + getContractType() + ", contractCode=" + getContractCode() + ", volume=" + getVolume() + ", amount=" + getAmount() + ")";
    }
}
