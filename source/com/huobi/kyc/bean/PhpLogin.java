package com.huobi.kyc.bean;

import java.io.Serializable;

public class PhpLogin implements Serializable {
    private static final long serialVersionUID = 1634738572896505550L;
    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
