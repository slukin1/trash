package com.tencent.liteav.txcvodplayer.renderer;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final d f22046a;

    private k(d dVar) {
        this.f22046a = dVar;
    }

    public static Runnable a(d dVar) {
        return new k(dVar);
    }

    public final void run() {
        d.a(this.f22046a);
    }
}
