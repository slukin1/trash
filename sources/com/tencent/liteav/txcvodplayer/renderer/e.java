package com.tencent.liteav.txcvodplayer.renderer;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final d f22034a;

    private e(d dVar) {
        this.f22034a = dVar;
    }

    public static Runnable a(d dVar) {
        return new e(dVar);
    }

    public final void run() {
        d.b(this.f22034a);
    }
}
