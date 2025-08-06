package com.hbg.lib.core.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import com.facebook.places.model.PlaceFields;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.network.NetworkStatus;
import com.hbg.lib.common.utils.RootUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.permissions.EasyPermissions;
import com.iproov.sdk.bridge.OptionsBridge;
import i6.d;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

public class PhoneUtils {

    /* renamed from: a  reason: collision with root package name */
    public static String f68675a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f68676b = "";

    /* renamed from: c  reason: collision with root package name */
    public static String f68677c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f68678d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f68679e;

    /* renamed from: f  reason: collision with root package name */
    public static String f68680f;

    /* renamed from: g  reason: collision with root package name */
    public static String f68681g;

    /* renamed from: h  reason: collision with root package name */
    public static String f68682h;

    /* renamed from: i  reason: collision with root package name */
    public static List<WeakReference<b>> f68683i = new ArrayList();

    public class a extends PhoneStateListener {
        public void onCallStateChanged(int i11, String str) {
            Iterator it2 = PhoneUtils.f68683i.iterator();
            while (it2.hasNext()) {
                WeakReference weakReference = (WeakReference) it2.next();
                if (weakReference == null || weakReference.get() == null) {
                    it2.remove();
                } else {
                    ((b) weakReference.get()).a(i11);
                }
            }
            super.onCallStateChanged(i11, str);
        }
    }

    public interface b {
        void a(int i11);
    }

    public static void b(b bVar) {
        f68683i.add(new WeakReference(bVar));
    }

    public static void c(Context context) {
        if (Build.VERSION.SDK_INT >= 22) {
            CookieManager.getInstance().removeAllCookies((ValueCallback) null);
            return;
        }
        CookieSyncManager createInstance = CookieSyncManager.createInstance(context);
        createInstance.startSync();
        CookieManager instance = CookieManager.getInstance();
        instance.removeAllCookie();
        instance.removeSessionCookie();
        createInstance.stopSync();
        createInstance.sync();
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String e() {
        try {
            f68675a = m0.a();
        } catch (Exception e11) {
            d.g(e11);
            f68675a = "";
        }
        return f68675a;
    }

    public static String f() {
        String str = Build.MODEL;
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e11) {
            e11.printStackTrace();
            return str;
        }
    }

    public static String g() {
        if (TextUtils.isEmpty(f68678d)) {
            f68678d = Build.VERSION.RELEASE;
        }
        return f68678d;
    }

    public static String h() {
        if (TextUtils.isEmpty(f68677c)) {
            TelephonyManager telephonyManager = (TelephonyManager) BaseApplication.b().getSystemService(PlaceFields.PHONE);
            if (EasyPermissions.hasPermissions(BaseApplication.b(), "android.permission.READ_PHONE_STATE")) {
                f68677c = telephonyManager.getSubscriberId();
            }
        }
        return f68677c;
    }

    public static String i() {
        if (TextUtils.isEmpty(f68676b)) {
            WifiInfo connectionInfo = ((WifiManager) BaseApplication.b().getApplicationContext().getSystemService("wifi")).getConnectionInfo();
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    for (T t11 : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                        if (t11.getName().equalsIgnoreCase("wlan0")) {
                            byte[] hardwareAddress = t11.getHardwareAddress();
                            if (hardwareAddress == null) {
                                return f68676b;
                            }
                            StringBuilder sb2 = new StringBuilder();
                            int length = hardwareAddress.length;
                            for (int i11 = 0; i11 < length; i11++) {
                                sb2.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i11])}));
                            }
                            if (sb2.length() > 0) {
                                sb2.deleteCharAt(sb2.length() - 1);
                            }
                            f68676b = sb2.toString();
                        }
                    }
                } catch (Exception unused) {
                }
            } else if (connectionInfo != null) {
                f68676b = connectionInfo.getMacAddress();
            }
        }
        return f68676b;
    }

    public static String j(Context context) {
        String str;
        if (!TextUtils.isEmpty(f68676b)) {
            return f68676b;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 23) {
            str = k(context);
        } else if (i11 < 23 || i11 >= 24) {
            str = i11 >= 24 ? m() : "02:00:00:00:00:00";
        } else {
            str = l();
        }
        f68676b = str;
        return str;
    }

    public static String k(Context context) {
        WifiInfo wifiInfo;
        if (context == null) {
            return "02:00:00:00:00:00";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                return "02:00:00:00:00:00";
            }
            try {
                wifiInfo = wifiManager.getConnectionInfo();
            } catch (Exception e11) {
                e11.printStackTrace();
                wifiInfo = null;
            }
            if (wifiInfo == null) {
                return null;
            }
            String macAddress = wifiInfo.getMacAddress();
            if (!TextUtils.isEmpty(macAddress)) {
                return macAddress.toUpperCase(Locale.ENGLISH);
            }
            return macAddress;
        } catch (Exception e12) {
            e12.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String l() {
        try {
            return new BufferedReader(new FileReader(new File("/sys/class/net/wlan0/address"))).readLine();
        } catch (IOException e11) {
            e11.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String m() {
        try {
            for (T t11 : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (t11.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = t11.getHardwareAddress();
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
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception e11) {
            e11.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String n(Context context) {
        if (!TextUtils.isEmpty(f68682h)) {
            return f68682h;
        }
        String a11 = NetworkStatus.a(context);
        f68682h = a11;
        return a11;
    }

    public static String o() {
        String h11 = h();
        if (h11 != null) {
            if (h11.startsWith("46000") || h11.startsWith("46002") || h11.startsWith("46007")) {
                return "CMCC";
            }
            if (h11.startsWith("46001") || h11.startsWith("46006")) {
                return "CUCC";
            }
            if (h11.startsWith("46003")) {
                return "CTCC";
            }
        }
        return "none";
    }

    public static String p() {
        return StringUtils.b(Build.VERSION.RELEASE);
    }

    public static String q(Context context) {
        try {
            if (Build.VERSION.SDK_INT < 15) {
                String host = Proxy.getHost(context);
                if (host != null) {
                    if (!host.equals("")) {
                        return host + ":" + Proxy.getPort(context);
                    }
                }
                return host;
            }
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (TextUtils.isEmpty(property) || TextUtils.isEmpty(property2)) {
                return null;
            }
            return property + ":" + property2;
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public static String r() {
        String str = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10);
        try {
            String obj = Build.class.getField("SERIAL").get((Object) null).toString();
            if (obj.equalsIgnoreCase(OptionsBridge.NULL_VALUE) || obj.equalsIgnoreCase("unknown") || TextUtils.isEmpty(obj.trim())) {
                obj = m0.a();
            }
            return new UUID((long) str.hashCode(), (long) obj.hashCode()).toString();
        } catch (Exception unused) {
            return new UUID((long) str.hashCode(), (long) m0.a().hashCode()).toString();
        }
    }

    @Deprecated
    public static String s(boolean z11) {
        if (!z11) {
            return r();
        }
        if (TextUtils.isEmpty(f68679e)) {
            f68679e = r();
        }
        return f68679e;
    }

    public static String t() {
        String str = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
        try {
            return new UUID((long) str.hashCode(), (long) Build.class.getField("SERIAL").get((Object) null).toString().hashCode()).toString();
        } catch (Exception unused) {
            return new UUID((long) str.hashCode(), (long) -905839116).toString();
        }
    }

    public static String[] u(Context context) {
        String str;
        String str2;
        String str3 = "";
        String[] strArr = new String[2];
        if (TextUtils.isEmpty(f68680f) || TextUtils.isEmpty(f68681g)) {
            try {
                int i11 = Build.VERSION.SDK_INT;
                if (i11 <= 26) {
                    WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                    if (i11 < 19) {
                        str2 = connectionInfo.getSSID();
                        try {
                            str = connectionInfo.getBSSID();
                        } catch (Exception e11) {
                            e = e11;
                            e.printStackTrace();
                            str = str3;
                            str3 = str2;
                            f68680f = str3;
                            f68681g = str;
                            strArr[0] = str3;
                            strArr[1] = str;
                            return strArr;
                        }
                        str3 = str2;
                        f68680f = str3;
                        f68681g = str;
                        strArr[0] = str3;
                        strArr[1] = str;
                        return strArr;
                    }
                    str2 = connectionInfo.getSSID().replace("\"", str3);
                    str = connectionInfo.getBSSID().replace("\"", str3);
                    str3 = str2;
                    f68680f = str3;
                    f68681g = str;
                    strArr[0] = str3;
                    strArr[1] = str;
                    return strArr;
                }
                if (i11 == 27) {
                    NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                    if (activeNetworkInfo.isConnected()) {
                        str2 = activeNetworkInfo.getExtraInfo() != null ? activeNetworkInfo.getExtraInfo().replace("\"", str3) : str3;
                        str3 = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getBSSID().replace("\"", str3);
                        str = str3;
                        str3 = str2;
                        f68680f = str3;
                        f68681g = str;
                        strArr[0] = str3;
                        strArr[1] = str;
                        return strArr;
                    }
                } else if (w() && ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).isConnected()) {
                    WifiInfo connectionInfo2 = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                    str2 = connectionInfo2.getSSID().replace("\"", str3);
                    str = connectionInfo2.getBSSID().replace("\"", str3);
                    str3 = str2;
                    f68680f = str3;
                    f68681g = str;
                    strArr[0] = str3;
                    strArr[1] = str;
                    return strArr;
                }
                str = str3;
                f68680f = str3;
                f68681g = str;
                strArr[0] = str3;
                strArr[1] = str;
                return strArr;
            } catch (Exception e12) {
                e = e12;
                str2 = str3;
                e.printStackTrace();
                str = str3;
                str3 = str2;
                f68680f = str3;
                f68681g = str;
                strArr[0] = str3;
                strArr[1] = str;
                return strArr;
            }
        } else {
            strArr[0] = f68680f;
            strArr[1] = f68681g;
            return strArr;
        }
    }

    public static void v() {
        TelephonyManager telephonyManager = (TelephonyManager) BaseApplication.b().getSystemService(PlaceFields.PHONE);
        if (telephonyManager != null) {
            try {
                telephonyManager.listen(new a(), 32);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public static boolean w() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean x() {
        return RootUtils.a() || RootUtils.b() || RootUtils.c();
    }
}
