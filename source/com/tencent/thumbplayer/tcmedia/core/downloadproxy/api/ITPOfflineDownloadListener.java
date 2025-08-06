package com.tencent.thumbplayer.tcmedia.core.downloadproxy.api;

import java.util.Map;

public interface ITPOfflineDownloadListener {
    void onDownloadCdnUrlExpired(Map<String, String> map);

    void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4);

    void onDownloadCdnUrlUpdate(String str);

    void onDownloadError(int i11, int i12, String str);

    void onDownloadFinish();

    void onDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str);

    void onDownloadProtocolUpdate(String str, String str2);

    void onDownloadStatusUpdate(int i11);
}
