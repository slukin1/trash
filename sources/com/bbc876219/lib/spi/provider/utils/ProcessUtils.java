package com.bbc876219.lib.spi.provider.utils;

public class ProcessUtils {

    /* renamed from: a  reason: collision with root package name */
    public static String f63233a = "";

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0092 A[Catch:{ Exception -> 0x0096 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a() {
        /*
            java.lang.String r0 = f63233a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0099
            int r0 = android.os.Process.myPid()     // Catch:{ Exception -> 0x0096 }
            java.lang.Class<f3.a> r1 = f3.a.class
            java.lang.Object r1 = com.bbc876219.lib.spi.provider.a.e(r1)     // Catch:{ Exception -> 0x0096 }
            f3.a r1 = (f3.a) r1     // Catch:{ Exception -> 0x0096 }
            android.app.Application r1 = r1.a()     // Catch:{ Exception -> 0x0096 }
            java.lang.String r2 = "activity"
            java.lang.Object r1 = r1.getSystemService(r2)     // Catch:{ Exception -> 0x0096 }
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch:{ Exception -> 0x0096 }
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch:{ Exception -> 0x0096 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0096 }
        L_0x0028:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0096 }
            if (r2 == 0) goto L_0x003c
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0096 }
            android.app.ActivityManager$RunningAppProcessInfo r2 = (android.app.ActivityManager.RunningAppProcessInfo) r2     // Catch:{ Exception -> 0x0096 }
            int r3 = r2.pid     // Catch:{ Exception -> 0x0096 }
            if (r3 != r0) goto L_0x0028
            java.lang.String r0 = r2.processName     // Catch:{ Exception -> 0x0096 }
            f63233a = r0     // Catch:{ Exception -> 0x0096 }
        L_0x003c:
            java.lang.String r0 = f63233a     // Catch:{ Exception -> 0x0096 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0096 }
            if (r0 == 0) goto L_0x0099
            r0 = 0
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ all -> 0x008c }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ all -> 0x008c }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ all -> 0x008c }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
            r4.<init>()     // Catch:{ all -> 0x008c }
            java.lang.String r5 = "/proc/"
            r4.append(r5)     // Catch:{ all -> 0x008c }
            int r5 = android.os.Process.myPid()     // Catch:{ all -> 0x008c }
            r4.append(r5)     // Catch:{ all -> 0x008c }
            java.lang.String r5 = "/cmdline"
            r4.append(r5)     // Catch:{ all -> 0x008c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x008c }
            r3.<init>(r4)     // Catch:{ all -> 0x008c }
            java.lang.String r4 = "iso-8859-1"
            r2.<init>(r3, r4)     // Catch:{ all -> 0x008c }
            r1.<init>(r2)     // Catch:{ all -> 0x008c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            r0.<init>()     // Catch:{ all -> 0x008a }
        L_0x0075:
            int r2 = r1.read()     // Catch:{ all -> 0x008a }
            if (r2 <= 0) goto L_0x0080
            char r2 = (char) r2     // Catch:{ all -> 0x008a }
            r0.append(r2)     // Catch:{ all -> 0x008a }
            goto L_0x0075
        L_0x0080:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008a }
            f63233a = r0     // Catch:{ all -> 0x008a }
            r1.close()     // Catch:{ Exception -> 0x0096 }
            goto L_0x0099
        L_0x008a:
            r0 = move-exception
            goto L_0x0090
        L_0x008c:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L_0x0090:
            if (r1 == 0) goto L_0x0095
            r1.close()     // Catch:{ Exception -> 0x0096 }
        L_0x0095:
            throw r0     // Catch:{ Exception -> 0x0096 }
        L_0x0096:
            java.lang.String r0 = ""
            return r0
        L_0x0099:
            java.lang.String r0 = f63233a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bbc876219.lib.spi.provider.utils.ProcessUtils.a():java.lang.String");
    }
}
