package com.tencent.ugc.renderer;

final /* synthetic */ class ac implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50763a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50764b;

    private ac(VideoRenderer videoRenderer, boolean z11) {
        this.f50763a = videoRenderer;
        this.f50764b = z11;
    }

    public static Runnable a(VideoRenderer videoRenderer, boolean z11) {
        return new ac(videoRenderer, z11);
    }

    public final void run() {
        VideoRenderer.lambda$setVerticalMirror$8(this.f50763a, this.f50764b);
    }
}
