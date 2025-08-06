package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.PowerManager;

public class PowerUtils {
    private static final String TAG = "PowerUtils";

    public static final class PowerMode {
        public static final int POWER_MODE_DEFAULT_RETURN_VALUE = 0;
        public static final int POWER_SAVER_MODE = 4;
        public static final String SMART_MODE_STATUS = "SmartModeStatus";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.app.usage.UsageStatsManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isAppIdleMode(android.content.Context r7) {
        /*
            r0 = 0
            java.lang.String r1 = "PowerUtils"
            if (r7 == 0) goto L_0x0038
            java.lang.String r2 = r7.getPackageName()
            r3 = 0
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 21
            java.lang.String r6 = "isAppIdleMode statsManager is null!"
            if (r4 < r5) goto L_0x0025
            r5 = 22
            if (r4 < r5) goto L_0x0028
            java.lang.String r3 = "usagestats"
            java.lang.Object r7 = r7.getSystemService(r3)
            boolean r3 = r7 instanceof android.app.usage.UsageStatsManager
            if (r3 == 0) goto L_0x0024
            r3 = r7
            android.app.usage.UsageStatsManager r3 = (android.app.usage.UsageStatsManager) r3
            goto L_0x0028
        L_0x0024:
            return r0
        L_0x0025:
            com.huawei.hms.framework.common.Logger.i(r1, r6)
        L_0x0028:
            if (r3 == 0) goto L_0x0034
            r7 = 23
            if (r4 < r7) goto L_0x003d
            boolean r7 = r3.isAppInactive(r2)
            r0 = r7
            goto L_0x003d
        L_0x0034:
            com.huawei.hms.framework.common.Logger.i(r1, r6)
            return r0
        L_0x0038:
            java.lang.String r7 = "isAppIdleMode Context is null!"
            com.huawei.hms.framework.common.Logger.i(r1, r7)
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.PowerUtils.isAppIdleMode(android.content.Context):boolean");
    }

    public static boolean isDozeIdleMode(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
            if (powerManager == null) {
                Logger.i(TAG, "isDozeIdleMode powerManager is null!");
                return false;
            } else if (Build.VERSION.SDK_INT >= 23) {
                try {
                    return powerManager.isDeviceIdleMode();
                } catch (RuntimeException e11) {
                    Logger.e(TAG, "dealType rethrowFromSystemServer:", (Throwable) e11);
                    return false;
                }
            } else {
                Logger.i(TAG, "isDozeIdleMode is version control state!");
                return false;
            }
        } else {
            Logger.i(TAG, "isDozeIdleMode Context is null!");
            return false;
        }
    }

    public static boolean isInteractive(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            if (systemService instanceof PowerManager) {
                PowerManager powerManager = (PowerManager) systemService;
                if (Build.VERSION.SDK_INT >= 20) {
                    try {
                        return powerManager.isInteractive();
                    } catch (RuntimeException e11) {
                        Logger.i(TAG, "getActiveNetworkInfo failed, exception:" + e11.getClass().getSimpleName() + e11.getMessage());
                    }
                }
            }
        }
        return false;
    }

    public static boolean isWhilteList(Context context) {
        if (context != null) {
            Object systemService = ContextCompat.getSystemService(context, "power");
            PowerManager powerManager = systemService instanceof PowerManager ? (PowerManager) systemService : null;
            String packageName = context.getPackageName();
            if (powerManager != null && Build.VERSION.SDK_INT >= 23) {
                try {
                    return powerManager.isIgnoringBatteryOptimizations(packageName);
                } catch (RuntimeException e11) {
                    Logger.e(TAG, "dealType rethrowFromSystemServer:", (Throwable) e11);
                }
            }
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static int readDataSaverMode(Context context) {
        if (context != null) {
            Object systemService = context.getSystemService("connectivity");
            ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
            if (connectivityManager != null) {
                int i11 = Build.VERSION.SDK_INT;
                if (i11 < 16 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    return 0;
                }
                if (!connectivityManager.isActiveNetworkMetered()) {
                    Logger.v(TAG, "ConnectType is not Mobile Network!");
                    return 0;
                } else if (i11 >= 24) {
                    return connectivityManager.getRestrictBackgroundStatus();
                } else {
                    return 0;
                }
            } else {
                Logger.i(TAG, "readDataSaverMode Context is null!");
                return 0;
            }
        } else {
            Logger.i(TAG, "readDataSaverMode manager is null!");
            return 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: android.os.PowerManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int readPowerSaverMode(android.content.Context r5) {
        /*
            java.lang.String r0 = "PowerUtils"
            r1 = 0
            if (r5 == 0) goto L_0x003d
            android.content.ContentResolver r2 = r5.getContentResolver()
            java.lang.String r3 = "SmartModeStatus"
            int r2 = com.huawei.hms.framework.common.SettingUtil.getSystemInt(r2, r3, r1)
            if (r2 != 0) goto L_0x003b
            r3 = 0
            java.lang.String r4 = "power"
            java.lang.Object r5 = com.huawei.hms.framework.common.ContextCompat.getSystemService(r5, r4)
            boolean r4 = r5 instanceof android.os.PowerManager
            if (r4 == 0) goto L_0x001f
            r3 = r5
            android.os.PowerManager r3 = (android.os.PowerManager) r3
        L_0x001f:
            if (r3 == 0) goto L_0x003b
            int r5 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r5 < r4) goto L_0x0036
            boolean r5 = r3.isPowerSaveMode()     // Catch:{ RuntimeException -> 0x002f }
            if (r5 == 0) goto L_0x0042
            r1 = 4
            goto L_0x0042
        L_0x002f:
            r5 = move-exception
            java.lang.String r1 = "dealType rethrowFromSystemServer:"
            com.huawei.hms.framework.common.Logger.e((java.lang.String) r0, (java.lang.String) r1, (java.lang.Throwable) r5)
            goto L_0x003b
        L_0x0036:
            java.lang.String r5 = "readPowerSaverMode is control by version!"
            com.huawei.hms.framework.common.Logger.i(r0, r5)
        L_0x003b:
            r1 = r2
            goto L_0x0042
        L_0x003d:
            java.lang.String r5 = "readPowerSaverMode Context is null!"
            com.huawei.hms.framework.common.Logger.i(r0, r5)
        L_0x0042:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.common.PowerUtils.readPowerSaverMode(android.content.Context):int");
    }
}
