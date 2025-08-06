package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f66103b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f66104c;

    public /* synthetic */ f(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f66103b = eventDispatcher;
        this.f66104c = decoderCounters;
    }

    public final void run() {
        this.f66103b.lambda$disabled$8(this.f66104c);
    }
}
