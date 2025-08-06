package com.hbg.lib.network.option.core.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class OptionIndexInfo implements Serializable {
    private static final long serialVersionUID = 7961532336761266315L;
    @SerializedName("index_price")
    private String indexPrice;
    @SerializedName("index_ts")
    private String indexTs;
    private String symbol;
    @SerializedName("trade_partition")
    private String tradePartition;

    public boolean canEqual(Object obj) {
        return obj instanceof OptionIndexInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OptionIndexInfo)) {
            return false;
        }
        OptionIndexInfo optionIndexInfo = (OptionIndexInfo) obj;
        if (!optionIndexInfo.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = optionIndexInfo.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String tradePartition2 = getTradePartition();
        String tradePartition3 = optionIndexInfo.getTradePartition();
        if (tradePartition2 != null ? !tradePartition2.equals(tradePartition3) : tradePartition3 != null) {
            return false;
        }
        String indexPrice2 = getIndexPrice();
        String indexPrice3 = optionIndexInfo.getIndexPrice();
        if (indexPrice2 != null ? !indexPrice2.equals(indexPrice3) : indexPrice3 != null) {
            return false;
        }
        String indexTs2 = getIndexTs();
        String indexTs3 = optionIndexInfo.getIndexTs();
        return indexTs2 != null ? indexTs2.equals(indexTs3) : indexTs3 == null;
    }

    public String getIndexPrice() {
        return this.indexPrice;
    }

    public String getIndexTs() {
        return this.indexTs;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getTradePartition() {
        return this.tradePartition;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String tradePartition2 = getTradePartition();
        int hashCode2 = ((hashCode + 59) * 59) + (tradePartition2 == null ? 43 : tradePartition2.hashCode());
        String indexPrice2 = getIndexPrice();
        int hashCode3 = (hashCode2 * 59) + (indexPrice2 == null ? 43 : indexPrice2.hashCode());
        String indexTs2 = getIndexTs();
        int i12 = hashCode3 * 59;
        if (indexTs2 != null) {
            i11 = indexTs2.hashCode();
        }
        return i12 + i11;
    }

    public void setIndexPrice(String str) {
        this.indexPrice = str;
    }

    public void setIndexTs(String str) {
        this.indexTs = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradePartition(String str) {
        this.tradePartition = str;
    }

    public String toString() {
        return "OptionIndexInfo(symbol=" + getSymbol() + ", tradePartition=" + getTradePartition() + ", indexPrice=" + getIndexPrice() + ", indexTs=" + getIndexTs() + ")";
    }
}
