package com.google.android.exoplayer2;

public final /* synthetic */ class u0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StreamVolumeManager f66072b;

    public /* synthetic */ u0(StreamVolumeManager streamVolumeManager) {
        this.f66072b = streamVolumeManager;
    }

    public final void run() {
        this.f66072b.updateVolumeAndNotifyIfChanged();
    }
}
