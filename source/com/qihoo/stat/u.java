package com.qihoo.stat;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.widget.Toast;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.places.model.PlaceFields;
import com.huochat.community.util.FileTool;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class u {

    /* renamed from: a  reason: collision with root package name */
    public static String f28844a = "QUtil";

    /* renamed from: b  reason: collision with root package name */
    public static final char[] f28845b = {'d', 'r', 'e', 'a', 'm', '3', '6', '0', '@', 'c', 'h', 'i', 'n', 'a'};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f28846c = {"READ_PHONE_STATE", "INTERNET", "ACCESS_NETWORK_STATE", "GET_TASKS", "WRITE_EXTERNAL_STORAGE"};

    /* renamed from: d  reason: collision with root package name */
    public static boolean f28847d = false;

    /* renamed from: e  reason: collision with root package name */
    public static ActivityManager f28848e = null;

    /* renamed from: f  reason: collision with root package name */
    public static ComponentName f28849f = null;

    /* renamed from: g  reason: collision with root package name */
    public static String f28850g = null;

    /* renamed from: h  reason: collision with root package name */
    public static List f28851h = null;

    /* renamed from: i  reason: collision with root package name */
    public static String f28852i = "";

    /* renamed from: j  reason: collision with root package name */
    public static String f28853j = "";

    /* renamed from: k  reason: collision with root package name */
    public static String f28854k = null;

    /* renamed from: l  reason: collision with root package name */
    public static String f28855l = null;

    /* renamed from: m  reason: collision with root package name */
    public static String f28856m = null;

    /* renamed from: n  reason: collision with root package name */
    public static String f28857n = null;

    public static String A() {
        return "189ED2CC2171C0DA";
    }

    public static String B(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(packageInfo.versionCode);
            return sb2.toString();
        } catch (Exception e11) {
            g0.b(f28844a, e11);
            return "";
        } catch (Error e12) {
            g0.a(f28844a, e12);
            return "";
        }
    }

    public static String C() {
        return "BF589327C17470D0";
    }

    public static boolean D(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || connectivityManager.getActiveNetworkInfo() == null) {
            return false;
        }
        return connectivityManager.getActiveNetworkInfo().isAvailable();
    }

    public static String E() {
        int nextInt = new Random().nextInt();
        if (nextInt <= 0 || nextInt > 1000) {
            nextInt = 1000;
        }
        long currentTimeMillis = System.currentTimeMillis() * ((long) nextInt);
        long nextLong = new Random().nextLong();
        if (nextLong < 0) {
            nextLong = -nextLong;
        }
        String str = "000000" + Long.toHexString(nextLong);
        if (str.length() > 7) {
            str = str.substring(str.length() - 7);
        }
        String str2 = String.valueOf(Long.toHexString(currentTimeMillis)) + str;
        if (str2.length() > 18) {
            str2 = str2.substring(str2.length() - 18);
        }
        return str2.toUpperCase();
    }

    public static String F(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            String lowerCase = activeNetworkInfo.getTypeName().toLowerCase();
            if (lowerCase.equals("wifi")) {
                return lowerCase;
            }
            return String.valueOf(activeNetworkInfo.getExtraInfo().toLowerCase()) + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getSubtypeName().toLowerCase();
        } catch (Exception e11) {
            g0.b(f28844a, e11);
            return "";
        } catch (Error e12) {
            g0.a(f28844a, e12);
            return "";
        }
    }

    public static String G() {
        int nextInt = new Random().nextInt();
        if (nextInt < 0) {
            nextInt = -nextInt;
        }
        String str = "0000000" + nextInt;
        if (str.length() > 8) {
            str = str.substring(str.length() - 8);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(System.currentTimeMillis());
        String sb3 = sb2.toString();
        return String.valueOf(R()) + (String.valueOf(sb3.substring(sb3.length() - 3)) + str);
    }

    public static String H(Context context) {
        try {
            String deviceId = ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getDeviceId();
            return deviceId == null ? "" : deviceId;
        } catch (Exception e11) {
            g0.b(f28844a, e11);
            return "";
        }
    }

    public static String I() {
        StringBuilder sb2;
        StringBuilder sb3;
        Date date = new Date();
        int month = date.getMonth() + 1;
        int date2 = date.getDate();
        String valueOf = String.valueOf("" + (date.getYear() + 1900));
        if (month < 10) {
            sb2.append("0");
        } else {
            sb2 = new StringBuilder(valueOf);
        }
        sb2.append(month);
        String valueOf2 = String.valueOf(sb2.toString());
        if (date2 < 10) {
            sb3.append("0");
        } else {
            sb3 = new StringBuilder(valueOf2);
        }
        sb3.append(date2);
        return sb3.toString();
    }

    public static String J(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(PlaceFields.PHONE)).getNetworkOperatorName();
        } catch (Exception e11) {
            g0.b(f28844a, e11);
            return "";
        }
    }

    public static String K() {
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        Date date = new Date();
        int month = date.getMonth() + 1;
        int date2 = date.getDate();
        int hours = date.getHours();
        if (month < 10) {
            sb2.append("0");
        } else {
            sb2 = new StringBuilder("");
        }
        sb2.append(month);
        String valueOf = String.valueOf(sb2.toString());
        if (date2 < 10) {
            sb3.append("0");
        } else {
            sb3 = new StringBuilder(valueOf);
        }
        sb3.append(date2);
        String valueOf2 = String.valueOf(sb3.toString());
        if (hours < 10) {
            sb4.append("0");
        } else {
            sb4 = new StringBuilder(valueOf2);
        }
        sb4.append(hours);
        return sb4.toString();
    }

    public static String L(Context context) {
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        return displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
    }

    public static long M() {
        return System.currentTimeMillis() / 1000;
    }

    public static n N(Context context) {
        int nextInt = new Random().nextInt();
        if (nextInt < 0) {
            nextInt = -nextInt;
        }
        String str = "000" + nextInt;
        if (str.length() > 4) {
            str = str.substring(str.length() - 4);
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = currentTimeMillis / 1000;
        String lowerCase = f(String.valueOf(e(context, "QHOPENSDK_APPKEY")) + currentTimeMillis + H(context) + str).toLowerCase();
        g0.c(f28844a, "Generate session: " + lowerCase + ", createTime: " + j11);
        return new n(lowerCase, j11);
    }

    public static String O(Context context) {
        String str = "";
        try {
            String P = P();
            try {
                if (!TextUtils.isEmpty(P)) {
                    return P;
                }
                str = c0.g(context, "randId", str);
                if (TextUtils.isEmpty(str)) {
                    str = E();
                    c0.c(context, "randId", str);
                }
                t(str);
                return str;
            } catch (Exception e11) {
                e = e11;
                str = P;
                g0.b(f28844a, e);
                return str;
            } catch (Error e12) {
                e = e12;
                str = P;
                g0.a(f28844a, e);
                return str;
            }
        } catch (Exception e13) {
            e = e13;
            g0.b(f28844a, e);
            return str;
        } catch (Error e14) {
            e = e14;
            g0.a(f28844a, e);
            return str;
        }
    }

    public static String P() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                String str = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + "/data/com/qihoo/stat/";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return k(String.valueOf(str) + "randId");
            }
        } catch (Exception e11) {
            g0.b(f28844a, e11);
        } catch (Error e12) {
            g0.a(f28844a, e12);
        }
        return "";
    }

    public static void Q(Context context) {
        try {
            long e11 = c0.e(context, "ttimes", 1) + 1;
            c0.b(context, "ttimes", e11);
            c0.c(context, "lastVersion", z(context));
            if ("mounted".equals(Environment.getExternalStorageState())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(e11);
                g(String.valueOf(Environment.getExternalStorageDirectory().getPath()) + "/data/com/" + "qihoo" + "/stat/" + O(context) + "_" + e(context, "QHOPENSDK_CHANNEL") + "_" + v(context), sb2.toString());
            }
        } catch (Exception e12) {
            g0.b(f28844a, e12);
        } catch (Error e13) {
            g0.a(f28844a, e13);
        }
    }

    public static String R() {
        StringBuilder sb2;
        StringBuilder sb3;
        StringBuilder sb4;
        StringBuilder sb5;
        StringBuilder sb6;
        Date date = new Date();
        int month = date.getMonth() + 1;
        int date2 = date.getDate();
        int hours = date.getHours();
        int minutes = date.getMinutes();
        int seconds = date.getSeconds();
        String valueOf = String.valueOf("" + (date.getYear() + 1900));
        if (month < 10) {
            sb2.append("0");
        } else {
            sb2 = new StringBuilder(valueOf);
        }
        sb2.append(month);
        String valueOf2 = String.valueOf(sb2.toString());
        if (date2 < 10) {
            sb3.append("0");
        } else {
            sb3 = new StringBuilder(valueOf2);
        }
        sb3.append(date2);
        String valueOf3 = String.valueOf(sb3.toString());
        if (hours < 10) {
            sb4.append("0");
        } else {
            sb4 = new StringBuilder(valueOf3);
        }
        sb4.append(hours);
        String valueOf4 = String.valueOf(sb4.toString());
        if (minutes < 10) {
            sb5.append("0");
        } else {
            sb5 = new StringBuilder(valueOf4);
        }
        sb5.append(minutes);
        String valueOf5 = String.valueOf(sb5.toString());
        if (seconds < 10) {
            sb6.append("0");
        } else {
            sb6 = new StringBuilder(valueOf5);
        }
        sb6.append(seconds);
        return sb6.toString();
    }

    public static String S(Context context) {
        File filesDir = context.getFilesDir();
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }
        return String.valueOf(filesDir.getPath()) + "/" + "qihoo" + "_game_stat_log.json";
    }

    public static String T() {
        if (f28855l == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                f28855l = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.serialno"});
            } catch (Exception e11) {
                g0.b(f28844a, e11);
                f28855l = "";
            }
        }
        return f28855l;
    }

    public static String U(Context context) {
        File filesDir = context.getFilesDir();
        if (!filesDir.exists()) {
            filesDir.mkdirs();
        }
        return String.valueOf(filesDir.getPath()) + "/" + "qihoo" + "_game_stat_ex.log";
    }

    public static int V(Context context) {
        try {
            if (f28848e == null) {
                f28848e = (ActivityManager) context.getSystemService("activity");
            }
            f28849f = f28848e.getRunningTasks(1).get(0).topActivity;
            if (f28850g == null) {
                f28850g = context.getPackageName();
            }
            return f28849f.getPackageName().equals(f28850g) ? 100 : -1;
        } catch (Exception e11) {
            g0.b(f28844a, e11);
        }
    }

    public static String W(Context context) {
        try {
            if (TextUtils.isEmpty(f28852i)) {
                String g11 = c0.g(context, "ctime", "");
                f28852i = g11;
                if (TextUtils.isEmpty(g11)) {
                    String R = R();
                    f28852i = R;
                    c0.c(context, "ctime", R);
                }
            }
        } catch (Exception e11) {
            g0.b(f28844a, e11);
        }
        return f28852i;
    }

    public static String X(Context context) {
        try {
            if (TextUtils.isEmpty(f28853j)) {
                String str = String.valueOf(context.getFilesDir().getPath()) + "/";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                f28853j = String.valueOf(str) + "qihoo_service_data.log";
                g0.c(f28844a, "serviceDataFile: " + f28853j);
            }
        } catch (Exception e11) {
            g0.b(f28844a, e11);
        }
        return f28853j;
    }

    public static String Y(Context context) {
        try {
            if (f28854k == null && context != null) {
                f28854k = f(H(context)).toLowerCase();
            }
        } catch (Exception e11) {
            g0.b(f28844a, e11);
        }
        return f28854k;
    }

    public static String Z(Context context) {
        try {
            if (f28857n == null) {
                f28857n = f(String.valueOf(H(context)) + T() + d(context.getContentResolver())).toLowerCase();
            }
        } catch (Exception e11) {
            g0.b(f28844a, e11);
        }
        return f28857n;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long a(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            java.lang.String r0 = "_"
            java.lang.String r1 = "ttimes"
            r2 = 1
            long r2 = com.qihoo.stat.c0.e(r6, r1, r2)
            java.lang.String r4 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            java.lang.String r5 = "mounted"
            boolean r4 = r5.equals(r4)     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            if (r4 == 0) goto L_0x0065
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            java.io.File r5 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            java.lang.String r5 = r5.getPath()     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            java.lang.String r5 = "/data/com/"
            r4.append(r5)     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            java.lang.String r5 = "qihoo"
            r4.append(r5)     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            java.lang.String r5 = "/stat/"
            r4.append(r5)     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            r4.append(r7)     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            r4.append(r0)     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            r4.append(r8)     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            r4.append(r0)     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            r4.append(r9)     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            java.lang.String r7 = r4.toString()     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            java.lang.String r7 = k(r7)     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            if (r8 != 0) goto L_0x0065
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x005f, Error -> 0x0058 }
            goto L_0x0066
        L_0x0058:
            r7 = move-exception
            java.lang.String r8 = f28844a
            com.qihoo.stat.g0.a(r8, r7)
            goto L_0x0065
        L_0x005f:
            r7 = move-exception
            java.lang.String r8 = f28844a
            com.qihoo.stat.g0.b(r8, r7)
        L_0x0065:
            r7 = 1
        L_0x0066:
            long r7 = (long) r7
            int r9 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r9 <= 0) goto L_0x006f
            com.qihoo.stat.c0.b(r6, r1, r7)
            r2 = r7
        L_0x006f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo.stat.u.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):long");
    }

    public static Pair b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 1);
            long uidTxBytes = TrafficStats.getUidTxBytes(applicationInfo.uid);
            long uidRxBytes = TrafficStats.getUidRxBytes(applicationInfo.uid);
            if (!(0 == uidTxBytes && 0 == uidRxBytes)) {
                return new Pair(Long.valueOf(uidTxBytes), Long.valueOf(uidRxBytes));
            }
        } catch (Exception e11) {
            g0.b(f28844a, e11);
        }
        return null;
    }

    public static String c() {
        return Locale.getDefault().getLanguage();
    }

    public static String d(ContentResolver contentResolver) {
        if (f28856m == null) {
            f28856m = Settings.System.getString(contentResolver, "android_id");
        }
        return f28856m;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String e(android.content.Context r3, java.lang.String r4) {
        /*
            android.content.pm.PackageManager r0 = r3.getPackageManager()     // Catch:{ Exception -> 0x002e }
            java.lang.String r1 = r3.getPackageName()     // Catch:{ Exception -> 0x002e }
            r2 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo(r1, r2)     // Catch:{ Exception -> 0x002e }
            if (r0 == 0) goto L_0x0034
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0027 }
            r1.<init>()     // Catch:{ Exception -> 0x0027 }
            android.os.Bundle r0 = r0.metaData     // Catch:{ Exception -> 0x0027 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0027 }
            r1.append(r0)     // Catch:{ Exception -> 0x0027 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0027 }
            goto L_0x0036
        L_0x0027:
            r0 = move-exception
            java.lang.String r1 = f28844a     // Catch:{ Exception -> 0x002e }
            com.qihoo.stat.g0.b(r1, r0)     // Catch:{ Exception -> 0x002e }
            goto L_0x0034
        L_0x002e:
            r0 = move-exception
            java.lang.String r1 = f28844a
            com.qihoo.stat.g0.b(r1, r0)
        L_0x0034:
            java.lang.String r0 = ""
        L_0x0036:
            java.lang.String r1 = "QHOPENSDK_CHANNEL"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0042
            java.lang.String r0 = com.qihoo.stat.c0.f(r3, r0)
        L_0x0042:
            java.lang.String r3 = f28844a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "meta "
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r4 = ": "
            r1.append(r4)
            r1.append(r0)
            java.lang.String r4 = r1.toString()
            com.qihoo.stat.g0.c(r3, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo.stat.u.e(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String f(String str) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] bytes = str.getBytes();
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.update(bytes);
            char[] cArr2 = new char[(r1 * 2)];
            int i11 = 0;
            for (byte b11 : instance.digest()) {
                int i12 = i11 + 1;
                cArr2[i11] = cArr[(b11 >>> 4) & 15];
                i11 = i12 + 1;
                cArr2[i12] = cArr[b11 & 15];
            }
            return new String(cArr2);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0039 A[SYNTHETIC, Splitter:B:23:0x0039] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(java.lang.String r2, java.lang.String r3) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0024 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0024 }
            java.lang.String r2 = "UTF-8"
            byte[] r2 = r3.getBytes(r2)     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            r3 = 0
            int r0 = r2.length     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            r1.write(r2, r3, r0)     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            r1.close()     // Catch:{ Exception -> 0x001f, all -> 0x001c }
            goto L_0x0036
        L_0x001c:
            r2 = move-exception
            r0 = r1
            goto L_0x0037
        L_0x001f:
            r2 = move-exception
            r0 = r1
            goto L_0x0025
        L_0x0022:
            r2 = move-exception
            goto L_0x0037
        L_0x0024:
            r2 = move-exception
        L_0x0025:
            java.lang.String r3 = f28844a     // Catch:{ all -> 0x0022 }
            com.qihoo.stat.g0.b(r3, r2)     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0036
            r0.close()     // Catch:{ Exception -> 0x0030 }
            goto L_0x0036
        L_0x0030:
            r2 = move-exception
            java.lang.String r3 = f28844a
            com.qihoo.stat.g0.b(r3, r2)
        L_0x0036:
            return
        L_0x0037:
            if (r0 == 0) goto L_0x0043
            r0.close()     // Catch:{ Exception -> 0x003d }
            goto L_0x0043
        L_0x003d:
            r3 = move-exception
            java.lang.String r0 = f28844a
            com.qihoo.stat.g0.b(r0, r3)
        L_0x0043:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo.stat.u.g(java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0061 A[Catch:{ Exception -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0066 A[Catch:{ Exception -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x007d A[Catch:{ Exception -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0082 A[Catch:{ Exception -> 0x0086 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009a A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x009f A[Catch:{ Exception -> 0x00a3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:33:0x0050=Splitter:B:33:0x0050, B:43:0x006c=Splitter:B:43:0x006c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void h(org.json.JSONArray r5) {
        /*
            r0 = 0
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x006a, Error -> 0x004e, all -> 0x004b }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x006a, Error -> 0x004e, all -> 0x004b }
            java.lang.String r3 = f28853j     // Catch:{ Exception -> 0x006a, Error -> 0x004e, all -> 0x004b }
            r2.<init>(r3)     // Catch:{ Exception -> 0x006a, Error -> 0x004e, all -> 0x004b }
            java.lang.String r3 = "UTF-8"
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x006a, Error -> 0x004e, all -> 0x004b }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0047, Error -> 0x0043, all -> 0x003f }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0047, Error -> 0x0043, all -> 0x003f }
        L_0x0014:
            java.lang.String r3 = r2.readLine()     // Catch:{ Exception -> 0x003d, Error -> 0x003b, all -> 0x0039 }
            if (r3 != 0) goto L_0x0030
            r1.close()     // Catch:{ Exception -> 0x003d, Error -> 0x003b, all -> 0x0039 }
            r2.close()     // Catch:{ Exception -> 0x002e, Error -> 0x002c }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0086 }
            java.lang.String r0 = f28853j     // Catch:{ Exception -> 0x0086 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x0086 }
            r5.delete()     // Catch:{ Exception -> 0x0086 }
            goto L_0x008c
        L_0x002c:
            r5 = move-exception
            goto L_0x0050
        L_0x002e:
            r5 = move-exception
            goto L_0x006c
        L_0x0030:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x003d, Error -> 0x003b, all -> 0x0039 }
            r4.<init>(r3)     // Catch:{ Exception -> 0x003d, Error -> 0x003b, all -> 0x0039 }
            r5.put(r4)     // Catch:{ Exception -> 0x003d, Error -> 0x003b, all -> 0x0039 }
            goto L_0x0014
        L_0x0039:
            r5 = move-exception
            goto L_0x0041
        L_0x003b:
            r5 = move-exception
            goto L_0x0045
        L_0x003d:
            r5 = move-exception
            goto L_0x0049
        L_0x003f:
            r5 = move-exception
            r2 = r0
        L_0x0041:
            r0 = r1
            goto L_0x008e
        L_0x0043:
            r5 = move-exception
            r2 = r0
        L_0x0045:
            r0 = r1
            goto L_0x0050
        L_0x0047:
            r5 = move-exception
            r2 = r0
        L_0x0049:
            r0 = r1
            goto L_0x006c
        L_0x004b:
            r5 = move-exception
            r2 = r0
            goto L_0x008e
        L_0x004e:
            r5 = move-exception
            r2 = r0
        L_0x0050:
            java.lang.String r1 = f28844a     // Catch:{ all -> 0x008d }
            com.qihoo.stat.g0.a(r1, r5)     // Catch:{ all -> 0x008d }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0086 }
            java.lang.String r1 = f28853j     // Catch:{ Exception -> 0x0086 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x0086 }
            r5.delete()     // Catch:{ Exception -> 0x0086 }
            if (r0 == 0) goto L_0x0064
            r0.close()     // Catch:{ Exception -> 0x0086 }
        L_0x0064:
            if (r2 == 0) goto L_0x008c
            r2.close()     // Catch:{ Exception -> 0x0086 }
            goto L_0x008c
        L_0x006a:
            r5 = move-exception
            r2 = r0
        L_0x006c:
            java.lang.String r1 = f28844a     // Catch:{ all -> 0x008d }
            com.qihoo.stat.g0.b(r1, r5)     // Catch:{ all -> 0x008d }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0086 }
            java.lang.String r1 = f28853j     // Catch:{ Exception -> 0x0086 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x0086 }
            r5.delete()     // Catch:{ Exception -> 0x0086 }
            if (r0 == 0) goto L_0x0080
            r0.close()     // Catch:{ Exception -> 0x0086 }
        L_0x0080:
            if (r2 == 0) goto L_0x008c
            r2.close()     // Catch:{ Exception -> 0x0086 }
            goto L_0x008c
        L_0x0086:
            r5 = move-exception
            java.lang.String r0 = f28844a
            com.qihoo.stat.g0.b(r0, r5)
        L_0x008c:
            return
        L_0x008d:
            r5 = move-exception
        L_0x008e:
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x00a3 }
            java.lang.String r3 = f28853j     // Catch:{ Exception -> 0x00a3 }
            r1.<init>(r3)     // Catch:{ Exception -> 0x00a3 }
            r1.delete()     // Catch:{ Exception -> 0x00a3 }
            if (r0 == 0) goto L_0x009d
            r0.close()     // Catch:{ Exception -> 0x00a3 }
        L_0x009d:
            if (r2 == 0) goto L_0x00a9
            r2.close()     // Catch:{ Exception -> 0x00a3 }
            goto L_0x00a9
        L_0x00a3:
            r0 = move-exception
            java.lang.String r1 = f28844a
            com.qihoo.stat.g0.b(r1, r0)
        L_0x00a9:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo.stat.u.h(org.json.JSONArray):void");
    }

    public static String i() {
        return Locale.getDefault().getCountry();
    }

    public static String j(Context context) {
        try {
            String obj = context.toString();
            return obj.substring(obj.lastIndexOf(InstructionFileId.DOT) + 1, obj.indexOf(TIMMentionEditText.TIM_MENTION_TAG));
        } catch (Exception e11) {
            g0.b(f28844a, e11);
            return "";
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        r1 = r9;
        r9 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        r1 = r9;
        r9 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0056, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0057, code lost:
        com.qihoo.stat.g0.b(f28844a, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0064, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0065, code lost:
        com.qihoo.stat.g0.b(f28844a, r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f A[ExcHandler: all (r0v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:6:0x0014] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0052 A[SYNTHETIC, Splitter:B:27:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0060 A[SYNTHETIC, Splitter:B:33:0x0060] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String k(java.lang.String r9) {
        /*
            java.lang.String r0 = ""
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x004a }
            r2.<init>(r9)     // Catch:{ Exception -> 0x004a }
            boolean r9 = r2.exists()     // Catch:{ Exception -> 0x004a }
            if (r9 != 0) goto L_0x000f
            return r0
        L_0x000f:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Exception -> 0x004a }
            r9.<init>(r2)     // Catch:{ Exception -> 0x004a }
            long r3 = r2.length()     // Catch:{ Exception -> 0x0043, all -> 0x003f }
            int r3 = (int) r3     // Catch:{ Exception -> 0x0043, all -> 0x003f }
            byte[] r4 = new byte[r3]     // Catch:{ Exception -> 0x0043, all -> 0x003f }
            r9.read(r4)     // Catch:{ Exception -> 0x0043, all -> 0x003f }
            java.lang.String r5 = new java.lang.String     // Catch:{ Exception -> 0x0043, all -> 0x003f }
            r6 = 0
            java.lang.String r7 = "UTF-8"
            r5.<init>(r4, r6, r3, r7)     // Catch:{ Exception -> 0x0043, all -> 0x003f }
            r9.close()     // Catch:{ Exception -> 0x003a, all -> 0x003f }
            long r3 = r2.length()     // Catch:{ Exception -> 0x0038 }
            r6 = 20971520(0x1400000, double:1.03613076E-316)
            int r9 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r9 <= 0) goto L_0x005d
            r2.delete()     // Catch:{ Exception -> 0x0038 }
            goto L_0x005d
        L_0x0038:
            r9 = move-exception
            goto L_0x003d
        L_0x003a:
            r0 = move-exception
            r1 = r9
            r9 = r0
        L_0x003d:
            r0 = r5
            goto L_0x004b
        L_0x003f:
            r0 = move-exception
            r1 = r9
            r9 = r0
            goto L_0x005e
        L_0x0043:
            r1 = move-exception
            r8 = r1
            r1 = r9
            r9 = r8
            goto L_0x004b
        L_0x0048:
            r9 = move-exception
            goto L_0x005e
        L_0x004a:
            r9 = move-exception
        L_0x004b:
            java.lang.String r2 = f28844a     // Catch:{ all -> 0x0048 }
            com.qihoo.stat.g0.b(r2, r9)     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x005c
            r1.close()     // Catch:{ Exception -> 0x0056 }
            goto L_0x005c
        L_0x0056:
            r9 = move-exception
            java.lang.String r1 = f28844a
            com.qihoo.stat.g0.b(r1, r9)
        L_0x005c:
            r5 = r0
        L_0x005d:
            return r5
        L_0x005e:
            if (r1 == 0) goto L_0x006a
            r1.close()     // Catch:{ Exception -> 0x0064 }
            goto L_0x006a
        L_0x0064:
            r0 = move-exception
            java.lang.String r1 = f28844a
            com.qihoo.stat.g0.b(r1, r0)
        L_0x006a:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo.stat.u.k(java.lang.String):java.lang.String");
    }

    public static String l() {
        try {
            String str = Build.MODEL;
            return str == null ? "" : str;
        } catch (Exception e11) {
            g0.b(f28844a, e11);
            return "";
        }
    }

    public static String m(Context context) {
        try {
            return ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getShortClassName().replace(InstructionFileId.DOT, "");
        } catch (Exception e11) {
            g0.b(f28844a, e11);
            return "";
        }
    }

    public static String n(String str) {
        try {
            byte[] bytes = str.getBytes();
            for (int i11 = 0; i11 < bytes.length; i11++) {
                byte b11 = bytes[i11];
                char[] cArr = f28845b;
                bytes[i11] = (byte) (b11 ^ cArr[i11 % cArr.length]);
            }
            return Base64.encodeToString(bytes, 11);
        } catch (Exception e11) {
            g0.b(f28844a, e11);
            return "";
        }
    }

    public static String o() {
        try {
            String str = Build.BOARD;
            return str == null ? "" : str;
        } catch (Exception e11) {
            g0.b(f28844a, e11);
            return "";
        }
    }

    public static String p(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (Exception e11) {
            g0.b(f28844a, e11);
        } catch (Error e12) {
            g0.a(f28844a, e12);
        }
        return "";
    }

    public static String q(String str) {
        byte[] decode = Base64.decode(str, 11);
        for (int i11 = 0; i11 < decode.length; i11++) {
            byte b11 = decode[i11];
            char[] cArr = f28845b;
            decode[i11] = (byte) (b11 ^ cArr[i11 % cArr.length]);
        }
        return new String(decode);
    }

    public static String r() {
        try {
            String str = Build.BRAND;
            return str == null ? "" : str;
        } catch (Exception e11) {
            g0.b(f28844a, e11);
            return "";
        }
    }

    public static void s(Context context) {
        boolean z11;
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            int i11 = 0;
            while (true) {
                if (i11 >= f28846c.length) {
                    break;
                }
                if (strArr != null) {
                    for (String replace : strArr) {
                        if (replace.replace("android.permission.", "").equals(f28846c[i11])) {
                            z11 = true;
                            break;
                        }
                    }
                }
                z11 = false;
                if (!z11) {
                    Toast.makeText(context, "您的程序没有声明android.permission." + f28846c[i11] + "权限", 1).show();
                    break;
                }
                i11++;
            }
            if (strArr != null) {
                for (String replace2 : strArr) {
                    if (replace2.replace("android.permission.", "").equals("ACCESS_WIFI_STATE")) {
                        f28847d = true;
                        return;
                    }
                }
            }
        } catch (Exception e11) {
            g0.b(f28844a, e11);
        }
    }

    public static void t(String str) {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                String str2 = String.valueOf(Environment.getExternalStorageDirectory().getPath()) + "/data/com/qihoo/stat/" + "randId";
                if (TextUtils.isEmpty(k(str2))) {
                    g(str2, str);
                }
            }
        } catch (Exception e11) {
            g0.b(f28844a, e11);
        } catch (Error e12) {
            g0.a(f28844a, e12);
        }
    }

    public static String u() {
        try {
            String str = Build.MANUFACTURER;
            return str == null ? "" : str;
        } catch (Exception e11) {
            g0.b(f28844a, e11);
            return "";
        }
    }

    public static String v(Context context) {
        return context.getPackageName();
    }

    public static String w() {
        try {
            String str = Build.VERSION.RELEASE;
            return str == null ? "" : str;
        } catch (Exception e11) {
            g0.b(f28844a, e11);
            return "";
        }
    }

    public static String x(Context context) {
        try {
            if (f28847d) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    return connectionInfo.getMacAddress();
                }
            }
        } catch (Exception e11) {
            g0.b(f28844a, e11);
        } catch (Error e12) {
            g0.a(f28844a, e12);
        }
        return "";
    }

    public static String y() {
        String str = "";
        try {
            FileReader fileReader = new FileReader(l.f34626a);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            str = bufferedReader.readLine().split(":\\s+", 2)[1];
            bufferedReader.close();
            fileReader.close();
            return str;
        } catch (Exception e11) {
            g0.b(f28844a, e11);
            return str;
        } catch (Error e12) {
            g0.a(f28844a, e12);
            return str;
        }
    }

    public static String z(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e11) {
            g0.b(f28844a, e11);
        } catch (Error e12) {
            g0.a(f28844a, e12);
        }
        return "";
    }
}
