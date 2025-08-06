package com.amazonaws;

import com.amazonaws.retry.PredefinedRetryPolicies;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.VersionInfoUtils;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import javax.net.ssl.TrustManager;

public class ClientConfiguration {

    /* renamed from: u  reason: collision with root package name */
    public static final String f14772u = VersionInfoUtils.b();

    /* renamed from: v  reason: collision with root package name */
    public static final RetryPolicy f14773v = PredefinedRetryPolicies.f15071b;

    /* renamed from: a  reason: collision with root package name */
    public String f14774a = f14772u;

    /* renamed from: b  reason: collision with root package name */
    public String f14775b;

    /* renamed from: c  reason: collision with root package name */
    public int f14776c = -1;

    /* renamed from: d  reason: collision with root package name */
    public RetryPolicy f14777d = f14773v;

    /* renamed from: e  reason: collision with root package name */
    public Protocol f14778e = Protocol.HTTPS;

    /* renamed from: f  reason: collision with root package name */
    public String f14779f = null;

    /* renamed from: g  reason: collision with root package name */
    public int f14780g = -1;

    /* renamed from: h  reason: collision with root package name */
    public String f14781h = null;

    /* renamed from: i  reason: collision with root package name */
    public String f14782i = null;
    @Deprecated

    /* renamed from: j  reason: collision with root package name */
    public String f14783j = null;
    @Deprecated

    /* renamed from: k  reason: collision with root package name */
    public String f14784k = null;

    /* renamed from: l  reason: collision with root package name */
    public int f14785l = 10;

    /* renamed from: m  reason: collision with root package name */
    public int f14786m = DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS;

    /* renamed from: n  reason: collision with root package name */
    public int f14787n = DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS;

    /* renamed from: o  reason: collision with root package name */
    public int f14788o = 0;

    /* renamed from: p  reason: collision with root package name */
    public int f14789p = 0;

    /* renamed from: q  reason: collision with root package name */
    public String f14790q;

    /* renamed from: r  reason: collision with root package name */
    public TrustManager f14791r = null;

    /* renamed from: s  reason: collision with root package name */
    public boolean f14792s = false;

    /* renamed from: t  reason: collision with root package name */
    public boolean f14793t = false;

    public int a() {
        return this.f14787n;
    }

    public int b() {
        return this.f14776c;
    }

    public Protocol c() {
        return this.f14778e;
    }

    public RetryPolicy d() {
        return this.f14777d;
    }

    public String e() {
        return this.f14790q;
    }

    public int f() {
        return this.f14786m;
    }

    public TrustManager g() {
        return this.f14791r;
    }

    public String h() {
        return this.f14774a;
    }

    public String i() {
        return this.f14775b;
    }

    public boolean j() {
        return this.f14792s;
    }

    public boolean k() {
        return this.f14793t;
    }
}
