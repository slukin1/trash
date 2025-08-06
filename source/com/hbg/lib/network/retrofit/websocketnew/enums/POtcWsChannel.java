package com.hbg.lib.network.retrofit.websocketnew.enums;

public enum POtcWsChannel {
    wps("1"),
    order("3"),
    chat("2");
    
    private String value;

    private POtcWsChannel(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
