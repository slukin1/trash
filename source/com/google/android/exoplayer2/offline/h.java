package com.google.android.exoplayer2.offline;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.offline.DownloadHelper;

public final /* synthetic */ class h implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DownloadHelper.MediaPreparer f65961b;

    public /* synthetic */ h(DownloadHelper.MediaPreparer mediaPreparer) {
        this.f65961b = mediaPreparer;
    }

    public final boolean handleMessage(Message message) {
        return this.f65961b.handleDownloadHelperCallbackMessage(message);
    }
}
