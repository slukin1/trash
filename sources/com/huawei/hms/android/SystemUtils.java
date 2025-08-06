package com.huawei.hms.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.support.log.HMSLog;
import com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

public class SystemUtils {
    public static final String PRODUCT_BRAND = "ro.product.brand";
    public static final String PRODUCT_HONOR = "HONOR";
    public static final String PRODUCT_HUAWEI = "HUAWEI";
    public static final String UNKNOWN = "unknown";

    private static String a() {
        return getSystemProperties("ro.product.locale", "");
    }

    private static String b() {
        return getSystemProperties("ro.product.locale.region", "");
    }

    public static String getAndoridVersion() {
        return getSystemProperties(TPSystemInfo.KEY_PROPERTY_VERSION_RELEASE, "unknown");
    }

    public static String getLocalCountry() {
        Locale locale = Locale.getDefault();
        return locale != null ? locale.getCountry() : "";
    }

    public static String getManufacturer() {
        return getSystemProperties(TPSystemInfo.KEY_PROPERTY_MANUFACTURER, "unknown");
    }

    public static long getMegabyte(double d11) {
        double d12 = Build.VERSION.SDK_INT > 25 ? 1000.0d : 1024.0d;
        return (long) (d11 * d12 * d12);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r1 = (r1 = (android.net.ConnectivityManager) r1.getSystemService("connectivity")).getActiveNetworkInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getNetType(android.content.Context r1) {
        /*
            if (r1 == 0) goto L_0x001d
            java.lang.String r0 = "connectivity"
            java.lang.Object r1 = r1.getSystemService(r0)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            if (r1 == 0) goto L_0x001d
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()
            if (r1 == 0) goto L_0x001d
            boolean r0 = r1.isAvailable()
            if (r0 == 0) goto L_0x001d
            java.lang.String r1 = r1.getTypeName()
            goto L_0x001f
        L_0x001d:
            java.lang.String r1 = ""
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.android.SystemUtils.getNetType(android.content.Context):java.lang.String");
    }

    public static String getPhoneModel() {
        return getSystemProperties(TPSystemInfo.KEY_PROPERTY_MODEL, "unknown");
    }

    public static String getSystemProperties(String str, String str2) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return (String) cls2.getDeclaredMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, str2});
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            HMSLog.e("SystemUtils", "An exception occurred while reading: getSystemProperties:" + str);
            return str2;
        }
    }

    @Deprecated
    public static boolean isChinaROM() {
        String b11 = b();
        if (!TextUtils.isEmpty(b11)) {
            return "cn".equalsIgnoreCase(b11);
        }
        String a11 = a();
        if (!TextUtils.isEmpty(a11)) {
            return a11.toLowerCase(Locale.US).contains("cn");
        }
        String localCountry = getLocalCountry();
        if (!TextUtils.isEmpty(localCountry)) {
            return "cn".equalsIgnoreCase(localCountry);
        }
        return false;
    }

    public static boolean isEMUI() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("is Emui :");
        int i11 = HwBuildEx.VERSION.EMUI_SDK_INT;
        sb2.append(i11);
        HMSLog.i("SystemUtils", sb2.toString());
        return i11 > 0;
    }

    public static boolean isHuawei() {
        String systemProperties = getSystemProperties(PRODUCT_BRAND, "unknown");
        return "HUAWEI".equalsIgnoreCase(systemProperties) || PRODUCT_HONOR.equalsIgnoreCase(systemProperties);
    }

    public static boolean isSystemApp(Context context, String str) {
        if (context == null) {
            HMSLog.w("SystemUtils", "isSystemApp context is null");
            return false;
        }
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (AndroidException e11) {
            HMSLog.e("SystemUtils", "isSystemApp Exception: " + e11);
        } catch (RuntimeException e12) {
            HMSLog.e("SystemUtils", "isSystemApp RuntimeException:" + e12);
        }
        if (packageInfo == null || (packageInfo.applicationInfo.flags & 1) <= 0) {
            return false;
        }
        return true;
    }

    public static boolean isTVDevice() {
        return getSystemProperties("ro.build.characteristics", "default").equalsIgnoreCase("tv");
    }
}
