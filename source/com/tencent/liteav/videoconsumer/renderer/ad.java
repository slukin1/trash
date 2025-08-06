package com.tencent.liteav.videoconsumer.renderer;

import com.tencent.liteav.videobase.base.GLConstants;

final /* synthetic */ class ad implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final t f22412a;

    /* renamed from: b  reason: collision with root package name */
    private final GLConstants.GLScaleType f22413b;

    private ad(t tVar, GLConstants.GLScaleType gLScaleType) {
        this.f22412a = tVar;
        this.f22413b = gLScaleType;
    }

    public static Runnable a(t tVar, GLConstants.GLScaleType gLScaleType) {
        return new ad(tVar, gLScaleType);
    }

    public final void run() {
        t.a(this.f22412a, this.f22413b);
    }
}
