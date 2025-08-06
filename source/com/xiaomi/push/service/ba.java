package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.af;
import com.xiaomi.push.az;
import com.xiaomi.push.bc;
import com.xiaomi.push.gk;
import com.xiaomi.push.o;
import java.util.Arrays;
import net.sf.scuba.smartcards.ISO7816;

public class ba {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f52542a = new Object();

    public static void a(final Context context, final gk gkVar) {
        if (az.a(gkVar.e())) {
            af.a(context).a((Runnable) new Runnable() {
                /* JADX WARNING: Removed duplicated region for block: B:25:0x004a A[SYNTHETIC, Splitter:B:25:0x004a] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void run() {
                    /*
                        r5 = this;
                        java.lang.Object r0 = com.xiaomi.push.service.ba.f52542a
                        monitor-enter(r0)
                        r1 = 0
                        java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                        android.content.Context r3 = r2     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                        java.io.File r3 = r3.getFilesDir()     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                        java.lang.String r4 = "tiny_data.lock"
                        r2.<init>(r3, r4)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                        com.xiaomi.push.x.a((java.io.File) r2)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                        java.io.RandomAccessFile r3 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                        java.lang.String r4 = "rw"
                        r3.<init>(r2, r4)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                        java.nio.channels.FileChannel r2 = r3.getChannel()     // Catch:{ Exception -> 0x003e }
                        java.nio.channels.FileLock r1 = r2.lock()     // Catch:{ Exception -> 0x003e }
                        android.content.Context r2 = r2     // Catch:{ Exception -> 0x003e }
                        com.xiaomi.push.gk r4 = r3     // Catch:{ Exception -> 0x003e }
                        com.xiaomi.push.service.ba.c(r2, r4)     // Catch:{ Exception -> 0x003e }
                        if (r1 == 0) goto L_0x003a
                        boolean r2 = r1.isValid()     // Catch:{ all -> 0x005b }
                        if (r2 == 0) goto L_0x003a
                        r1.release()     // Catch:{ IOException -> 0x0036 }
                        goto L_0x003a
                    L_0x0036:
                        r1 = move-exception
                        com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x005b }
                    L_0x003a:
                        com.xiaomi.push.x.a((java.io.Closeable) r3)     // Catch:{ all -> 0x005b }
                        goto L_0x0059
                    L_0x003e:
                        r2 = move-exception
                        goto L_0x0045
                    L_0x0040:
                        r2 = move-exception
                        r3 = r1
                        goto L_0x005e
                    L_0x0043:
                        r2 = move-exception
                        r3 = r1
                    L_0x0045:
                        com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x005d }
                        if (r1 == 0) goto L_0x003a
                        boolean r2 = r1.isValid()     // Catch:{ all -> 0x005b }
                        if (r2 == 0) goto L_0x003a
                        r1.release()     // Catch:{ IOException -> 0x0054 }
                        goto L_0x003a
                    L_0x0054:
                        r1 = move-exception
                        com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x005b }
                        goto L_0x003a
                    L_0x0059:
                        monitor-exit(r0)     // Catch:{ all -> 0x005b }
                        return
                    L_0x005b:
                        r1 = move-exception
                        goto L_0x0072
                    L_0x005d:
                        r2 = move-exception
                    L_0x005e:
                        if (r1 == 0) goto L_0x006e
                        boolean r4 = r1.isValid()     // Catch:{ all -> 0x005b }
                        if (r4 == 0) goto L_0x006e
                        r1.release()     // Catch:{ IOException -> 0x006a }
                        goto L_0x006e
                    L_0x006a:
                        r1 = move-exception
                        com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x005b }
                    L_0x006e:
                        com.xiaomi.push.x.a((java.io.Closeable) r3)     // Catch:{ all -> 0x005b }
                        throw r2     // Catch:{ all -> 0x005b }
                    L_0x0072:
                        monitor-exit(r0)     // Catch:{ all -> 0x005b }
                        throw r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ba.AnonymousClass1.run():void");
                }
            });
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: java.io.BufferedOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v16 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(android.content.Context r7, com.xiaomi.push.gk r8) {
        /*
            byte[] r0 = a((android.content.Context) r7)
            r1 = 0
            byte[] r2 = com.xiaomi.push.hq.a(r8)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            byte[] r0 = com.xiaomi.push.h.b(r0, r2)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            java.lang.String r2 = "  ts:"
            if (r0 == 0) goto L_0x007f
            int r3 = r0.length     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            r4 = 1
            if (r3 >= r4) goto L_0x0017
            goto L_0x007f
        L_0x0017:
            int r3 = r0.length     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            r5 = 30720(0x7800, float:4.3048E-41)
            if (r3 <= r5) goto L_0x0045
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            r7.<init>()     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            java.lang.String r0 = "TinyData write to cache file failed case too much data content item:"
            r7.append(r0)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            java.lang.String r0 = r8.d()     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            r7.append(r0)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            r7.append(r2)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            r7.append(r2)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r7)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
        L_0x003e:
            com.xiaomi.push.x.a((java.io.Closeable) r1)
            com.xiaomi.push.x.a((java.io.Closeable) r1)
            return
        L_0x0045:
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            java.io.File r7 = r7.getFilesDir()     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            java.lang.String r3 = "tiny_data.data"
            r2.<init>(r7, r3)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            java.io.BufferedOutputStream r7 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            r3.<init>(r2, r4)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            r7.<init>(r3)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            int r2 = r0.length     // Catch:{ IOException -> 0x007a, Exception -> 0x0075, all -> 0x0070 }
            byte[] r2 = com.xiaomi.push.z.a((int) r2)     // Catch:{ IOException -> 0x007a, Exception -> 0x0075, all -> 0x0070 }
            r7.write(r2)     // Catch:{ IOException -> 0x007a, Exception -> 0x0075, all -> 0x0070 }
            r7.write(r0)     // Catch:{ IOException -> 0x007a, Exception -> 0x0075, all -> 0x0070 }
            r7.flush()     // Catch:{ IOException -> 0x007a, Exception -> 0x0075, all -> 0x0070 }
            com.xiaomi.push.x.a((java.io.Closeable) r1)
            com.xiaomi.push.x.a((java.io.Closeable) r7)
            goto L_0x00e0
        L_0x0070:
            r8 = move-exception
            r0 = r7
            r7 = r8
            goto L_0x00e2
        L_0x0075:
            r0 = move-exception
            r6 = r0
            r0 = r7
            r7 = r6
            goto L_0x00a7
        L_0x007a:
            r0 = move-exception
            r6 = r0
            r0 = r7
            r7 = r6
            goto L_0x00c2
        L_0x007f:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            r7.<init>()     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            java.lang.String r0 = "TinyData write to cache file failed case encryption fail item:"
            r7.append(r0)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            java.lang.String r0 = r8.d()     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            r7.append(r0)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            r7.append(r2)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            r7.append(r2)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r7)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00a5, all -> 0x00a2 }
            goto L_0x003e
        L_0x00a2:
            r7 = move-exception
            r0 = r1
            goto L_0x00e2
        L_0x00a5:
            r7 = move-exception
            r0 = r1
        L_0x00a7:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e1 }
            r2.<init>()     // Catch:{ all -> 0x00e1 }
            java.lang.String r3 = "TinyData write to cache file  failed item:"
            r2.append(r3)     // Catch:{ all -> 0x00e1 }
            java.lang.String r8 = r8.d()     // Catch:{ all -> 0x00e1 }
            r2.append(r8)     // Catch:{ all -> 0x00e1 }
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x00e1 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r8, (java.lang.Throwable) r7)     // Catch:{ all -> 0x00e1 }
            goto L_0x00da
        L_0x00c0:
            r7 = move-exception
            r0 = r1
        L_0x00c2:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e1 }
            r2.<init>()     // Catch:{ all -> 0x00e1 }
            java.lang.String r3 = "TinyData write to cache file failed cause io exception item:"
            r2.append(r3)     // Catch:{ all -> 0x00e1 }
            java.lang.String r8 = r8.d()     // Catch:{ all -> 0x00e1 }
            r2.append(r8)     // Catch:{ all -> 0x00e1 }
            java.lang.String r8 = r2.toString()     // Catch:{ all -> 0x00e1 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r8, (java.lang.Throwable) r7)     // Catch:{ all -> 0x00e1 }
        L_0x00da:
            com.xiaomi.push.x.a((java.io.Closeable) r1)
            com.xiaomi.push.x.a((java.io.Closeable) r0)
        L_0x00e0:
            return
        L_0x00e1:
            r7 = move-exception
        L_0x00e2:
            com.xiaomi.push.x.a((java.io.Closeable) r1)
            com.xiaomi.push.x.a((java.io.Closeable) r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ba.c(android.content.Context, com.xiaomi.push.gk):void");
    }

    public static byte[] a(Context context) {
        String a11 = o.a(context).a("mipush", "td_key", "");
        if (TextUtils.isEmpty(a11)) {
            a11 = bc.a(20);
            o.a(context).a("mipush", "td_key", a11);
        }
        return a(a11);
    }

    private static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(az.a(str), 16);
        copyOf[0] = ISO7816.INS_REHABILITATE_CHV;
        copyOf[15] = 84;
        return copyOf;
    }
}
