package com.hbg.lib.core.network.response;

public class AliTokenStringStatusResponse<T> extends StringStatusResponse<T> {
    private static final long serialVersionUID = -6929718062467568802L;
    private String token;

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
