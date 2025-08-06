package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f65826b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f65827c;

    public /* synthetic */ e(AudioRendererEventListener.EventDispatcher eventDispatcher, long j11) {
        this.f65826b = eventDispatcher;
        this.f65827c = j11;
    }

    public final void run() {
        this.f65826b.lambda$positionAdvancing$3(this.f65827c);
    }
}
