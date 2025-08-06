package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.scheduler.RequirementsWatcher;

public final /* synthetic */ class j implements RequirementsWatcher.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DownloadManager f65963a;

    public /* synthetic */ j(DownloadManager downloadManager) {
        this.f65963a = downloadManager;
    }

    public final void onRequirementsStateChanged(RequirementsWatcher requirementsWatcher, int i11) {
        this.f65963a.onRequirementsStateChanged(requirementsWatcher, i11);
    }
}
