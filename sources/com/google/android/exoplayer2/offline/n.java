package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadService;

public final /* synthetic */ class n implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadService.ForegroundNotificationUpdater f65967b;

    public /* synthetic */ n(DownloadService.ForegroundNotificationUpdater foregroundNotificationUpdater) {
        this.f65967b = foregroundNotificationUpdater;
    }

    public final void run() {
        this.f65967b.update();
    }
}
