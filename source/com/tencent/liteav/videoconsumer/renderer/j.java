package com.tencent.liteav.videoconsumer.renderer;

final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f22440a;

    private j(f fVar) {
        this.f22440a = fVar;
    }

    public static Runnable a(f fVar) {
        return new j(fVar);
    }

    public final void run() {
        this.f22440a.b();
    }
}
