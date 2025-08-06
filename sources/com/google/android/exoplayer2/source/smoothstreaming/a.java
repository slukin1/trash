package com.google.android.exoplayer2.source.smoothstreaming;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SsMediaSource f66049b;

    public /* synthetic */ a(SsMediaSource ssMediaSource) {
        this.f66049b = ssMediaSource;
    }

    public final void run() {
        this.f66049b.startLoadingManifest();
    }
}
