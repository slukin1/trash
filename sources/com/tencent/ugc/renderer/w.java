package com.tencent.ugc.renderer;

import com.tencent.liteav.videobase.videobase.DisplayTarget;

final /* synthetic */ class w implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50806a;

    /* renamed from: b  reason: collision with root package name */
    private final DisplayTarget f50807b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f50808c;

    private w(VideoRenderer videoRenderer, DisplayTarget displayTarget, boolean z11) {
        this.f50806a = videoRenderer;
        this.f50807b = displayTarget;
        this.f50808c = z11;
    }

    public static Runnable a(VideoRenderer videoRenderer, DisplayTarget displayTarget, boolean z11) {
        return new w(videoRenderer, displayTarget, z11);
    }

    public final void run() {
        this.f50806a.setDisplayViewInternal(this.f50807b, this.f50808c);
    }
}
