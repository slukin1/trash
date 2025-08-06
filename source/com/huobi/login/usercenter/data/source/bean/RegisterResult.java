package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;

public class RegisterResult {
    @SerializedName("uuid")

    /* renamed from: a  reason: collision with root package name */
    public String f75652a;
    @SerializedName("token_url")

    /* renamed from: b  reason: collision with root package name */
    public String f75653b;
    @SerializedName("ticket")

    /* renamed from: c  reason: collision with root package name */
    public String f75654c;
    @SerializedName("uc_token")

    /* renamed from: d  reason: collision with root package name */
    public String f75655d;

    public String a() {
        return this.f75654c;
    }

    public String b() {
        return this.f75655d;
    }

    public String c() {
        return this.f75652a;
    }

    public void d(String str) {
        this.f75654c = str;
    }

    public void e(String str) {
        this.f75653b = str;
    }

    public void f(String str) {
        this.f75655d = str;
    }
}
