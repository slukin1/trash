package com.tencent.liteav.txcvodplayer.renderer;

import com.tencent.liteav.base.util.k;

final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final d f22044a;

    /* renamed from: b  reason: collision with root package name */
    private final k f22045b;

    private j(d dVar, k kVar) {
        this.f22044a = dVar;
        this.f22045b = kVar;
    }

    public static Runnable a(d dVar, k kVar) {
        return new j(dVar, kVar);
    }

    public final void run() {
        d.a(this.f22044a, this.f22045b);
    }
}
