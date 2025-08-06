package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videobase.videobase.DisplayTarget;

final /* synthetic */ class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final t f22409a;

    /* renamed from: b  reason: collision with root package name */
    private final DisplayTarget f22410b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f22411c;

    private ac(t tVar, DisplayTarget displayTarget, boolean z11) {
        this.f22409a = tVar;
        this.f22410b = displayTarget;
        this.f22411c = z11;
    }

    public static Runnable a(t tVar, DisplayTarget displayTarget, boolean z11) {
        return new ac(tVar, displayTarget, z11);
    }

    public final void run() {
        this.f22409a.b(this.f22410b, this.f22411c);
    }
}
