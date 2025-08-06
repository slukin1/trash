package com.hbg.module.kline.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class KlineReqConfigData implements Serializable {
    public static final int TRADE_TYPE_PRO = 1;
    private static final long serialVersionUID = -5455307545692499369L;
    @SerializedName("start_time")
    private long startTime;
    private String symbol;
    @SerializedName("trade_type")
    private int tradeType;

    public boolean canEqual(Object obj) {
        return obj instanceof KlineReqConfigData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof KlineReqConfigData)) {
            return false;
        }
        KlineReqConfigData klineReqConfigData = (KlineReqConfigData) obj;
        if (!klineReqConfigData.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = klineReqConfigData.getSymbol();
        if (symbol2 != null ? symbol2.equals(symbol3) : symbol3 == null) {
            return getTradeType() == klineReqConfigData.getTradeType() && getStartTime() == klineReqConfigData.getStartTime();
        }
        return false;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getTradeType() {
        return this.tradeType;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int hashCode = (((symbol2 == null ? 43 : symbol2.hashCode()) + 59) * 59) + getTradeType();
        long startTime2 = getStartTime();
        return (hashCode * 59) + ((int) ((startTime2 >>> 32) ^ startTime2));
    }

    public void setStartTime(long j11) {
        this.startTime = j11;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setTradeType(int i11) {
        this.tradeType = i11;
    }

    public String toString() {
        return "KlineReqConfigData(symbol=" + getSymbol() + ", tradeType=" + getTradeType() + ", startTime=" + getStartTime() + ")";
    }
}
