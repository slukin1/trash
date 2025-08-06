package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class gc {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f51893a = false;

    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Context f51894a;

        /* renamed from: a  reason: collision with other field name */
        private gf f2901a;

        public a(Context context, gf gfVar) {
            this.f2901a = gfVar;
            this.f51894a = context;
        }

        public void run() {
            gc.c(this.f51894a, this.f2901a);
        }
    }

    public static void a(Context context, gf gfVar) {
        af.a(context).a((Runnable) new a(context, gfVar));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(android.content.Context r11, com.xiaomi.push.gf r12) {
        /*
            java.lang.String r0 = "/"
            java.lang.String r1 = "/tdReadTemp"
            boolean r2 = f51893a
            if (r2 != 0) goto L_0x00dd
            r2 = 1
            f51893a = r2
            java.io.File r2 = new java.io.File
            java.io.File r3 = r11.getFilesDir()
            java.lang.String r4 = "tiny_data.data"
            r2.<init>(r3, r4)
            boolean r3 = r2.exists()
            java.lang.String r5 = "TinyData no ready file to get data."
            if (r3 != 0) goto L_0x0022
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r5)
            return
        L_0x0022:
            a(r11)
            byte[] r3 = com.xiaomi.push.service.ba.a((android.content.Context) r11)
            r6 = 0
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            java.io.File r8 = r11.getFilesDir()     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            java.lang.String r9 = "tiny_data.lock"
            r7.<init>(r8, r9)     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            com.xiaomi.push.x.a((java.io.File) r7)     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            java.io.RandomAccessFile r8 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            java.lang.String r9 = "rw"
            r8.<init>(r7, r9)     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            java.nio.channels.FileChannel r7 = r8.getChannel()     // Catch:{ Exception -> 0x0076 }
            java.nio.channels.FileLock r6 = r7.lock()     // Catch:{ Exception -> 0x0076 }
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x0076 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0076 }
            r9.<init>()     // Catch:{ Exception -> 0x0076 }
            java.io.File r10 = r11.getFilesDir()     // Catch:{ Exception -> 0x0076 }
            r9.append(r10)     // Catch:{ Exception -> 0x0076 }
            r9.append(r1)     // Catch:{ Exception -> 0x0076 }
            r9.append(r0)     // Catch:{ Exception -> 0x0076 }
            r9.append(r4)     // Catch:{ Exception -> 0x0076 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x0076 }
            r7.<init>(r9)     // Catch:{ Exception -> 0x0076 }
            r2.renameTo(r7)     // Catch:{ Exception -> 0x0076 }
            if (r6 == 0) goto L_0x0090
            boolean r2 = r6.isValid()
            if (r2 == 0) goto L_0x0090
            r6.release()     // Catch:{ IOException -> 0x0074 }
            goto L_0x0090
        L_0x0074:
            r2 = move-exception
            goto L_0x008d
        L_0x0076:
            r2 = move-exception
            goto L_0x007d
        L_0x0078:
            r11 = move-exception
            r8 = r6
            goto L_0x00c9
        L_0x007b:
            r2 = move-exception
            r8 = r6
        L_0x007d:
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x00c8 }
            if (r6 == 0) goto L_0x0090
            boolean r2 = r6.isValid()
            if (r2 == 0) goto L_0x0090
            r6.release()     // Catch:{ IOException -> 0x008c }
            goto L_0x0090
        L_0x008c:
            r2 = move-exception
        L_0x008d:
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r2)
        L_0x0090:
            com.xiaomi.push.x.a((java.io.Closeable) r8)
            java.io.File r2 = new java.io.File
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.io.File r7 = r11.getFilesDir()
            r6.append(r7)
            r6.append(r1)
            r6.append(r0)
            r6.append(r4)
            java.lang.String r0 = r6.toString()
            r2.<init>(r0)
            boolean r0 = r2.exists()
            if (r0 != 0) goto L_0x00bb
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r5)
            return
        L_0x00bb:
            a(r11, r12, r2, r3)
            r12 = 0
            com.xiaomi.push.gb.a((boolean) r12)
            b(r11)
            f51893a = r12
            return
        L_0x00c8:
            r11 = move-exception
        L_0x00c9:
            if (r6 == 0) goto L_0x00d9
            boolean r12 = r6.isValid()
            if (r12 == 0) goto L_0x00d9
            r6.release()     // Catch:{ IOException -> 0x00d5 }
            goto L_0x00d9
        L_0x00d5:
            r12 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r12)
        L_0x00d9:
            com.xiaomi.push.x.a((java.io.Closeable) r8)
            throw r11
        L_0x00dd:
            java.lang.String r11 = "TinyData extractTinyData is running"
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.gc.c(android.content.Context, com.xiaomi.push.gf):void");
    }

    private static void a(Context context, gf gfVar, File file, byte[] bArr) {
        int a11;
        ArrayList arrayList = new ArrayList();
        byte[] bArr2 = new byte[4];
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            loop0:
            while (true) {
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    try {
                        int read = bufferedInputStream2.read(bArr2);
                        if (read == -1) {
                            break loop0;
                        } else if (read != 4) {
                            b.d("TinyData read from cache file failed cause lengthBuffer error. size:" + read);
                            break loop0;
                        } else {
                            a11 = z.a(bArr2);
                            if (a11 < 1) {
                                break loop0;
                            } else if (a11 > 30720) {
                                break loop0;
                            } else {
                                byte[] bArr3 = new byte[a11];
                                int read2 = bufferedInputStream2.read(bArr3);
                                if (read2 != a11) {
                                    b.d("TinyData read from cache file failed cause buffer size not equal length. size:" + read2 + "__length:" + a11);
                                    break loop0;
                                }
                                byte[] a12 = h.a(bArr, bArr3);
                                if (a12 != null) {
                                    if (a12.length != 0) {
                                        gk gkVar = new gk();
                                        hq.a(gkVar, a12);
                                        gkVar.a("item_size", String.valueOf(a12.length));
                                        arrayList.add(gkVar);
                                        i11++;
                                        i12 += a12.length;
                                        if (i11 >= 8 || i12 >= 30720) {
                                            gd.a(context, gfVar, (List<gk>) arrayList);
                                            arrayList.clear();
                                        }
                                    }
                                }
                                b.d("TinyData read from cache file failed cause decrypt fail");
                            }
                        }
                    } catch (Exception e11) {
                        e = e11;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            b.a((Throwable) e);
                            x.a((Closeable) bufferedInputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            x.a((Closeable) bufferedInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = bufferedInputStream2;
                        x.a((Closeable) bufferedInputStream);
                        throw th;
                    }
                }
            }
            b.d("TinyData read from cache file failed cause lengthBuffer < 1 || too big. length:" + a11);
            gd.a(context, gfVar, (List<gk>) arrayList);
            if (file != null && file.exists() && !file.delete()) {
                b.a("TinyData delete reading temp file failed");
            }
            x.a((Closeable) bufferedInputStream2);
        } catch (Exception e12) {
            e = e12;
            b.a((Throwable) e);
            x.a((Closeable) bufferedInputStream);
        }
    }

    private static void b(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_extra", 4).edit();
        edit.putLong("last_tiny_data_upload_timestamp", System.currentTimeMillis() / 1000);
        edit.commit();
    }

    private static void a(Context context) {
        File file = new File(context.getFilesDir() + "/tdReadTemp");
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}
