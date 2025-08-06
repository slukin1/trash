package com.huawei.hms.push.ups.entity;

public class TokenResult extends CodeResult {

    /* renamed from: c  reason: collision with root package name */
    private String f38452c;

    public TokenResult() {
    }

    public String getToken() {
        return this.f38452c;
    }

    public void setToken(String str) {
        this.f38452c = str;
    }

    public TokenResult(int i11) {
        super(i11);
    }

    public TokenResult(int i11, String str) {
        super(i11, str);
    }

    public TokenResult(String str) {
        this.f38452c = str;
    }
}
