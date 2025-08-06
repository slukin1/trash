package uy;

import com.ta.a.e.h;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import ty.d;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static File f40594a;

    /* renamed from: b  reason: collision with root package name */
    public static FileChannel f40595b;

    /* renamed from: c  reason: collision with root package name */
    public static FileLock f40596c;

    /* renamed from: d  reason: collision with root package name */
    public static File f40597d;

    /* renamed from: e  reason: collision with root package name */
    public static FileChannel f40598e;

    /* renamed from: f  reason: collision with root package name */
    public static FileLock f40599f;

    public static synchronized boolean a() {
        synchronized (e.class) {
            h.i();
            if (f40597d == null) {
                f40597d = new File(d.i());
            }
            if (!f40597d.exists()) {
                try {
                    f40597d.createNewFile();
                } catch (Exception unused) {
                    return false;
                }
            }
            if (f40598e == null) {
                try {
                    f40598e = new RandomAccessFile(f40597d, "rw").getChannel();
                } catch (Exception unused2) {
                    return false;
                }
            }
            try {
                FileLock tryLock = f40598e.tryLock();
                if (tryLock != null) {
                    f40599f = tryLock;
                    return true;
                }
            } catch (Throwable unused3) {
            }
        }
        return false;
    }

    public static synchronized void b() {
        synchronized (e.class) {
            h.i();
            if (f40594a == null) {
                f40594a = new File(d.g());
            }
            if (!f40594a.exists()) {
                try {
                    f40594a.createNewFile();
                } catch (Exception unused) {
                    return;
                }
            }
            if (f40595b == null) {
                try {
                    f40595b = new RandomAccessFile(f40594a, "rw").getChannel();
                } catch (Exception unused2) {
                    return;
                }
            }
            try {
                f40596c = f40595b.lock();
            } catch (Throwable unused3) {
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x001c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void c() {
        /*
            java.lang.Class<uy.e> r0 = uy.e.class
            monitor-enter(r0)
            com.ta.a.e.h.i()     // Catch:{ all -> 0x0025 }
            java.nio.channels.FileLock r1 = f40596c     // Catch:{ all -> 0x0025 }
            r2 = 0
            if (r1 == 0) goto L_0x0015
            r1.release()     // Catch:{ Exception -> 0x000e, all -> 0x0011 }
        L_0x000e:
            f40596c = r2     // Catch:{ all -> 0x0025 }
            goto L_0x0015
        L_0x0011:
            r1 = move-exception
            f40596c = r2     // Catch:{ all -> 0x0025 }
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x0015:
            java.nio.channels.FileChannel r1 = f40595b     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0023
            r1.close()     // Catch:{ Exception -> 0x001c, all -> 0x001f }
        L_0x001c:
            f40595b = r2     // Catch:{ all -> 0x0025 }
            goto L_0x0023
        L_0x001f:
            r1 = move-exception
            f40595b = r2     // Catch:{ all -> 0x0025 }
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r0)
            return
        L_0x0025:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: uy.e.c():void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x001c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void d() {
        /*
            java.lang.Class<uy.e> r0 = uy.e.class
            monitor-enter(r0)
            com.ta.a.e.h.i()     // Catch:{ all -> 0x0025 }
            java.nio.channels.FileLock r1 = f40599f     // Catch:{ all -> 0x0025 }
            r2 = 0
            if (r1 == 0) goto L_0x0015
            r1.release()     // Catch:{ Exception -> 0x000e, all -> 0x0011 }
        L_0x000e:
            f40599f = r2     // Catch:{ all -> 0x0025 }
            goto L_0x0015
        L_0x0011:
            r1 = move-exception
            f40599f = r2     // Catch:{ all -> 0x0025 }
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x0015:
            java.nio.channels.FileChannel r1 = f40598e     // Catch:{ all -> 0x0025 }
            if (r1 == 0) goto L_0x0023
            r1.close()     // Catch:{ Exception -> 0x001c, all -> 0x001f }
        L_0x001c:
            f40598e = r2     // Catch:{ all -> 0x0025 }
            goto L_0x0023
        L_0x001f:
            r1 = move-exception
            f40598e = r2     // Catch:{ all -> 0x0025 }
            throw r1     // Catch:{ all -> 0x0025 }
        L_0x0023:
            monitor-exit(r0)
            return
        L_0x0025:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: uy.e.d():void");
    }
}
