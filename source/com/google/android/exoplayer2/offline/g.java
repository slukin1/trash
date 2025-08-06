package com.google.android.exoplayer2.offline;

import java.io.IOException;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadHelper f65959b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IOException f65960c;

    public /* synthetic */ g(DownloadHelper downloadHelper, IOException iOException) {
        this.f65959b = downloadHelper;
        this.f65960c = iOException;
    }

    public final void run() {
        this.f65959b.lambda$onMediaPreparationFailed$5(this.f65960c);
    }
}
