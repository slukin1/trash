package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f66114b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f66115c;

    public /* synthetic */ k(VideoRendererEventListener.EventDispatcher eventDispatcher, String str) {
        this.f66114b = eventDispatcher;
        this.f66115c = str;
    }

    public final void run() {
        this.f66114b.lambda$decoderReleased$7(this.f66115c);
    }
}
