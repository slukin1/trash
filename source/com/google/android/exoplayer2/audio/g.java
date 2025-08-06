package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f65831b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DecoderCounters f65832c;

    public /* synthetic */ g(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.f65831b = eventDispatcher;
        this.f65832c = decoderCounters;
    }

    public final void run() {
        this.f65831b.lambda$disabled$6(this.f65832c);
    }
}
