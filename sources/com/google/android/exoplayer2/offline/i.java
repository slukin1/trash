package com.google.android.exoplayer2.offline;

import android.os.Handler;
import android.os.Message;

public final /* synthetic */ class i implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadManager f65962b;

    public /* synthetic */ i(DownloadManager downloadManager) {
        this.f65962b = downloadManager;
    }

    public final boolean handleMessage(Message message) {
        return this.f65962b.handleMainMessage(message);
    }
}
