package com.huawei.agconnect.config.impl;

import android.text.TextUtils;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f37495a;

    /* renamed from: b  reason: collision with root package name */
    private final String f37496b;

    /* renamed from: c  reason: collision with root package name */
    private final String f37497c;

    /* renamed from: d  reason: collision with root package name */
    private final String f37498d;

    /* renamed from: e  reason: collision with root package name */
    private final String f37499e;

    /* renamed from: f  reason: collision with root package name */
    private final int f37500f;

    /* renamed from: g  reason: collision with root package name */
    private int f37501g = 0;

    public d(String str, String str2, String str3, String str4, String str5, int i11) {
        this.f37495a = str;
        this.f37496b = str2;
        this.f37497c = str3;
        this.f37498d = str4;
        this.f37499e = str5;
        this.f37500f = i11;
        if (str != null) {
            this.f37501g = str.length() / 2;
        }
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.f37495a) && !TextUtils.isEmpty(this.f37496b) && !TextUtils.isEmpty(this.f37497c) && !TextUtils.isEmpty(this.f37498d) && this.f37495a.length() == this.f37496b.length() && this.f37496b.length() == this.f37497c.length() && this.f37497c.length() == this.f37501g * 2 && this.f37500f >= 0 && !TextUtils.isEmpty(this.f37499e);
    }

    public String b() {
        return this.f37495a;
    }

    public String c() {
        return this.f37496b;
    }

    public String d() {
        return this.f37497c;
    }

    public String e() {
        return this.f37498d;
    }

    public String f() {
        return this.f37499e;
    }

    public int g() {
        return this.f37500f;
    }

    public int h() {
        return this.f37501g;
    }
}
