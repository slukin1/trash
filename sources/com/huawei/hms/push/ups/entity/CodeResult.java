package com.huawei.hms.push.ups.entity;

public class CodeResult {

    /* renamed from: a  reason: collision with root package name */
    private int f38450a;

    /* renamed from: b  reason: collision with root package name */
    private String f38451b;

    public CodeResult() {
    }

    public String getReason() {
        return this.f38451b;
    }

    public int getReturnCode() {
        return this.f38450a;
    }

    public void setReason(String str) {
        this.f38451b = str;
    }

    public void setReturnCode(int i11) {
        this.f38450a = i11;
    }

    public CodeResult(int i11) {
        this.f38450a = i11;
    }

    public CodeResult(int i11, String str) {
        this.f38450a = i11;
        this.f38451b = str;
    }
}
