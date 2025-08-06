package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f65835b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f65836c;

    public /* synthetic */ i(AudioRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.f65835b = eventDispatcher;
        this.f65836c = exc;
    }

    public final void run() {
        this.f65835b.lambda$audioCodecError$9(this.f65836c);
    }
}
