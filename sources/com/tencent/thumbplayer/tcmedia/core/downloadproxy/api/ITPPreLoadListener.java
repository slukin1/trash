package com.tencent.thumbplayer.tcmedia.core.downloadproxy.api;

public interface ITPPreLoadListener {
    void onPrepareDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str);

    void onPrepareError(int i11, int i12, String str);

    void onPrepareOK();
}
