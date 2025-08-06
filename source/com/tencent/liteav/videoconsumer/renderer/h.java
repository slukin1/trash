package com.tencent.liteav.videoconsumer.renderer;

final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f22438a;

    private h(f fVar) {
        this.f22438a = fVar;
    }

    public static Runnable a(f fVar) {
        return new h(fVar);
    }

    public final void run() {
        f.c(this.f22438a);
    }
}
