package com.hbg.lib.common.utils;

import android.os.Build;
import java.io.File;

public class RootUtils {
    public static boolean a() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public static boolean b() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
        for (int i11 = 0; i11 < 9; i11++) {
            if (new File(strArr[i11]).exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e A[SYNTHETIC, Splitter:B:23:0x003e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c() {
        /*
            r0 = 0
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch:{ all -> 0x0036 }
            java.lang.String r3 = "/system/xbin/which"
            java.lang.String r4 = "su"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ all -> 0x0036 }
            java.lang.Process r2 = r2.exec(r3)     // Catch:{ all -> 0x0036 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x0033 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x0033 }
            java.io.InputStream r5 = r2.getInputStream()     // Catch:{ all -> 0x0033 }
            r4.<init>(r5)     // Catch:{ all -> 0x0033 }
            r3.<init>(r4)     // Catch:{ all -> 0x0033 }
            java.lang.String r1 = r3.readLine()     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x0027
            r0 = 1
        L_0x0027:
            r2.destroy()
            r3.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0041
        L_0x002e:
            r1 = move-exception
            r1.printStackTrace()
            goto L_0x0041
        L_0x0033:
            r3 = r1
        L_0x0034:
            r1 = r2
            goto L_0x0037
        L_0x0036:
            r3 = r1
        L_0x0037:
            if (r1 == 0) goto L_0x003c
            r1.destroy()
        L_0x003c:
            if (r3 == 0) goto L_0x0041
            r3.close()     // Catch:{ IOException -> 0x002e }
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.common.utils.RootUtils.c():boolean");
    }
}
