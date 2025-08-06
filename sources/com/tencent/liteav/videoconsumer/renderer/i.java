package com.tencent.liteav.videoconsumer.renderer;

final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final f f22439a;

    private i(f fVar) {
        this.f22439a = fVar;
    }

    public static Runnable a(f fVar) {
        return new i(fVar);
    }

    public final void run() {
        f.b(this.f22439a);
    }
}
