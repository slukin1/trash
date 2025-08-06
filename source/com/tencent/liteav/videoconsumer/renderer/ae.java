package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.base.util.k;

final /* synthetic */ class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final t f22414a;

    /* renamed from: b  reason: collision with root package name */
    private final k f22415b;

    private ae(t tVar, k kVar) {
        this.f22414a = tVar;
        this.f22415b = kVar;
    }

    public static Runnable a(t tVar, k kVar) {
        return new ae(tVar, kVar);
    }

    public final void run() {
        t.a(this.f22414a, this.f22415b);
    }
}
