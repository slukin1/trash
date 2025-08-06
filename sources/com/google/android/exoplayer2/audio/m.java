package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f65845b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f65846c;

    public /* synthetic */ m(AudioRendererEventListener.EventDispatcher eventDispatcher, boolean z11) {
        this.f65845b = eventDispatcher;
        this.f65846c = z11;
    }

    public final void run() {
        this.f65845b.lambda$skipSilenceEnabledChanged$7(this.f65846c);
    }
}
