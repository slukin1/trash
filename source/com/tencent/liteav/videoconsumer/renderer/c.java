package com.tencent.liteav.videoconsumer.renderer;

import android.view.Surface;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final b f22420a;

    /* renamed from: b  reason: collision with root package name */
    private final Surface f22421b;

    private c(b bVar, Surface surface) {
        this.f22420a = bVar;
        this.f22421b = surface;
    }

    public static Runnable a(b bVar, Surface surface) {
        return new c(bVar, surface);
    }

    public final void run() {
        b.a(this.f22420a, this.f22421b);
    }
}
