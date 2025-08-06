package com.tencent.liteav.videoconsumer.renderer;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final t f22499a;

    private v(t tVar) {
        this.f22499a = tVar;
    }

    public static Runnable a(t tVar) {
        return new v(tVar);
    }

    public final void run() {
        t.c(this.f22499a);
    }
}
