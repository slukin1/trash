package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f65839b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f65840c;

    public /* synthetic */ k(AudioRendererEventListener.EventDispatcher eventDispatcher, String str) {
        this.f65839b = eventDispatcher;
        this.f65840c = str;
    }

    public final void run() {
        this.f65839b.lambda$decoderReleased$5(this.f65840c);
    }
}
