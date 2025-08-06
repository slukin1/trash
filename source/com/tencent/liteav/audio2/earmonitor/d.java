package com.tencent.liteav.audio2.earmonitor;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a f21377a;

    private d(a aVar) {
        this.f21377a = aVar;
    }

    public static Runnable a(a aVar) {
        return new d(aVar);
    }

    public final void run() {
        a.b(this.f21377a);
    }
}
