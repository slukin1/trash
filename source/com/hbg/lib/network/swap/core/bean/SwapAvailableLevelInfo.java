package com.hbg.lib.network.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Arrays;

public class SwapAvailableLevelInfo implements Serializable {
    private static final long serialVersionUID = 6535731348696739661L;
    @SerializedName("lever_list")
    private String[] leverList;
    private String symbol;

    public boolean canEqual(Object obj) {
        return obj instanceof SwapAvailableLevelInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SwapAvailableLevelInfo)) {
            return false;
        }
        SwapAvailableLevelInfo swapAvailableLevelInfo = (SwapAvailableLevelInfo) obj;
        if (!swapAvailableLevelInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = swapAvailableLevelInfo.getSymbol();
        if (symbol2 != null ? symbol2.equals(symbol3) : symbol3 == null) {
            return Arrays.deepEquals(getLeverList(), swapAvailableLevelInfo.getLeverList());
        }
        return false;
    }

    public String[] getLeverList() {
        return this.leverList;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        return (((symbol2 == null ? 43 : symbol2.hashCode()) + 59) * 59) + Arrays.deepHashCode(getLeverList());
    }

    public void setLeverList(String[] strArr) {
        this.leverList = strArr;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public String toString() {
        return "SwapAvailableLevelInfo(symbol=" + getSymbol() + ", leverList=" + Arrays.deepToString(getLeverList()) + ")";
    }
}
