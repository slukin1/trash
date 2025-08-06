package com.tencent.liteav.videoconsumer.renderer;

public final /* synthetic */ class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final t f22407a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22408b;

    private ab(t tVar, boolean z11) {
        this.f22407a = tVar;
        this.f22408b = z11;
    }

    public static Runnable a(t tVar, boolean z11) {
        return new ab(tVar, z11);
    }

    public final void run() {
        t.a(this.f22407a, this.f22408b);
    }
}
