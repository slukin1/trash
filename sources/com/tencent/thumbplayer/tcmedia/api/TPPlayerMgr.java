package com.tencent.thumbplayer.tcmedia.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.thumbplayer.tcmedia.adapter.a.b.a;
import com.tencent.thumbplayer.tcmedia.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.tcmedia.c.b;
import com.tencent.thumbplayer.tcmedia.c.i;
import com.tencent.thumbplayer.tcmedia.common.a.c;
import com.tencent.thumbplayer.tcmedia.config.TPPlayerConfig;
import com.tencent.thumbplayer.tcmedia.core.common.ITPNativeLibraryExternalLoader;
import com.tencent.thumbplayer.tcmedia.core.common.ITPNativeLogCallback;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.tcmedia.core.common.TPNativeLog;
import com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo;
import com.tencent.thumbplayer.tcmedia.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDLProxyNativeLibLoader;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.ITPProxyAdapter;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import com.tencent.thumbplayer.tcmedia.utils.d;
import com.tencent.thumbplayer.tcmedia.utils.f;
import com.tencent.thumbplayer.tcmedia.utils.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class TPPlayerMgr {
    public static final String BEACON_LOG_HOST_KEY = "beacon_log_host";
    public static final String BEACON_POLICY_HOST_KEY = "beacon_policy_host";
    public static final int EVENT_ID_APP_ENTER_BACKGROUND = 100001;
    public static final int EVENT_ID_APP_ENTER_FOREGROUND = 100002;
    public static final int INVALID_CELLULAR_FLOW = -1;
    public static final int INVALID_SUGGEST_BITRATE = -1;
    public static final String PLYAER_HOST_KEY = "player_host_config";
    public static final String PROPERTY_AB_USER_ID = "PROPERTY_AbUserId";
    public static final String PROPERTY_ENABLE_DATA_REPORT = "PROPERTY_EnableDataReport";
    public static final String PROPERTY_ENABLE_NEW_REPORT = "PROPERTY_EnableNewReport";
    public static final String PROPERTY_ENABLE_PLAYER_REPORT = "PROPERTY_EnablePlayerReport";
    public static final String PROPERTY_MEDIA_DRM_REUSE = "PROPERTY_MediaDrmReuse";
    public static final String PROPERTY_PROXY_MAX_USE_MEMORY_MB = "PROPERTY_ProxyMaxUseMemoryMB";
    public static final String PROPERTY_VIDEO_MEDIACODEC_CO_EXIST_MAX_CNT = "PROPERTY_VideoMediaCodecCoexistMaxCnt";
    public static final String PROPERTY_WIDEVINE_PROVISIONING_SERVER_URL = "PROPERTY_WidevineProvisioningServerUrl";
    public static final String PROXY_HOST_KEY = "httpproxy_config";
    private static final String TAG = "TPThumbPlayer[TPPlayerMgr.java]";
    public static final String TP_DOWNLOAD_PROXY_MODULE_NAME = "DownloadProxy";
    public static final String TP_PLAYERCORE_MODULE_NAME = "TPCore";
    /* access modifiers changed from: private */
    public static Context mAppContext;
    private static final HashMap<String, Boolean> mBoolPropertyNameToValueCache = new HashMap<>();
    private static final HashMap<String, ITPPropertyHandler<Boolean>> mBooleanPropertyNameToPropertyHandlerTables;
    private static final HashMap<String, ITPPropertyHandler<Integer>> mIntegerPropertyNameToPropertyHandlerTables;
    private static final HashMap<String, Integer> mIntegerPropertyNameToValueCache = new HashMap<>();
    private static boolean mIsInit;
    private static final HashMap<String, ITPPropertyHandler<Long>> mLongPropertyNameToPropertyHandlerTables;
    private static final HashMap<String, Long> mLongPropertyNameToValueCache = new HashMap<>();
    private static final HashMap<String, ITPPropertyHandler<String>> mStringPropertyNameToPropertyHandlerTables;
    private static final HashMap<String, String> mStringPropertyNameToValueCache = new HashMap<>();

    @Retention(RetentionPolicy.SOURCE)
    public @interface BooleanProperty {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface EventId {
    }

    public interface ITPPropertyHandler<T> {
        T getPropertyValue();

        void setPropertyValue(T t11);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface IntegerProperty {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LongProperty {
    }

    public interface OnLogListener {
        int d(String str, String str2);

        int e(String str, String str2);

        int i(String str, String str2);

        int v(String str, String str2);

        int w(String str, String str2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface StringProperty {
    }

    static {
        HashMap<String, ITPPropertyHandler<Boolean>> hashMap = new HashMap<>();
        mBooleanPropertyNameToPropertyHandlerTables = hashMap;
        hashMap.put(PROPERTY_MEDIA_DRM_REUSE, new ITPPropertyHandler<Boolean>() {
            public final Boolean getPropertyValue() {
                return Boolean.valueOf(TPPlayerConfig.getMediaDrmReuseEnable());
            }

            public final void setPropertyValue(Boolean bool) {
                TPPlayerConfig.setMediaDrmReuseEnable(bool.booleanValue());
            }
        });
        hashMap.put(PROPERTY_ENABLE_DATA_REPORT, new ITPPropertyHandler<Boolean>() {
            public final Boolean getPropertyValue() {
                return Boolean.valueOf(TPPlayerConfig.isDataReportEnable());
            }

            public final void setPropertyValue(Boolean bool) {
                TPLogUtil.i(TPPlayerMgr.TAG, "set data report enable : ".concat(String.valueOf(bool)));
                TPPlayerConfig.setDataReportEnable(bool.booleanValue());
                i.a().a(bool.booleanValue());
            }
        });
        hashMap.put(PROPERTY_ENABLE_PLAYER_REPORT, new ITPPropertyHandler<Boolean>() {
            public final Boolean getPropertyValue() {
                return Boolean.valueOf(TPPlayerConfig.isPlayerReportEnable());
            }

            public final void setPropertyValue(Boolean bool) {
                TPLogUtil.i(TPPlayerMgr.TAG, "set player report enable : ".concat(String.valueOf(bool)));
                TPPlayerConfig.setPlayerReportEnable(bool.booleanValue());
            }
        });
        hashMap.put(PROPERTY_ENABLE_NEW_REPORT, new ITPPropertyHandler<Boolean>() {
            public final Boolean getPropertyValue() {
                return Boolean.valueOf(TPPlayerConfig.getNewReportEnable());
            }

            public final void setPropertyValue(Boolean bool) {
                TPLogUtil.i(TPPlayerMgr.TAG, "set new report enable : ".concat(String.valueOf(bool)));
                TPPlayerConfig.setNewReportEnable(bool.booleanValue());
            }
        });
        HashMap<String, ITPPropertyHandler<String>> hashMap2 = new HashMap<>();
        mStringPropertyNameToPropertyHandlerTables = hashMap2;
        hashMap2.put(PROPERTY_AB_USER_ID, new ITPPropertyHandler<String>() {
            public final String getPropertyValue() {
                return TPPlayerConfig.getAbUserId();
            }

            public final void setPropertyValue(String str) {
                TPPlayerConfig.setAbUserId(str);
            }
        });
        hashMap2.put(PROPERTY_WIDEVINE_PROVISIONING_SERVER_URL, new ITPPropertyHandler<String>() {
            public final String getPropertyValue() {
                return TPPlayerConfig.getWidevineProvisioningServerUrl();
            }

            public final void setPropertyValue(String str) {
                TPPlayerConfig.setWidevineProvisioningServerUrl(str);
            }
        });
        HashMap<String, ITPPropertyHandler<Integer>> hashMap3 = new HashMap<>();
        mIntegerPropertyNameToPropertyHandlerTables = hashMap3;
        hashMap3.put(PROPERTY_VIDEO_MEDIACODEC_CO_EXIST_MAX_CNT, new ITPPropertyHandler<Integer>() {
            public final Integer getPropertyValue() {
                return Integer.valueOf(TPPlayerConfig.getVideoMediaCodecCoexistMaxCnt());
            }

            public final void setPropertyValue(Integer num) {
                TPPlayerConfig.setVideoMediaCodecCoexistMaxCnt(num.intValue());
            }
        });
        HashMap<String, ITPPropertyHandler<Long>> hashMap4 = new HashMap<>();
        mLongPropertyNameToPropertyHandlerTables = hashMap4;
        hashMap4.put(PROPERTY_PROXY_MAX_USE_MEMORY_MB, new ITPPropertyHandler<Long>() {
            public final Long getPropertyValue() {
                return Long.valueOf(TPPlayerConfig.getProxyMaxUseMemoryMB());
            }

            public final void setPropertyValue(Long l11) {
                TPPlayerConfig.setProxyMaxUseMemoryMB(l11.longValue());
                i.a().b(l11.longValue());
            }
        });
    }

    private static void dumpStackTrace() {
        TPLogUtil.i(TAG, "Current stack trace: ");
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            TPLogUtil.i(TAG, stackTraceElement.toString());
        }
    }

    public static Context getAppContext() {
        return mAppContext;
    }

    public static int getCellularDataCost() {
        ITPDownloadProxy a11;
        b a12 = i.a().a(TPPlayerConfig.getProxyServiceType());
        if (a12 == null || (a11 = a12.a()) == null) {
            return -1;
        }
        return com.tencent.thumbplayer.tcmedia.utils.b.a(a11.getNativeInfo(2), -1);
    }

    public static String getLibVersion(String str) {
        if (mIsInit) {
            if (!TextUtils.isEmpty(str)) {
                if (str.equals(TP_DOWNLOAD_PROXY_MODULE_NAME)) {
                    return TPDownloadProxyHelper.getNativeLibVersion();
                }
                if (str.equals(TP_PLAYERCORE_MODULE_NAME)) {
                    return TPNativeLibraryLoader.getLibVersion();
                }
            }
            throw new IllegalArgumentException("libName:".concat(String.valueOf(str)));
        }
        throw new IllegalStateException("player not initialized");
    }

    public static int getOfflineRecordDurationMs(String str, String str2) {
        return TPDownloadProxyHelper.getRecordDuration(str, str2);
    }

    public static String getOfflineRecordVinfo(String str, String str2) {
        return TPDownloadProxyHelper.checkVideoStatus(str, str2);
    }

    @Deprecated
    public static synchronized boolean getPropertyBoolean(String str) {
        boolean propertyBoolean;
        synchronized (TPPlayerMgr.class) {
            propertyBoolean = getPropertyBoolean(str, false);
        }
        return propertyBoolean;
    }

    public static synchronized boolean getPropertyBoolean(String str, boolean z11) {
        synchronized (TPPlayerMgr.class) {
            Boolean bool = mBoolPropertyNameToValueCache.get(str);
            if (bool == null) {
                return z11;
            }
            boolean booleanValue = bool.booleanValue();
            return booleanValue;
        }
    }

    @Deprecated
    public static synchronized int getPropertyInteger(String str) {
        int propertyInteger;
        synchronized (TPPlayerMgr.class) {
            propertyInteger = getPropertyInteger(str, 0);
        }
        return propertyInteger;
    }

    public static synchronized int getPropertyInteger(String str, int i11) {
        synchronized (TPPlayerMgr.class) {
            Integer num = mIntegerPropertyNameToValueCache.get(str);
            if (num == null) {
                return i11;
            }
            int intValue = num.intValue();
            return intValue;
        }
    }

    @Deprecated
    public static long getPropertyLong(String str) {
        return getPropertyLong(str, 0);
    }

    public static synchronized long getPropertyLong(String str, long j11) {
        synchronized (TPPlayerMgr.class) {
            Long l11 = mLongPropertyNameToValueCache.get(str);
            if (l11 == null) {
                return j11;
            }
            long longValue = l11.longValue();
            return longValue;
        }
    }

    @Deprecated
    public static String getPropertyString(String str) {
        return getPropertyString(str, "");
    }

    public static synchronized String getPropertyString(String str, String str2) {
        String str3;
        synchronized (TPPlayerMgr.class) {
            str3 = mStringPropertyNameToValueCache.get(str);
        }
        return str3 == null ? str2 : str3;
    }

    public static int getSuggestedBitrate() {
        ITPDownloadProxy a11;
        b a12 = i.a().a(TPPlayerConfig.getProxyServiceType());
        if (a12 == null || (a11 = a12.a()) == null) {
            return -1;
        }
        return com.tencent.thumbplayer.tcmedia.utils.b.a(a11.getNativeInfo(0), -1);
    }

    public static String getThumbPlayerVersion() {
        return TPPlayerConfig.VERSION;
    }

    private static Future<Boolean> initAsyncWithWait() {
        return o.a().c().submit(new Callable<Boolean>() {
            public final Boolean call() {
                TPPlayerMgr.initInAsyncThread();
                return Boolean.TRUE;
            }
        });
    }

    private static void initAsyncWithoutWait() {
        o.a().d().execute(new Runnable() {
            public final void run() {
                d dVar = new d();
                dVar.a();
                TPNativeKeyMapUtil.init();
                TPLogUtil.i(TPPlayerMgr.TAG, "Init SDK, initAsyncWithoutWait  nativeKeyMap init, times: " + dVar.c());
                com.tencent.thumbplayer.tcmedia.utils.i.a().a(TPPlayerMgr.mAppContext);
                new c().a();
                TPPlayerMgr.setExternalProperties();
                TPLogUtil.i(TPPlayerMgr.TAG, "Init SDK, initAsyncWithoutWait all times: " + dVar.d());
            }
        });
    }

    /* access modifiers changed from: private */
    public static void initInAsyncThread() {
        d dVar = new d();
        dVar.a();
        com.tencent.thumbplayer.tcmedia.common.a.b.a(mAppContext.getApplicationContext());
        TPLogUtil.i(TAG, "Init SDK, initAsyncWithWait  TPBeaconReportWrapper init, times: " + dVar.e());
        a.a(mAppContext);
        TPLogUtil.i(TAG, "Init SDK, initAsyncWithWait  TPDrmCapability init, times: " + dVar.e());
        TPThumbplayerCapabilityHelper.init(mAppContext, true);
        TPLogUtil.i(TAG, "Init SDK, initAsyncWithWait all times: " + dVar.d());
    }

    public static void initSdk(Context context, TPInitParams tPInitParams) {
        TPSystemInfo.setDeviceName(tPInitParams.getDeviceName());
        initSdk(context, tPInitParams.getGuid(), tPInitParams.getPlatform());
    }

    public static synchronized void initSdk(Context context, String str, int i11) {
        String str2;
        String str3;
        synchronized (TPPlayerMgr.class) {
            dumpStackTrace();
            if (mIsInit) {
                TPLogUtil.i(TAG, "Init SDK, has init sdk");
                return;
            }
            mIsInit = true;
            d dVar = new d();
            dVar.a();
            preInitSync(context, str, i11);
            Future<Boolean> initAsyncWithWait = initAsyncWithWait();
            initSync();
            initAsyncWithoutWait();
            dVar.b();
            try {
                if (initAsyncWithWait.get().booleanValue()) {
                    TPLogUtil.i(TAG, "Init SDK, TPPlayer  wait initSync finish, times: " + dVar.c());
                }
            } catch (ExecutionException unused) {
                str2 = TAG;
                str3 = "Init SDK, TPPlayer wait initSync ExecutionException, times: " + dVar.c();
                TPLogUtil.e(str2, str3);
                TPLogUtil.i(TAG, "Init SDK, TPPlayer all times: " + dVar.d());
            } catch (InterruptedException unused2) {
                str2 = TAG;
                str3 = "Init SDK, TPPlayer wait initSync InterruptedException, times: " + dVar.c();
                TPLogUtil.e(str2, str3);
                TPLogUtil.i(TAG, "Init SDK, TPPlayer all times: " + dVar.d());
            }
            TPLogUtil.i(TAG, "Init SDK, TPPlayer all times: " + dVar.d());
        }
    }

    private static void initSync() {
        d dVar = new d();
        dVar.a();
        try {
            TPNativeLibraryLoader.loadLibIfNeeded(mAppContext);
        } catch (UnsupportedOperationException e11) {
            TPLogUtil.e(TAG, (Throwable) e11);
        }
        TPLogUtil.i(TAG, "Init SDK, initSync so load times: " + dVar.d());
    }

    public static boolean isProxyEnable() {
        return TPPlayerConfig.isUseP2P() && TPDownloadProxyHelper.isReadyForPlay();
    }

    public static boolean isThumbPlayerEnable() {
        return TPNativeLibraryLoader.isLibLoadedAndTryToLoad();
    }

    public static void postEvent(int i11, int i12, int i13, Object obj) {
        f.a(i11, i12, i13, obj);
    }

    private static void preInitSync(Context context, String str, int i11) {
        d dVar = new d();
        dVar.a();
        mAppContext = context.getApplicationContext();
        TPPlayerConfig.setGuid(str);
        TPPlayerConfig.setPlatform(i11);
        TPNativeLog.setLogCallback(new ITPNativeLogCallback() {
            public final void onPrintLog(int i11, String str, String str2) {
                if (i11 == 0) {
                    TPLogUtil.v(str, str2);
                } else if (i11 == 1) {
                    TPLogUtil.d(str, str2);
                } else if (i11 == 2) {
                    TPLogUtil.i(str, str2);
                } else if (i11 == 3) {
                    TPLogUtil.w(str, str2);
                } else if (i11 == 4) {
                    TPLogUtil.e(str, str2);
                }
            }
        });
        TPLogUtil.i(TAG, "Init SDK, preInitSync all times: " + dVar.d());
    }

    public static void setDebugEnable(boolean z11) {
        TPPlayerConfig.setDebugEnable(z11);
    }

    /* access modifiers changed from: private */
    public static synchronized void setExternalProperties() {
        synchronized (TPPlayerMgr.class) {
            for (Map.Entry next : mBoolPropertyNameToValueCache.entrySet()) {
                ITPPropertyHandler iTPPropertyHandler = mBooleanPropertyNameToPropertyHandlerTables.get(next.getKey());
                if (iTPPropertyHandler != null) {
                    iTPPropertyHandler.setPropertyValue(next.getValue());
                }
            }
            for (Map.Entry next2 : mIntegerPropertyNameToValueCache.entrySet()) {
                ITPPropertyHandler iTPPropertyHandler2 = mIntegerPropertyNameToPropertyHandlerTables.get(next2.getKey());
                if (iTPPropertyHandler2 != null) {
                    iTPPropertyHandler2.setPropertyValue(next2.getValue());
                }
            }
            for (Map.Entry next3 : mStringPropertyNameToValueCache.entrySet()) {
                ITPPropertyHandler iTPPropertyHandler3 = mStringPropertyNameToPropertyHandlerTables.get(next3.getKey());
                if (iTPPropertyHandler3 != null) {
                    iTPPropertyHandler3.setPropertyValue(next3.getValue());
                }
            }
            for (Map.Entry next4 : mLongPropertyNameToValueCache.entrySet()) {
                ITPPropertyHandler iTPPropertyHandler4 = mLongPropertyNameToPropertyHandlerTables.get(next4.getKey());
                if (iTPPropertyHandler4 != null) {
                    iTPPropertyHandler4.setPropertyValue(next4.getValue());
                }
            }
        }
    }

    public static void setHost(String str) {
        TPPlayerConfig.parseHostConfig(str);
    }

    public static void setLibLoader(final ITPModuleLoader iTPModuleLoader) {
        if (!mIsInit) {
            TPNativeLibraryLoader.setLibLoader(new ITPNativeLibraryExternalLoader() {
                public final boolean loadLib(String str, String str2) {
                    ITPModuleLoader iTPModuleLoader = iTPModuleLoader;
                    if (iTPModuleLoader == null) {
                        return false;
                    }
                    try {
                        iTPModuleLoader.loadLibrary(str, str2);
                        return true;
                    } catch (Throwable th2) {
                        TPLogUtil.e(TPPlayerMgr.TAG, th2);
                        return false;
                    }
                }
            });
            TPDownloadProxyHelper.setNativeLibLoader(new ITPDLProxyNativeLibLoader() {
                public final boolean loadLib(String str, String str2) {
                    ITPModuleLoader iTPModuleLoader = iTPModuleLoader;
                    if (iTPModuleLoader == null) {
                        return false;
                    }
                    try {
                        iTPModuleLoader.loadLibrary(str, str2);
                        return true;
                    } catch (Throwable th2) {
                        TPLogUtil.e(TPPlayerMgr.TAG, th2);
                        return false;
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("player has init");
    }

    public static void setOnLogListener(OnLogListener onLogListener) {
        TPLogUtil.setOnLogListener(onLogListener);
    }

    public static void setOutNetIP(String str) {
        TPPlayerConfig.setOutNetIp(str);
    }

    public static synchronized void setPropertyBool(String str, boolean z11) {
        synchronized (TPPlayerMgr.class) {
            if (!mIsInit) {
                mBoolPropertyNameToValueCache.put(str, Boolean.valueOf(z11));
                return;
            }
            ITPPropertyHandler iTPPropertyHandler = mBooleanPropertyNameToPropertyHandlerTables.get(str);
            if (iTPPropertyHandler == null) {
                TPLogUtil.w(TAG, "not found handler of property, propertyName:".concat(String.valueOf(str)));
                return;
            }
            iTPPropertyHandler.setPropertyValue(Boolean.valueOf(z11));
            mBoolPropertyNameToValueCache.put(str, Boolean.valueOf(z11));
        }
    }

    public static synchronized void setPropertyInteger(String str, int i11) {
        synchronized (TPPlayerMgr.class) {
            if (!mIsInit) {
                mIntegerPropertyNameToValueCache.put(str, Integer.valueOf(i11));
                return;
            }
            ITPPropertyHandler iTPPropertyHandler = mIntegerPropertyNameToPropertyHandlerTables.get(str);
            if (iTPPropertyHandler == null) {
                TPLogUtil.w(TAG, "not found handler of property, propertyName:".concat(String.valueOf(str)));
                return;
            }
            iTPPropertyHandler.setPropertyValue(Integer.valueOf(i11));
            mIntegerPropertyNameToValueCache.put(str, Integer.valueOf(i11));
        }
    }

    public static synchronized void setPropertyLong(String str, long j11) {
        synchronized (TPPlayerMgr.class) {
            if (!mIsInit) {
                mLongPropertyNameToValueCache.put(str, Long.valueOf(j11));
                return;
            }
            ITPPropertyHandler iTPPropertyHandler = mLongPropertyNameToPropertyHandlerTables.get(str);
            if (iTPPropertyHandler == null) {
                TPLogUtil.w(TAG, "not found handler of property, propertyName:".concat(String.valueOf(str)));
                return;
            }
            iTPPropertyHandler.setPropertyValue(Long.valueOf(j11));
            mLongPropertyNameToValueCache.put(str, Long.valueOf(j11));
        }
    }

    public static synchronized void setPropertyString(String str, String str2) {
        synchronized (TPPlayerMgr.class) {
            if (!mIsInit) {
                mStringPropertyNameToValueCache.put(str, str2);
                return;
            }
            ITPPropertyHandler iTPPropertyHandler = mStringPropertyNameToPropertyHandlerTables.get(str);
            if (iTPPropertyHandler == null) {
                TPLogUtil.w(TAG, "not found handler of property, propertyName:".concat(String.valueOf(str)));
                return;
            }
            iTPPropertyHandler.setPropertyValue(str2);
            mStringPropertyNameToValueCache.put(str, str2);
        }
    }

    public static void setProxyEnable(boolean z11) {
        TPPlayerConfig.setP2PEnable(z11);
    }

    public static void setProxyMaxStorageSizeMB(long j11) {
        TPLogUtil.i(TAG, "setProxyMaxStorageSize: " + j11 + " MB.");
        TPPlayerConfig.setProxyMaxStorageSizeMB(j11);
        i.a().a(j11);
    }

    public static void setProxyServiceType(int i11) {
        TPPlayerConfig.setProxyServiceType(i11);
    }

    public static void setTPProxyAdapter(ITPProxyAdapter iTPProxyAdapter) {
        TPDownloadProxyHelper.setTPProxyAdapter(iTPProxyAdapter);
    }

    public static void setUpcInfo(String str, int i11) {
        TPPlayerConfig.setUserUpc(str);
        TPPlayerConfig.setUserUpcState(i11);
        f.a(100003, i11, 0, str);
    }

    public static void setUserInfo(String str, boolean z11) {
        TPPlayerConfig.setUserUin(str);
        TPPlayerConfig.setUserIsVip(z11);
    }
}
