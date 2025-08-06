package com.tencent.ugc.renderer;

final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50784a;

    private o(VideoRenderer videoRenderer) {
        this.f50784a = videoRenderer;
    }

    public static Runnable a(VideoRenderer videoRenderer) {
        return new o(videoRenderer);
    }

    public final void run() {
        VideoRenderer.lambda$renderFrame$9(this.f50784a);
    }
}
