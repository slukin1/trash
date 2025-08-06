package com.tencent.thumbplayer.tcmedia.core.downloadproxy.service;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl.ITPDownloadProxyAidl;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl.ITPPlayListenerAidl;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl.ITPPreLoadListenerAidl;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl.TPDownloadParamAidl;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPPlayListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadParam;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TPDownloadProxyService extends Service {
    private static final String FILE_NAME = "TPDownloadProxyService";
    private TPDownloadProxyFactoryAidl.Stub downloadProxyFactory = null;
    private int pid = -1;

    public class DownloadProxy extends ITPDownloadProxyAidl.Stub {
        private ITPDownloadProxy downloadProxy = null;

        public DownloadProxy(int i11) {
            this.downloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(i11);
        }

        public boolean checkResourceExist(String str, String str2, long j11) throws RemoteException {
            try {
                return this.downloadProxy.checkResourceExist(str, str2, j11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "checkResourceExist failed, error:" + th2.toString());
                return false;
            }
        }

        public int checkResourceStatus(String str, String str2, int i11) {
            try {
                return this.downloadProxy.checkResourceStatus(str, str2, i11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "checkResourceStatus failed, error:" + th2.toString());
                return -1;
            }
        }

        public int clearCache(String str, String str2, int i11, long j11) {
            try {
                return this.downloadProxy.clearCache(str, str2, i11, j11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "clearCache failed, error:" + th2.toString());
                return -1;
            }
        }

        public int deleteOfflineLicenseKeySetId(String str, String str2, String str3) {
            try {
                return this.downloadProxy.deleteOfflineLicenseKeySetId(str, str2, str3);
            } catch (Throwable th2) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "deleteOfflineLicenseKeySetId failed, error:" + th2.toString());
                return -1;
            }
        }

        public String getClipPlayUrl(int i11, int i12, int i13) {
            return this.downloadProxy.getClipPlayUrl(i11, i12, i13);
        }

        public String getNativeInfo(int i11) {
            try {
                return this.downloadProxy.getNativeInfo(i11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getNativeInfo failed, error:" + th2.toString());
                return null;
            }
        }

        public byte[] getOfflineLicenseKeySetId(String str, String str2, String str3) {
            try {
                return this.downloadProxy.getOfflineLicenseKeySetId(str, str2, str3);
            } catch (Throwable th2) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getOfflineLicenseKeySetId failed, error:" + th2.toString());
                return null;
            }
        }

        public String getPlayErrorCodeStr(int i11) {
            return this.downloadProxy.getPlayErrorCodeStr(i11);
        }

        public String getPlayUrl(int i11, int i12) {
            return this.downloadProxy.getPlayUrl(i11, i12);
        }

        public float getResourceDownloadProgress(String str, String str2, long j11) throws RemoteException {
            try {
                return this.downloadProxy.getResourceDownloadProgress(str, str2, j11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getResourceDownloadProgress failed, error:" + th2.toString());
                return 0.0f;
            }
        }

        public long getResourceSize(String str, String str2) {
            try {
                return this.downloadProxy.getResourceSize(str, str2);
            } catch (Throwable th2) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getResourceSize failed, error:" + th2.toString());
                return -1;
            }
        }

        public int init(String str) {
            try {
                TPDLProxyInitParam tPDLProxyInitParam = (TPDLProxyInitParam) TPDLProxyUtils.serializeToObject(str);
                if (tPDLProxyInitParam != null) {
                    return this.downloadProxy.init(TPDownloadProxyHelper.getContext(), tPDLProxyInitParam);
                }
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "param is null");
                return -1;
            } catch (Throwable th2) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "init failed, error:" + th2.toString());
                return -2;
            }
        }

        public int pauseDownload(int i11) {
            return this.downloadProxy.pauseDownload(i11);
        }

        public void pushEvent(int i11) {
            this.downloadProxy.pushEvent(i11);
        }

        public int removeStorageCache(String str, long j11) throws RemoteException {
            try {
                return this.downloadProxy.removeStorageCache(str, j11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "removeStorageCache failed, error:" + th2.toString());
                return -1;
            }
        }

        public int resumeDownload(int i11) {
            return this.downloadProxy.resumeDownload(i11);
        }

        public boolean setClipInfo(int i11, int i12, String str, TPDownloadParamAidl tPDownloadParamAidl) {
            return this.downloadProxy.setClipInfo(i11, i12, str, new TPDownloadParam(tPDownloadParamAidl.getUrlList(), tPDownloadParamAidl.getDlType(), tPDownloadParamAidl.getExtInfoMap()));
        }

        public void setMaxStorageSizeMB(long j11) {
            this.downloadProxy.setMaxStorageSizeMB(j11);
        }

        public void setPlayState(int i11, int i12) {
            this.downloadProxy.setPlayState(i11, i12);
        }

        public void setUserData(Map map) {
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    if (entry != null) {
                        try {
                            if (entry.getValue() != null) {
                                this.downloadProxy.setUserData((String) entry.getKey(), entry.getValue());
                            }
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setUserData failed, error:" + th2.toString());
                        }
                    }
                }
            }
        }

        public int startClipPlay(String str, int i11, final ITPPlayListenerAidl iTPPlayListenerAidl) {
            return this.downloadProxy.startClipPlay(str, i11, new ITPPlayListener() {
                public long getAdvRemainTime() {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            return iTPPlayListenerAidl.getAdvRemainTime();
                        }
                        return -1;
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getAdvRemainTime failed, error:" + th2.toString());
                        return -1;
                    }
                }

                public String getContentType(int i11, String str) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            return iTPPlayListenerAidl.getContentType(i11, str);
                        }
                        return "";
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getContentType key failed, error:" + th2.toString());
                        return "";
                    }
                }

                public int getCurrentPlayClipNo() {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            return iTPPlayListenerAidl.getCurrentPlayClipNo();
                        }
                        return -1;
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPlayClipNo failed, error:" + th2.toString());
                        return -1;
                    }
                }

                public long getCurrentPlayOffset() {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            return iTPPlayListenerAidl.getCurrentPlayOffset();
                        }
                        return -1;
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPlayOffset failed, error:" + th2.toString());
                        return -1;
                    }
                }

                public long getCurrentPosition() {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            return iTPPlayListenerAidl.getCurrentPosition();
                        }
                        return -1;
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPosition failed, error:" + th2.toString());
                        return -1;
                    }
                }

                public String getDataFilePath(int i11, String str) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            return iTPPlayListenerAidl.getDataFilePath(i11, str);
                        }
                        return "";
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataFilePath key failed, error:" + th2.toString());
                        return "";
                    }
                }

                public long getDataTotalSize(int i11, String str) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            return iTPPlayListenerAidl.getDataTotalSize(i11, str);
                        }
                        return -1;
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataTotalSize key failed, error:" + th2.toString());
                        return -1;
                    }
                }

                public Object getPlayInfo(long j11) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            return iTPPlayListenerAidl.getPlayInfo(Long.toString(j11));
                        }
                        return null;
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayInfo type failed, error:" + th2.toString());
                        return null;
                    }
                }

                public long getPlayerBufferLength() {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            return iTPPlayListenerAidl.getPlayerBufferLength();
                        }
                        return -1;
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayerBufferLength failed, error:" + th2.toString());
                        return -1;
                    }
                }

                public void onDownloadCdnUrlExpired(Map<String, String> map) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadCdnUrlExpired(map);
                        }
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlExpired failed, error:" + th2.toString());
                    }
                }

                public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadCdnUrlInfoUpdate(str, str2, str3, str4);
                        }
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlInfoUpdate failed, error:" + th2.toString());
                    }
                }

                public void onDownloadCdnUrlUpdate(String str) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadCdnUrlUpdate(str);
                        }
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlUpdate failed, error:" + th2.toString());
                    }
                }

                public void onDownloadError(int i11, int i12, String str) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadError(i11, i12, str);
                        }
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadError failed, error:" + th2.toString());
                    }
                }

                public void onDownloadFinish() {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadFinish();
                        }
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadFinish failed, error:" + th2.toString());
                    }
                }

                public void onDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadProgressUpdate(i11, i12, j11, j12, str);
                        }
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadProgressUpdate failed, error:" + th2.toString());
                    }
                }

                public void onDownloadProtocolUpdate(String str, String str2) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadProtocolUpdate(str, str2);
                        }
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadProtocolUpdate failed, error:" + th2.toString());
                    }
                }

                public void onDownloadStatusUpdate(int i11) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            iTPPlayListenerAidl.onDownloadStatusUpdate(i11);
                        }
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadStatusUpdate failed, error:" + th2.toString());
                    }
                }

                public Object onPlayCallback(int i11, Object obj, Object obj2, Object obj3, Object obj4) {
                    try {
                        ArrayList arrayList = new ArrayList();
                        if (obj != null) {
                            arrayList.add(obj);
                        }
                        if (obj != null) {
                            arrayList.add(obj2);
                        }
                        if (obj != null) {
                            arrayList.add(obj3);
                        }
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl == null) {
                            return null;
                        }
                        iTPPlayListenerAidl.onPlayCallback(i11, arrayList);
                        return null;
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPlayCallback failed, error:" + th2.toString());
                        return null;
                    }
                }

                public int onReadData(int i11, String str, long j11, long j12) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            return iTPPlayListenerAidl.onReadData(i11, str, j11, j12);
                        }
                        return -1;
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onReadData key failed, error:" + th2.toString());
                        return -1;
                    }
                }

                public int onStartReadData(int i11, String str, long j11, long j12) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            return iTPPlayListenerAidl.onStartReadData(i11, str, j11, j12);
                        }
                        return -1;
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onStartReadData key failed, error:" + th2.toString());
                        return -1;
                    }
                }

                public int onStopReadData(int i11, String str, int i12) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            return iTPPlayListenerAidl.onStopReadData(i11, str, i12);
                        }
                        return -1;
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onStopReadData key failed, error:" + th2.toString());
                        return -1;
                    }
                }

                public Object getPlayInfo(String str) {
                    try {
                        ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                        if (iTPPlayListenerAidl != null) {
                            return iTPPlayListenerAidl.getPlayInfo(str);
                        }
                        return null;
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayInfo key failed, error:" + th2.toString());
                        return null;
                    }
                }
            });
        }

        public int startClipPreload(String str, int i11, final ITPPreLoadListenerAidl iTPPreLoadListenerAidl) {
            return this.downloadProxy.startClipPreload(str, i11, new ITPPreLoadListener() {
                public void onPrepareDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) {
                    try {
                        ITPPreLoadListenerAidl iTPPreLoadListenerAidl = iTPPreLoadListenerAidl;
                        if (iTPPreLoadListenerAidl != null) {
                            iTPPreLoadListenerAidl.onPrepareDownloadProgressUpdate(i11, i12, j11, j12, str);
                        }
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPrepareDownloadProgressUpdate failed, error:" + th2.toString());
                    }
                }

                public void onPrepareError(int i11, int i12, String str) {
                    try {
                        ITPPreLoadListenerAidl iTPPreLoadListenerAidl = iTPPreLoadListenerAidl;
                        if (iTPPreLoadListenerAidl != null) {
                            iTPPreLoadListenerAidl.onPrepareError(i11, i12, str);
                        }
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPrepareError failed, error:" + th2.toString());
                    }
                }

                public void onPrepareOK() {
                    try {
                        ITPPreLoadListenerAidl iTPPreLoadListenerAidl = iTPPreLoadListenerAidl;
                        if (iTPPreLoadListenerAidl != null) {
                            iTPPreLoadListenerAidl.onPrepareOK();
                        }
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPrepareOK failed, error:" + th2.toString());
                    }
                }
            });
        }

        public int startPlay(String str, TPDownloadParamAidl tPDownloadParamAidl, final ITPPlayListenerAidl iTPPlayListenerAidl) {
            try {
                return this.downloadProxy.startPlay(str, new TPDownloadParam(tPDownloadParamAidl.getUrlList(), tPDownloadParamAidl.getDlType(), tPDownloadParamAidl.getExtInfoMap()), new ITPPlayListener() {
                    public long getAdvRemainTime() {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                return iTPPlayListenerAidl.getAdvRemainTime();
                            }
                            return -1;
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getAdvRemainTime failed, error:" + th2.toString());
                            return -1;
                        }
                    }

                    public String getContentType(int i11, String str) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                return iTPPlayListenerAidl.getContentType(i11, str);
                            }
                            return "";
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getContentType key failed, error:" + th2.toString());
                            return "";
                        }
                    }

                    public int getCurrentPlayClipNo() {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                return iTPPlayListenerAidl.getCurrentPlayClipNo();
                            }
                            return -1;
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPlayClipInfo failed, error:" + th2.toString());
                            return -1;
                        }
                    }

                    public long getCurrentPlayOffset() {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                return iTPPlayListenerAidl.getCurrentPlayOffset();
                            }
                            return -1;
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPlayOffset failed, error:" + th2.toString());
                            return -1;
                        }
                    }

                    public long getCurrentPosition() {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                return iTPPlayListenerAidl.getCurrentPosition();
                            }
                            return -1;
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getCurrentPosition failed, error:" + th2.toString());
                            return -1;
                        }
                    }

                    public String getDataFilePath(int i11, String str) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                return iTPPlayListenerAidl.getDataFilePath(i11, str);
                            }
                            return "";
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataFilePath key failed, error:" + th2.toString());
                            return "";
                        }
                    }

                    public long getDataTotalSize(int i11, String str) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                return iTPPlayListenerAidl.getDataTotalSize(i11, str);
                            }
                            return -1;
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getDataTotalSize key failed, error:" + th2.toString());
                            return -1;
                        }
                    }

                    public Object getPlayInfo(long j11) {
                        try {
                            return iTPPlayListenerAidl.getPlayInfo(Long.toString(j11));
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayInfo type failed, error:" + th2.toString());
                            return null;
                        }
                    }

                    public long getPlayerBufferLength() {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                return iTPPlayListenerAidl.getPlayerBufferLength();
                            }
                            return -1;
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayerBufferLength failed, error:" + th2.toString());
                            return -1;
                        }
                    }

                    public void onDownloadCdnUrlExpired(Map<String, String> map) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadCdnUrlExpired(map);
                            }
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlExpired failed, error:" + th2.toString());
                        }
                    }

                    public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadCdnUrlInfoUpdate(str, str2, str3, str4);
                            }
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlInfoUpdate failed, error:" + th2.toString());
                        }
                    }

                    public void onDownloadCdnUrlUpdate(String str) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadCdnUrlUpdate(str);
                            }
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadCdnUrlUpdate failed, error:" + th2.toString());
                        }
                    }

                    public void onDownloadError(int i11, int i12, String str) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadError(i11, i12, str);
                            }
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadError failed, error:" + th2.toString());
                        }
                    }

                    public void onDownloadFinish() {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadFinish();
                            }
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownlaodFinish failed, error:" + th2.toString());
                        }
                    }

                    public void onDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadProgressUpdate(i11, i12, j11, j12, str);
                            }
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownlaodProgressUpdate failed, error:" + th2.toString());
                        }
                    }

                    public void onDownloadProtocolUpdate(String str, String str2) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadProtocolUpdate(str, str2);
                            }
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadProtocolUpdate failed, error:" + th2.toString());
                        }
                    }

                    public void onDownloadStatusUpdate(int i11) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                iTPPlayListenerAidl.onDownloadStatusUpdate(i11);
                            }
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onDownloadStatusUpdate failed, error:" + th2.toString());
                        }
                    }

                    public Object onPlayCallback(int i11, Object obj, Object obj2, Object obj3, Object obj4) {
                        try {
                            ArrayList arrayList = new ArrayList();
                            if (obj != null) {
                                arrayList.add(obj);
                            }
                            if (obj2 != null) {
                                arrayList.add(obj2);
                            }
                            if (obj3 != null) {
                                arrayList.add(obj3);
                            }
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl == null) {
                                return null;
                            }
                            iTPPlayListenerAidl.onPlayCallback(i11, arrayList);
                            return null;
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPlayCallback failed, error:" + th2.toString());
                            return null;
                        }
                    }

                    public int onReadData(int i11, String str, long j11, long j12) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                return iTPPlayListenerAidl.onReadData(i11, str, j11, j12);
                            }
                            return -1;
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onReadData key failed, error:" + th2.toString());
                            return -1;
                        }
                    }

                    public int onStartReadData(int i11, String str, long j11, long j12) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                return iTPPlayListenerAidl.onStartReadData(i11, str, j11, j12);
                            }
                            return -1;
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onStartReadData key failed, error:" + th2.toString());
                            return -1;
                        }
                    }

                    public int onStopReadData(int i11, String str, int i12) {
                        try {
                            ITPPlayListenerAidl iTPPlayListenerAidl = iTPPlayListenerAidl;
                            if (iTPPlayListenerAidl != null) {
                                return iTPPlayListenerAidl.onStopReadData(i11, str, i12);
                            }
                            return -1;
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onStopReadData key failed, error:" + th2.toString());
                            return -1;
                        }
                    }

                    public Object getPlayInfo(String str) {
                        try {
                            return iTPPlayListenerAidl.getPlayInfo(str);
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayInfo key failed, error:" + th2.toString());
                            return null;
                        }
                    }
                });
            } catch (Throwable th2) {
                TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPlay failed, error:" + th2.toString());
                return -1;
            }
        }

        public int startPreload(String str, TPDownloadParamAidl tPDownloadParamAidl, final ITPPreLoadListenerAidl iTPPreLoadListenerAidl) {
            return this.downloadProxy.startPreload(str, new TPDownloadParam(tPDownloadParamAidl.getUrlList(), tPDownloadParamAidl.getDlType(), tPDownloadParamAidl.getExtInfoMap()), new ITPPreLoadListener() {
                public void onPrepareDownloadProgressUpdate(int i11, int i12, long j11, long j12, String str) {
                    try {
                        ITPPreLoadListenerAidl iTPPreLoadListenerAidl = iTPPreLoadListenerAidl;
                        if (iTPPreLoadListenerAidl != null) {
                            iTPPreLoadListenerAidl.onPrepareDownloadProgressUpdate(i11, i12, j11, j12, str);
                        }
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPrepareDownloadProgressUpdate failed, error:" + th2.toString());
                    }
                }

                public void onPrepareError(int i11, int i12, String str) {
                    try {
                        ITPPreLoadListenerAidl iTPPreLoadListenerAidl = iTPPreLoadListenerAidl;
                        if (iTPPreLoadListenerAidl != null) {
                            iTPPreLoadListenerAidl.onPrepareError(i11, i12, str);
                        }
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPrepareError failed, error:" + th2.toString());
                    }
                }

                public void onPrepareOK() {
                    try {
                        ITPPreLoadListenerAidl iTPPreLoadListenerAidl = iTPPreLoadListenerAidl;
                        if (iTPPreLoadListenerAidl != null) {
                            iTPPreLoadListenerAidl.onPrepareOK();
                        }
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onPrepareOK failed, error:" + th2.toString());
                    }
                }
            });
        }

        public void startTask(int i11) {
            this.downloadProxy.startTask(i11);
        }

        public void stopPlay(int i11) {
            this.downloadProxy.stopPlay(i11);
        }

        public void stopPreload(int i11) {
            this.downloadProxy.stopPreload(i11);
        }

        public void updateTaskInfo(int i11, Map map) {
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    if (entry != null) {
                        try {
                            if (entry.getValue() != null) {
                                this.downloadProxy.updateTaskInfo(i11, (String) entry.getKey(), entry.getValue());
                            }
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(TPDownloadProxyService.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "updateTaskInfo failed, error:" + th2.toString());
                        }
                    }
                }
            }
        }
    }

    public class DownloadProxyFactory extends TPDownloadProxyFactoryAidl.Stub {
        private HashMap<Integer, ITPDownloadProxyAidl> mvTPDownloadProxyMap;

        private DownloadProxyFactory() {
            this.mvTPDownloadProxyMap = new HashMap<>();
        }

        public String getNativeVersion() {
            return TPDownloadProxyFactory.getNativeVersion();
        }

        public synchronized ITPDownloadProxyAidl getTPDownloadProxy(int i11) {
            ITPDownloadProxyAidl iTPDownloadProxyAidl;
            iTPDownloadProxyAidl = this.mvTPDownloadProxyMap.get(Integer.valueOf(i11));
            if (iTPDownloadProxyAidl == null) {
                iTPDownloadProxyAidl = new DownloadProxy(i11);
                this.mvTPDownloadProxyMap.put(Integer.valueOf(i11), iTPDownloadProxyAidl);
            }
            return iTPDownloadProxyAidl;
        }

        public boolean isReadyForDownload() {
            return TPDownloadProxyFactory.isReadyForDownload();
        }

        public boolean isReadyForPlay() {
            return TPDownloadProxyFactory.isReadyForPlay();
        }
    }

    private boolean isExistMainProcess() {
        int i11;
        try {
            for (ActivityManager.RunningAppProcessInfo next : ((ActivityManager) getSystemService("activity")).getRunningAppProcesses()) {
                String str = next.processName;
                if (!TextUtils.isEmpty(str) && str.equals(getPackageName())) {
                    int i12 = this.pid;
                    if (i12 == -1 || i12 == (i11 = next.pid)) {
                        this.pid = next.pid;
                        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "app main exist!");
                        return true;
                    }
                    this.pid = i11;
                    return false;
                }
            }
        } catch (Throwable th2) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isExistMainProcess failed, error:" + th2.toString());
        }
        return false;
    }

    public IBinder onBind(Intent intent) {
        if (this.downloadProxyFactory == null) {
            this.downloadProxyFactory = new DownloadProxyFactory();
        }
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on bind!");
        isExistMainProcess();
        return this.downloadProxyFactory;
    }

    public void onRebind(Intent intent) {
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on rebind!");
        isExistMainProcess();
        super.onRebind(intent);
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i11, i12);
        super.onStartCommand(intent, i11, i12);
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on start command!");
        return 2;
    }

    public boolean onUnbind(Intent intent) {
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on unbind!");
        super.onUnbind(intent);
        if (isExistMainProcess()) {
            return true;
        }
        try {
            TPDownloadProxyNative.getInstance().stopAllDownload(3);
            TPListenerManager.getInstance().removeAllPlayListener();
            TPListenerManager.getInstance().removeAllPreLoadListener();
            return true;
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, th2.toString());
            return true;
        }
    }
}
