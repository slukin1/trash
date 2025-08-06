package com.tencent.ugc.renderer;

import android.view.Surface;

final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50793a;

    /* renamed from: b  reason: collision with root package name */
    private final Surface f50794b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f50795c;

    private r(VideoRenderer videoRenderer, Surface surface, boolean z11) {
        this.f50793a = videoRenderer;
        this.f50794b = surface;
        this.f50795c = z11;
    }

    public static Runnable a(VideoRenderer videoRenderer, Surface surface, boolean z11) {
        return new r(videoRenderer, surface, z11);
    }

    public final void run() {
        VideoRenderer.lambda$onSurfaceChanged$13(this.f50793a, this.f50794b, this.f50795c);
    }
}
