package com.alibaba.sdk.android.crashdefend.a;

import k2.a;

public class b implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    public String f14493b;

    /* renamed from: c  reason: collision with root package name */
    public String f14494c;

    /* renamed from: d  reason: collision with root package name */
    public int f14495d;

    /* renamed from: e  reason: collision with root package name */
    public int f14496e;

    /* renamed from: f  reason: collision with root package name */
    public int f14497f;

    /* renamed from: g  reason: collision with root package name */
    public long f14498g;

    /* renamed from: h  reason: collision with root package name */
    public long f14499h;

    /* renamed from: i  reason: collision with root package name */
    public int f14500i = 0;

    /* renamed from: j  reason: collision with root package name */
    public long f14501j = 0;

    /* renamed from: k  reason: collision with root package name */
    public volatile boolean f14502k = false;

    /* renamed from: l  reason: collision with root package name */
    public a f14503l = null;

    public Object clone() {
        try {
            return (b) super.clone();
        } catch (CloneNotSupportedException e11) {
            l2.b.b("CrashSDK", "clone fail: ", e11);
            return null;
        }
    }
}
