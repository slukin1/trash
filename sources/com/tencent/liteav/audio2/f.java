package com.tencent.liteav.audio2;

final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final e f21387a;

    private f(e eVar) {
        this.f21387a = eVar;
    }

    public static Runnable a(e eVar) {
        return new f(eVar);
    }

    public final void run() {
        e.a(this.f21387a);
    }
}
