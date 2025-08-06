package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlayerImplInternal;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImpl f65974b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExoPlayerImplInternal.PlaybackInfoUpdate f65975c;

    public /* synthetic */ s(ExoPlayerImpl exoPlayerImpl, ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.f65974b = exoPlayerImpl;
        this.f65975c = playbackInfoUpdate;
    }

    public final void run() {
        this.f65974b.lambda$new$1(this.f65975c);
    }
}
