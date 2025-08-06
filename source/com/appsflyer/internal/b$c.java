package com.appsflyer.internal;

import com.iproov.sdk.bridge.OptionsBridge;

public enum b$c {
    NULL(OptionsBridge.NULL_VALUE),
    COM_ANDROID_VENDING("cav"),
    OTHER("other");
    
    public String valueOf;

    private b$c(String str) {
        this.valueOf = str;
    }
}
