package com.tencent.liteav.txcvodplayer.renderer;

import com.tencent.liteav.videobase.videobase.DisplayTarget;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final d f22037a;

    /* renamed from: b  reason: collision with root package name */
    private final DisplayTarget f22038b;

    private g(d dVar, DisplayTarget displayTarget) {
        this.f22037a = dVar;
        this.f22038b = displayTarget;
    }

    public static Runnable a(d dVar, DisplayTarget displayTarget) {
        return new g(dVar, displayTarget);
    }

    public final void run() {
        d.a(this.f22037a, this.f22038b);
    }
}
