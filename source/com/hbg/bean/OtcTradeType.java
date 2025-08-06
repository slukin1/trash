package com.hbg.bean;

public enum OtcTradeType {
    NONE(""),
    BUY("buy"),
    SELL("sell"),
    CONVERT("convert");
    
    public String value;

    private OtcTradeType(String str) {
        this.value = str;
    }

    public static OtcTradeType parseFromValue(String str) {
        if ("buy".equalsIgnoreCase(str) || "0".equalsIgnoreCase(str)) {
            return BUY;
        }
        if ("sell".equalsIgnoreCase(str) || "1".equalsIgnoreCase(str)) {
            return SELL;
        }
        if ("convert".equalsIgnoreCase(str) || "3".equalsIgnoreCase(str)) {
            return CONVERT;
        }
        return BUY;
    }

    public boolean isBuy() {
        return this == BUY;
    }

    public boolean isConvert() {
        return this == CONVERT;
    }

    public boolean isSell() {
        return this == SELL;
    }
}
