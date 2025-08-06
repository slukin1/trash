package com.tencent.liteav.videoconsumer.renderer;

final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final k f22464a;

    private p(k kVar) {
        this.f22464a = kVar;
    }

    public static Runnable a(k kVar) {
        return new p(kVar);
    }

    public final void run() {
        this.f22464a.b(this.f22464a.f22441a);
    }
}
