package com.huobi.otc.enums;

public enum OtcReceiveOrderAdsType {
    ALL_ADS("-1"),
    NOT_RECEIVE_ORDER("0"),
    RECEIVE_ORDER("1");
    
    private String value;

    private OtcReceiveOrderAdsType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
