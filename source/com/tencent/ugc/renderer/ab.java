package com.tencent.ugc.renderer;

final /* synthetic */ class ab implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50761a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50762b;

    private ab(VideoRenderer videoRenderer, boolean z11) {
        this.f50761a = videoRenderer;
        this.f50762b = z11;
    }

    public static Runnable a(VideoRenderer videoRenderer, boolean z11) {
        return new ab(videoRenderer, z11);
    }

    public final void run() {
        VideoRenderer.lambda$setHorizontalMirror$7(this.f50761a, this.f50762b);
    }
}
