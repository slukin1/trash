package com.tencent.liteav.videoconsumer.renderer;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final b f22422a;

    private d(b bVar) {
        this.f22422a = bVar;
    }

    public static Runnable a(b bVar) {
        return new d(bVar);
    }

    public final void run() {
        b.b(this.f22422a);
    }
}
