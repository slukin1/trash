package com.tencent.thumbplayer.tcmedia.core.downloadproxy.client;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl.ITPDownloadProxyAidl;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl.ITPPlayListenerAidl;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl.ITPPreLoadListenerAidl;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl.TPDownloadParamAidl;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPOfflineDownloadListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDLProxyMsg;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TPDownloadProxyClient implements ITPDownloadProxy {
    private static final String FILE_NAME = "TPDownloadProxyClient";
    private ITPDownloadProxyAidl downloadProxyAidl = null;

    public TPDownloadProxyClient(ITPDownloadProxyAidl iTPDownloadProxyAidl) {
        this.downloadProxyAidl = iTPDownloadProxyAidl;
    }

    public boolean checkResourceExist(String str, String str2, long j11) {
        try {
            return this.downloadProxyAidl.checkResourceExist(str, str2, j11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "checkResourceExist failed, error:" + th2.toString());
            return false;
        }
    }

    public int checkResourceStatus(String str, String str2, int i11) {
        try {
            return this.downloadProxyAidl.checkResourceStatus(str, str2, i11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "checkResourceStatus failed, error:" + th2.toString());
            return -1;
        }
    }

    public int clearCache(String str, String str2, int i11) {
        return clearCache(str, str2, i11, -1);
    }

    public int deinit() {
        return 0;
    }

    public int deleteOfflineLicenseKeySetId(String str, String str2, String str3) {
        try {
            return this.downloadProxyAidl.deleteOfflineLicenseKeySetId(str, str2, str3);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "deleteOfflineLicenseKeySetId failed, error:" + th2.toString());
            return -1;
        }
    }

    public String getClipPlayUrl(int i11, int i12, int i13) {
        try {
            return this.downloadProxyAidl.getClipPlayUrl(i11, i12, i13);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getClipPlayUrl failed, error:" + th2.toString());
            return null;
        }
    }

    public String getNativeInfo(int i11) {
        try {
            return this.downloadProxyAidl.getNativeInfo(i11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getNativeInfo failed, error:" + th2.toString());
            return null;
        }
    }

    public byte[] getOfflineLicenseKeySetId(String str, String str2, String str3) {
        try {
            return this.downloadProxyAidl.getOfflineLicenseKeySetId(str, str2, str3);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getOfflineLicenseKeySetId failed, error:" + th2.toString());
            return null;
        }
    }

    public TPDLProxyMsg.TPPDTInfo[] getPDTInfos(int i11) {
        return new TPDLProxyMsg.TPPDTInfo[0];
    }

    public String getPlayErrorCodeStr(int i11) {
        try {
            return this.downloadProxyAidl.getPlayErrorCodeStr(i11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayErrorCodeStr failed, error:" + th2.toString());
            return null;
        }
    }

    public String getPlayUrl(int i11, int i12) {
        try {
            return this.downloadProxyAidl.getPlayUrl(i11, i12);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayUrl failed, error:" + th2.toString());
            return null;
        }
    }

    public float getResourceDownloadProgress(String str, String str2, long j11) {
        try {
            return this.downloadProxyAidl.getResourceDownloadProgress(str, str2, j11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getResourceDownloadProgress failed, error:" + th2.toString());
            return -1.0f;
        }
    }

    public long getResourceSize(String str, String str2) {
        try {
            return this.downloadProxyAidl.getResourceSize(str, str2);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getResourceSize failed, error:" + th2.toString());
            return -1;
        }
    }

    public int init(Context context, TPDLProxyInitParam tPDLProxyInitParam) {
        String serialize = TPDLProxyUtils.serialize(tPDLProxyInitParam);
        if (TextUtils.isEmpty(serialize)) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "param is null");
            return -1;
        }
        try {
            return this.downloadProxyAidl.init(serialize);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "init failed, error:" + th2.toString());
            return -2;
        }
    }

    public int pauseDownload(int i11) {
        try {
            return this.downloadProxyAidl.pauseDownload(i11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "pauseDownload failed, error:" + th2.toString());
            return -1;
        }
    }

    public void pushEvent(int i11) {
        try {
            this.downloadProxyAidl.pushEvent(i11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "pushEvent failed, error:" + th2.toString());
        }
    }

    public int removeStorageCache(String str) {
        return removeStorageCache(str, -1);
    }

    public int resumeDownload(int i11) {
        try {
            return this.downloadProxyAidl.resumeDownload(i11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "resumeDownload failed, error:" + th2.toString());
            return -1;
        }
    }

    public boolean setClipInfo(int i11, int i12, String str, TPDownloadParam tPDownloadParam) {
        try {
            return this.downloadProxyAidl.setClipInfo(i11, i12, str, new TPDownloadParamAidl(tPDownloadParam.getUrlList(), tPDownloadParam.getDlType(), tPDownloadParam.getExtInfoMap()));
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setClipInfo failed, error:" + th2.toString());
            return false;
        }
    }

    public void setLogListener(ITPDLProxyLogListener iTPDLProxyLogListener) {
        TPDLProxyLog.setLogListener(10303, iTPDLProxyLogListener);
    }

    public void setMaxStorageSizeMB(long j11) {
        try {
            this.downloadProxyAidl.setMaxStorageSizeMB(j11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setMaxStorageSizeMB failed, error:" + th2.toString());
        }
    }

    public void setPlayState(int i11, int i12) {
        try {
            this.downloadProxyAidl.setPlayState(i11, i12);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setPlayState failed, error:" + th2.toString());
        }
    }

    public void setUserData(String str, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, obj);
        try {
            this.downloadProxyAidl.setUserData(hashMap);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setUserData failed, error:" + th2.toString());
        }
    }

    public int startClipOfflineDownload(String str, int i11, ITPOfflineDownloadListener iTPOfflineDownloadListener) {
        return -1;
    }

    public int startClipPlay(String str, int i11, final ITPPlayListener iTPPlayListener) {
        if (iTPPlayListener == null) {
            try {
                return this.downloadProxyAidl.startClipPlay(str, i11, (ITPPlayListenerAidl) null);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startClipPlay failed, error:" + th2.toString());
                return -1;
            }
        } else {
            return this.downloadProxyAidl.startClipPlay(str, i11, new ITPPlayListenerAidl.Stub() {
                public long getAdvRemainTime() {
                    return iTPPlayListener.getAdvRemainTime();
                }

                public String getContentType(int i11, String str) throws RemoteException {
                    return null;
                }

                public int getCurrentPlayClipNo() {
                    return iTPPlayListener.getCurrentPlayClipNo();
                }

                public long getCurrentPlayOffset() {
                    return iTPPlayListener.getCurrentPlayOffset();
                }

                public long getCurrentPosition() {
                    return iTPPlayListener.getCurrentPosition();
                }

                public String getDataFilePath(int i11, String str) throws RemoteException {
                    return null;
                }

                public long getDataTotalSize(int i11, String str) throws RemoteException {
                    return 0;
                }

                public String getPlayInfo(String str) {
                    Class<String> cls = String.class;
                    Object playInfo = iTPPlayListener.getPlayInfo(str);
                    if (playInfo == null || playInfo.getClass() != cls) {
                        return null;
                    }
                    if (playInfo.getClass() == cls) {
                        return (String) playInfo;
                    }
                    if (playInfo.getClass() == Integer.class) {
                        return Integer.toString(((Integer) playInfo).intValue());
                    }
                    return null;
                }

                public long getPlayerBufferLength() {
                    return iTPPlayListener.getPlayerBufferLength();
                }

                public void onDownloadCdnUrlExpired(Map map) {
                    iTPPlayListener.onDownloadCdnUrlExpired(map);
                }

                public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
                    iTPPlayListener.onDownloadCdnUrlInfoUpdate(str, str2, str3, str4);
                }

                public void onDownloadCdnUrlUpdate(String str) {
                    iTPPlayListener.onDownloadCdnUrlUpdate(str);
                }

                public void onDownloadError(int i11, int i12, String str) {
                    iTPPlayListener.onDownloadError(i11, i12, str);
                }

                public void onDownloadFinish() {
                    iTPPlayListener.onDownloadFinish();
                }

                public void onDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) {
                    iTPPlayListener.onDownloadProgressUpdate(i11, i12, j11, j12, str);
                }

                public void onDownloadProtocolUpdate(String str, String str2) {
                    iTPPlayListener.onDownloadProtocolUpdate(str, str2);
                }

                public void onDownloadStatusUpdate(int i11) {
                    iTPPlayListener.onDownloadStatusUpdate(i11);
                }

                public int onPlayCallback(int i11, List list) {
                    Object obj = 0;
                    if (list != null && !list.isEmpty()) {
                        if (list.size() == 1) {
                            obj = iTPPlayListener.onPlayCallback(i11, list.get(0), (Object) null, (Object) null, (Object) null);
                        } else if (list.size() == 2) {
                            obj = iTPPlayListener.onPlayCallback(i11, list.get(0), list.get(1), (Object) null, (Object) null);
                        } else if (list.size() == 3) {
                            obj = iTPPlayListener.onPlayCallback(i11, list.get(0), list.get(1), list.get(2), (Object) null);
                        }
                    }
                    if (obj == null || obj.getClass() != Integer.class) {
                        return -1;
                    }
                    return ((Integer) obj).intValue();
                }

                public int onReadData(int i11, String str, long j11, long j12) throws RemoteException {
                    return 0;
                }

                public int onStartReadData(int i11, String str, long j11, long j12) throws RemoteException {
                    return 0;
                }

                public int onStopReadData(int i11, String str, int i12) throws RemoteException {
                    return 0;
                }
            });
        }
    }

    public int startClipPreload(String str, int i11, final ITPPreLoadListener iTPPreLoadListener) {
        try {
            return this.downloadProxyAidl.startClipPreload(str, i11, new ITPPreLoadListenerAidl.Stub() {
                public void onPrepareDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) {
                    iTPPreLoadListener.onPrepareDownloadProgressUpdate(i11, i12, j11, j12, str);
                }

                public void onPrepareError(int i11, int i12, String str) {
                    iTPPreLoadListener.onPrepareError(i11, i12, str);
                }

                public void onPrepareOK() {
                    iTPPreLoadListener.onPrepareOK();
                }
            });
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startClipPreload failed, error:" + th2.toString());
            return -1;
        }
    }

    public int startOfflineDownload(String str, TPDownloadParam tPDownloadParam, ITPOfflineDownloadListener iTPOfflineDownloadListener) {
        return -1;
    }

    public int startPlay(String str, TPDownloadParam tPDownloadParam, final ITPPlayListener iTPPlayListener) {
        if (!(this.downloadProxyAidl == null || tPDownloadParam == null)) {
            TPDownloadParamAidl tPDownloadParamAidl = new TPDownloadParamAidl(tPDownloadParam.getUrlList(), tPDownloadParam.getDlType(), tPDownloadParam.getExtInfoMap());
            if (iTPPlayListener == null) {
                try {
                    return this.downloadProxyAidl.startPlay(str, tPDownloadParamAidl, (ITPPlayListenerAidl) null);
                } catch (Throwable th2) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPlay failed, error:" + th2.toString());
                }
            } else {
                return this.downloadProxyAidl.startPlay(str, tPDownloadParamAidl, new ITPPlayListenerAidl.Stub() {
                    public long getAdvRemainTime() {
                        return iTPPlayListener.getAdvRemainTime();
                    }

                    public String getContentType(int i11, String str) throws RemoteException {
                        return iTPPlayListener.getContentType(i11, str);
                    }

                    public int getCurrentPlayClipNo() {
                        return iTPPlayListener.getCurrentPlayClipNo();
                    }

                    public long getCurrentPlayOffset() {
                        return iTPPlayListener.getCurrentPlayOffset();
                    }

                    public long getCurrentPosition() {
                        return iTPPlayListener.getCurrentPosition();
                    }

                    public String getDataFilePath(int i11, String str) throws RemoteException {
                        return iTPPlayListener.getDataFilePath(i11, str);
                    }

                    public long getDataTotalSize(int i11, String str) throws RemoteException {
                        return iTPPlayListener.getDataTotalSize(i11, str);
                    }

                    public String getPlayInfo(String str) {
                        Class<String> cls = String.class;
                        Object playInfo = iTPPlayListener.getPlayInfo(str);
                        if (playInfo == null || playInfo.getClass() != cls) {
                            return null;
                        }
                        if (playInfo.getClass() == cls) {
                            return (String) playInfo;
                        }
                        if (playInfo.getClass() == Integer.class) {
                            return Integer.toString(((Integer) playInfo).intValue());
                        }
                        return null;
                    }

                    public long getPlayerBufferLength() {
                        return iTPPlayListener.getPlayerBufferLength();
                    }

                    public void onDownloadCdnUrlExpired(Map map) {
                        iTPPlayListener.onDownloadCdnUrlExpired(map);
                    }

                    public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
                        iTPPlayListener.onDownloadCdnUrlInfoUpdate(str, str2, str3, str4);
                    }

                    public void onDownloadCdnUrlUpdate(String str) {
                        iTPPlayListener.onDownloadCdnUrlUpdate(str);
                    }

                    public void onDownloadError(int i11, int i12, String str) {
                        iTPPlayListener.onDownloadError(i11, i12, str);
                    }

                    public void onDownloadFinish() {
                        iTPPlayListener.onDownloadFinish();
                    }

                    public void onDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) {
                        iTPPlayListener.onDownloadProgressUpdate(i11, i12, j11, j12, str);
                    }

                    public void onDownloadProtocolUpdate(String str, String str2) {
                        iTPPlayListener.onDownloadProtocolUpdate(str, str2);
                    }

                    public void onDownloadStatusUpdate(int i11) {
                        iTPPlayListener.onDownloadStatusUpdate(i11);
                    }

                    public int onPlayCallback(int i11, List list) {
                        Object obj = 0;
                        if (list != null && !list.isEmpty()) {
                            if (list.size() == 1) {
                                obj = iTPPlayListener.onPlayCallback(i11, list.get(0), (Object) null, (Object) null, (Object) null);
                            } else if (list.size() == 2) {
                                obj = iTPPlayListener.onPlayCallback(i11, list.get(0), list.get(1), (Object) null, (Object) null);
                            } else if (list.size() == 3) {
                                obj = iTPPlayListener.onPlayCallback(i11, list.get(0), list.get(1), list.get(2), (Object) null);
                            }
                        }
                        if (obj == null || obj.getClass() != Integer.class) {
                            return -1;
                        }
                        return ((Integer) obj).intValue();
                    }

                    public int onReadData(int i11, String str, long j11, long j12) throws RemoteException {
                        return iTPPlayListener.onReadData(i11, str, j11, j12);
                    }

                    public int onStartReadData(int i11, String str, long j11, long j12) throws RemoteException {
                        return iTPPlayListener.onStartReadData(i11, str, j11, j12);
                    }

                    public int onStopReadData(int i11, String str, int i12) throws RemoteException {
                        return iTPPlayListener.onStopReadData(i11, str, i12);
                    }
                });
            }
        }
        return -1;
    }

    public int startPreload(String str, TPDownloadParam tPDownloadParam, final ITPPreLoadListener iTPPreLoadListener) {
        try {
            return this.downloadProxyAidl.startPreload(str, new TPDownloadParamAidl(tPDownloadParam.getUrlList(), tPDownloadParam.getDlType(), tPDownloadParam.getExtInfoMap()), new ITPPreLoadListenerAidl.Stub() {
                public void onPrepareDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) {
                    iTPPreLoadListener.onPrepareDownloadProgressUpdate(i11, i12, j11, j12, str);
                }

                public void onPrepareError(int i11, int i12, String str) {
                    iTPPreLoadListener.onPrepareError(i11, i12, str);
                }

                public void onPrepareOK() {
                    iTPPreLoadListener.onPrepareOK();
                }
            });
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPreload failed, error:" + th2.toString());
            return -1;
        }
    }

    public void startTask(int i11) {
        try {
            this.downloadProxyAidl.startTask(i11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startTask failed, error:" + th2.toString());
        }
    }

    public void stopOfflineDownload(int i11) {
    }

    public void stopPlay(int i11) {
        try {
            this.downloadProxyAidl.stopPlay(i11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopPlay failed, error:" + th2.toString());
        }
    }

    public void stopPreload(int i11) {
        try {
            this.downloadProxyAidl.stopPreload(i11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopPreload failed, error:" + th2.toString());
        }
    }

    public void switchToResolution(int i11, int i12, int i13) {
    }

    public void updateAidl(ITPDownloadProxyAidl iTPDownloadProxyAidl) {
        this.downloadProxyAidl = iTPDownloadProxyAidl;
    }

    public void updateStoragePath(String str) {
    }

    public void updateTaskInfo(int i11, String str, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, obj);
        try {
            this.downloadProxyAidl.updateTaskInfo(i11, hashMap);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "updateTaskInfo failed, error:" + th2.toString());
        }
    }

    public int clearCache(String str, String str2, int i11, long j11) {
        try {
            return this.downloadProxyAidl.clearCache(str, str2, i11, j11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "clearCache failed, error:" + th2.toString());
            return -1;
        }
    }

    public int removeStorageCache(String str, long j11) {
        try {
            return this.downloadProxyAidl.removeStorageCache(str, j11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "removeStorageCache failed, error:" + th2.toString());
            return -1;
        }
    }
}
