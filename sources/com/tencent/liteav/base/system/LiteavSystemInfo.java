package com.tencent.liteav.base.system;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Debug;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.places.model.PlaceFields;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.b.a;
import com.tencent.liteav.base.util.i;
import com.tencent.liteav.base.util.s;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@JNINamespace("liteav")
public class LiteavSystemInfo {
    private static final int APP_SYSTEM_METHOD_DEFAULT_GET_INTERVAL_MS = 1000;
    private static final String EXT_KEY_APP_BACKGROUND = "isAppBackground";
    private static final String EXT_KEY_APP_NAME = "appName";
    private static final String EXT_KEY_APP_PACKAGE_NAME = "appPackageName";
    private static final String EXT_KEY_APP_VERSION = "appVersion";
    private static final String EXT_KEY_BUILD_BOARD = "buildBoard";
    private static final String EXT_KEY_BUILD_BRAND = "buildBrand";
    private static final String EXT_KEY_BUILD_HARDWARE = "buildHardware";
    private static final String EXT_KEY_BUILD_MANUFACTURER = "buildManufacturer";
    private static final String EXT_KEY_BUILD_MODEL = "buildModel";
    private static final String EXT_KEY_BUILD_VERSION = "buildVersion";
    private static final String EXT_KEY_BUILD_VERSION_INT = "buildVersionInt";
    private static final int GET_APP_MEMORY_INTERVAL_MS = 15000;
    private static final int NETWORK_TYPE_2G = 4;
    private static final int NETWORK_TYPE_3G = 3;
    private static final int NETWORK_TYPE_4G = 2;
    private static final int NETWORK_TYPE_5G = 6;
    private static final int NETWORK_TYPE_UNKNOWN = 0;
    private static final int NETWORK_TYPE_WIFI = 1;
    private static final int NETWORK_TYPE_WIRED = 5;
    private static final String TAG = "LiteavBaseSystemInfo";
    private static final s<String> sAppName = new s<>(e.a());
    private static final s<String> sAppPackageName = new s<>(d.a());
    private static final s<String> sAppVersion = new s<>(f.a());
    private static final s<String> sBoard = new s<>(o.a());
    private static final s<String> sBrand = new s<>(j.a());
    private static final a sGatewayThrottler = new a(1000);
    private static final s<String> sHardware = new s<>(l.a());
    private static AtomicBoolean sIsGettingMemoryUsage = new AtomicBoolean(false);
    private static int sLastGateway = 0;
    private static AtomicInteger sLastMemoryUsage = new AtomicInteger(0);
    private static boolean sLastMicPermission = false;
    private static int sLastNetworkType = 0;
    private static final s<String> sManufacturer = new s<>(k.a());
    private static final a sMemoryUsageThrottler = new a(15000);
    private static final a sMicPermissionThrottler = new a(1000);
    private static final s<String> sModel = new s<>(i.a());
    private static final a sNetworkTypeThrottler = new a(1000);
    private static final s<String> sSystemOSVersion = new s<>(m.a());
    private static final s<Integer> sSystemOSVersionInt = new s<>(n.a());
    private static final s<String> sUUID = new s<>(g.a());

    public static synchronized int getAppBackgroundState() {
        int i11;
        synchronized (LiteavSystemInfo.class) {
            i11 = i.a().b() ? 1 : 0;
        }
        return i11;
    }

    public static synchronized int getAppMemoryUsage() {
        int i11;
        synchronized (LiteavSystemInfo.class) {
            if (sMemoryUsageThrottler.a()) {
                getAppMemoryUsageFromSystem();
            }
            i11 = sLastMemoryUsage.get();
        }
        return i11;
    }

    private static void getAppMemoryUsageFromSystem() {
        if (!sIsGettingMemoryUsage.get()) {
            sIsGettingMemoryUsage.set(true);
            AsyncTask.execute(c.a());
        }
    }

    public static String getAppName() {
        return sAppName.a();
    }

    public static String getAppPackageName() {
        return sAppPackageName.a();
    }

    public static synchronized int getAppThreadSize() {
        int activeCount;
        synchronized (LiteavSystemInfo.class) {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            while (threadGroup.getParent() != null) {
                threadGroup = threadGroup.getParent();
            }
            activeCount = threadGroup.activeCount();
        }
        return activeCount;
    }

    public static String getAppVersion() {
        return sAppVersion.a();
    }

    public static synchronized boolean getAudioRecordPermission() {
        boolean z11;
        synchronized (LiteavSystemInfo.class) {
            if (sMicPermissionThrottler.a()) {
                sLastMicPermission = getAudioRecordPermissionFromSystem();
            }
            z11 = sLastMicPermission;
        }
        return z11;
    }

    private static boolean getAudioRecordPermissionFromSystem() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext != null && applicationContext.checkPermission("android.permission.RECORD_AUDIO", Process.myPid(), Process.myUid()) == 0) {
            return true;
        }
        return false;
    }

    public static String getBoard() {
        return sBoard.a();
    }

    public static String getBrand() {
        return sBrand.a();
    }

    public static String getDeviceUuid() {
        return sUUID.a();
    }

    public static synchronized int getGateway() {
        int i11;
        synchronized (LiteavSystemInfo.class) {
            if (sGatewayThrottler.a()) {
                sLastGateway = getGatewayFromSystem();
            }
            i11 = sLastGateway;
        }
        return i11;
    }

    private static int getGatewayFromSystem() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return 0;
        }
        try {
            return ((WifiManager) applicationContext.getSystemService("wifi")).getDhcpInfo().gateway;
        } catch (Throwable th2) {
            Log.e(TAG, "getGateway error " + th2.getMessage(), new Object[0]);
            return 0;
        }
    }

    public static String getHardware() {
        return sHardware.a();
    }

    public static String getManufacturer() {
        return sManufacturer.a();
    }

    public static String getModel() {
        return sModel.a();
    }

    public static synchronized int getNetworkType() {
        int i11;
        synchronized (LiteavSystemInfo.class) {
            if (sNetworkTypeThrottler.a()) {
                sLastNetworkType = getNetworkTypeFromSystem();
            }
            i11 = sLastNetworkType;
        }
        return i11;
    }

    private static int getNetworkTypeFromSystem() {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService(PlaceFields.PHONE);
        NetworkInfo networkInfo = null;
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception e11) {
            Log.e(TAG, "getNetworkType error occurred.", e11);
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return 0;
        }
        if (networkInfo.getType() == 9) {
            return 5;
        }
        if (networkInfo.getType() == 1) {
            return 1;
        }
        if (networkInfo.getType() != 0) {
            return 0;
        }
        try {
            int networkType = telephonyManager.getNetworkType();
            switch (networkType) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 4;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 3;
                case 13:
                    return 2;
                default:
                    if (getSystemOSVersionInt() < 29 || networkType != 20) {
                        return 2;
                    }
                    return 6;
            }
        } catch (Exception e12) {
            Log.e(TAG, "getNetworkType error occurred.", e12);
            return 2;
        }
    }

    public static String getSystemOSVersion() {
        return sSystemOSVersion.a();
    }

    public static int getSystemOSVersionInt() {
        return sSystemOSVersionInt.a().intValue();
    }

    public static /* synthetic */ void lambda$getAppMemoryUsageFromSystem$8() {
        int i11;
        try {
            Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
            i11 = memoryInfo.getTotalPss();
        } catch (Exception e11) {
            Log.e(TAG, "Get App memory usage failed." + e11.getMessage(), new Object[0]);
            i11 = 0;
        }
        sLastMemoryUsage.set(i11 / 1024);
        sIsGettingMemoryUsage.set(false);
    }

    public static synchronized void listenAppBackgroundState() {
        synchronized (LiteavSystemInfo.class) {
            i.a().a(h.a());
        }
    }

    private static native void nativeOnAppBackgroundStateChanged(int i11);

    public static void onAppBackgroundStateChanged(boolean z11) {
        nativeOnAppBackgroundStateChanged(z11 ? 1 : 0);
    }

    public static boolean setExtID(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str.hashCode();
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1978299099:
                    if (str.equals(EXT_KEY_APP_BACKGROUND)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -911706486:
                    if (str.equals(EXT_KEY_BUILD_VERSION)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -794136500:
                    if (str.equals(EXT_KEY_APP_NAME)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -589756065:
                    if (str.equals(EXT_KEY_BUILD_MANUFACTURER)) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -497349352:
                    if (str.equals(EXT_KEY_BUILD_BOARD)) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -497260103:
                    if (str.equals(EXT_KEY_BUILD_BRAND)) {
                        c11 = 5;
                        break;
                    }
                    break;
                case -487188133:
                    if (str.equals(EXT_KEY_BUILD_MODEL)) {
                        c11 = 6;
                        break;
                    }
                    break;
                case -441921776:
                    if (str.equals(EXT_KEY_APP_PACKAGE_NAME)) {
                        c11 = 7;
                        break;
                    }
                    break;
                case -391134602:
                    if (str.equals(EXT_KEY_BUILD_HARDWARE)) {
                        c11 = 8;
                        break;
                    }
                    break;
                case 725329157:
                    if (str.equals(EXT_KEY_BUILD_VERSION_INT)) {
                        c11 = 9;
                        break;
                    }
                    break;
                case 1484112759:
                    if (str.equals("appVersion")) {
                        c11 = 10;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    try {
                        i.a(Integer.parseInt(str2) == 1);
                        break;
                    } catch (Exception e11) {
                        Log.e(TAG, "set app background state failed. ".concat(String.valueOf(e11)), new Object[0]);
                        break;
                    }
                case 1:
                    sSystemOSVersion.a(str2);
                    break;
                case 2:
                    sAppName.a(str2);
                    break;
                case 3:
                    sManufacturer.a(str2);
                    break;
                case 4:
                    sBoard.a(str2);
                    break;
                case 5:
                    sBrand.a(str2);
                    break;
                case 6:
                    sModel.a(str2);
                    break;
                case 7:
                    sAppPackageName.a(str2);
                    break;
                case 8:
                    sHardware.a(str2);
                    break;
                case 9:
                    try {
                        sSystemOSVersionInt.a(Integer.valueOf(Integer.parseInt(str2)));
                        break;
                    } catch (Exception e12) {
                        e12.printStackTrace();
                        break;
                    }
                case 10:
                    sAppVersion.a(str2);
                    break;
                default:
                    return false;
            }
        }
        return false;
        return true;
    }
}
