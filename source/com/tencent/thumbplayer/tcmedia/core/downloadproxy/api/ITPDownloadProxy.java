package com.tencent.thumbplayer.tcmedia.core.downloadproxy.api;

import android.content.Context;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDLProxyMsg;

public interface ITPDownloadProxy {
    boolean checkResourceExist(String str, String str2, long j11);

    int checkResourceStatus(String str, String str2, int i11);

    @Deprecated
    int clearCache(String str, String str2, int i11);

    int clearCache(String str, String str2, int i11, long j11);

    int deinit();

    int deleteOfflineLicenseKeySetId(String str, String str2, String str3);

    String getClipPlayUrl(int i11, int i12, int i13);

    String getNativeInfo(int i11);

    byte[] getOfflineLicenseKeySetId(String str, String str2, String str3);

    TPDLProxyMsg.TPPDTInfo[] getPDTInfos(int i11);

    String getPlayErrorCodeStr(int i11);

    String getPlayUrl(int i11, int i12);

    float getResourceDownloadProgress(String str, String str2, long j11);

    long getResourceSize(String str, String str2);

    int init(Context context, TPDLProxyInitParam tPDLProxyInitParam);

    int pauseDownload(int i11);

    void pushEvent(int i11);

    @Deprecated
    int removeStorageCache(String str);

    int removeStorageCache(String str, long j11);

    int resumeDownload(int i11);

    boolean setClipInfo(int i11, int i12, String str, TPDownloadParam tPDownloadParam);

    void setLogListener(ITPDLProxyLogListener iTPDLProxyLogListener);

    void setMaxStorageSizeMB(long j11);

    void setPlayState(int i11, int i12);

    void setUserData(String str, Object obj);

    int startClipOfflineDownload(String str, int i11, ITPOfflineDownloadListener iTPOfflineDownloadListener);

    int startClipPlay(String str, int i11, ITPPlayListener iTPPlayListener);

    int startClipPreload(String str, int i11, ITPPreLoadListener iTPPreLoadListener);

    int startOfflineDownload(String str, TPDownloadParam tPDownloadParam, ITPOfflineDownloadListener iTPOfflineDownloadListener);

    int startPlay(String str, TPDownloadParam tPDownloadParam, ITPPlayListener iTPPlayListener);

    int startPreload(String str, TPDownloadParam tPDownloadParam, ITPPreLoadListener iTPPreLoadListener);

    void startTask(int i11);

    void stopOfflineDownload(int i11);

    void stopPlay(int i11);

    void stopPreload(int i11);

    void switchToResolution(int i11, int i12, int i13);

    void updateStoragePath(String str);

    void updateTaskInfo(int i11, String str, Object obj);
}
