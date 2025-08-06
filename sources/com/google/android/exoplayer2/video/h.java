package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f66107b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VideoSize f66108c;

    public /* synthetic */ h(VideoRendererEventListener.EventDispatcher eventDispatcher, VideoSize videoSize) {
        this.f66107b = eventDispatcher;
        this.f66108c = videoSize;
    }

    public final void run() {
        this.f66107b.lambda$videoSizeChanged$5(this.f66108c);
    }
}
