package com.tencent.liteav.txcvodplayer.renderer;

import com.tencent.liteav.videobase.base.GLConstants;

final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final d f22042a;

    /* renamed from: b  reason: collision with root package name */
    private final GLConstants.GLScaleType f22043b;

    private i(d dVar, GLConstants.GLScaleType gLScaleType) {
        this.f22042a = dVar;
        this.f22043b = gLScaleType;
    }

    public static Runnable a(d dVar, GLConstants.GLScaleType gLScaleType) {
        return new i(dVar, gLScaleType);
    }

    public final void run() {
        d.a(this.f22042a, this.f22043b);
    }
}
