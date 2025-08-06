package com.huobi.vulcan.utils.riskinfo;

import android.content.Context;
import android.os.Debug;
import com.huobi.vulcan.core.SecurityKey;

public class AntiDebug {

    /* renamed from: a  reason: collision with root package name */
    public static String f20621a = "TracerPid";

    public static boolean a() {
        return Debug.isDebuggerConnected();
    }

    public static boolean b() {
        long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
        for (int i11 = 0; i11 < 1000000; i11++) {
        }
        if (Debug.threadCpuTimeNanos() - threadCpuTimeNanos < 10000000) {
            return false;
        }
        return true;
    }

    public static boolean c() {
        return SecurityKey.ddgp() > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063 A[SYNTHETIC, Splitter:B:24:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0069 A[SYNTHETIC, Splitter:B:30:0x0069] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d() {
        /*
            r0 = 0
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            java.lang.String r5 = "/proc/self/status"
            r4.<init>(r5)     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
            r4 = 1000(0x3e8, float:1.401E-42)
            r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0067, all -> 0x0060 }
        L_0x0015:
            java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            if (r1 == 0) goto L_0x0057
            int r3 = r1.length()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.String r4 = f20621a     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            int r4 = r4.length()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            if (r3 <= r4) goto L_0x0015
            java.lang.String r3 = f20621a     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            int r3 = r3.length()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.String r3 = r1.substring(r0, r3)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.String r4 = f20621a     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            boolean r3 = r3.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            if (r3 == 0) goto L_0x0015
            java.lang.String r3 = f20621a     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            int r3 = r3.length()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            r4 = 1
            int r3 = r3 + r4
            java.lang.String r1 = r1.substring(r3)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.String r1 = r1.trim()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            java.lang.Integer r1 = java.lang.Integer.decode(r1)     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x005e, all -> 0x005b }
            if (r1 <= 0) goto L_0x0057
            r2.close()     // Catch:{ IOException -> 0x0056 }
        L_0x0056:
            return r4
        L_0x0057:
            r2.close()     // Catch:{ IOException -> 0x006c }
            goto L_0x006c
        L_0x005b:
            r0 = move-exception
            r1 = r2
            goto L_0x0061
        L_0x005e:
            r1 = r2
            goto L_0x0067
        L_0x0060:
            r0 = move-exception
        L_0x0061:
            if (r1 == 0) goto L_0x0066
            r1.close()     // Catch:{ IOException -> 0x0066 }
        L_0x0066:
            throw r0
        L_0x0067:
            if (r1 == 0) goto L_0x006c
            r1.close()     // Catch:{ IOException -> 0x006c }
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.vulcan.utils.riskinfo.AntiDebug.d():boolean");
    }

    public static boolean e() {
        return SecurityKey.ddtp() > 0;
    }

    public static boolean f(Context context) {
        return (context == null || (context.getApplicationContext().getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    public static boolean g(Context context) {
        return f(context) || a() || b() || d() || e() || c();
    }
}
