package com.huobi.login.bean;

import java.io.Serializable;

public class SecurityVerifyBean implements Serializable {
    private String reset_token;

    public String getReset_token() {
        return this.reset_token;
    }

    public void setReset_token(String str) {
        this.reset_token = str;
    }
}
