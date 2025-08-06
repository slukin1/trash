package com.huobi.login.bean;

import java.io.Serializable;

public class H5LoginInfo implements Serializable {
    public static final String LOGIN_RESULT_CALLBACK_METHOD = "onLoginResultCallback";
    private static final long serialVersionUID = 1017363997606266411L;
    private String callback;

    /* renamed from: fp  reason: collision with root package name */
    private String f75435fp;

    public H5LoginInfo(String str, String str2) {
        this.callback = str;
        this.f75435fp = str2;
    }

    public String getCallback() {
        return this.callback;
    }

    public String getFp() {
        return this.f75435fp;
    }

    public void setCallback(String str) {
        this.callback = str;
    }

    public void setFp(String str) {
        this.f75435fp = str;
    }
}
