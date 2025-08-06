package com.alibaba.sdk.android.httpdns;

import com.google.android.exoplayer2.DefaultControlDispatcher;
import java.util.HashMap;
import java.util.List;
import x2.a;

public class InitConfig {

    /* renamed from: g  reason: collision with root package name */
    public static final HashMap<String, InitConfig> f14523g = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public boolean f14524a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f14525b;

    /* renamed from: c  reason: collision with root package name */
    public int f14526c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f14527d;

    /* renamed from: e  reason: collision with root package name */
    public List<a> f14528e;

    /* renamed from: f  reason: collision with root package name */
    public String f14529f;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f14530a = true;

        /* renamed from: b  reason: collision with root package name */
        public boolean f14531b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f14532c = DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS;

        /* renamed from: d  reason: collision with root package name */
        public boolean f14533d = false;

        /* renamed from: e  reason: collision with root package name */
        public List<a> f14534e = null;

        /* renamed from: f  reason: collision with root package name */
        public String f14535f = "";
    }

    public static InitConfig a(String str) {
        return f14523g.get(str);
    }

    public List<a> b() {
        return this.f14528e;
    }

    public String c() {
        return this.f14529f;
    }

    public int d() {
        return this.f14526c;
    }

    public boolean e() {
        return this.f14525b;
    }

    public boolean f() {
        return this.f14524a;
    }

    public boolean g() {
        return this.f14527d;
    }
}
