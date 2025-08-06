package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f66109b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f66110c;

    public /* synthetic */ i(VideoRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.f66109b = eventDispatcher;
        this.f66110c = exc;
    }

    public final void run() {
        this.f66109b.lambda$videoCodecError$9(this.f66110c);
    }
}
