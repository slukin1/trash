package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f65837b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Exception f65838c;

    public /* synthetic */ j(AudioRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.f65837b = eventDispatcher;
        this.f65838c = exc;
    }

    public final void run() {
        this.f65837b.lambda$audioSinkError$8(this.f65838c);
    }
}
