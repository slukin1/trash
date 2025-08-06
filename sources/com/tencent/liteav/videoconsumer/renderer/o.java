package com.tencent.liteav.videoconsumer.renderer;

final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final k f22463a;

    private o(k kVar) {
        this.f22463a = kVar;
    }

    public static Runnable a(k kVar) {
        return new o(kVar);
    }

    public final void run() {
        k.b(this.f22463a);
    }
}
