package com.tencent.liteav.audio2.earmonitor;

final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f21381a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21382b;

    private g(a aVar, int i11) {
        this.f21381a = aVar;
        this.f21382b = i11;
    }

    public static Runnable a(a aVar, int i11) {
        return new g(aVar, i11);
    }

    public final void run() {
        a.a(this.f21381a, this.f21382b);
    }
}
