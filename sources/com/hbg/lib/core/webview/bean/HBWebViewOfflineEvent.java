package com.hbg.lib.core.webview.bean;

import java.io.Serializable;

public class HBWebViewOfflineEvent implements Serializable {
    public boolean hitCache;
    public String md5;
    public String packageName;

    public HBWebViewOfflineEvent(boolean z11) {
        this.hitCache = z11;
    }
}
