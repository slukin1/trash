package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;

public class ThirdAuth {
    @SerializedName("third_token")

    /* renamed from: a  reason: collision with root package name */
    public String f75660a;
    @SerializedName("icon")

    /* renamed from: b  reason: collision with root package name */
    public String f75661b;
    @SerializedName("name")

    /* renamed from: c  reason: collision with root package name */
    public String f75662c;
    @SerializedName("binded")

    /* renamed from: d  reason: collision with root package name */
    public Boolean f75663d;
    @SerializedName("login_name")

    /* renamed from: e  reason: collision with root package name */
    public String f75664e;
    @SerializedName("email")

    /* renamed from: f  reason: collision with root package name */
    public String f75665f;
    @SerializedName("registered")

    /* renamed from: g  reason: collision with root package name */
    public boolean f75666g;
    @SerializedName("auth_token")

    /* renamed from: h  reason: collision with root package name */
    public String f75667h;

    public String a() {
        return this.f75667h;
    }

    public Boolean b() {
        return this.f75663d;
    }

    public String c() {
        return this.f75665f;
    }

    public String d() {
        return this.f75664e;
    }

    public String e() {
        return this.f75660a;
    }

    public boolean f() {
        return this.f75666g;
    }

    public String toString() {
        return "ThirdAuth{thirdToken='" + this.f75660a + '\'' + ", icon='" + this.f75661b + '\'' + ", name='" + this.f75662c + '\'' + ", binded=" + this.f75663d + ", loginName='" + this.f75664e + '\'' + ", email='" + this.f75665f + '\'' + ", registered=" + this.f75666g + ", authToken='" + this.f75667h + '\'' + '}';
    }
}
