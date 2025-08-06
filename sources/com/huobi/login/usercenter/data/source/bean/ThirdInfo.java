package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;

public class ThirdInfo {
    @SerializedName("app_icon")

    /* renamed from: a  reason: collision with root package name */
    public String f75677a;
    @SerializedName("app_name")

    /* renamed from: b  reason: collision with root package name */
    public String f75678b;
    @SerializedName("authorize_url")

    /* renamed from: c  reason: collision with root package name */
    public String f75679c;
    @SerializedName("scope")

    /* renamed from: d  reason: collision with root package name */
    public String f75680d;
    @SerializedName("client_id")

    /* renamed from: e  reason: collision with root package name */
    public String f75681e;
    @SerializedName("redirect_uri")

    /* renamed from: f  reason: collision with root package name */
    public String f75682f;
    @SerializedName("third_type")

    /* renamed from: g  reason: collision with root package name */
    public String f75683g;

    public String a() {
        return this.f75678b;
    }

    public String b() {
        return this.f75681e;
    }

    public String c() {
        return this.f75682f;
    }

    public String d() {
        return this.f75683g;
    }

    public String toString() {
        return "ThirdInfo{app_icon='" + this.f75677a + '\'' + ", app_name='" + this.f75678b + '\'' + ", authorize_url='" + this.f75679c + '\'' + ", scope='" + this.f75680d + '\'' + ", client_id='" + this.f75681e + '\'' + ", redirect_uri='" + this.f75682f + '\'' + ", third_type='" + this.f75683g + '\'' + '}';
    }
}
