package com.huobi.otc.enums;

public enum OtcTradeArea {
    OLD_AREA("1"),
    EMPTY_AREA("0");
    
    private String value;

    private OtcTradeArea(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
