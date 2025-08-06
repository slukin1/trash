package com.tencent.ugc.renderer;

final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50797a;

    private t(VideoRenderer videoRenderer) {
        this.f50797a = videoRenderer;
    }

    public static Runnable a(VideoRenderer videoRenderer) {
        return new t(videoRenderer);
    }

    public final void run() {
        VideoRenderer.lambda$onSurfaceDestroy$15(this.f50797a);
    }
}
