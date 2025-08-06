package com.huobi.vulcan.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.content.ContextCompat;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.NetworkInterface;
import java.util.Locale;
import ku.a;
import ou.b;

public class SystemUtils {

    /* renamed from: a  reason: collision with root package name */
    public static String f20617a;

    public static int A(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if ("armeabi".equals(str)) {
            return 1;
        }
        if ("armeabi-v7a".equals(str)) {
            return 2;
        }
        if ("arm64-v8a".equals(str)) {
            return 16;
        }
        if ("x86".equals(str)) {
            return 4;
        }
        if ("x86_64".equals(str)) {
            return 32;
        }
        if ("mips".equals(str)) {
            return 8;
        }
        if ("mips64".equals(str)) {
            return 64;
        }
        return 0;
    }

    @TargetApi(21)
    public static int a() {
        if (b.a()) {
            String[] strArr = Build.SUPPORTED_ABIS;
            int i11 = 0;
            if (strArr != null) {
                int length = strArr.length;
                int i12 = 0;
                while (i11 < length) {
                    i12 |= A(strArr[i11]);
                    i11++;
                }
                i11 = i12;
            }
            if (i11 > 0) {
                return i11;
            }
        }
        return A(t("ro.product.cpu.abi")) | A(t("ro.product.cpu.abi2"));
    }

    public static String b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return Settings.System.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th2) {
            LogUtils.b(th2);
            return null;
        }
    }

    public static float c(Context context) {
        Intent intent;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if (Build.VERSION.SDK_INT >= 26) {
            intent = context.registerReceiver((BroadcastReceiver) null, intentFilter, 2);
        } else {
            intent = context.registerReceiver((BroadcastReceiver) null, intentFilter);
        }
        return ((float) intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) intent.getIntExtra("scale", -1));
    }

    public static boolean d(Context context) {
        Intent intent;
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if (Build.VERSION.SDK_INT >= 26) {
            intent = context.registerReceiver((BroadcastReceiver) null, intentFilter, 2);
        } else {
            intent = context.registerReceiver((BroadcastReceiver) null, intentFilter);
        }
        int intExtra = intent.getIntExtra("status", -1);
        return intExtra == 2 || intExtra == 5;
    }

    public static String e(Context context) {
        return StringUtils.a(x(context));
    }

    public static String f() {
        return StringUtils.a(Build.VERSION.RELEASE);
    }

    public static double g(Context context) {
        return (double) context.getResources().getDisplayMetrics().density;
    }

    public static String h(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
    }

    public static long i(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static String j(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
                return ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getDeviceId();
            }
            return null;
        } catch (Throwable th2) {
            LogUtils.b(th2);
            return null;
        }
    }

    public static String k(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
                return ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getSubscriberId();
            }
            return null;
        } catch (Exception e11) {
            LogUtils.b(e11);
            return null;
        }
    }

    public static String l(Context context) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 23) {
            return m(context);
        }
        if (i11 < 23 || i11 >= 24) {
            return i11 >= 24 ? o() : "02:00:00:00:00:00";
        }
        return n();
    }

    public static String m(Context context) {
        WifiManager wifiManager;
        WifiInfo wifiInfo;
        if (context == null || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) {
            return "02:00:00:00:00:00";
        }
        try {
            wifiInfo = wifiManager.getConnectionInfo();
        } catch (Exception unused) {
            wifiInfo = null;
        }
        if (wifiInfo == null) {
            return null;
        }
        String macAddress = wifiInfo.getMacAddress();
        return !TextUtils.isEmpty(macAddress) ? macAddress.toUpperCase(Locale.ENGLISH) : macAddress;
    }

    public static String n() {
        try {
            return new BufferedReader(new FileReader(new File("/sys/class/net/wlan0/address"))).readLine();
        } catch (IOException e11) {
            e11.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String o() {
        try {
            NetworkInterface byName = NetworkInterface.getByName(u("wifi.interface", "wlan0"));
            if (byName == null) {
                return "02:00:00:00:00:00";
            }
            byte[] hardwareAddress = byName.getHardwareAddress();
            if (hardwareAddress == null) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            int length = hardwareAddress.length;
            for (int i11 = 0; i11 < length; i11++) {
                sb2.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i11])}));
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            return sb2.toString();
        } catch (Exception e11) {
            e11.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String p() {
        try {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 28) {
                if (ContextCompat.checkSelfPermission(a.b(), "android.permission.READ_PHONE_STATE") == 0) {
                    return Build.getSerial();
                }
                return "";
            } else if (i11 >= 26) {
                return Build.SERIAL;
            } else {
                String t11 = t("ro.serialno");
                if (StringUtils.d(t11)) {
                    return t("ro.boot.serialno");
                }
                return t11;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            LogUtils.a("读取设备序列号异常：" + e11.toString());
            return "";
        }
    }

    public static String q(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
                return ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getSimCountryIso();
            }
            return null;
        } catch (Exception e11) {
            LogUtils.b(e11);
            return null;
        }
    }

    public static String r(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
                return ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getSimOperator();
            }
            return null;
        } catch (Exception e11) {
            LogUtils.b(e11);
            return null;
        }
    }

    public static String s(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
                return ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getSimSerialNumber();
            }
            return null;
        } catch (Exception e11) {
            LogUtils.b(e11);
            return null;
        }
    }

    public static final String t(String str) {
        return u(str, (String) null);
    }

    public static final String u(String str, String str2) {
        try {
            return Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{str}).toString();
        } catch (ClassNotFoundException e11) {
            LogUtils.b(e11);
            return str2;
        } catch (SecurityException e12) {
            LogUtils.b(e12);
            return str2;
        } catch (Throwable th2) {
            LogUtils.b(th2);
            return str2;
        }
    }

    public static long v(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        if (Build.VERSION.SDK_INT >= 16) {
            return memoryInfo.totalMem;
        }
        return 0;
    }

    public static String w(Context context) {
        return String.valueOf(context.getApplicationInfo().uid);
    }

    public static String x(Context context) {
        if (context == null) {
            return f20617a;
        }
        if (!TextUtils.isEmpty(f20617a)) {
            return f20617a;
        }
        try {
            f20617a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
        }
        return f20617a;
    }

    public static double y(Context context) {
        return (double) context.getResources().getDisplayMetrics().xdpi;
    }

    public static double z(Context context) {
        return (double) context.getResources().getDisplayMetrics().ydpi;
    }
}
