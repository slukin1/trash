package com.huobi.sharev2.bean;

import java.io.Serializable;

public final class JsToNativeBean implements Serializable {
    private String action;
    private Data data;

    public final String getAction() {
        return this.action;
    }

    public final Data getData() {
        return this.data;
    }

    public final void setAction(String str) {
        this.action = str;
    }

    public final void setData(Data data2) {
        this.data = data2;
    }
}
