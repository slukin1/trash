package com.hbg.lib.network.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SwapOpenInterestInfo implements Serializable {
    private static final long serialVersionUID = -3009452060690675685L;
    private String amount;
    @SerializedName("contract_code")
    private String contractCode;
    private String symbol;
    private long volume;

    public boolean canEqual(Object obj) {
        return obj instanceof SwapOpenInterestInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapOpenInterestInfo)) {
            return false;
        }
        SwapOpenInterestInfo swapOpenInterestInfo = (SwapOpenInterestInfo) obj;
        if (!swapOpenInterestInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = swapOpenInterestInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = swapOpenInterestInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        if (getVolume() != swapOpenInterestInfo.getVolume()) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = swapOpenInterestInfo.getAmount();
        return amount2 != null ? amount2.equals(amount3) : amount3 == null;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getContractCode() {
        return this.contractCode;
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
        String contractCode2 = getContractCode();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        long volume2 = getVolume();
        int i12 = (hashCode2 * 59) + ((int) (volume2 ^ (volume2 >>> 32)));
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

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setVolume(long j11) {
        this.volume = j11;
    }

    public String toString() {
        return "SwapOpenInterestInfo(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", volume=" + getVolume() + ", amount=" + getAmount() + ")";
    }
}
