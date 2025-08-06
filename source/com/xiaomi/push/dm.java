package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.af;
import com.xiaomi.push.service.ah;

public abstract class dm extends af.a {

    /* renamed from: a  reason: collision with root package name */
    public int f51592a;

    /* renamed from: a  reason: collision with other field name */
    public Context f2675a;

    public dm(Context context, int i11) {
        this.f51592a = i11;
        this.f2675a = context;
    }

    private String c() {
        return "dc_job_result_time_" + a();
    }

    private String d() {
        return "dc_job_result_" + a();
    }

    public abstract gi a();

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2522a() {
        return dj.a(this.f2675a, String.valueOf(a()), (long) this.f51592a);
    }

    public abstract String b();

    /* renamed from: b  reason: collision with other method in class */
    public boolean m2523b() {
        return true;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m2524c() {
        return false;
    }

    public void run() {
        String str;
        String b11 = b();
        if (!TextUtils.isEmpty(b11)) {
            if (a()) {
                b.a("DC run job mutual: " + a());
                return;
            }
            dg a11 = dh.a().a();
            if (a11 == null) {
                str = "";
            } else {
                str = a11.a();
            }
            if (!TextUtils.isEmpty(str) && b()) {
                if (c()) {
                    SharedPreferences sharedPreferences = this.f2675a.getSharedPreferences("mipush_extra", 0);
                    if (bc.a(b11).equals(sharedPreferences.getString(d(), (String) null))) {
                        long j11 = sharedPreferences.getLong(c(), 0);
                        int a12 = ah.a(this.f2675a).a(gl.DCJobUploadRepeatedInterval.a(), 604800);
                        if ((System.currentTimeMillis() - j11) / 1000 >= ((long) this.f51592a)) {
                            if ((System.currentTimeMillis() - j11) / 1000 < ((long) a12)) {
                                b11 = "same_" + j11;
                            }
                        } else {
                            return;
                        }
                    }
                }
                go goVar = new go();
                goVar.a(b11);
                goVar.a(System.currentTimeMillis());
                goVar.a(a());
                a(this.f2675a, goVar, str);
            }
        }
    }

    public static void a(Context context, go goVar) {
        String str;
        dg a11 = dh.a().a();
        if (a11 == null) {
            str = "";
        } else {
            str = a11.a();
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(goVar.a())) {
            a(context, goVar, str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.nio.channels.FileLock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.nio.channels.FileLock} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v5, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Can't wrap try/catch for region: R(10:37|38|43|44|(0)|51|52|28|53|54) */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:6|7|8|9|10|11|12|(4:14|15|16|17)|(3:21|22|(2:24|25))|26|27|28|53) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:35|36|59|61|62|63|64|65) */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00a0, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a2, code lost:
        r7 = th;
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00b6, code lost:
        throw r6;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:21:0x0067, B:43:0x008c] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0070 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x009a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00ae */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0091 A[SYNTHETIC, Splitter:B:46:0x0091] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:26:0x0070=Splitter:B:26:0x0070, B:51:0x009a=Splitter:B:51:0x009a, B:43:0x008c=Splitter:B:43:0x008c, B:63:0x00ae=Splitter:B:63:0x00ae} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r6, com.xiaomi.push.go r7, java.lang.String r8) {
        /*
            byte[] r7 = com.xiaomi.push.hq.a(r7)
            byte[] r7 = com.xiaomi.push.dj.b(r8, r7)
            if (r7 == 0) goto L_0x00b7
            int r8 = r7.length
            if (r8 != 0) goto L_0x000f
            goto L_0x00b7
        L_0x000f:
            java.lang.Object r8 = com.xiaomi.push.dk.f51588a
            monitor-enter(r8)
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ IOException -> 0x0089, all -> 0x0085 }
            java.io.File r2 = r6.getFilesDir()     // Catch:{ IOException -> 0x0089, all -> 0x0085 }
            java.lang.String r3 = "push_cdata.lock"
            r1.<init>(r2, r3)     // Catch:{ IOException -> 0x0089, all -> 0x0085 }
            com.xiaomi.push.x.a((java.io.File) r1)     // Catch:{ IOException -> 0x0089, all -> 0x0085 }
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0089, all -> 0x0085 }
            java.lang.String r3 = "rw"
            r2.<init>(r1, r3)     // Catch:{ IOException -> 0x0089, all -> 0x0085 }
            java.nio.channels.FileChannel r1 = r2.getChannel()     // Catch:{ IOException -> 0x0082, all -> 0x007f }
            java.nio.channels.FileLock r1 = r1.lock()     // Catch:{ IOException -> 0x0082, all -> 0x007f }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x007b, all -> 0x0077 }
            java.io.File r6 = r6.getFilesDir()     // Catch:{ IOException -> 0x007b, all -> 0x0077 }
            java.lang.String r4 = "push_cdata.data"
            r3.<init>(r6, r4)     // Catch:{ IOException -> 0x007b, all -> 0x0077 }
            boolean r6 = com.xiaomi.push.w.a((java.io.File) r3)     // Catch:{ IOException -> 0x007b, all -> 0x0077 }
            if (r6 == 0) goto L_0x0065
            java.io.BufferedOutputStream r6 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x007b, all -> 0x0077 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x007b, all -> 0x0077 }
            r5 = 1
            r4.<init>(r3, r5)     // Catch:{ IOException -> 0x007b, all -> 0x0077 }
            r6.<init>(r4)     // Catch:{ IOException -> 0x007b, all -> 0x0077 }
            int r0 = r7.length     // Catch:{ IOException -> 0x0063, all -> 0x0061 }
            byte[] r0 = com.xiaomi.push.z.a((int) r0)     // Catch:{ IOException -> 0x0063, all -> 0x0061 }
            r6.write(r0)     // Catch:{ IOException -> 0x0063, all -> 0x0061 }
            r6.write(r7)     // Catch:{ IOException -> 0x0063, all -> 0x0061 }
            r6.flush()     // Catch:{ IOException -> 0x0063, all -> 0x0061 }
            r4 = 0
            r3.setLastModified(r4)     // Catch:{ IOException -> 0x0063, all -> 0x0061 }
            r0 = r6
            goto L_0x0065
        L_0x0061:
            r7 = move-exception
            goto L_0x0079
        L_0x0063:
            r7 = move-exception
            goto L_0x007d
        L_0x0065:
            if (r1 == 0) goto L_0x0070
            boolean r6 = r1.isValid()     // Catch:{ all -> 0x00a0 }
            if (r6 == 0) goto L_0x0070
            r1.release()     // Catch:{ IOException -> 0x0070 }
        L_0x0070:
            com.xiaomi.push.x.a((java.io.Closeable) r0)     // Catch:{ all -> 0x00a0 }
        L_0x0073:
            com.xiaomi.push.x.a((java.io.Closeable) r2)     // Catch:{ all -> 0x00a0 }
            goto L_0x009e
        L_0x0077:
            r7 = move-exception
            r6 = r0
        L_0x0079:
            r0 = r1
            goto L_0x00a3
        L_0x007b:
            r7 = move-exception
            r6 = r0
        L_0x007d:
            r0 = r1
            goto L_0x008c
        L_0x007f:
            r7 = move-exception
            r6 = r0
            goto L_0x00a3
        L_0x0082:
            r7 = move-exception
            r6 = r0
            goto L_0x008c
        L_0x0085:
            r7 = move-exception
            r6 = r0
            r2 = r6
            goto L_0x00a3
        L_0x0089:
            r7 = move-exception
            r6 = r0
            r2 = r6
        L_0x008c:
            r7.printStackTrace()     // Catch:{ all -> 0x00a2 }
            if (r0 == 0) goto L_0x009a
            boolean r7 = r0.isValid()     // Catch:{ all -> 0x00a0 }
            if (r7 == 0) goto L_0x009a
            r0.release()     // Catch:{ IOException -> 0x009a }
        L_0x009a:
            com.xiaomi.push.x.a((java.io.Closeable) r6)     // Catch:{ all -> 0x00a0 }
            goto L_0x0073
        L_0x009e:
            monitor-exit(r8)     // Catch:{ all -> 0x00a0 }
            return
        L_0x00a0:
            r6 = move-exception
            goto L_0x00b5
        L_0x00a2:
            r7 = move-exception
        L_0x00a3:
            if (r0 == 0) goto L_0x00ae
            boolean r1 = r0.isValid()     // Catch:{ all -> 0x00a0 }
            if (r1 == 0) goto L_0x00ae
            r0.release()     // Catch:{ IOException -> 0x00ae }
        L_0x00ae:
            com.xiaomi.push.x.a((java.io.Closeable) r6)     // Catch:{ all -> 0x00a0 }
            com.xiaomi.push.x.a((java.io.Closeable) r2)     // Catch:{ all -> 0x00a0 }
            throw r7     // Catch:{ all -> 0x00a0 }
        L_0x00b5:
            monitor-exit(r8)     // Catch:{ all -> 0x00a0 }
            throw r6
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dm.a(android.content.Context, com.xiaomi.push.go, java.lang.String):void");
    }
}
