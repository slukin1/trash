package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f66111b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f66112c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f66113d;

    public /* synthetic */ j(VideoRendererEventListener.EventDispatcher eventDispatcher, Object obj, long j11) {
        this.f66111b = eventDispatcher;
        this.f66112c = obj;
        this.f66113d = j11;
    }

    public final void run() {
        this.f66111b.lambda$renderedFirstFrame$6(this.f66112c, this.f66113d);
    }
}
