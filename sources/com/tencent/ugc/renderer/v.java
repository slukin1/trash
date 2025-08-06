package com.tencent.ugc.renderer;

final /* synthetic */ class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50804a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50805b;

    private v(VideoRenderer videoRenderer, boolean z11) {
        this.f50804a = videoRenderer;
        this.f50805b = z11;
    }

    public static Runnable a(VideoRenderer videoRenderer, boolean z11) {
        return new v(videoRenderer, z11);
    }

    public final void run() {
        VideoRenderer.lambda$stop$1(this.f50804a, this.f50805b);
    }
}
