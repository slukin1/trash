package com.hbg.lib.network.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SwapPriceInfo implements Serializable {
    private static final long serialVersionUID = -2759048871546134381L;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("index_price")
    private String currentIndex;

    public boolean canEqual(Object obj) {
        return obj instanceof SwapPriceInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapPriceInfo)) {
            return false;
        }
        SwapPriceInfo swapPriceInfo = (SwapPriceInfo) obj;
        if (!swapPriceInfo.canEqual(this)) {
            return false;
        }
        String currentIndex2 = getCurrentIndex();
        String currentIndex3 = swapPriceInfo.getCurrentIndex();
        if (currentIndex2 != null ? !currentIndex2.equals(currentIndex3) : currentIndex3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = swapPriceInfo.getContractCode();
        return contractCode2 != null ? contractCode2.equals(contractCode3) : contractCode3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getCurrentIndex() {
        return this.currentIndex;
    }

    public int hashCode() {
        String currentIndex2 = getCurrentIndex();
        int i11 = 43;
        int hashCode = currentIndex2 == null ? 43 : currentIndex2.hashCode();
        String contractCode2 = getContractCode();
        int i12 = (hashCode + 59) * 59;
        if (contractCode2 != null) {
            i11 = contractCode2.hashCode();
        }
        return i12 + i11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setCurrentIndex(String str) {
        this.currentIndex = str;
    }

    public String toString() {
        return "SwapPriceInfo(currentIndex=" + getCurrentIndex() + ", contractCode=" + getContractCode() + ")";
    }
}
