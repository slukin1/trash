package com.google.android.exoplayer2.source.dash;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DashMediaSource f66003b;

    public /* synthetic */ a(DashMediaSource dashMediaSource) {
        this.f66003b = dashMediaSource;
    }

    public final void run() {
        this.f66003b.startLoadingManifest();
    }
}
