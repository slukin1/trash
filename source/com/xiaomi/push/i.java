package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.places.model.PlaceFields;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class i {

    /* renamed from: a  reason: collision with root package name */
    private static String f52347a = null;

    /* renamed from: a  reason: collision with other field name */
    private static final Set<String> f3245a;

    /* renamed from: a  reason: collision with other field name */
    private static final String[] f3246a = {"--", "a-", "u-", "v-", "o-", "g-", "d-"};

    /* renamed from: b  reason: collision with root package name */
    private static String f52348b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f52349c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f52350d;

    /* renamed from: e  reason: collision with root package name */
    private static String f52351e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f52352f = String.valueOf(2);

    static {
        HashSet hashSet = new HashSet();
        f3245a = hashSet;
        hashSet.add("com.xiaomi.xmsf");
        hashSet.add("com.xiaomi.finddevice");
        hashSet.add("com.miui.securitycenter");
    }

    private static double a(double d11) {
        int i11 = 1;
        while (true) {
            double d12 = (double) i11;
            if (d12 >= d11) {
                return d12;
            }
            i11 <<= 1;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private static String m2878a(int i11) {
        if (i11 > 0) {
            String[] strArr = f3246a;
            if (i11 < strArr.length) {
                return strArr[i11];
            }
        }
        return f3246a[0];
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f A[SYNTHETIC, Splitter:B:24:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0055 A[SYNTHETIC, Splitter:B:30:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b() {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "/proc/meminfo"
            r0.<init>(r1)
            boolean r0 = r0.exists()
            r2 = 0
            if (r0 == 0) goto L_0x0058
            r0 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0053, all -> 0x0049 }
            r3.<init>(r1)     // Catch:{ Exception -> 0x0053, all -> 0x0049 }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0053, all -> 0x0049 }
            r4 = 8192(0x2000, float:1.14794E-41)
            r1.<init>(r3, r4)     // Catch:{ Exception -> 0x0053, all -> 0x0049 }
            java.lang.String r0 = r1.readLine()     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            if (r3 != 0) goto L_0x0041
            java.lang.String r3 = "\\s+"
            java.lang.String[] r0 = r0.split(r3)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            if (r0 == 0) goto L_0x0041
            int r3 = r0.length     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r4 = 2
            if (r3 < r4) goto L_0x0041
            r3 = 1
            r4 = r0[r3]     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            boolean r4 = android.text.TextUtils.isDigitsOnly(r4)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            if (r4 == 0) goto L_0x0041
            r0 = r0[r3]     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r2 = r0
        L_0x0041:
            r1.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x0058
        L_0x0045:
            r0 = move-exception
            goto L_0x004d
        L_0x0047:
            r0 = r1
            goto L_0x0053
        L_0x0049:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x004d:
            if (r1 == 0) goto L_0x0052
            r1.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            throw r0
        L_0x0053:
            if (r0 == 0) goto L_0x0058
            r0.close()     // Catch:{ IOException -> 0x0058 }
        L_0x0058:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.i.b():int");
    }

    @Deprecated
    public static String b(Context context) {
        return null;
    }

    public static String c() {
        return b() + "KB";
    }

    @Deprecated
    public static String c(Context context) {
        return null;
    }

    public static String d() {
        long a11 = a(Environment.getDataDirectory());
        return (a11 / 1024) + "KB";
    }

    @Deprecated
    public static String d(Context context) {
        return null;
    }

    @Deprecated
    public static String e(Context context) {
        return "";
    }

    public static String f(Context context) {
        return ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getSimOperatorName();
    }

    private static String g(Context context) {
        String string = context.getSharedPreferences(DeviceRequestsHelper.DEVICE_INFO_PARAM, 0).getString("default_id", (String) null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String h11 = h(context);
        a(context, h11);
        return h11;
    }

    private static String h(Context context) {
        String str = Build.BRAND;
        String a11 = k.a();
        int i11 = Build.VERSION.SDK_INT;
        String str2 = Build.VERSION.RELEASE;
        String e11 = j.e();
        int a12 = a();
        String packageName = context.getPackageName();
        long currentTimeMillis = System.currentTimeMillis();
        String a13 = bc.a(16);
        return az.a(str + "_" + a11 + "_" + i11 + "_" + str2 + "_" + e11 + "_" + a12 + "_" + packageName + "_" + currentTimeMillis + "_" + a13);
    }

    public static synchronized String a(Context context, boolean z11) {
        String str;
        int i11;
        synchronized (i.class) {
            if (f52350d == null) {
                String a11 = ao.a(context).a();
                if (TextUtils.isEmpty(a11) || a11.startsWith("00000000-0000-0000-0000-000000000000")) {
                    a11 = a(context);
                    if (!TextUtils.isEmpty(a11)) {
                        i11 = 5;
                    } else {
                        a11 = g(context);
                        i11 = 6;
                    }
                } else {
                    i11 = 4;
                }
                b.b("devid rule select:" + i11);
                if (i11 == 3) {
                    f52350d = a11;
                } else {
                    f52350d = a(i11) + bc.b(a11);
                }
            }
            str = f52350d;
        }
        return str;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static String m2882b() {
        double a11 = a(((((double) a(Environment.getDataDirectory())) / 1024.0d) / 1024.0d) / 1024.0d);
        return a11 + "GB";
    }

    public static String a(Context context) {
        if (!j.a(context)) {
            return null;
        }
        String str = f52348b;
        if (str != null) {
            return str;
        }
        try {
            f52348b = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable th2) {
            b.a("failure to get androidId: " + th2);
        }
        return f52348b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public static boolean m2883b(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager == null || powerManager.isScreenOn();
    }

    @TargetApi(17)
    public static int a() {
        Object a11 = ax.a("android.os.UserHandle", "myUserId", new Object[0]);
        if (a11 == null) {
            return -1;
        }
        return Integer.class.cast(a11).intValue();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m2877a() {
        return a(b()) + "GB";
    }

    private static float a(int i11) {
        float f11 = (((float) (((((i11 + com.sumsub.sns.internal.core.data.source.applicant.remote.utils.b.f33222a) / 524288) + 1) * 512) * 1024)) / 1024.0f) / 1024.0f;
        double d11 = (double) f11;
        return d11 > 0.5d ? (float) Math.ceil(d11) : f11;
    }

    private static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2880a(Context context) {
        Intent a11 = m.a(context, (BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), (String) null, (Handler) null);
        if (a11 == null) {
            return false;
        }
        int intExtra = a11.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            return true;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2879a() {
        return a() <= 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2881a(Context context, String str) {
        ApplicationInfo applicationInfo;
        PackageInfo packageInfo = (PackageInfo) ax.a((Object) context.getPackageManager(), "getPackageInfoAsUser", str, 0, 999);
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 8388608) != 8388608) {
            return true;
        }
        return false;
    }

    private static void a(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(DeviceRequestsHelper.DEVICE_INFO_PARAM, 0);
        if (TextUtils.isEmpty(sharedPreferences.getString("default_id", (String) null))) {
            sharedPreferences.edit().putString("default_id", str).apply();
        } else {
            b.a("default_id exist,do not change it.");
        }
    }
}
