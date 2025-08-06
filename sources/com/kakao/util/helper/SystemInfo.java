package com.kakao.util.helper;

import android.os.Build;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Locale;

public class SystemInfo {

    /* renamed from: a  reason: collision with root package name */
    public static final int f25152a = Build.VERSION.SDK_INT;

    /* renamed from: b  reason: collision with root package name */
    public static final String f25153b = Build.MODEL.replaceAll("\\s", Constants.ACCEPT_TIME_SEPARATOR_SERVER).toUpperCase(Locale.ROOT);

    /* renamed from: c  reason: collision with root package name */
    public static String f25154c;

    public static String a() {
        return f25154c;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:5|6|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x009d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void b(android.content.Context r4) {
        /*
            java.lang.Class<com.kakao.util.helper.SystemInfo> r0 = com.kakao.util.helper.SystemInfo.class
            monitor-enter(r0)
            java.lang.String r1 = f25154c     // Catch:{ all -> 0x00a1 }
            if (r1 != 0) goto L_0x009f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a1 }
            r1.<init>()     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = "sdk/1.29.0 os/android-"
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            int r2 = f25152a     // Catch:{ all -> 0x00a1 }
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = " "
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = "lang/"
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = r2.getLanguage()     // Catch:{ all -> 0x00a1 }
            java.util.Locale r3 = java.util.Locale.ROOT     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = r2.toLowerCase(r3)     // Catch:{ all -> 0x00a1 }
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = "-"
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = r2.getCountry()     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = r2.toUpperCase(r3)     // Catch:{ all -> 0x00a1 }
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = " "
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = "origin/"
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = com.kakao.util.helper.Utility.b(r4)     // Catch:{ all -> 0x00a1 }
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = " "
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = "device/"
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = f25153b     // Catch:{ all -> 0x00a1 }
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = " "
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = "android_pkg/"
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = r4.getPackageName()     // Catch:{ all -> 0x00a1 }
            r1.append(r2)     // Catch:{ all -> 0x00a1 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a1 }
            android.content.pm.PackageManager r2 = r4.getPackageManager()     // Catch:{ NameNotFoundException -> 0x009d }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ NameNotFoundException -> 0x009d }
            r3 = 0
            android.content.pm.PackageInfo r4 = r2.getPackageInfo(r4, r3)     // Catch:{ NameNotFoundException -> 0x009d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ NameNotFoundException -> 0x009d }
            r2.<init>()     // Catch:{ NameNotFoundException -> 0x009d }
            r2.append(r1)     // Catch:{ NameNotFoundException -> 0x009d }
            java.lang.String r3 = " app_ver/"
            r2.append(r3)     // Catch:{ NameNotFoundException -> 0x009d }
            java.lang.String r4 = r4.versionName     // Catch:{ NameNotFoundException -> 0x009d }
            r2.append(r4)     // Catch:{ NameNotFoundException -> 0x009d }
            java.lang.String r1 = r2.toString()     // Catch:{ NameNotFoundException -> 0x009d }
        L_0x009d:
            f25154c = r1     // Catch:{ all -> 0x00a1 }
        L_0x009f:
            monitor-exit(r0)
            return
        L_0x00a1:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.util.helper.SystemInfo.b(android.content.Context):void");
    }
}
