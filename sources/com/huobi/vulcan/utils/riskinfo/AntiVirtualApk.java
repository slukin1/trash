package com.huobi.vulcan.utils.riskinfo;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

public class AntiVirtualApk {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f20632a = {"com.bly.dkplat", "com.by.chaos", "com.lbe.parallel", "com.excelliance.dualaid", "com.lody.virtual", "com.qihoo.magic", "io.va.exposed", "com.excean.maid"};

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004c A[SYNTHETIC, Splitter:B:23:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052 A[SYNTHETIC, Splitter:B:29:0x0052] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a() {
        /*
            r0 = 0
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0050, all -> 0x0049 }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0050, all -> 0x0049 }
            java.lang.String r4 = "/proc/self/maps"
            r3.<init>(r4)     // Catch:{ Exception -> 0x0050, all -> 0x0049 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0050, all -> 0x0049 }
        L_0x000e:
            java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            if (r1 == 0) goto L_0x0040
            java.lang.String[] r3 = f20632a     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            int r4 = r3.length     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            r5 = r0
        L_0x0018:
            if (r5 >= r4) goto L_0x000e
            r6 = r3[r5]     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            boolean r6 = r1.contains(r6)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            if (r6 == 0) goto L_0x003d
            java.lang.String r3 = "AntiVirtualApk"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            r4.<init>()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            java.lang.String r5 = "/proc/self/maps contains -> "
            r4.append(r5)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            r4.append(r1)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            android.util.Log.d(r3, r1)     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            r2.close()     // Catch:{ IOException -> 0x003b }
        L_0x003b:
            r0 = 1
            return r0
        L_0x003d:
            int r5 = r5 + 1
            goto L_0x0018
        L_0x0040:
            r2.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0055
        L_0x0044:
            r0 = move-exception
            r1 = r2
            goto L_0x004a
        L_0x0047:
            r1 = r2
            goto L_0x0050
        L_0x0049:
            r0 = move-exception
        L_0x004a:
            if (r1 == 0) goto L_0x004f
            r1.close()     // Catch:{ IOException -> 0x004f }
        L_0x004f:
            throw r0
        L_0x0050:
            if (r1 == 0) goto L_0x0055
            r1.close()     // Catch:{ IOException -> 0x0055 }
        L_0x0055:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.vulcan.utils.riskinfo.AntiVirtualApk.a():boolean");
    }

    public static boolean b(Context context) {
        String path = context.getFilesDir().getPath();
        String packageName = context.getPackageName();
        if (path.contains(packageName)) {
            String[] split = path.split("/" + packageName + "/");
            if (split != null && split.length == 2) {
                String b11 = ReUtils.b(split[0], "/data/(\\w+/)+(\\w+\\.\\w+\\.[\\w.]+)/", 2);
                if (!TextUtils.isEmpty(b11)) {
                    Log.d("AntiVirtualApk", "context.getFilesDir() = " + path);
                    Log.d("AntiVirtualApk", " context.getFilesDir() contains other packageNames : " + b11);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean c(Context context) {
        return b(context) || a();
    }
}
