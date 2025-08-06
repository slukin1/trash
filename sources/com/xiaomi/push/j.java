package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.thumbplayer.tcmedia.core.common.TPSystemInfo;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static volatile int f52370a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static Map<String, n> f3252a = null;

    /* renamed from: b  reason: collision with root package name */
    private static int f52371b = -1;

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2908a() {
        return a() == 1;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m2913b() {
        return a() == 2;
    }

    /* renamed from: c  reason: collision with other method in class */
    public static boolean m2914c() {
        if (f52371b < 0) {
            f52371b = f() ^ true ? 1 : 0;
        }
        if (f52371b > 0) {
            return true;
        }
        return false;
    }

    /* renamed from: d  reason: collision with other method in class */
    public static boolean m2915d() {
        return !n.China.name().equalsIgnoreCase(a(b()).name());
    }

    /* renamed from: e  reason: collision with other method in class */
    public static boolean m2916e() {
        return a(1);
    }

    public static String f() {
        return a("ro.miui.ui.version.name");
    }

    public static String g() {
        return a("ro.build.characteristics");
    }

    public static String h() {
        return a(TPSystemInfo.KEY_PROPERTY_MANUFACTURER);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003c A[Catch:{ all -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d A[Catch:{ all -> 0x0041 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a() {
        /*
            int r0 = f52370a
            if (r0 != 0) goto L_0x005f
            r0 = 0
            java.lang.String r1 = "ro.miui.ui.version.code"
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ all -> 0x0041 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0041 }
            r2 = 1
            if (r1 == 0) goto L_0x0039
            java.lang.String r1 = "ro.miui.ui.version.name"
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ all -> 0x0041 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x0039
            java.lang.String r1 = "ro.mi.os.version.code"
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ all -> 0x0041 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x0039
            java.lang.String r1 = "ro.mi.os.version.name"
            java.lang.String r1 = a((java.lang.String) r1)     // Catch:{ all -> 0x0041 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0041 }
            if (r1 != 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r1 = r0
            goto L_0x003a
        L_0x0039:
            r1 = r2
        L_0x003a:
            if (r1 == 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r2 = 2
        L_0x003e:
            f52370a = r2     // Catch:{ all -> 0x0041 }
            goto L_0x0049
        L_0x0041:
            r1 = move-exception
            java.lang.String r2 = "get isMIUI failed"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r2, (java.lang.Throwable) r1)
            f52370a = r0
        L_0x0049:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "isMIUI's value is: "
            r0.append(r1)
            int r1 = f52370a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.xiaomi.channel.commonutils.logger.b.b(r0)
        L_0x005f:
            int r0 = f52370a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.j.a():int");
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m2911b() {
        String a11 = q.a("ro.miui.region", "");
        if (TextUtils.isEmpty(a11)) {
            a11 = q.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(a11)) {
            a11 = q.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(a11)) {
            a11 = q.a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(a11)) {
            a11 = q.a("ro.hw.country", "");
        }
        if (TextUtils.isEmpty(a11)) {
            a11 = q.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(a11)) {
            a11 = b(q.a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(a11)) {
            a11 = q.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(a11)) {
            a11 = q.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(a11)) {
            a11 = q.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(a11)) {
            a11 = q.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(a11)) {
            b.a("get region from system, region = " + a11);
        }
        if (!TextUtils.isEmpty(a11)) {
            return a11;
        }
        String country = Locale.getDefault().getCountry();
        b.a("locale.default.country = " + country);
        return country;
    }

    public static String d() {
        return a("ro.mi.os.version.incremental");
    }

    public static String e() {
        return e() ? d() : Build.VERSION.INCREMENTAL;
    }

    /* renamed from: f  reason: collision with other method in class */
    public static boolean m2917f() {
        String str;
        String str2 = "";
        try {
            str = q.a("ro.miui.ui.version.code", str2);
        } catch (Exception unused) {
            str = str2;
        }
        if (TextUtils.isEmpty(str)) {
            try {
                str2 = q.a("ro.mi.os.version.code", str2);
            } catch (Exception unused2) {
            }
        } else {
            str2 = str;
        }
        return !TextUtils.isEmpty(str2);
    }

    public static String c() {
        return a("ro.mi.os.version.name");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m2905a() {
        int a11 = s.a();
        if (!a() || a11 <= 0) {
            return "";
        }
        if (a11 < 2) {
            return "alpha";
        }
        return a11 < 3 ? "development" : "stable";
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m2906a(String str) {
        try {
            return (String) ax.a("android.os.SystemProperties", "get", str, "");
        } catch (Exception e11) {
            b.d("fail to get property. " + e11);
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2909a(Context context) {
        return context != null && a(context.getPackageName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2910a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static n a(String str) {
        n b11 = b(str);
        return b11 == null ? n.Global : b11;
    }

    /* renamed from: a  reason: collision with other method in class */
    private static void m2907a() {
        if (f3252a == null) {
            HashMap hashMap = new HashMap();
            f3252a = hashMap;
            hashMap.put("CN", n.China);
            Map<String, n> map = f3252a;
            n nVar = n.Europe;
            map.put("FI", nVar);
            f3252a.put("SE", nVar);
            f3252a.put("NO", nVar);
            f3252a.put("FO", nVar);
            f3252a.put("EE", nVar);
            f3252a.put("LV", nVar);
            f3252a.put("LT", nVar);
            f3252a.put("BY", nVar);
            f3252a.put("MD", nVar);
            f3252a.put("UA", nVar);
            f3252a.put("PL", nVar);
            f3252a.put("CZ", nVar);
            f3252a.put("SK", nVar);
            f3252a.put("HU", nVar);
            f3252a.put("DE", nVar);
            f3252a.put("AT", nVar);
            f3252a.put("CH", nVar);
            f3252a.put("LI", nVar);
            f3252a.put("GB", nVar);
            f3252a.put("IE", nVar);
            f3252a.put("NL", nVar);
            f3252a.put("BE", nVar);
            f3252a.put("LU", nVar);
            f3252a.put("FR", nVar);
            f3252a.put("RO", nVar);
            f3252a.put("BG", nVar);
            f3252a.put("RS", nVar);
            f3252a.put("MK", nVar);
            f3252a.put("AL", nVar);
            f3252a.put("GR", nVar);
            f3252a.put("SI", nVar);
            f3252a.put("HR", nVar);
            f3252a.put("IT", nVar);
            f3252a.put("SM", nVar);
            f3252a.put("MT", nVar);
            f3252a.put("ES", nVar);
            f3252a.put("PT", nVar);
            f3252a.put("AD", nVar);
            f3252a.put("CY", nVar);
            f3252a.put("DK", nVar);
            f3252a.put("IS", nVar);
            f3252a.put("UK", nVar);
            f3252a.put("EL", nVar);
            f3252a.put("RU", n.Russia);
            f3252a.put("IN", n.India);
        }
    }

    private static n b(String str) {
        a();
        return f3252a.get(str.toUpperCase());
    }

    public static int b() {
        String a11 = a("ro.mi.os.version.code");
        if (TextUtils.isEmpty(a11) || !TextUtils.isDigitsOnly(a11)) {
            return 0;
        }
        return Integer.parseInt(a11);
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b  reason: collision with other method in class */
    private static String m2912b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        return split.length > 0 ? split[0] : str;
    }

    public static int a(Context context) {
        String a11 = a("ro.miui.ui.version.code");
        if (TextUtils.isEmpty(a11) || !TextUtils.isDigitsOnly(a11)) {
            return 0;
        }
        return Integer.parseInt(a11);
    }

    public static boolean a(int i11) {
        String a11 = a("ro.mi.os.version.code");
        if (TextUtils.isEmpty(a11) || !TextUtils.isDigitsOnly(a11) || Integer.parseInt(a11) < i11) {
            return false;
        }
        return true;
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + " " + a(intent.getExtras());
    }

    public static String a(Bundle bundle) {
        StringBuilder sb2 = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb2.append(OptionsBridge.NULL_VALUE);
        } else {
            boolean z11 = true;
            for (String str : bundle.keySet()) {
                if (!z11) {
                    sb2.append(", ");
                }
                sb2.append(str);
                sb2.append('=');
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    sb2.append(Arrays.toString((int[]) obj));
                } else if (obj instanceof byte[]) {
                    sb2.append(Arrays.toString((byte[]) obj));
                } else if (obj instanceof boolean[]) {
                    sb2.append(Arrays.toString((boolean[]) obj));
                } else if (obj instanceof short[]) {
                    sb2.append(Arrays.toString((short[]) obj));
                } else if (obj instanceof long[]) {
                    sb2.append(Arrays.toString((long[]) obj));
                } else if (obj instanceof float[]) {
                    sb2.append(Arrays.toString((float[]) obj));
                } else if (obj instanceof double[]) {
                    sb2.append(Arrays.toString((double[]) obj));
                } else if (obj instanceof String[]) {
                    sb2.append(Arrays.toString((String[]) obj));
                } else if (obj instanceof CharSequence[]) {
                    sb2.append(Arrays.toString((CharSequence[]) obj));
                } else if (obj instanceof Parcelable[]) {
                    sb2.append(Arrays.toString((Parcelable[]) obj));
                } else if (obj instanceof Bundle) {
                    sb2.append(a((Bundle) obj));
                } else {
                    sb2.append(obj);
                }
                z11 = false;
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
