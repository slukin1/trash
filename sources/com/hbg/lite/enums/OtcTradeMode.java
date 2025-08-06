package com.hbg.lite.enums;

import com.hbg.module.huobi.im.group.bean.MessageCustomBlockBean;

public enum OtcTradeMode {
    C2C_SIMPLE(1, "c2c_simple"),
    C2C_BRAND(5, "c2c_brand"),
    C2C_BLOCK(3, MessageCustomBlockBean.BUSINESS_ID_C2C_BLOCK),
    FAST(4, "fast");
    
    private int code;
    private String value;

    private OtcTradeMode(int i11, String str) {
        this.code = i11;
        this.value = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getValue() {
        return this.value;
    }
}
