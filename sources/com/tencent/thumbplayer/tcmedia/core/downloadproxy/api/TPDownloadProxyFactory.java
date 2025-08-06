package com.tencent.thumbplayer.tcmedia.core.downloadproxy.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.aidl.TPDownloadProxyFactoryAidl;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.client.TPDownloadProxyClient;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.service.TPDownloadProxyService;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.utils.TPDLProxyLog;
import java.util.HashMap;
import java.util.Map;

public class TPDownloadProxyFactory {
    private static final String FILE_NAME = "TPDownloadProxyFactory";
    /* access modifiers changed from: private */
    public static TPDownloadProxyFactoryAidl downloadProxyFactoryAidl;
    /* access modifiers changed from: private */
    public static TPDLProxyBindServiceCallback mCallback = null;
    private static boolean mCanUseAIDL = false;
    private static ServiceConnection mConnection = new ServiceConnection() {
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            TPDownloadProxyFactoryAidl unused = TPDownloadProxyFactory.downloadProxyFactoryAidl = TPDownloadProxyFactoryAidl.Stub.asInterface(iBinder);
            try {
                for (Map.Entry entry : TPDownloadProxyFactory.mvTPDownloadProxyClientMap.entrySet()) {
                    ((TPDownloadProxyClient) entry.getValue()).updateAidl(TPDownloadProxyFactory.downloadProxyFactoryAidl.getTPDownloadProxy(((Integer) entry.getKey()).intValue()));
                }
            } catch (Throwable th2) {
                TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "onServiceConnected failed, error:" + th2.toString());
            }
            TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service connected!");
            if (TPDownloadProxyFactory.downloadProxyFactoryAidl == null) {
                TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service connected, aidl is null!");
                return;
            }
            TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service connected, aidl not null!");
            TPDownloadProxyFactory.setCanUseAIDL(true);
            if (TPDownloadProxyFactory.mCallback != null) {
                TPDownloadProxyFactory.mCallback.onBindSuccess();
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            TPDLProxyLog.i(TPDownloadProxyFactory.FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "on service disconnected");
            TPDownloadProxyFactoryAidl unused = TPDownloadProxyFactory.downloadProxyFactoryAidl = null;
            TPDownloadProxyFactory.setCanUseAIDL(false);
            TPDownloadProxyFactory.ensurePlayManagerService(TPDownloadProxyFactory.mCallback);
        }
    };
    private static boolean mIsReadyForDownload = false;
    private static Object mMapObject = new Object();
    private static boolean mUseService = false;
    /* access modifiers changed from: private */
    public static HashMap<Integer, TPDownloadProxyClient> mvTPDownloadProxyClientMap = new HashMap<>();
    private static HashMap<Integer, ITPDownloadProxy> mvTPDownloadProxyMap = new HashMap<>();

    public static synchronized boolean canUseService() {
        synchronized (TPDownloadProxyFactory.class) {
            if (!mUseService) {
                return true;
            }
            if (!mCanUseAIDL) {
                return false;
            }
            TPDownloadProxyFactoryAidl tPDownloadProxyFactoryAidl = downloadProxyFactoryAidl;
            if (tPDownloadProxyFactoryAidl != null) {
                try {
                    tPDownloadProxyFactoryAidl.isReadyForPlay();
                    return true;
                } catch (Throwable th2) {
                    TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "canUseService failed, error:" + th2.toString());
                    return false;
                }
            }
        }
    }

    public static boolean ensurePlayManagerService(TPDLProxyBindServiceCallback tPDLProxyBindServiceCallback) {
        Context context = TPDownloadProxyHelper.getContext();
        if (context == null) {
            TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "ensurePlayManagerService get context null!");
            return false;
        }
        mCallback = tPDLProxyBindServiceCallback;
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "ensurePlayManagerService " + BaseHbgResponse.STATUS_OK);
        try {
            Intent intent = new Intent(context, TPDownloadProxyService.class);
            context.startService(intent);
            if (!context.bindService(intent, mConnection, 1)) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "ensurePlayManagerService bind service failed!");
            }
            return true;
        } catch (Throwable th2) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "ensurePlayManagerService failed, error:" + th2.toString());
            return false;
        }
    }

    public static synchronized boolean getCanUseAIDL() {
        boolean z11;
        synchronized (TPDownloadProxyFactory.class) {
            z11 = mCanUseAIDL;
        }
        return z11;
    }

    public static String getNativeVersion() {
        if (!mUseService) {
            return TPDownloadProxyNative.getInstance().getNativeVersion();
        }
        if (!mCanUseAIDL) {
            return TPDownloadProxyNative.getInstance().getNativeVersion();
        }
        TPDownloadProxyFactoryAidl tPDownloadProxyFactoryAidl = downloadProxyFactoryAidl;
        if (tPDownloadProxyFactoryAidl != null) {
            try {
                return tPDownloadProxyFactoryAidl.getNativeVersion();
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getNativeVersion failed, error:" + th2.toString());
            }
        }
        return TPDownloadProxyNative.getInstance().getNativeVersion();
    }

    public static ITPDownloadProxy getTPDownloadProxy(int i11) {
        ITPDownloadProxy iTPDownloadProxy;
        if (i11 <= 0) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxy is invalid, serviceType:".concat(String.valueOf(i11)));
            return null;
        } else if (!mUseService) {
            synchronized (mMapObject) {
                iTPDownloadProxy = mvTPDownloadProxyMap.get(Integer.valueOf(i11));
                if (iTPDownloadProxy == null) {
                    iTPDownloadProxy = new TPDownloadProxy(i11);
                    mvTPDownloadProxyMap.put(Integer.valueOf(i11), iTPDownloadProxy);
                }
            }
            return iTPDownloadProxy;
        } else if (mCanUseAIDL) {
            try {
                return getTPDownloadProxyService(i11);
            } catch (Throwable th2) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxy failed, error:" + th2.toString());
                return null;
            }
        } else {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxy failed, can't use aidl!");
            return null;
        }
    }

    private static synchronized ITPDownloadProxy getTPDownloadProxyService(int i11) {
        TPDownloadProxyClient tPDownloadProxyClient;
        synchronized (TPDownloadProxyFactory.class) {
            if (downloadProxyFactoryAidl != null) {
                synchronized (mvTPDownloadProxyClientMap) {
                    tPDownloadProxyClient = mvTPDownloadProxyClientMap.get(Integer.valueOf(i11));
                    if (tPDownloadProxyClient == null) {
                        try {
                            tPDownloadProxyClient = new TPDownloadProxyClient(downloadProxyFactoryAidl.getTPDownloadProxy(i11));
                        } catch (Throwable th2) {
                            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxyService failed, error:" + th2.toString());
                        }
                    }
                    mvTPDownloadProxyClientMap.put(Integer.valueOf(i11), tPDownloadProxyClient);
                }
                return tPDownloadProxyClient;
            }
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "getTPDownloadProxyService failed, aidl is null!");
            return null;
        }
    }

    public static boolean getUseService() {
        return mUseService;
    }

    public static synchronized boolean isReadyForDownload() {
        boolean z11;
        synchronized (TPDownloadProxyFactory.class) {
            z11 = false;
            if (!mUseService) {
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isReadyForDownload ret:" + mIsReadyForDownload);
                boolean z12 = mIsReadyForDownload;
                return z12;
            } else if (!mCanUseAIDL) {
                return false;
            } else {
                TPDownloadProxyFactoryAidl tPDownloadProxyFactoryAidl = downloadProxyFactoryAidl;
                if (tPDownloadProxyFactoryAidl != null) {
                    try {
                        z11 = tPDownloadProxyFactoryAidl.isReadyForDownload();
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isReadyForDownload failed, error:" + th2.toString());
                    }
                }
            }
        }
        return z11;
    }

    public static synchronized boolean isReadyForPlay() {
        boolean z11;
        synchronized (TPDownloadProxyFactory.class) {
            z11 = false;
            if (!mUseService) {
                boolean isReadyForWork = TPDownloadProxyNative.getInstance().isReadyForWork();
                TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isReadyForPlay ret:".concat(String.valueOf(isReadyForWork)));
                return isReadyForWork;
            } else if (!mCanUseAIDL) {
                return false;
            } else {
                TPDownloadProxyFactoryAidl tPDownloadProxyFactoryAidl = downloadProxyFactoryAidl;
                if (tPDownloadProxyFactoryAidl != null) {
                    try {
                        z11 = tPDownloadProxyFactoryAidl.isReadyForPlay();
                    } catch (Throwable th2) {
                        TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "isReadyForPlay failed, error:" + th2.toString());
                    }
                }
            }
        }
        return z11;
    }

    /* access modifiers changed from: private */
    public static synchronized void setCanUseAIDL(boolean z11) {
        synchronized (TPDownloadProxyFactory.class) {
            mCanUseAIDL = z11;
        }
    }

    public static synchronized void setReadyForDownload(boolean z11) {
        synchronized (TPDownloadProxyFactory.class) {
            mIsReadyForDownload = z11;
        }
    }

    public static void setUseService(boolean z11) {
        mUseService = z11;
    }
}
