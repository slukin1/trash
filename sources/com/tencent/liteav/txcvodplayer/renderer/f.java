package com.tencent.liteav.txcvodplayer.renderer;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final d f22035a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22036b;

    private f(d dVar, boolean z11) {
        this.f22035a = dVar;
        this.f22036b = z11;
    }

    public static Runnable a(d dVar, boolean z11) {
        return new f(dVar, z11);
    }

    public final void run() {
        d.a(this.f22035a, this.f22036b);
    }
}
