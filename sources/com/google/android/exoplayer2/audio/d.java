package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f65822b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f65823c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f65824d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f65825e;

    public /* synthetic */ d(AudioRendererEventListener.EventDispatcher eventDispatcher, int i11, long j11, long j12) {
        this.f65822b = eventDispatcher;
        this.f65823c = i11;
        this.f65824d = j11;
        this.f65825e = j12;
    }

    public final void run() {
        this.f65822b.lambda$underrun$4(this.f65823c, this.f65824d, this.f65825e);
    }
}
