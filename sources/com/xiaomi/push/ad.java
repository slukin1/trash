package com.xiaomi.push;

import android.content.Context;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

public class ad {
    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.Closeable, java.nio.channels.FileLock] */
    public static boolean a(Context context, String str, long j11) {
        RandomAccessFile randomAccessFile;
        ? r12 = 0;
        try {
            File file = new File(context.getFilesDir(), "/.vdevdir/");
            if (!w.a(file)) {
                x.a((Closeable) r12);
                return true;
            }
            File file2 = new File(file, "lcfp.lock");
            x.a(file2);
            randomAccessFile = new RandomAccessFile(file2, "rw");
            try {
                FileLock lock = randomAccessFile.getChannel().lock();
                boolean b11 = b(context, str, j11);
                if (lock != null && lock.isValid()) {
                    try {
                        lock.release();
                    } catch (IOException unused) {
                    }
                }
                x.a((Closeable) randomAccessFile);
                return b11;
            } catch (IOException e11) {
                e = e11;
                try {
                    e.printStackTrace();
                    if (r12 != 0 && r12.isValid()) {
                        try {
                            r12.release();
                        } catch (IOException unused2) {
                        }
                    }
                    x.a((Closeable) randomAccessFile);
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    if (r12 != 0 && r12.isValid()) {
                        try {
                            r12.release();
                        } catch (IOException unused3) {
                        }
                    }
                    x.a((Closeable) randomAccessFile);
                    throw th;
                }
            }
        } catch (IOException e12) {
            e = e12;
            randomAccessFile = r12;
            e.printStackTrace();
            r12.release();
            x.a((Closeable) randomAccessFile);
            return true;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = r12;
            r12.release();
            x.a((Closeable) randomAccessFile);
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:25|26|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r0.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b4, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b5, code lost:
        r10 = r9;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00ad */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean b(android.content.Context r16, java.lang.String r17, long r18) {
        /*
            java.io.File r0 = new java.io.File
            java.io.File r1 = r16.getFilesDir()
            java.lang.String r2 = "/.vdevdir/"
            r0.<init>(r1, r2)
            boolean r1 = com.xiaomi.push.w.a((java.io.File) r0)
            r2 = 1
            if (r1 != 0) goto L_0x0013
            return r2
        L_0x0013:
            java.io.File r1 = new java.io.File
            java.lang.String r3 = "lcfp"
            r1.<init>(r0, r3)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = r17
            r5.append(r6)
            java.lang.String r7 = ":"
            r5.append(r7)
            java.lang.String r8 = r16.getPackageName()
            r5.append(r8)
            java.lang.String r8 = ","
            r5.append(r8)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            boolean r9 = r1.exists()
            if (r9 == 0) goto L_0x00ba
            java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            java.io.FileReader r11 = new java.io.FileReader     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r11.<init>(r1)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
            r9.<init>(r11)     // Catch:{ Exception -> 0x00ac, all -> 0x00a9 }
        L_0x0055:
            java.lang.String r11 = r9.readLine()     // Catch:{ Exception -> 0x00ad }
            if (r11 == 0) goto L_0x00b0
            java.lang.String[] r12 = r11.split(r7)     // Catch:{ Exception -> 0x00ad }
            int r13 = r12.length     // Catch:{ Exception -> 0x00ad }
            r14 = 2
            if (r13 == r14) goto L_0x0064
            goto L_0x0055
        L_0x0064:
            r13 = 0
            r15 = r12[r13]     // Catch:{ Exception -> 0x00ad }
            java.lang.String r10 = java.lang.String.valueOf(r17)     // Catch:{ Exception -> 0x00ad }
            boolean r10 = android.text.TextUtils.equals(r15, r10)     // Catch:{ Exception -> 0x00ad }
            if (r10 == 0) goto L_0x00a5
            r10 = r12[r2]     // Catch:{ Exception -> 0x00ad }
            java.lang.String[] r10 = r10.split(r8)     // Catch:{ Exception -> 0x00ad }
            int r11 = r10.length     // Catch:{ Exception -> 0x00ad }
            if (r11 == r14) goto L_0x007b
            goto L_0x0055
        L_0x007b:
            r11 = r10[r2]     // Catch:{ Exception -> 0x00ad }
            long r11 = java.lang.Long.parseLong(r11)     // Catch:{ Exception -> 0x00ad }
            r10 = r10[r13]     // Catch:{ Exception -> 0x00ad }
            java.lang.String r14 = r16.getPackageName()     // Catch:{ Exception -> 0x00ad }
            boolean r10 = android.text.TextUtils.equals(r10, r14)     // Catch:{ Exception -> 0x00ad }
            if (r10 != 0) goto L_0x0055
            long r10 = r3 - r11
            long r10 = java.lang.Math.abs(r10)     // Catch:{ Exception -> 0x00ad }
            float r10 = (float) r10
            r11 = 1000(0x3e8, double:4.94E-321)
            long r11 = r11 * r18
            float r11 = (float) r11
            r12 = 1063675494(0x3f666666, float:0.9)
            float r11 = r11 * r12
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 >= 0) goto L_0x0055
            com.xiaomi.push.x.a((java.io.Closeable) r9)
            return r13
        L_0x00a5:
            r0.add(r11)     // Catch:{ Exception -> 0x00ad }
            goto L_0x0055
        L_0x00a9:
            r0 = move-exception
            r10 = 0
            goto L_0x00b6
        L_0x00ac:
            r9 = 0
        L_0x00ad:
            r0.clear()     // Catch:{ all -> 0x00b4 }
        L_0x00b0:
            com.xiaomi.push.x.a((java.io.Closeable) r9)
            goto L_0x00c1
        L_0x00b4:
            r0 = move-exception
            r10 = r9
        L_0x00b6:
            com.xiaomi.push.x.a((java.io.Closeable) r10)
            throw r0
        L_0x00ba:
            boolean r3 = com.xiaomi.push.x.a((java.io.File) r1)
            if (r3 != 0) goto L_0x00c1
            return r2
        L_0x00c1:
            r0.add(r5)
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x00f5, all -> 0x00f2 }
            java.io.FileWriter r4 = new java.io.FileWriter     // Catch:{ IOException -> 0x00f5, all -> 0x00f2 }
            r4.<init>(r1)     // Catch:{ IOException -> 0x00f5, all -> 0x00f2 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00f5, all -> 0x00f2 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
        L_0x00d2:
            boolean r1 = r0.hasNext()     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            if (r1 == 0) goto L_0x00e8
            java.lang.Object r1 = r0.next()     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            r3.write(r1)     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            r3.newLine()     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            r3.flush()     // Catch:{ IOException -> 0x00ef, all -> 0x00ec }
            goto L_0x00d2
        L_0x00e8:
            com.xiaomi.push.x.a((java.io.Closeable) r3)
            goto L_0x0101
        L_0x00ec:
            r0 = move-exception
            r10 = r3
            goto L_0x0103
        L_0x00ef:
            r0 = move-exception
            r10 = r3
            goto L_0x00f7
        L_0x00f2:
            r0 = move-exception
            r10 = 0
            goto L_0x0103
        L_0x00f5:
            r0 = move-exception
            r10 = 0
        L_0x00f7:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0102 }
            com.xiaomi.channel.commonutils.logger.b.d(r0)     // Catch:{ all -> 0x0102 }
            com.xiaomi.push.x.a((java.io.Closeable) r10)
        L_0x0101:
            return r2
        L_0x0102:
            r0 = move-exception
        L_0x0103:
            com.xiaomi.push.x.a((java.io.Closeable) r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ad.b(android.content.Context, java.lang.String, long):boolean");
    }
}
