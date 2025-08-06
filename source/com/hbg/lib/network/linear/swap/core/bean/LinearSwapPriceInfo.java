package com.hbg.lib.network.linear.swap.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LinearSwapPriceInfo implements Serializable {
    private static final long serialVersionUID = -2759048871546134381L;
    @SerializedName("contract_code")
    private String contractCode;
    @SerializedName("index_price")
    private String currentIndex;
    @SerializedName("index_ts")
    private long indexTs;
    @SerializedName("trade_partition")
    private String tradePartition;

    public boolean canEqual(Object obj) {
        return obj instanceof LinearSwapPriceInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LinearSwapPriceInfo)) {
            return false;
        }
        LinearSwapPriceInfo linearSwapPriceInfo = (LinearSwapPriceInfo) obj;
        if (!linearSwapPriceInfo.canEqual(this)) {
            return false;
        }
        String currentIndex2 = getCurrentIndex();
        String currentIndex3 = linearSwapPriceInfo.getCurrentIndex();
        if (currentIndex2 != null ? !currentIndex2.equals(currentIndex3) : currentIndex3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = linearSwapPriceInfo.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        if (getIndexTs() != linearSwapPriceInfo.getIndexTs()) {
            return false;
        }
        String tradePartition2 = getTradePartition();
        String tradePartition3 = linearSwapPriceInfo.getTradePartition();
        return tradePartition2 != null ? tradePartition2.equals(tradePartition3) : tradePartition3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getCurrentIndex() {
        return this.currentIndex;
    }

    public long getIndexTs() {
        return this.indexTs;
    }

    public String getTradePartition() {
        return this.tradePartition;
    }

    public int hashCode() {
        String currentIndex2 = getCurrentIndex();
        int i11 = 43;
        int hashCode = currentIndex2 == null ? 43 : currentIndex2.hashCode();
        String contractCode2 = getContractCode();
        int hashCode2 = ((hashCode + 59) * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        long indexTs2 = getIndexTs();
        int i12 = (hashCode2 * 59) + ((int) (indexTs2 ^ (indexTs2 >>> 32)));
        String tradePartition2 = getTradePartition();
        int i13 = i12 * 59;
        if (tradePartition2 != null) {
            i11 = tradePartition2.hashCode();
        }
        return i13 + i11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setCurrentIndex(String str) {
        this.currentIndex = str;
    }

    public void setIndexTs(long j11) {
        this.indexTs = j11;
    }

    public void setTradePartition(String str) {
        this.tradePartition = str;
    }

    public String toString() {
        return "LinearSwapPriceInfo(currentIndex=" + getCurrentIndex() + ", contractCode=" + getContractCode() + ", indexTs=" + getIndexTs() + ", tradePartition=" + getTradePartition() + ")";
    }
}
