package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f66097b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f66098c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f66099d;

    public /* synthetic */ d(VideoRendererEventListener.EventDispatcher eventDispatcher, long j11, int i11) {
        this.f66097b = eventDispatcher;
        this.f66098c = j11;
        this.f66099d = i11;
    }

    public final void run() {
        this.f66097b.lambda$reportVideoFrameProcessingOffset$4(this.f66098c, this.f66099d);
    }
}
