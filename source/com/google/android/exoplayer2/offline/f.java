package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadHelper;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadHelper f65957b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DownloadHelper.Callback f65958c;

    public /* synthetic */ f(DownloadHelper downloadHelper, DownloadHelper.Callback callback) {
        this.f65957b = downloadHelper;
        this.f65958c = callback;
    }

    public final void run() {
        this.f65957b.lambda$prepare$3(this.f65958c);
    }
}
