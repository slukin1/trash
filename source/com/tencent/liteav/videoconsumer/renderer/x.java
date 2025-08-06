package com.tencent.liteav.videoconsumer.renderer;

import android.view.Surface;

final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final t f22506a;

    /* renamed from: b  reason: collision with root package name */
    private final Surface f22507b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f22508c;

    private x(t tVar, Surface surface, boolean z11) {
        this.f22506a = tVar;
        this.f22507b = surface;
        this.f22508c = z11;
    }

    public static Runnable a(t tVar, Surface surface, boolean z11) {
        return new x(tVar, surface, z11);
    }

    public final void run() {
        t.a(this.f22506a, this.f22507b, this.f22508c);
    }
}
