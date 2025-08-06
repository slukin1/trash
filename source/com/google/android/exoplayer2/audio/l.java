package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f65841b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f65842c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f65843d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f65844e;

    public /* synthetic */ l(AudioRendererEventListener.EventDispatcher eventDispatcher, String str, long j11, long j12) {
        this.f65841b = eventDispatcher;
        this.f65842c = str;
        this.f65843d = j11;
        this.f65844e = j12;
    }

    public final void run() {
        this.f65841b.lambda$decoderInitialized$1(this.f65842c, this.f65843d, this.f65844e);
    }
}
