package com.tencent.liteav.audio2.earmonitor;

final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f21344a;

    private b(a aVar) {
        this.f21344a = aVar;
    }

    public static Runnable a(a aVar) {
        return new b(aVar);
    }

    public final void run() {
        a.d(this.f21344a);
    }
}
