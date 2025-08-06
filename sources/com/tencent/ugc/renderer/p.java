package com.tencent.ugc.renderer;

final /* synthetic */ class p implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50785a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50786b;

    private p(VideoRenderer videoRenderer, boolean z11) {
        this.f50785a = videoRenderer;
        this.f50786b = z11;
    }

    public static Runnable a(VideoRenderer videoRenderer, boolean z11) {
        return new p(videoRenderer, z11);
    }

    public final void run() {
        this.f50785a.mIsHDR = this.f50786b;
    }
}
