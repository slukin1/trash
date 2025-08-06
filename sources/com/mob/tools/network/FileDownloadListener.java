package com.mob.tools.network;

import com.mob.tools.proguard.EverythingKeeper;

@Deprecated
public abstract class FileDownloadListener implements EverythingKeeper {
    private boolean isCanceled = false;

    public void cancel() {
        this.isCanceled = true;
    }

    public boolean isCanceled() {
        return this.isCanceled;
    }

    public abstract void onProgress(int i11, long j11, long j12);
}
