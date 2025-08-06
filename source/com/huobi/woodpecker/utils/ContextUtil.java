package com.huobi.woodpecker.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.view.View;
import com.facebook.places.model.PlaceFields;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huobi.woodpecker.WoodPeckerSDK;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kv.e;

public class ContextUtil {

    /* renamed from: a  reason: collision with root package name */
    public static String f21161a = "";

    /* renamed from: b  reason: collision with root package name */
    public static String f21162b = "";

    public enum NetworkType {
        NETWORK_WIFI,
        NETWORK_5G,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO;

        public String toString() {
            int i11 = a.f21163a[ordinal()];
            if (i11 == 1) {
                return "WIFI";
            }
            if (i11 == 2) {
                return "5G";
            }
            if (i11 == 3) {
                return "4G";
            }
            if (i11 != 4) {
                return i11 != 5 ? GrsBaseInfo.CountryCodeSource.UNKNOWN : "2G";
            }
            return "3G";
        }
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21163a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.woodpecker.utils.ContextUtil$NetworkType[] r0 = com.huobi.woodpecker.utils.ContextUtil.NetworkType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21163a = r0
                com.huobi.woodpecker.utils.ContextUtil$NetworkType r1 = com.huobi.woodpecker.utils.ContextUtil.NetworkType.NETWORK_WIFI     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21163a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.woodpecker.utils.ContextUtil$NetworkType r1 = com.huobi.woodpecker.utils.ContextUtil.NetworkType.NETWORK_5G     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21163a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.woodpecker.utils.ContextUtil$NetworkType r1 = com.huobi.woodpecker.utils.ContextUtil.NetworkType.NETWORK_4G     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f21163a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.woodpecker.utils.ContextUtil$NetworkType r1 = com.huobi.woodpecker.utils.ContextUtil.NetworkType.NETWORK_3G     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f21163a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.woodpecker.utils.ContextUtil$NetworkType r1 = com.huobi.woodpecker.utils.ContextUtil.NetworkType.NETWORK_2G     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f21163a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.woodpecker.utils.ContextUtil$NetworkType r1 = com.huobi.woodpecker.utils.ContextUtil.NetworkType.NETWORK_UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.woodpecker.utils.ContextUtil.a.<clinit>():void");
        }
    }

    public static Activity a(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public static Application b() {
        if (WoodPeckerSDK.f().e() instanceof Application) {
            return (Application) WoodPeckerSDK.f().e();
        }
        return e();
    }

    public static String c() {
        if (StringUtils.b(f21161a) && g() != null) {
            f21161a = g().getApplicationContext().getPackageName();
        }
        return f21161a;
    }

    public static String d() {
        if (StringUtils.b(f21162b) && g() != null) {
            try {
                f21162b = g().getPackageManager().getPackageInfo(g().getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e11) {
                e11.printStackTrace();
            }
        }
        return f21162b;
    }

    public static Application e() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]);
            declaredMethod.setAccessible(true);
            return (Application) declaredMethod.invoke((Object) null, (Object[]) null);
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
            return null;
        } catch (ClassNotFoundException e12) {
            e12.printStackTrace();
            return null;
        } catch (IllegalAccessException e13) {
            e13.printStackTrace();
            return null;
        } catch (InvocationTargetException e14) {
            e14.printStackTrace();
            return null;
        }
    }

    public static String f() {
        return Build.BRAND;
    }

    public static Context g() {
        if (WoodPeckerSDK.f().e() != null) {
            return WoodPeckerSDK.f().e();
        }
        return e();
    }

    public static String h(View view) {
        String str = null;
        if (view == null) {
            return null;
        }
        if (view.getId() != -1) {
            str = view.getContext().getResources().getResourceEntryName(view.getId());
        }
        return StringUtils.b(str) ? h((View) view.getParent()) : str;
    }

    public static String i() {
        TelephonyManager telephonyManager;
        if (g() == null || (telephonyManager = (TelephonyManager) g().getSystemService(PlaceFields.PHONE)) == null) {
            return "";
        }
        return telephonyManager.getNetworkOperatorName();
    }

    public static String j() {
        return k().toString();
    }

    public static NetworkType k() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        NetworkType networkType = NetworkType.NETWORK_UNKNOWN;
        if (g() == null || (connectivityManager = (ConnectivityManager) g().getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return networkType;
        }
        if (activeNetworkInfo.getType() == 1) {
            return NetworkType.NETWORK_WIFI;
        }
        if (activeNetworkInfo.getType() != 0) {
            return networkType;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkType.NETWORK_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return NetworkType.NETWORK_3G;
            case 13:
            case 18:
            case 19:
                return NetworkType.NETWORK_4G;
            case 20:
                return NetworkType.NETWORK_5G;
            default:
                String subtypeName = activeNetworkInfo.getSubtypeName();
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? NetworkType.NETWORK_3G : networkType;
        }
    }

    public static String l() {
        return "1.5.6";
    }

    public static String m() {
        return Build.VERSION.RELEASE;
    }

    public static boolean n() {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) g().getSystemService("connectivity");
        if (!(connectivityManager == null || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null || allNetworkInfo.length <= 0)) {
            for (int i11 = 0; i11 < allNetworkInfo.length; i11++) {
                e.b(i11 + "===状态===" + allNetworkInfo[i11].getState());
                e.b(i11 + "===类型===" + allNetworkInfo[i11].getTypeName());
                if (allNetworkInfo[i11].getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }
}
