package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.e.c;
import java.util.concurrent.Callable;

public class f extends a implements Callable<d> {

    /* renamed from: i  reason: collision with root package name */
    private static final String f38064i = "f";

    public f(String str, int i11, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, c cVar2) {
        super(str, i11, cVar, context, str2, grsBaseInfo, cVar2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v0, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v2, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX WARNING: type inference failed for: r0v23, types: [byte[]] */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b4, code lost:
        com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b7, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00dd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00df, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e0, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e1, code lost:
        r19 = r4;
        r4 = r7;
        r6 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        r9.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0109, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0110, code lost:
        r4 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r6.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0150, code lost:
        com.huawei.hms.framework.common.Logger.w(f38064i, "RequestCallableV2 disconnect HttpsURLConnection catch Throwable");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0156, code lost:
        com.huawei.hms.framework.common.Logger.w(f38064i, "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:7:0x002c, B:34:0x00a6] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e7 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0010] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0105 A[SYNTHETIC, Splitter:B:58:0x0105] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x014c A[SYNTHETIC, Splitter:B:77:0x014c] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.framework.network.grs.g.d call() {
        /*
            r21 = this;
            r1 = r21
            java.lang.String r2 = "RequestCallableV2 disconnect HttpsURLConnection catch Throwable"
            java.lang.String r3 = "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException"
            java.lang.String r0 = f38064i
            java.lang.String r4 = "Post call execute"
            com.huawei.hms.framework.common.Logger.i(r0, r4)
            r4 = 0
            r6 = 0
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x00e9, all -> 0x00e7 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00df, all -> 0x00e7 }
            java.lang.String r9 = r21.c()     // Catch:{ IOException -> 0x00df, all -> 0x00e7 }
            android.content.Context r10 = r21.a()     // Catch:{ IOException -> 0x00df, all -> 0x00e7 }
            java.lang.String r11 = r21.e()     // Catch:{ IOException -> 0x00df, all -> 0x00e7 }
            javax.net.ssl.HttpsURLConnection r9 = com.huawei.hms.framework.network.grs.h.f.a.a(r9, r10, r11)     // Catch:{ IOException -> 0x00df, all -> 0x00e7 }
            if (r9 != 0) goto L_0x0041
            java.lang.String r10 = "create HttpsURLConnection instance by url return null."
            com.huawei.hms.framework.common.Logger.w(r0, r10)     // Catch:{ IOException -> 0x00dd }
            if (r9 == 0) goto L_0x0040
            r9.disconnect()     // Catch:{ RuntimeException -> 0x003b, all -> 0x0035 }
            goto L_0x0040
        L_0x0035:
            java.lang.String r0 = f38064i
            com.huawei.hms.framework.common.Logger.w(r0, r2)
            goto L_0x0040
        L_0x003b:
            java.lang.String r0 = f38064i
            com.huawei.hms.framework.common.Logger.w(r0, r3)
        L_0x0040:
            return r6
        L_0x0041:
            java.lang.String r10 = "Content-Type"
            java.lang.String r11 = "application/json; charset=UTF-8"
            r9.setRequestProperty(r10, r11)     // Catch:{ IOException -> 0x00dd }
            java.lang.String r10 = "Connection"
            java.lang.String r11 = "close"
            r9.setRequestProperty(r10, r11)     // Catch:{ IOException -> 0x00dd }
            java.lang.String r10 = "POST"
            r9.setRequestMethod(r10)     // Catch:{ IOException -> 0x00dd }
            r10 = 1
            r9.setDoOutput(r10)     // Catch:{ IOException -> 0x00dd }
            r9.setDoInput(r10)     // Catch:{ IOException -> 0x00dd }
            com.huawei.hms.framework.network.grs.g.c r10 = r21.b()     // Catch:{ IOException -> 0x00dd }
            java.lang.String r11 = ""
            if (r10 == 0) goto L_0x006c
            com.huawei.hms.framework.network.grs.g.c r10 = r21.b()     // Catch:{ IOException -> 0x00dd }
            java.lang.String r10 = r10.a()     // Catch:{ IOException -> 0x00dd }
            goto L_0x006d
        L_0x006c:
            r10 = r11
        L_0x006d:
            java.lang.String r12 = "If-None-Match"
            boolean r13 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IOException -> 0x00dd }
            if (r13 == 0) goto L_0x0077
            java.lang.String r10 = "&"
        L_0x0077:
            r9.setRequestProperty(r12, r10)     // Catch:{ IOException -> 0x00dd }
            r9.connect()     // Catch:{ IOException -> 0x00dd }
            com.huawei.hms.framework.network.grs.e.c r10 = r21.f()     // Catch:{ IOException -> 0x00dd }
            java.lang.String r12 = "services"
            java.lang.String r10 = r10.a(r12, r11)     // Catch:{ IOException -> 0x00dd }
            com.huawei.hms.framework.network.grs.h.f.a.a(r9, r10)     // Catch:{ IOException -> 0x00dd }
            int r12 = r9.getResponseCode()     // Catch:{ IOException -> 0x00dd }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00dd }
            r10.<init>()     // Catch:{ IOException -> 0x00dd }
            java.lang.String r11 = "httpsURLConnection result code:"
            r10.append(r11)     // Catch:{ IOException -> 0x00dd }
            r10.append(r12)     // Catch:{ IOException -> 0x00dd }
            java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x00dd }
            com.huawei.hms.framework.common.Logger.i(r0, r10)     // Catch:{ IOException -> 0x00dd }
            r0 = 200(0xc8, float:2.8E-43)
            if (r12 != r0) goto L_0x00b8
            java.io.InputStream r6 = r9.getInputStream()     // Catch:{ all -> 0x00b3 }
            byte[] r0 = com.huawei.hms.framework.common.IoUtils.toByteArray(r6)     // Catch:{ all -> 0x00b3 }
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r6)     // Catch:{ IOException -> 0x00dd }
            r6 = r0
            goto L_0x00b8
        L_0x00b3:
            r0 = move-exception
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r6)     // Catch:{ IOException -> 0x00dd }
            throw r0     // Catch:{ IOException -> 0x00dd }
        L_0x00b8:
            java.util.Map r13 = r9.getHeaderFields()     // Catch:{ IOException -> 0x00dd }
            r9.disconnect()     // Catch:{ IOException -> 0x00dd }
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x00dd }
            long r17 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00dd }
            if (r6 != 0) goto L_0x00ce
            r0 = 0
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x00dd }
            r14 = r0
            goto L_0x00cf
        L_0x00ce:
            r14 = r6
        L_0x00cf:
            com.huawei.hms.framework.network.grs.g.d r0 = new com.huawei.hms.framework.network.grs.g.d     // Catch:{ IOException -> 0x00dd }
            long r15 = r10 - r7
            r11 = r0
            r11.<init>(r12, r13, r14, r15)     // Catch:{ IOException -> 0x00dd }
            r1.f38023a = r0     // Catch:{ IOException -> 0x00dd }
            r9.disconnect()     // Catch:{ RuntimeException -> 0x0111, all -> 0x010a }
            goto L_0x0118
        L_0x00dd:
            r0 = move-exception
            goto L_0x00e1
        L_0x00df:
            r0 = move-exception
            r9 = r6
        L_0x00e1:
            r19 = r4
            r4 = r7
            r6 = r19
            goto L_0x00ec
        L_0x00e7:
            r0 = move-exception
            goto L_0x014a
        L_0x00e9:
            r0 = move-exception
            r9 = r6
            r6 = r4
        L_0x00ec:
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0148 }
            long r17 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0148 }
            java.lang.String r8 = f38064i     // Catch:{ all -> 0x0148 }
            java.lang.String r12 = "RequestCallableV2 run task catch IOException"
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r8, (java.lang.String) r12, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0148 }
            com.huawei.hms.framework.network.grs.g.d r8 = new com.huawei.hms.framework.network.grs.g.d     // Catch:{ all -> 0x0148 }
            long r10 = r10 - r4
            r8.<init>(r0, r10)     // Catch:{ all -> 0x0148 }
            r1.f38023a = r8     // Catch:{ all -> 0x0148 }
            if (r9 == 0) goto L_0x0117
            r9.disconnect()     // Catch:{ RuntimeException -> 0x0110, all -> 0x0109 }
            goto L_0x0117
        L_0x0109:
            r4 = r6
        L_0x010a:
            java.lang.String r0 = f38064i
            com.huawei.hms.framework.common.Logger.w(r0, r2)
            goto L_0x0118
        L_0x0110:
            r4 = r6
        L_0x0111:
            java.lang.String r0 = f38064i
            com.huawei.hms.framework.common.Logger.w(r0, r3)
            goto L_0x0118
        L_0x0117:
            r4 = r6
        L_0x0118:
            r2 = r17
            com.huawei.hms.framework.network.grs.g.d r0 = r1.f38023a
            java.lang.String r6 = r21.c()
            r0.b((java.lang.String) r6)
            com.huawei.hms.framework.network.grs.g.d r0 = r1.f38023a
            int r6 = r21.d()
            r0.a((int) r6)
            com.huawei.hms.framework.network.grs.g.d r0 = r1.f38023a
            r0.b((long) r4)
            com.huawei.hms.framework.network.grs.g.d r0 = r1.f38023a
            r0.a((long) r2)
            com.huawei.hms.framework.network.grs.g.c r0 = r21.b()
            if (r0 == 0) goto L_0x0145
            com.huawei.hms.framework.network.grs.g.c r0 = r21.b()
            com.huawei.hms.framework.network.grs.g.d r2 = r1.f38023a
            r0.a((com.huawei.hms.framework.network.grs.g.d) r2)
        L_0x0145:
            com.huawei.hms.framework.network.grs.g.d r0 = r1.f38023a
            return r0
        L_0x0148:
            r0 = move-exception
            r6 = r9
        L_0x014a:
            if (r6 == 0) goto L_0x015b
            r6.disconnect()     // Catch:{ RuntimeException -> 0x0156, all -> 0x0150 }
            goto L_0x015b
        L_0x0150:
            java.lang.String r3 = f38064i
            com.huawei.hms.framework.common.Logger.w(r3, r2)
            goto L_0x015b
        L_0x0156:
            java.lang.String r2 = f38064i
            com.huawei.hms.framework.common.Logger.w(r2, r3)
        L_0x015b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.f.call():com.huawei.hms.framework.network.grs.g.d");
    }
}
