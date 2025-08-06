package com.huobi.otc.enums;

public enum OtcWsChannel {
    wps("1"),
    order("3"),
    chat("2");
    
    private String value;

    private OtcWsChannel(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
