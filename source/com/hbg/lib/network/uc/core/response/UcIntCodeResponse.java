package com.hbg.lib.network.uc.core.response;

import com.google.gson.annotations.SerializedName;

public class UcIntCodeResponse<T> {
    @SerializedName("code")

    /* renamed from: a  reason: collision with root package name */
    public int f70775a;
    @SerializedName("success")

    /* renamed from: b  reason: collision with root package name */
    public boolean f70776b;
    @SerializedName("message")

    /* renamed from: c  reason: collision with root package name */
    public String f70777c;
    @SerializedName("data")

    /* renamed from: d  reason: collision with root package name */
    public T f70778d;

    public int a() {
        return this.f70775a;
    }

    public T b() {
        return this.f70778d;
    }

    public String c() {
        return this.f70777c;
    }

    public boolean d() {
        return this.f70775a == 200 && this.f70776b;
    }
}
