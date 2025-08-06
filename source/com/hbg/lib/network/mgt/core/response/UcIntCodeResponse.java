package com.hbg.lib.network.mgt.core.response;

import com.google.gson.annotations.SerializedName;

public class UcIntCodeResponse<T> {
    @SerializedName("code")

    /* renamed from: a  reason: collision with root package name */
    public int f68868a;
    @SerializedName("success")

    /* renamed from: b  reason: collision with root package name */
    public boolean f68869b;
    @SerializedName("message")

    /* renamed from: c  reason: collision with root package name */
    public String f68870c;
    @SerializedName("data")

    /* renamed from: d  reason: collision with root package name */
    public T f68871d;

    public int a() {
        return this.f68868a;
    }

    public T b() {
        return this.f68871d;
    }

    public String c() {
        return this.f68870c;
    }

    public boolean d() {
        return this.f68868a == 200 && this.f68869b;
    }
}
