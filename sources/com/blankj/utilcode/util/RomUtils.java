package com.blankj.utilcode.util;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.engagelab.privates.push.constants.MTPushConstants;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public final class RomUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f63383a = {MTPushConstants.Manufacturer.HUAWEI};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f63384b = {"vivo"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f63385c = {"xiaomi"};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f63386d = {MTPushConstants.Manufacturer.OPPO};

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f63387e = {"leeco", "letv"};

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f63388f = {"360", "qiku"};

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f63389g = {"zte"};

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f63390h = {MTPushConstants.Manufacturer.ONEPLUS};

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f63391i = {"nubia"};

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f63392j = {"coolpad", "yulong"};

    /* renamed from: k  reason: collision with root package name */
    public static final String[] f63393k = {"lg", "lge"};

    /* renamed from: l  reason: collision with root package name */
    public static final String[] f63394l = {Constants.REFERRER_API_GOOGLE};

    /* renamed from: m  reason: collision with root package name */
    public static final String[] f63395m = {Constants.REFERRER_API_SAMSUNG};

    /* renamed from: n  reason: collision with root package name */
    public static final String[] f63396n = {MTPushConstants.Manufacturer.MEIZU};

    /* renamed from: o  reason: collision with root package name */
    public static final String[] f63397o = {"lenovo"};

    /* renamed from: p  reason: collision with root package name */
    public static final String[] f63398p = {"smartisan", "deltainno"};

    /* renamed from: q  reason: collision with root package name */
    public static final String[] f63399q = {"htc"};

    /* renamed from: r  reason: collision with root package name */
    public static final String[] f63400r = {"sony"};

    /* renamed from: s  reason: collision with root package name */
    public static final String[] f63401s = {"gionee", "amigo"};

    /* renamed from: t  reason: collision with root package name */
    public static final String[] f63402t = {"motorola"};

    /* renamed from: u  reason: collision with root package name */
    public static RomInfo f63403u = null;

    public static class RomInfo {

        /* renamed from: a  reason: collision with root package name */
        public String f63404a;

        /* renamed from: b  reason: collision with root package name */
        public String f63405b;

        public String toString() {
            return "RomInfo{name=" + this.f63404a + ", version=" + this.f63405b + "}";
        }
    }

    public static String a() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static String b() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static RomInfo c() {
        RomInfo romInfo = f63403u;
        if (romInfo != null) {
            return romInfo;
        }
        f63403u = new RomInfo();
        String a11 = a();
        String b11 = b();
        String[] strArr = f63383a;
        if (i(a11, b11, strArr)) {
            String unused = f63403u.f63404a = strArr[0];
            String d11 = d("ro.build.version.emui");
            String[] split = d11.split("_");
            if (split.length > 1) {
                String unused2 = f63403u.f63405b = split[1];
            } else {
                String unused3 = f63403u.f63405b = d11;
            }
            return f63403u;
        }
        String[] strArr2 = f63384b;
        if (i(a11, b11, strArr2)) {
            String unused4 = f63403u.f63404a = strArr2[0];
            String unused5 = f63403u.f63405b = d("ro.vivo.os.build.display.id");
            return f63403u;
        }
        String[] strArr3 = f63385c;
        if (i(a11, b11, strArr3)) {
            String unused6 = f63403u.f63404a = strArr3[0];
            String unused7 = f63403u.f63405b = d("ro.build.version.incremental");
            return f63403u;
        }
        String[] strArr4 = f63386d;
        if (i(a11, b11, strArr4)) {
            String unused8 = f63403u.f63404a = strArr4[0];
            String unused9 = f63403u.f63405b = d("ro.build.version.opporom");
            return f63403u;
        }
        String[] strArr5 = f63387e;
        if (i(a11, b11, strArr5)) {
            String unused10 = f63403u.f63404a = strArr5[0];
            String unused11 = f63403u.f63405b = d("ro.letv.release.version");
            return f63403u;
        }
        String[] strArr6 = f63388f;
        if (i(a11, b11, strArr6)) {
            String unused12 = f63403u.f63404a = strArr6[0];
            String unused13 = f63403u.f63405b = d("ro.build.uiversion");
            return f63403u;
        }
        String[] strArr7 = f63389g;
        if (i(a11, b11, strArr7)) {
            String unused14 = f63403u.f63404a = strArr7[0];
            String unused15 = f63403u.f63405b = d("ro.build.MiFavor_version");
            return f63403u;
        }
        String[] strArr8 = f63390h;
        if (i(a11, b11, strArr8)) {
            String unused16 = f63403u.f63404a = strArr8[0];
            String unused17 = f63403u.f63405b = d("ro.rom.version");
            return f63403u;
        }
        String[] strArr9 = f63391i;
        if (i(a11, b11, strArr9)) {
            String unused18 = f63403u.f63404a = strArr9[0];
            String unused19 = f63403u.f63405b = d("ro.build.rom.id");
            return f63403u;
        }
        String[] strArr10 = f63392j;
        if (i(a11, b11, strArr10)) {
            String unused20 = f63403u.f63404a = strArr10[0];
        } else {
            String[] strArr11 = f63393k;
            if (i(a11, b11, strArr11)) {
                String unused21 = f63403u.f63404a = strArr11[0];
            } else {
                String[] strArr12 = f63394l;
                if (i(a11, b11, strArr12)) {
                    String unused22 = f63403u.f63404a = strArr12[0];
                } else {
                    String[] strArr13 = f63395m;
                    if (i(a11, b11, strArr13)) {
                        String unused23 = f63403u.f63404a = strArr13[0];
                    } else {
                        String[] strArr14 = f63396n;
                        if (i(a11, b11, strArr14)) {
                            String unused24 = f63403u.f63404a = strArr14[0];
                        } else {
                            String[] strArr15 = f63397o;
                            if (i(a11, b11, strArr15)) {
                                String unused25 = f63403u.f63404a = strArr15[0];
                            } else {
                                String[] strArr16 = f63398p;
                                if (i(a11, b11, strArr16)) {
                                    String unused26 = f63403u.f63404a = strArr16[0];
                                } else {
                                    String[] strArr17 = f63399q;
                                    if (i(a11, b11, strArr17)) {
                                        String unused27 = f63403u.f63404a = strArr17[0];
                                    } else {
                                        String[] strArr18 = f63400r;
                                        if (i(a11, b11, strArr18)) {
                                            String unused28 = f63403u.f63404a = strArr18[0];
                                        } else {
                                            String[] strArr19 = f63401s;
                                            if (i(a11, b11, strArr19)) {
                                                String unused29 = f63403u.f63404a = strArr19[0];
                                            } else {
                                                String[] strArr20 = f63402t;
                                                if (i(a11, b11, strArr20)) {
                                                    String unused30 = f63403u.f63404a = strArr20[0];
                                                } else {
                                                    String unused31 = f63403u.f63404a = b11;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        String unused32 = f63403u.f63405b = d("");
        return f63403u;
    }

    public static String d(String str) {
        String e11 = !TextUtils.isEmpty(str) ? e(str) : "";
        if (TextUtils.isEmpty(e11) || e11.equals("unknown")) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    e11 = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(e11)) {
            return "unknown";
        }
        return e11;
    }

    public static String e(String str) {
        String g11 = g(str);
        if (!TextUtils.isEmpty(g11)) {
            return g11;
        }
        String h11 = h(str);
        return (TextUtils.isEmpty(h11) && Build.VERSION.SDK_INT < 28) ? f(str) : h11;
    }

    public static String f(String str) {
        Class<String> cls = String.class;
        try {
            Class<?> cls2 = Class.forName("android.os.SystemProperties");
            return (String) cls2.getMethod("get", new Class[]{cls, cls}).invoke(cls2, new Object[]{str, ""});
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040 A[SYNTHETIC, Splitter:B:18:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0046 A[SYNTHETIC, Splitter:B:24:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String g(java.lang.String r4) {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            r2.<init>()     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.lang.String r3 = "getprop "
            r2.append(r3)     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            r2.append(r4)     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.lang.String r4 = r2.toString()     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.lang.Process r4 = r1.exec(r4)     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            r2.<init>(r4)     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            r4 = 1024(0x400, float:1.435E-42)
            r1.<init>(r2, r4)     // Catch:{ IOException -> 0x0044, all -> 0x003d }
            java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x003b, all -> 0x0038 }
            if (r4 == 0) goto L_0x0034
            r1.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0033:
            return r4
        L_0x0034:
            r1.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x0049
        L_0x0038:
            r4 = move-exception
            r0 = r1
            goto L_0x003e
        L_0x003b:
            r0 = r1
            goto L_0x0044
        L_0x003d:
            r4 = move-exception
        L_0x003e:
            if (r0 == 0) goto L_0x0043
            r0.close()     // Catch:{ IOException -> 0x0043 }
        L_0x0043:
            throw r4
        L_0x0044:
            if (r0 == 0) goto L_0x0049
            r0.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0049:
            java.lang.String r4 = ""
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.RomUtils.g(java.lang.String):java.lang.String");
    }

    public static String h(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean i(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }
}
