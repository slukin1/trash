package com.alibaba.sdk.android.sender;

import java.util.Map;

public class SdkInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f14681a;

    /* renamed from: b  reason: collision with root package name */
    public String f14682b;

    /* renamed from: c  reason: collision with root package name */
    public String f14683c;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, String> f14684d;

    public String a() {
        return this.f14681a;
    }

    public String b() {
        return this.f14682b;
    }

    public String c() {
        return this.f14683c;
    }

    public SdkInfo d(Map<String, String> map) {
        this.f14684d = map;
        return this;
    }

    public SdkInfo e(String str) {
        this.f14681a = str;
        return this;
    }

    public SdkInfo f(String str) {
        this.f14682b = str;
        return this;
    }
}
