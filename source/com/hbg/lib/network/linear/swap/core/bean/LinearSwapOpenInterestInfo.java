package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapOpenInterestInfo implements Serializable {
    private static final long serialVersionUID = -3009452060690675685L;
    private String amount;
    @SerializedName("contract_code")
    private String contractCode;
    private String symbol;
    private String volume;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapOpenInterestInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapOpenInterestInfo)) {
            return false;
        }
        LinearSwapOpenInterestInfo linearSwapOpenInterestInfo = (LinearSwapOpenInterestInfo) obj;
        if (!linearSwapOpenInterestInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = linearSwapOpenInterestInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = linearSwapOpenInterestInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String volume2 = getVolume();
        String volume3 = linearSwapOpenInterestInfo.getVolume();
        if (volume2 != null ? !volume2.equals(volume3) : volume3 != null) {
            return false;
        }
        String amount2 = getAmount();
        String amount3 = linearSwapOpenInterestInfo.getAmount();
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

    public String getVolume() {
        return this.volume;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String contractCode2 = getContractCode();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String volume2 = getVolume();
        int hashCode3 = (hashCode2 * 59) + (volume2 == null ? 43 : volume2.hashCode());
        String amount2 = getAmount();
        int i12 = hashCode3 * 59;
        if (amount2 != null) {
            i11 = amount2.hashCode();
        }
        return i12 + i11;
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

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "LinearSwapOpenInterestInfo(symbol=" + getSymbol() + ", contractCode=" + getContractCode() + ", volume=" + getVolume() + ", amount=" + getAmount() + ")";
    }
}
