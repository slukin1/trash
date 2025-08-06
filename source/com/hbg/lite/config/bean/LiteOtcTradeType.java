package com.hbg.lite.config.bean;

public enum LiteOtcTradeType {
    NONE(""),
    BUY("buy"),
    SELL("sell");
    
    private String value;

    private LiteOtcTradeType(String str) {
        this.value = str;
    }

    public static LiteOtcTradeType parseFromValue(String str) {
        if ("buy".equalsIgnoreCase(str) || "0".equalsIgnoreCase(str)) {
            return BUY;
        }
        if ("sell".equalsIgnoreCase(str) || "1".equalsIgnoreCase(str)) {
            return SELL;
        }
        return BUY;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isBuy() {
        return this == BUY;
    }

    public boolean isSell() {
        return this == SELL;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
