package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f66094b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f66095c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f66096d;

    public /* synthetic */ c(VideoRendererEventListener.EventDispatcher eventDispatcher, int i11, long j11) {
        this.f66094b = eventDispatcher;
        this.f66095c = i11;
        this.f66096d = j11;
    }

    public final void run() {
        this.f66094b.lambda$droppedFrames$3(this.f66095c, this.f66096d);
    }
}
