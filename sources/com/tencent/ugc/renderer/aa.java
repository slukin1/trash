package com.tencent.ugc.renderer;

import com.tencent.liteav.base.util.k;

final /* synthetic */ class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50759a;

    /* renamed from: b  reason: collision with root package name */
    private final k f50760b;

    private aa(VideoRenderer videoRenderer, k kVar) {
        this.f50759a = videoRenderer;
        this.f50760b = kVar;
    }

    public static Runnable a(VideoRenderer videoRenderer, k kVar) {
        return new aa(videoRenderer, kVar);
    }

    public final void run() {
        VideoRenderer.lambda$setRenderRotation$6(this.f50759a, this.f50760b);
    }
}
