package com.huobi.tradenew.prime.helper;

public final class TradeMarginHelper {

    /* renamed from: g  reason: collision with root package name */
    public static volatile TradeMarginHelper f83019g;

    /* renamed from: a  reason: collision with root package name */
    public boolean f83020a = false;

    /* renamed from: b  reason: collision with root package name */
    public String f83021b;

    /* renamed from: c  reason: collision with root package name */
    public String f83022c;

    /* renamed from: d  reason: collision with root package name */
    public String f83023d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f83024e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f83025f = "";

    public static TradeMarginHelper b() {
        if (f83019g == null) {
            synchronized (TradeMarginHelper.class) {
                if (f83019g == null) {
                    f83019g = new TradeMarginHelper();
                }
            }
        }
        return f83019g;
    }

    public String a() {
        return this.f83021b;
    }

    public String c() {
        return this.f83022c;
    }

    public boolean d() {
        return this.f83020a;
    }

    public void e(String str) {
        this.f83021b = str;
    }

    public void f(boolean z11) {
        this.f83020a = z11;
    }

    public void g(String str) {
        this.f83022c = str;
    }
}
