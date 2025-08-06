package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadService;

public final /* synthetic */ class m implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadService.DownloadManagerHelper f65965b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DownloadService f65966c;

    public /* synthetic */ m(DownloadService.DownloadManagerHelper downloadManagerHelper, DownloadService downloadService) {
        this.f65965b = downloadManagerHelper;
        this.f65966c = downloadService;
    }

    public final void run() {
        this.f65965b.lambda$attachService$0(this.f65966c);
    }
}
