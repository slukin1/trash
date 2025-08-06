package com.huobi.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.Properties;

public class DeviceHelper {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f83685a = {"m9", "M9", "mx", "MX"};

    /* renamed from: b  reason: collision with root package name */
    public static String f83686b;

    /* renamed from: c  reason: collision with root package name */
    public static String f83687c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f83688d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f83689e = false;

    /* renamed from: f  reason: collision with root package name */
    public static final String f83690f = Build.BRAND.toLowerCase();

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0065 A[SYNTHETIC, Splitter:B:18:0x0065] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d A[SYNTHETIC, Splitter:B:23:0x006d] */
    static {
        /*
            java.lang.String r0 = "m9"
            java.lang.String r1 = "M9"
            java.lang.String r2 = "mx"
            java.lang.String r3 = "MX"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1, r2, r3}
            f83685a = r0
            r0 = 0
            f83688d = r0
            f83689e = r0
            java.lang.String r1 = android.os.Build.BRAND
            java.lang.String r1 = r1.toLowerCase()
            f83690f = r1
            java.util.Properties r1 = new java.util.Properties
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 26
            if (r2 >= r3) goto L_0x0076
            r2 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            java.io.File r5 = android.os.Environment.getRootDirectory()     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            java.lang.String r6 = "build.prop"
            r4.<init>(r5, r6)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r1.load(r3)     // Catch:{ Exception -> 0x0043 }
            r3.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x0076
        L_0x003e:
            r2 = move-exception
            r2.printStackTrace()
            goto L_0x0076
        L_0x0043:
            r2 = move-exception
            goto L_0x004b
        L_0x0045:
            r0 = move-exception
            goto L_0x006b
        L_0x0047:
            r3 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
        L_0x004b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            r4.<init>()     // Catch:{ all -> 0x0069 }
            java.lang.String r5 = "NBDeviceHelper: "
            r4.append(r5)     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x0069 }
            r4.append(r2)     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0069 }
            i6.d.d(r2)     // Catch:{ all -> 0x0069 }
            if (r3 == 0) goto L_0x0076
            r3.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x0076
        L_0x0069:
            r0 = move-exception
            r2 = r3
        L_0x006b:
            if (r2 == 0) goto L_0x0075
            r2.close()     // Catch:{ IOException -> 0x0071 }
            goto L_0x0075
        L_0x0071:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0075:
            throw r0
        L_0x0076:
            java.lang.String r2 = "android.os.SystemProperties"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ Exception -> 0x009a }
            java.lang.String r3 = "get"
            r4 = 1
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x009a }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r0] = r5     // Catch:{ Exception -> 0x009a }
            java.lang.reflect.Method r0 = r2.getDeclaredMethod(r3, r4)     // Catch:{ Exception -> 0x009a }
            java.lang.String r2 = "ro.miui.ui.version.name"
            java.lang.String r2 = b(r1, r0, r2)     // Catch:{ Exception -> 0x009a }
            f83686b = r2     // Catch:{ Exception -> 0x009a }
            java.lang.String r2 = "ro.build.display.id"
            java.lang.String r0 = b(r1, r0, r2)     // Catch:{ Exception -> 0x009a }
            f83687c = r0     // Catch:{ Exception -> 0x009a }
            goto L_0x009e
        L_0x009a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.utils.DeviceHelper.<clinit>():void");
    }

    public static boolean a(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static String b(Properties properties, Method method, String str) {
        String property = properties.getProperty(str);
        if (property == null) {
            try {
                property = (String) method.invoke((Object) null, new Object[]{str});
            } catch (Exception unused) {
            }
        }
        return property != null ? property.toLowerCase() : property;
    }

    public static boolean c() {
        return f83690f.contains("essential");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(f83687c) && f83687c.contains("flyme");
    }

    public static boolean e() {
        return !TextUtils.isEmpty(f83686b);
    }

    public static boolean f() {
        return g(f83685a) || d();
    }

    public static boolean g(String[] strArr) {
        String str = Build.BOARD;
        if (str == null) {
            return false;
        }
        for (String equals : strArr) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(Context context) {
        if (f83688d) {
            return f83689e;
        }
        boolean a11 = a(context);
        f83689e = a11;
        f83688d = true;
        return a11;
    }

    public static boolean i() {
        String str = Build.MODEL;
        return str != null && str.toLowerCase().contains("zte c2016");
    }

    public static boolean j() {
        String str = Build.MODEL;
        return str != null && str.toLowerCase().contains("zuk z1");
    }
}
