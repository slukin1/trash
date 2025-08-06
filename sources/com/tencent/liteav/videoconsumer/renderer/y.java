package com.tencent.liteav.videoconsumer.renderer;

final /* synthetic */ class y implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final t f22509a;

    private y(t tVar) {
        this.f22509a = tVar;
    }

    public static Runnable a(t tVar) {
        return new y(tVar);
    }

    public final void run() {
        t.b(this.f22509a);
    }
}
