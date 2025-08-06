package com.cloud.sdk;

import com.adjust.sdk.Constants;

public enum Protocol {
    HTTP("http"),
    HTTPS(Constants.SCHEME);
    
    private final String protocol;

    private Protocol(String str) {
        this.protocol = str;
    }

    public String toString() {
        return this.protocol;
    }
}
