package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import com.hbg.lib.common.utils.SP;
import com.hbg.lib.core.util.ConfigPreferences;
import java.util.List;

public class UserInfoData {
    @SerializedName("country_code")

    /* renamed from: a  reason: collision with root package name */
    public String f75686a;
    @SerializedName("email")

    /* renamed from: b  reason: collision with root package name */
    public String f75687b;
    @SerializedName("fullname")

    /* renamed from: c  reason: collision with root package name */
    public String f75688c;
    @SerializedName("gmt_created")

    /* renamed from: d  reason: collision with root package name */
    public long f75689d;
    @SerializedName("phone")

    /* renamed from: e  reason: collision with root package name */
    public String f75690e;
    @SerializedName("country_id")

    /* renamed from: f  reason: collision with root package name */
    public List<Integer> f75691f;
    @SerializedName("uid")

    /* renamed from: g  reason: collision with root package name */
    public String f75692g;
    @SerializedName("uuid")

    /* renamed from: h  reason: collision with root package name */
    public String f75693h;
    @SerializedName("user_type")

    /* renamed from: i  reason: collision with root package name */
    public int f75694i;
    @SerializedName("account_name")

    /* renamed from: j  reason: collision with root package name */
    public String f75695j;

    public static void a(String str) {
        if (SP.b("user_config", str + "_" + "config_uid")) {
            SP.o("user_config", str + "_" + "config_uid");
        }
        if (SP.b("user_config", str + "_" + "config_fullname")) {
            SP.o("user_config", str + "_" + "config_fullname");
        }
        if (SP.b("user_config", str + "_" + "config_email")) {
            SP.o("user_config", str + "_" + "config_email");
        }
        if (SP.b("user_config", str + "_" + "config_phone")) {
            SP.o("user_config", str + "_" + "config_phone");
        }
        if (SP.b("user_config", str + "_" + "assetPassword")) {
            SP.o("user_config", str + "_" + "assetPassword");
        }
    }

    public String b() {
        return this.f75695j;
    }

    public String c() {
        return this.f75686a;
    }

    public List<Integer> d() {
        return this.f75691f;
    }

    public String e() {
        return this.f75687b;
    }

    public String f() {
        return this.f75688c;
    }

    public long g() {
        return this.f75689d;
    }

    public String h() {
        return this.f75690e;
    }

    public String i() {
        return this.f75692g;
    }

    public int j() {
        return this.f75694i;
    }

    public String k() {
        return this.f75693h;
    }

    public void l(String str) {
        q(str);
        o(ConfigPreferences.e("user_config", str + "_" + "config_fullname", ""));
        n(ConfigPreferences.e("user_config", str + "_" + "config_email", ""));
        p(ConfigPreferences.e("user_config", str + "_" + "config_phone", ""));
    }

    public void m() {
        String str = this.f75692g;
        ConfigPreferences.m("user_config", str + "_" + "config_uid", i());
        ConfigPreferences.m("user_config", str + "_" + "config_fullname", f());
        ConfigPreferences.m("user_config", str + "_" + "config_email", e());
        ConfigPreferences.m("user_config", str + "_" + "config_phone", h());
    }

    public void n(String str) {
        this.f75687b = str;
    }

    public void o(String str) {
        this.f75688c = str;
    }

    public void p(String str) {
        this.f75690e = str;
    }

    public void q(String str) {
        this.f75692g = str;
    }
}
