package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f65833b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f65834c;

    public /* synthetic */ h(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f65833b = eventDispatcher;
        this.f65834c = decoderCounters;
    }

    public final void run() {
        this.f65833b.lambda$enabled$0(this.f65834c);
    }
}
