package com.engagelab.privates.common.global;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.engagelab.privates.common.cache.MTCommonConfig;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.common.component.MTCommonService;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.utils.StringUtil;
import com.engagelab.privates.common.utils.SystemUtil;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public class MTGlobal {
    private static final String APP_CHANNEL = "ENGAGELAB_PRIVATES_CHANNEL";
    private static final String APP_KEY = "ENGAGELAB_PRIVATES_APPKEY";
    private static final String APP_PROCESS = "ENGAGELAB_PRIVATES_PROCESS";
    private static final String APP_TRANSFER = "ENGAGELAB_PRIVATES_TRANSFER";
    private static final String INTENT_COMMON_RECEIVER = "com.engagelab.privates.intent.USER_RECEIVER";
    private static final String INTENT_COMMON_SERVICE = "com.engagelab.privates.intent.USER_SERVICE";
    public static boolean IS_FOR_BINANCE = false;
    public static boolean IS_FOR_CHINALIFE = false;
    public static boolean IS_FOR_JIGUANG = false;
    public static boolean IS_FOR_PINGANBANK = false;
    public static boolean IS_FOR_PINGANTECH = false;
    public static boolean IS_FOR_SGM = false;
    public static boolean IS_FOR_SPDBAND = false;
    private static final String TAG = "MTGlobal";
    private static String appChannel = null;
    private static String appKey = null;
    private static String appProcess = null;
    private static String appTransfer = null;
    private static int appVersionCode = 0;
    private static String appVersionName = null;
    private static MTCommonReceiver commonReceiver = null;
    private static MTCommonService commonService = null;
    public static Context context = null;
    private static String countryCode = null;
    private static String currentActivityName = "";
    private static int encryptType = 0;
    private static boolean isDebugMode = false;
    private static AtomicBoolean isMainProcess = null;
    public static boolean isNeedRemoteProcess = false;
    private static AtomicBoolean isRemoteProcess = null;
    private static boolean lifecycleState = false;
    private static String networkName = "unknown";
    private static String networkRadio = "";
    private static boolean networkState = false;
    private static int networkType;

    public static String getAppChannel(Context context2) {
        if (TextUtils.isEmpty(appChannel)) {
            appChannel = getMetaData(context2, APP_CHANNEL);
        }
        return appChannel;
    }

    public static String getAppKey(Context context2) {
        if (TextUtils.isEmpty(appKey)) {
            appKey = getMetaData(context2, APP_KEY);
        }
        return appKey;
    }

    public static String getAppProcess(Context context2) {
        if (TextUtils.isEmpty(appProcess)) {
            appProcess = getMetaData(context2, APP_PROCESS);
        }
        return appProcess;
    }

    public static int getAppVersionCode(Context context2) {
        int i11 = appVersionCode;
        if (i11 != 0) {
            return i11;
        }
        try {
            int i12 = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionCode;
            appVersionCode = i12;
            return i12;
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "getAppVersionCode failed: " + th2.getMessage());
            return 0;
        }
    }

    public static String getAppVersionName(Context context2) {
        if (!TextUtils.isEmpty(appVersionName)) {
            return appVersionName;
        }
        try {
            String str = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
            appVersionName = str;
            return str;
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "getAppVersionName failed: " + th2.getMessage());
            return "";
        }
    }

    public static MTCommonReceiver getCommonReceiver(Context context2) {
        MTCommonReceiver commonReceiverImpl = getCommonReceiverImpl(context2);
        if (commonReceiverImpl == null) {
            MTCommonLog.w(TAG, "getCommonReceiver is null");
        }
        return commonReceiverImpl;
    }

    private static MTCommonReceiver getCommonReceiverImpl(Context context2) {
        MTCommonReceiver mTCommonReceiver = commonReceiver;
        if (mTCommonReceiver != null) {
            return mTCommonReceiver;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(INTENT_COMMON_RECEIVER);
            intent.setPackage(context2.getPackageName());
            for (ResolveInfo resolveInfo : context2.getPackageManager().queryBroadcastReceivers(intent, 0)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    String str = activityInfo.name;
                    if (!TextUtils.isEmpty(str)) {
                        Class<?> cls = Class.forName(str);
                        if (MTCommonReceiver.class.isAssignableFrom(cls)) {
                            MTCommonReceiver mTCommonReceiver2 = (MTCommonReceiver) cls.newInstance();
                            commonReceiver = mTCommonReceiver2;
                            return mTCommonReceiver2;
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "getCommonReceiver failed " + th2.getMessage());
            return null;
        }
    }

    public static MTCommonService getCommonService(Context context2) {
        MTCommonService commonServiceImpl = getCommonServiceImpl(context2);
        if (commonServiceImpl == null) {
            MTCommonLog.w(TAG, "getCommonService is null");
        }
        return commonServiceImpl;
    }

    private static MTCommonService getCommonServiceImpl(Context context2) {
        MTCommonService mTCommonService = commonService;
        if (mTCommonService != null) {
            return mTCommonService;
        }
        try {
            Intent intent = new Intent();
            intent.setAction(INTENT_COMMON_SERVICE);
            intent.setPackage(context2.getPackageName());
            for (ResolveInfo resolveInfo : context2.getPackageManager().queryIntentServices(intent, 0)) {
                ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                if (serviceInfo != null) {
                    String str = serviceInfo.name;
                    if (!TextUtils.isEmpty(str)) {
                        Class<?> cls = Class.forName(str);
                        if (MTCommonService.class.isAssignableFrom(cls)) {
                            MTCommonService mTCommonService2 = (MTCommonService) cls.newInstance();
                            commonService = mTCommonService2;
                            return mTCommonService2;
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "getCommonService failed " + th2.getMessage());
            return null;
        }
    }

    public static String getCountryCode(Context context2) {
        if (TextUtils.isEmpty(countryCode)) {
            countryCode = SystemUtil.getCountry(context2);
        }
        return countryCode;
    }

    public static String getCurrentActivityName() {
        return currentActivityName;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0081 A[Catch:{ all -> 0x00c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4 A[SYNTHETIC, Splitter:B:36:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00dc A[SYNTHETIC, Splitter:B:46:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getCurrentProcessName(android.content.Context r8) {
        /*
            java.lang.String r8 = "MTGlobal"
            java.lang.String r0 = "getCurrentProcessName failed "
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x000f }
            r2 = 28
            if (r1 < r2) goto L_0x0026
            java.lang.String r8 = android.app.Application.getProcessName()     // Catch:{ all -> 0x000f }
            return r8
        L_0x000f:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.engagelab.privates.common.log.MTCommonLog.w(r8, r1)
        L_0x0026:
            java.lang.String r1 = "android.app.ActivityThread"
            r2 = 0
            r3 = 0
            java.lang.Class<android.app.Application> r4 = android.app.Application.class
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch:{ all -> 0x004d }
            java.lang.Class r1 = java.lang.Class.forName(r1, r3, r4)     // Catch:{ all -> 0x004d }
            java.lang.String r4 = "currentProcessName"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ all -> 0x004d }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r4, r5)     // Catch:{ all -> 0x004d }
            r4 = 1
            r1.setAccessible(r4)     // Catch:{ all -> 0x004d }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x004d }
            java.lang.Object r1 = r1.invoke(r2, r4)     // Catch:{ all -> 0x004d }
            boolean r4 = r1 instanceof java.lang.String     // Catch:{ all -> 0x004d }
            if (r4 == 0) goto L_0x0064
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x004d }
            return r1
        L_0x004d:
            r1 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r1 = r1.getMessage()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            com.engagelab.privates.common.log.MTCommonLog.w(r8, r1)
        L_0x0064:
            java.lang.String r1 = "/proc/self/cmdline"
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x00c3 }
            r4.<init>(r1)     // Catch:{ all -> 0x00c3 }
            r1 = 256(0x100, float:3.59E-43)
            byte[] r2 = new byte[r1]     // Catch:{ all -> 0x00c0 }
            r5 = r3
        L_0x0070:
            int r6 = r4.read()     // Catch:{ all -> 0x00c0 }
            if (r6 <= 0) goto L_0x007f
            if (r5 >= r1) goto L_0x007f
            int r7 = r5 + 1
            byte r6 = (byte) r6     // Catch:{ all -> 0x00c0 }
            r2[r5] = r6     // Catch:{ all -> 0x00c0 }
            r5 = r7
            goto L_0x0070
        L_0x007f:
            if (r5 <= 0) goto L_0x00a4
            java.lang.String r1 = new java.lang.String     // Catch:{ all -> 0x00c0 }
            java.lang.String r6 = "UTF-8"
            r1.<init>(r2, r3, r5, r6)     // Catch:{ all -> 0x00c0 }
            r4.close()     // Catch:{ all -> 0x008c }
            goto L_0x00a3
        L_0x008c:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = r2.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.engagelab.privates.common.log.MTCommonLog.w(r8, r0)
        L_0x00a3:
            return r1
        L_0x00a4:
            r4.close()     // Catch:{ all -> 0x00a8 }
            goto L_0x00f7
        L_0x00a8:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = r1.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.engagelab.privates.common.log.MTCommonLog.w(r8, r0)
            goto L_0x00f7
        L_0x00c0:
            r1 = move-exception
            r2 = r4
            goto L_0x00c4
        L_0x00c3:
            r1 = move-exception
        L_0x00c4:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fa }
            r3.<init>()     // Catch:{ all -> 0x00fa }
            r3.append(r0)     // Catch:{ all -> 0x00fa }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00fa }
            r3.append(r1)     // Catch:{ all -> 0x00fa }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x00fa }
            com.engagelab.privates.common.log.MTCommonLog.w(r8, r1)     // Catch:{ all -> 0x00fa }
            if (r2 == 0) goto L_0x00f7
            r2.close()     // Catch:{ all -> 0x00e0 }
            goto L_0x00f7
        L_0x00e0:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = r1.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.engagelab.privates.common.log.MTCommonLog.w(r8, r0)
        L_0x00f7:
            java.lang.String r8 = ""
            return r8
        L_0x00fa:
            r1 = move-exception
            if (r2 == 0) goto L_0x0118
            r2.close()     // Catch:{ all -> 0x0101 }
            goto L_0x0118
        L_0x0101:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            java.lang.String r0 = r2.getMessage()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.engagelab.privates.common.log.MTCommonLog.w(r8, r0)
        L_0x0118:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.engagelab.privates.common.global.MTGlobal.getCurrentProcessName(android.content.Context):java.lang.String");
    }

    public static boolean getDebugMode() {
        return isDebugMode;
    }

    public static String getDeviceId(Context context2) {
        String str;
        String deviceId = MTCommonConfig.getDeviceId(context2);
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        try {
            str = StringUtil.get32MD5String(" " + Settings.Secure.getString(context2.getContentResolver(), "android_id") + " " + (Build.PRODUCT.toLowerCase() + "_" + Build.TIME));
        } catch (Throwable unused) {
            str = StringUtil.get32MD5String(" " + UUID.randomUUID().toString() + "  ");
        }
        MTCommonConfig.setDeviceId(context2, str);
        return str;
    }

    public static int getEncryptType() {
        return encryptType;
    }

    public static boolean getLifecycleState() {
        return lifecycleState;
    }

    private static String getMainProcessName(Context context2) {
        return context2.getPackageName();
    }

    public static String getMetaData(Context context2, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context2.getPackageManager().getApplicationInfo(context2.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return "";
            }
            return String.valueOf(bundle.get(str));
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "getMetaData failed " + th2.getMessage());
            return "";
        }
    }

    public static String getNetworkName() {
        return networkName;
    }

    public static String getNetworkRadio() {
        return networkRadio;
    }

    public static boolean getNetworkState() {
        return networkState;
    }

    public static int getNetworkType() {
        return networkType;
    }

    private static String getRemoteProcessName(Context context2, Class<?> cls) {
        try {
            return context2.getPackageManager().getServiceInfo(new ComponentName(context2.getPackageName(), cls.getCanonicalName()), 128).processName;
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "getRemoteProcessName failed " + th2.getMessage());
            return "";
        }
    }

    public static String getTransfer(Context context2) {
        if (TextUtils.isEmpty(appTransfer)) {
            appTransfer = getMetaData(context2, APP_TRANSFER);
        }
        return appTransfer;
    }

    public static boolean hasPermission(Context context2, String str) {
        try {
            if (Build.VERSION.SDK_INT < 23) {
                for (String equals : context2.getPackageManager().getPackageInfo(context2.getPackageName(), 4096).requestedPermissions) {
                    if (TextUtils.equals(str, equals)) {
                        return true;
                    }
                }
                return false;
            } else if (context2.checkSelfPermission(str) == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean isMainProcess(Context context2) {
        AtomicBoolean atomicBoolean = isMainProcess;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        isMainProcess = new AtomicBoolean(false);
        try {
            if (TextUtils.equals(getCurrentProcessName(context2), getMainProcessName(context2))) {
                isMainProcess.set(true);
            }
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "isMainProcess failed " + th2.getMessage());
        }
        return isMainProcess.get();
    }

    public static boolean isRemoteProcess(Context context2) {
        AtomicBoolean atomicBoolean = isRemoteProcess;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        isRemoteProcess = new AtomicBoolean(false);
        try {
            String currentProcessName = getCurrentProcessName(context2);
            if (TextUtils.isEmpty(currentProcessName)) {
                isRemoteProcess.set(true);
            }
            if (TextUtils.equals(currentProcessName, getRemoteProcessName(context2, getCommonService(context2).getClass()))) {
                isRemoteProcess.set(true);
            }
        } catch (Throwable th2) {
            MTCommonLog.w(TAG, "isRemoteProcess failed " + th2.getMessage());
        }
        return isRemoteProcess.get();
    }

    public static void setAppChannel(String str) {
        appChannel = str;
    }

    public static void setAppKey(String str) {
        appKey = str;
    }

    public static void setCountryCode(String str) {
        countryCode = str;
    }

    public static void setCurrentActivityName(String str) {
        currentActivityName = str;
    }

    public static void setDebugMode(boolean z11) {
        isDebugMode = z11;
    }

    public static void setDeviceId(Context context2, String str) {
        MTCommonConfig.setDeviceId(context2, str);
    }

    public static void setEncryptType(int i11) {
        encryptType = i11;
    }

    public static void setLifecycleState(boolean z11) {
        lifecycleState = z11;
    }

    public static void setNetworkName(String str) {
        networkName = str;
    }

    public static void setNetworkRadio(String str) {
        networkRadio = str;
    }

    public static void setNetworkState(boolean z11) {
        networkState = z11;
    }

    public static void setNetworkType(int i11) {
        networkType = i11;
    }
}
