package com.hbg.lib.core.webview.bean;

import java.io.Serializable;

public class WebViewLoadFailedEvent implements Serializable {
    public String description;
    public int errorCode;
    public String failingUrl;

    public WebViewLoadFailedEvent(int i11, String str, String str2) {
        this.errorCode = i11;
        this.description = str;
        this.failingUrl = str2;
    }
}
