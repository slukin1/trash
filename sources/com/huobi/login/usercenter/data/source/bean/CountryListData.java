package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import com.huobi.login.presenter.CountryAreaSelectHandler;
import s9.a;

public class CountryListData implements a {
    @SerializedName("area_code")

    /* renamed from: b  reason: collision with root package name */
    public String f75644b;
    @SerializedName("name_cn")

    /* renamed from: c  reason: collision with root package name */
    public String f75645c;
    @SerializedName("name_en")

    /* renamed from: d  reason: collision with root package name */
    public String f75646d;
    @SerializedName("country_id")

    /* renamed from: e  reason: collision with root package name */
    public int f75647e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f75648f;

    /* renamed from: g  reason: collision with root package name */
    public String f75649g;

    public String a() {
        return this.f75644b;
    }

    public int c() {
        return this.f75647e;
    }

    public String d() {
        return this.f75645c;
    }

    public String e() {
        return this.f75646d;
    }

    public String f() {
        return this.f75649g;
    }

    public boolean g() {
        return this.f75648f;
    }

    public String getViewHandlerName() {
        return CountryAreaSelectHandler.class.getName();
    }

    public void h(String str) {
        this.f75644b = str;
    }

    public void i(int i11) {
        this.f75647e = i11;
    }

    public void j(String str) {
        this.f75645c = str;
    }

    public void k(String str) {
        this.f75646d = str;
    }

    public void l(String str) {
        this.f75649g = str;
    }

    public void m(boolean z11) {
        this.f75648f = z11;
    }
}
