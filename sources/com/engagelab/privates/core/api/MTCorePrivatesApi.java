package com.engagelab.privates.core.api;

import android.content.Context;
import android.text.TextUtils;
import com.engagelab.privates.common.g;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.core.global.MTCoreGlobal;

public class MTCorePrivatesApi {
    public static final int SDK_VERSION_CODE = 324;
    public static final String SDK_VERSION_NAME = "3.2.4";
    private static final String TAG = "MTCorePrivatesApi";

    public static void configAppChannel(Context context, String str) {
        if (context == null) {
            MTCommonLog.e(TAG, "configAppChannel context can't be null, please check it");
        } else if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "configAppChannel appChannel can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTGlobal.setAppChannel(str);
        }
    }

    public static void configAppKey(Context context, String str) {
        if (context == null) {
            MTCommonLog.e(TAG, "configAppKey context can't be null, please check it");
        } else if (TextUtils.isEmpty(str)) {
            MTCommonLog.e(TAG, "configAppKey appKey can't be empty, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTGlobal.setAppKey(str);
        }
    }

    public static void configConnectRetryCount(Context context, int i11) {
        if (context == null) {
            MTCoreGlobal.setConnectRetryCount(i11);
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTCoreGlobal.setConnectRetryCount(i11);
        }
    }

    public static void configDebugMode(Context context, boolean z11) {
        if (context == null) {
            MTGlobal.setDebugMode(z11);
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTGlobal.setDebugMode(z11);
        }
    }

    public static void configHeartbeatInterval(Context context, long j11) {
        if (context == null) {
            MTCoreGlobal.setHeartbeatInterval(j11);
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTCoreGlobal.setHeartbeatInterval(j11);
        }
    }

    public static void configSM4(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "configSM4 context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTGlobal.setEncryptType(2);
        }
    }

    public static void configWakeAndBeWake(Context context, boolean z11) {
        if (context == null) {
            MTCommonLog.e(TAG, "configWakeAndBeWake context can't be null, please check it");
        } else if (MTGlobal.isMainProcess(context.getApplicationContext()) || MTGlobal.isRemoteProcess(context.getApplicationContext())) {
            MTCoreGlobal.setWakeAndBeWakeState(z11);
        }
    }

    public static int getLoginCode(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "getLoginCode context can't be null, please check it");
            return 0;
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            return MTCoreGlobal.getLoginCode(context);
        } else {
            if (MTGlobal.isRemoteProcess(context.getApplicationContext())) {
                return g.c(context.getApplicationContext());
            }
            return 0;
        }
    }

    public static String getPassword(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "getPassword context can't be null, please check it");
            return "";
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            return MTCoreGlobal.getPassword(context);
        } else {
            if (MTGlobal.isRemoteProcess(context.getApplicationContext())) {
                return g.d(context.getApplicationContext());
            }
            return "";
        }
    }

    public static int getRegisterCode(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "getRegisterCode context can't be null, please check it");
            return 0;
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            return MTCoreGlobal.getRegisterCode(context);
        } else {
            if (MTGlobal.isRemoteProcess(context.getApplicationContext())) {
                return g.f(context.getApplicationContext());
            }
            return 0;
        }
    }

    public static String getRegistrationId(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "getRegistrationId context can't be null, please check it");
            return "";
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            return MTCoreGlobal.getRegistrationId(context);
        } else {
            if (MTGlobal.isRemoteProcess(context.getApplicationContext())) {
                return g.g(context.getApplicationContext());
            }
            return "";
        }
    }

    public static int getSeedId(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "getSeedId context can't be null, please check it");
            return 0;
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            return MTCoreGlobal.getSeedId(context);
        } else {
            if (MTGlobal.isRemoteProcess(context.getApplicationContext())) {
                return g.h(context.getApplicationContext());
            }
            return 0;
        }
    }

    public static long getServerTime(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "getServerTime context can't be null, please check it");
            return 0;
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            return MTCoreGlobal.getServerTime(context);
        } else {
            if (MTGlobal.isRemoteProcess(context.getApplicationContext())) {
                return g.i(context.getApplicationContext());
            }
            return 0;
        }
    }

    public static long getUserId(Context context) {
        if (context == null) {
            MTCommonLog.e(TAG, "getUserId context can't be null, please check it");
            return 0;
        } else if (MTGlobal.isMainProcess(context.getApplicationContext())) {
            return MTCoreGlobal.getUserId(context);
        } else {
            if (MTGlobal.isRemoteProcess(context.getApplicationContext())) {
                return g.m(context.getApplicationContext());
            }
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isConnectContinue(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x000b
            java.lang.String r4 = "MTCorePrivatesApi"
            java.lang.String r1 = "isConnectContinue context can't be null, please check it"
            com.engagelab.privates.common.log.MTCommonLog.e(r4, r1)
            return r0
        L_0x000b:
            android.content.Context r1 = r4.getApplicationContext()
            boolean r1 = com.engagelab.privates.common.global.MTGlobal.isMainProcess(r1)
            if (r1 != 0) goto L_0x0020
            android.content.Context r4 = r4.getApplicationContext()
            boolean r4 = com.engagelab.privates.common.global.MTGlobal.isRemoteProcess(r4)
            if (r4 != 0) goto L_0x0020
            return r0
        L_0x0020:
            com.engagelab.privates.common.observer.MTObservable r4 = com.engagelab.privates.common.observer.MTObservable.getInstance()
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.String> r4 = r4.observeNameQueue
            java.util.Iterator r4 = r4.iterator()
        L_0x002a:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0049
            java.lang.Object r1 = r4.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "com.engagelab.privates.push.MTPush"
            boolean r2 = android.text.TextUtils.equals(r1, r2)
            r3 = 1
            if (r2 == 0) goto L_0x0040
            return r3
        L_0x0040:
            java.lang.String r2 = "com.engagelab.privates.message.MTMessage"
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 == 0) goto L_0x002a
            return r3
        L_0x0049:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.engagelab.privates.core.api.MTCorePrivatesApi.isConnectContinue(android.content.Context):boolean");
    }

    @Deprecated
    public static void setWakeAndBeWakeEnable(Context context, boolean z11) {
        configWakeAndBeWake(context, z11);
    }
}
