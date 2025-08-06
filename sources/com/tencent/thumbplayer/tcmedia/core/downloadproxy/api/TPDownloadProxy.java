package com.tencent.thumbplayer.tcmedia.core.downloadproxy.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDLProxyMsg;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLFileSystem;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyUtils;
import java.io.File;

public class TPDownloadProxy implements ITPDownloadProxy {
    private static final String FILE_NAME = "TPDownloadProxy";
    private Context mContext = null;
    private String mCurrentStoragePath = "";
    private boolean mIsInit = false;
    private int mServiceType;

    public TPDownloadProxy(int i11) {
        this.mServiceType = i11;
    }

    private void getCellularNetwork(Context context) {
        if (context == null) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, context is null, can not set interface 4g");
        } else if (Build.VERSION.SDK_INT >= 23) {
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(12);
            builder.addTransportType(0);
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, connectivityManager is null, can not set interface 4g");
            } else {
                connectivityManager.requestNetwork(builder.build(), new ConnectivityManager.NetworkCallback() {
                    public void onAvailable(Network network) {
                        super.onAvailable(network);
                        TPListenerManager.getInstance().setNetwork(network);
                        long networkHandle = network.getNetworkHandle();
                        TPDLProxyLog.i(TPDownloadProxy.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, net_id_t: ".concat(String.valueOf(networkHandle)));
                        TPDownloadProxy.this.setUserData(TPDownloadProxyEnum.CELLULAR_NETWORK_INTERFACE_ID, Long.valueOf(networkHandle));
                    }

                    public void onLost(Network network) {
                        super.onLost(network);
                        TPDownloadProxy.this.setUserData(TPDownloadProxyEnum.CELLULAR_NETWORK_INTERFACE_ID, 0);
                        TPDLProxyLog.i(TPDownloadProxy.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network failed");
                    }
                });
            }
        }
    }

    public boolean checkResourceExist(String str, String str2, long j11) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDownloadProxyNative.getInstance().checkResourceExist(str, str2, j11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "checkResourceExist failed, error:" + th2.toString());
            }
        }
        return false;
    }

    public int checkResourceStatus(String str, String str2, int i11) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDownloadProxyNative.getInstance().checkResourceStatus(str, str2, i11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "checkResourceStatus failed, error:" + th2.toString());
            }
        }
        return -1;
    }

    public int clearCache(String str, String str2, int i11) {
        return clearCache(str, str2, i11, -1);
    }

    public int deinit() {
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return -1;
        }
        try {
            this.mIsInit = false;
            return TPDownloadProxyNative.getInstance().deInitService(this.mServiceType);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "deinit failed, error:" + th2.toString());
            return -1;
        }
    }

    public int deleteOfflineLicenseKeySetId(String str, String str2, String str3) {
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return -1;
        }
        try {
            return TPDownloadProxyNative.getInstance().deleteOfflineLicenseKeySetId(str, str2, str3);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "deleteOfflineLicenseKeySetId failed, error:" + th2.toString());
            return -1;
        }
    }

    public String getClipPlayUrl(int i11, int i12, int i13) {
        String str = "";
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                str = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(i11, i12, i13));
                if (i13 != 2) {
                    TPDownloadProxyNative.getInstance().startDownload(i11);
                }
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getClipPlayUrl failed, error:" + th2.toString());
            }
        }
        return str;
    }

    public String getNativeInfo(int i11) {
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return null;
        }
        try {
            return TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getNativeInfo(i11));
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getNativeInfo failed, error:" + th2.toString());
            return null;
        }
    }

    public byte[] getOfflineLicenseKeySetId(String str, String str2, String str3) {
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return null;
        }
        try {
            return TPDownloadProxyNative.getInstance().getOfflineLicenseKeySetId(str, str2, str3);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getOfflineLicenseKeySetId failed, error:" + th2.toString());
            return null;
        }
    }

    public TPDLProxyMsg.TPPDTInfo[] getPDTInfos(int i11) {
        if (i11 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDownloadProxyNative.getInstance().getPDTInfos(i11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPDTInfos failed, error:" + th2.toString());
            }
        }
        return null;
    }

    public String getPlayErrorCodeStr(int i11) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getErrorCodeStr(i11));
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayErrorCodeStr failed, error:" + th2.toString());
            }
        }
        return "";
    }

    public String getPlayUrl(int i11, int i12) {
        String str = "";
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                str = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getClipPlayUrl(i11, 1, i12));
                if (i12 != 2) {
                    TPDownloadProxyNative.getInstance().startDownload(i11);
                }
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getPlayUrl failed, error:" + th2.toString());
            }
        }
        return str;
    }

    public float getResourceDownloadProgress(String str, String str2, long j11) {
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return 0.0f;
        }
        try {
            return TPDownloadProxyNative.getInstance().getResourceDownloadProgress(str, str2, j11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getResourceDownloadProgress failed, error:" + th2.toString());
            return 0.0f;
        }
    }

    public long getResourceSize(String str, String str2) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDownloadProxyNative.getInstance().getResourceSize(str, str2);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getResourceSize failed, error:" + th2.toString());
            }
        }
        return -1;
    }

    public synchronized int init(Context context, TPDLProxyInitParam tPDLProxyInitParam) {
        String cacheDir;
        int i11;
        if (this.mIsInit) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "download already init");
            return 0;
        }
        TPDownloadProxyNative.getInstance().setAppContext(context);
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                if (!TextUtils.isEmpty(tPDLProxyInitParam.getAppVer())) {
                    setUserData(TPDownloadProxyEnum.USER_APP_VERSION, tPDLProxyInitParam.getAppVer());
                }
                if (tPDLProxyInitParam.getPlatform() > 0) {
                    setUserData("platform", Integer.valueOf(tPDLProxyInitParam.getPlatform()));
                }
                if (!TextUtils.isEmpty(tPDLProxyInitParam.getGuid())) {
                    setUserData(TPDownloadProxyEnum.USER_GUID, tPDLProxyInitParam.getGuid());
                }
                cacheDir = tPDLProxyInitParam.getCacheDir();
                if (TextUtils.isEmpty(cacheDir) && context != null) {
                    File properCacheDirectory = TPDLFileSystem.getProperCacheDirectory(context, "download");
                    if (properCacheDirectory != null) {
                        cacheDir = properCacheDirectory.getAbsolutePath();
                    }
                }
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "init failed, error:" + th2.toString());
            }
            TPListenerManager.getInstance().initHandler();
            if (!TextUtils.isEmpty(tPDLProxyInitParam.getDataDir()) || TextUtils.isEmpty(this.mCurrentStoragePath)) {
                if (!TextUtils.isEmpty(tPDLProxyInitParam.getDataDir())) {
                    this.mCurrentStoragePath = tPDLProxyInitParam.getDataDir();
                }
                i11 = TPDownloadProxyNative.getInstance().initService(this.mServiceType, cacheDir, tPDLProxyInitParam.getDataDir(), tPDLProxyInitParam.getConfigStr());
            } else {
                i11 = TPDownloadProxyNative.getInstance().initService(this.mServiceType, cacheDir, this.mCurrentStoragePath, tPDLProxyInitParam.getConfigStr());
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            AnonymousClass2 r22 = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                    String action = intent.getAction();
                    if ("android.intent.action.SCREEN_OFF".equals(action)) {
                        TPDownloadProxy.this.pushEvent(20);
                    } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                        TPDownloadProxy.this.pushEvent(19);
                    }
                }
            };
            if (context != null) {
                context.registerReceiver(r22, intentFilter);
            }
            if (i11 == 0) {
                this.mIsInit = true;
            }
            this.mContext = context;
            return i11;
        }
        return -1;
    }

    public int pauseDownload(int i11) {
        if (i11 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDownloadProxyNative.getInstance().pauseDownload(i11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "pauseDownload failed, error:" + th2.toString());
            }
        }
        return -1;
    }

    public void pushEvent(int i11) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().pushEvent(i11);
                if (9 == i11) {
                    TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network, update net interface info");
                    getCellularNetwork(this.mContext);
                }
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "cellular_network pushEvent failed, error:" + th2.toString());
            }
        }
    }

    public int removeStorageCache(String str) {
        return removeStorageCache(str, -1);
    }

    public int resumeDownload(int i11) {
        if (i11 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDownloadProxyNative.getInstance().resumeDownload(i11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "resumeDownload failed, error:" + th2.toString());
            }
        }
        return -1;
    }

    public boolean setClipInfo(int i11, int i12, String str, TPDownloadParam tPDownloadParam) {
        int dlType = tPDownloadParam.getDlType();
        if (tPDownloadParam.isOffline()) {
            dlType += 300;
        }
        int i13 = dlType;
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return false;
        }
        try {
            if (TPDownloadProxyNative.getInstance().setClipInfo(i11, i12, str, i13, tPDownloadParam.getCdnUrls(), tPDownloadParam.getSavaPath(), tPDownloadParam.getExtraJsonInfo()) >= 0) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setClipInfo failed, error:" + th2.toString());
            return false;
        }
    }

    public void setLogListener(ITPDLProxyLogListener iTPDLProxyLogListener) {
        TPDLProxyLog.setLogListener(this.mServiceType, iTPDLProxyLogListener);
    }

    public void setMaxStorageSizeMB(long j11) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().setMaxStorageSizeMB(this.mServiceType, j11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setMaxStorageSizeMB failed, error:" + th2.toString());
            }
        }
    }

    public void setPlayState(int i11, int i12) {
        if (i11 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().setPlayerState(i11, i12);
                if (i12 == 1) {
                    TPDownloadProxyNative.getInstance().updateTaskInfo(i11, TPDownloadProxyEnum.TASKINFO_PLAY_OFFSET, String.valueOf(TPListenerManager.getInstance().getPlaylistener(i11).getCurrentPlayOffset()));
                    TPDownloadProxyNative.getInstance().updatePlayerPlayMsg(i11, (int) (TPListenerManager.getInstance().getPlaylistener(i11).getCurrentPosition() / 1000), (int) (TPListenerManager.getInstance().getPlaylistener(i11).getPlayerBufferLength() / 1000), (int) (TPListenerManager.getInstance().getPlaylistener(i11).getAdvRemainTime() / 1000));
                }
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setPlayState failed, error:" + th2.toString());
            }
        }
    }

    public void setUserData(String str, Object obj) {
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                if (str.equalsIgnoreCase(TPDownloadProxyEnum.USER_APP_VERSION)) {
                    TPDownloadProxyNative.getInstance().setUserData(TPDownloadProxyEnum.USER_APP_VERSION, (String) obj);
                } else if (str.equalsIgnoreCase("platform")) {
                    TPDownloadProxyNative.getInstance().setUserData("platform", obj.toString());
                } else if (str.equalsIgnoreCase(TPDownloadProxyEnum.USER_GUID)) {
                    TPDownloadProxyNative.getInstance().setUserData(TPDownloadProxyEnum.USER_GUID, (String) obj);
                } else if (str.equalsIgnoreCase(TPDownloadProxyEnum.USER_IS_VIP)) {
                    TPDownloadProxyNative.getInstance().setUserData(TPDownloadProxyEnum.USER_IS_VIP, ((Boolean) obj).booleanValue() ? "1" : "0");
                } else if (str.equalsIgnoreCase(TPDownloadProxyEnum.USER_UPC)) {
                    TPDownloadProxyNative.getInstance().setUserData(TPDownloadProxyEnum.USER_UPC, (String) obj);
                } else if (str.equalsIgnoreCase(TPDownloadProxyEnum.USER_UPC_STATE)) {
                    TPDownloadProxyNative.getInstance().setUserData(TPDownloadProxyEnum.USER_UPC_STATE, obj.toString());
                } else if (str.equalsIgnoreCase(TPDownloadProxyEnum.USER_PROXY_CONFIG)) {
                    TPDownloadProxyNative.getInstance().setUserData(TPDownloadProxyEnum.USER_PROXY_CONFIG, obj.toString());
                } else {
                    TPDownloadProxyNative.getInstance().setUserData(str, obj.toString());
                }
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setUserData failed, error:" + th2.toString());
            }
        }
    }

    public int startClipOfflineDownload(String str, int i11, ITPOfflineDownloadListener iTPOfflineDownloadListener) {
        int i12 = -1;
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return -1;
        }
        try {
            i12 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, 102, i11);
            TPListenerManager.getInstance().setOfflineDownloadListener(i12, iTPOfflineDownloadListener);
            return i12;
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startClipOfflineDownload failed, error:" + th2.toString());
            return i12;
        }
    }

    public int startClipPlay(String str, int i11, ITPPlayListener iTPPlayListener) {
        int i12 = -1;
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return -1;
        }
        try {
            i12 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, 2, i11);
            TPListenerManager.getInstance().setPlayListener(i12, iTPPlayListener);
            return i12;
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startClipPlay failed, error:" + th2.toString());
            return i12;
        }
    }

    public int startClipPreload(String str, int i11, ITPPreLoadListener iTPPreLoadListener) {
        int i12 = -1;
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return -1;
        }
        try {
            i12 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, 202, i11);
            TPListenerManager.getInstance().setPreLoadListener(i12, iTPPreLoadListener);
            return i12;
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startClipPreload failed, error:" + th2.toString());
            return i12;
        }
    }

    public int startOfflineDownload(String str, TPDownloadParam tPDownloadParam, ITPOfflineDownloadListener iTPOfflineDownloadListener) {
        int i11 = -1;
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                int dlType = tPDownloadParam.getDlType() + 100;
                i11 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, dlType, tPDownloadParam.getClipCount());
                TPListenerManager.getInstance().setOfflineDownloadListener(i11, iTPOfflineDownloadListener);
                if (!TextUtils.isEmpty(tPDownloadParam.getKeyid())) {
                    str = tPDownloadParam.getKeyid();
                }
                int i12 = i11;
                TPDownloadProxyNative.getInstance().setClipInfo(i12, tPDownloadParam.getClipNo(), str, dlType, tPDownloadParam.getCdnUrls(), tPDownloadParam.getSavaPath(), tPDownloadParam.getExtraJsonInfo());
                TPDownloadProxyNative.getInstance().startDownload(i11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopOfflineDownload failed, error:" + th2.toString());
            }
        }
        return i11;
    }

    public int startPlay(String str, TPDownloadParam tPDownloadParam, ITPPlayListener iTPPlayListener) {
        int dlType = tPDownloadParam.getDlType();
        if (iTPPlayListener != null) {
            tPDownloadParam.getExtInfoMap().put(TPDownloadProxyEnum.DLPARAM_ADV_REMAIN_TIME, Long.valueOf(iTPPlayListener.getAdvRemainTime() / 1000));
        }
        if (tPDownloadParam.isOffline()) {
            dlType += 300;
        }
        int i11 = -1;
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                if (tPDownloadParam.isAdaptive() && (dlType == 3 || dlType == 5)) {
                    dlType += 400;
                }
                int i12 = dlType;
                i11 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, i12, tPDownloadParam.getClipCount());
                TPListenerManager.getInstance().setPlayListener(i11, iTPPlayListener);
                if (!TextUtils.isEmpty(tPDownloadParam.getKeyid())) {
                    str = tPDownloadParam.getKeyid();
                }
                int i13 = i11;
                TPDownloadProxyNative.getInstance().setClipInfo(i13, tPDownloadParam.getClipNo(), str, i12, tPDownloadParam.getCdnUrls(), tPDownloadParam.getSavaPath(), tPDownloadParam.getExtraJsonInfo());
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPlay failed, error:" + th2.toString());
            }
        }
        return i11;
    }

    public int startPreload(String str, TPDownloadParam tPDownloadParam, ITPPreLoadListener iTPPreLoadListener) {
        int i11 = -1;
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                int dlType = tPDownloadParam.getDlType() + 200;
                i11 = TPDownloadProxyNative.getInstance().createDownloadTask(this.mServiceType, str, dlType, tPDownloadParam.getClipCount());
                TPListenerManager.getInstance().setPreLoadListener(i11, iTPPreLoadListener);
                if (!TextUtils.isEmpty(tPDownloadParam.getKeyid())) {
                    str = tPDownloadParam.getKeyid();
                }
                int i12 = i11;
                TPDownloadProxyNative.getInstance().setClipInfo(i12, tPDownloadParam.getClipNo(), str, dlType, tPDownloadParam.getCdnUrls(), tPDownloadParam.getSavaPath(), tPDownloadParam.getExtraJsonInfo());
                TPDownloadProxyNative.getInstance().startDownload(i11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startPreload failed, error:" + th2.toString());
            }
        }
        return i11;
    }

    public void startTask(int i11) {
        if (i11 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().startDownload(i11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "startTask failed, error:" + th2.toString());
            }
        }
    }

    public void stopOfflineDownload(int i11) {
        if (i11 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().stopDownload(i11);
                TPListenerManager.getInstance().removeOfflineDownloadListener(i11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopOfflineDownload failed, error:" + th2.toString());
            }
        }
    }

    public void stopPlay(int i11) {
        if (i11 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().stopDownload(i11);
                TPListenerManager.getInstance().removePlayListener(i11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopPlay failed, error:" + th2.toString());
            }
        }
    }

    public void stopPreload(int i11) {
        if (i11 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().stopDownload(i11);
                TPListenerManager.getInstance().removePreLoadListener(i11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "stopPreload failed, error:" + th2.toString());
            }
        }
    }

    public void switchToResolution(int i11, int i12, int i13) {
        if (i12 != 0 && i13 != 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().switchToResolution(i11, i12, i13);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "switchToResolution failed, error:" + th2.toString());
            }
        }
    }

    public void updateStoragePath(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.mCurrentStoragePath = str;
                TPDownloadProxyNative.getInstance().updateStoragePath(this.mServiceType, str);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "updateStoragePath failed, error:" + th2.toString());
            }
        }
    }

    public void updateTaskInfo(int i11, String str, Object obj) {
        if (i11 > 0 && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().updateTaskInfo(i11, str, obj.toString());
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "updateTaskInfo failed, error:" + th2.toString());
            }
        }
    }

    public int clearCache(String str, String str2, int i11, long j11) {
        if (!TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            return -1;
        }
        try {
            return TPDownloadProxyNative.getInstance().clearCache(str, str2, i11, j11);
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "clearCache failed, error:" + th2.toString());
            return -1;
        }
    }

    public int removeStorageCache(String str, long j11) {
        if (!TextUtils.isEmpty(str) && TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                return TPDownloadProxyNative.getInstance().deleteCache(this.mCurrentStoragePath, str, j11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "deleteCache failed, error:" + th2.toString());
            }
        }
        return -1;
    }
}
