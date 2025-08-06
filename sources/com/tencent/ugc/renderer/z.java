package com.tencent.ugc.renderer;

import com.tencent.ugc.videobase.base.GLConstants;

final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50814a;

    /* renamed from: b  reason: collision with root package name */
    private final GLConstants.GLScaleType f50815b;

    private z(VideoRenderer videoRenderer, GLConstants.GLScaleType gLScaleType) {
        this.f50814a = videoRenderer;
        this.f50815b = gLScaleType;
    }

    public static Runnable a(VideoRenderer videoRenderer, GLConstants.GLScaleType gLScaleType) {
        return new z(videoRenderer, gLScaleType);
    }

    public final void run() {
        VideoRenderer.lambda$setScaleType$5(this.f50814a, this.f50815b);
    }
}
