package com.tencent.liteav.videoconsumer.renderer;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final t f22497a;

    /* renamed from: b  reason: collision with root package name */
    private final s f22498b = null;

    private u(t tVar) {
        this.f22497a = tVar;
    }

    public static Runnable a(t tVar) {
        return new u(tVar);
    }

    public final void run() {
        t.a(this.f22497a, this.f22498b);
    }
}
