package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f66105b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f66106c;

    public /* synthetic */ g(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f66105b = eventDispatcher;
        this.f66106c = decoderCounters;
    }

    public final void run() {
        this.f66105b.lambda$enabled$0(this.f66106c);
    }
}
