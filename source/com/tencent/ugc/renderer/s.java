package com.tencent.ugc.renderer;

final /* synthetic */ class s implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50796a;

    private s(VideoRenderer videoRenderer) {
        this.f50796a = videoRenderer;
    }

    public static Runnable a(VideoRenderer videoRenderer) {
        return new s(videoRenderer);
    }

    public final void run() {
        VideoRenderer.lambda$onRequestRedraw$14(this.f50796a);
    }
}
