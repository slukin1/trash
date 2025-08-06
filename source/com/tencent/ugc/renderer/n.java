package com.tencent.ugc.renderer;

final /* synthetic */ class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50782a;

    /* renamed from: b  reason: collision with root package name */
    private final VideoRenderListener f50783b;

    private n(VideoRenderer videoRenderer, VideoRenderListener videoRenderListener) {
        this.f50782a = videoRenderer;
        this.f50783b = videoRenderListener;
    }

    public static Runnable a(VideoRenderer videoRenderer, VideoRenderListener videoRenderListener) {
        return new n(videoRenderer, videoRenderListener);
    }

    public final void run() {
        VideoRenderer.lambda$start$0(this.f50782a, this.f50783b);
    }
}
