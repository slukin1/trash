package com.google.android.exoplayer2;

public final /* synthetic */ class d0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImplInternal f65851b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlayerMessage f65852c;

    public /* synthetic */ d0(ExoPlayerImplInternal exoPlayerImplInternal, PlayerMessage playerMessage) {
        this.f65851b = exoPlayerImplInternal;
        this.f65852c = playerMessage;
    }

    public final void run() {
        this.f65851b.lambda$sendMessageToTargetThread$1(this.f65852c);
    }
}
