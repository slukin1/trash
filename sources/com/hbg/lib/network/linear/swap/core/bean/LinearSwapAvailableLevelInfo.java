package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Arrays;

public class LinearSwapAvailableLevelInfo implements Serializable {
    private static final long serialVersionUID = 6535731348696739661L;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("lever_list")
    private String[] leverList;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapAvailableLevelInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapAvailableLevelInfo)) {
            return false;
        }
        LinearSwapAvailableLevelInfo linearSwapAvailableLevelInfo = (LinearSwapAvailableLevelInfo) obj;
        if (!linearSwapAvailableLevelInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = linearSwapAvailableLevelInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        if (!Arrays.deepEquals(getLeverList(), linearSwapAvailableLevelInfo.getLeverList())) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = linearSwapAvailableLevelInfo.getContractCode();
        return contractCode2 != null ? contractCode2.equals(contractCode3) : contractCode3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String[] getLeverList() {
        return this.leverList;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = (((symbol2 == null ? 43 : symbol2.hashCode()) + 59) * 59) + Arrays.deepHashCode(getLeverList());
        String contractCode2 = getContractCode();
        int i12 = hashCode * 59;
        if (contractCode2 != null) {
            i11 = contractCode2.hashCode();
        }
        return i12 + i11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setLeverList(String[] strArr) {
        this.leverList = strArr;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "LinearSwapAvailableLevelInfo(symbol=" + getSymbol() + ", leverList=" + Arrays.deepToString(getLeverList()) + ", contractCode=" + getContractCode() + ")";
    }
}
