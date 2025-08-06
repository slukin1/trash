package com.mob.tools.utils;

import com.mob.commons.v;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLocker implements PublicMemberKeeper {

    /* renamed from: a  reason: collision with root package name */
    private FileOutputStream f28052a;

    /* renamed from: b  reason: collision with root package name */
    private FileLock f28053b;

    /* renamed from: c  reason: collision with root package name */
    private FileChannel f28054c;

    private boolean a(boolean z11) throws Throwable {
        if (z11) {
            this.f28053b = this.f28054c.lock();
        } else {
            this.f28053b = this.f28054c.tryLock();
        }
        return this.f28053b != null;
    }

    public synchronized boolean lock(boolean z11) {
        return lock(z11, z11 ? 1000 : 500, 16);
    }

    public synchronized void release() {
        if (this.f28052a != null) {
            unlock();
            v.a(this.f28054c, this.f28052a);
            this.f28054c = null;
            this.f28052a = null;
        }
    }

    public synchronized void setLockFile(String str) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            this.f28052a = fileOutputStream;
            this.f28054c = fileOutputStream.getChannel();
        } catch (Throwable unused) {
            v.a(this.f28054c, this.f28052a);
        }
        return;
    }

    public synchronized void unlock() {
        FileLock fileLock = this.f28053b;
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (Throwable unused) {
            }
            this.f28053b = null;
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0029 */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0068 A[SYNTHETIC, Splitter:B:47:0x0068] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean lock(boolean r9, long r10, long r12) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.io.FileOutputStream r0 = r8.f28052a     // Catch:{ all -> 0x007f }
            r1 = 0
            if (r0 != 0) goto L_0x0008
            monitor-exit(r8)
            return r1
        L_0x0008:
            boolean r9 = r8.a(r9)     // Catch:{ all -> 0x000e }
            monitor-exit(r8)
            return r9
        L_0x000e:
            r0 = move-exception
            r2 = 0
            int r4 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x005d
            boolean r4 = r0 instanceof java.nio.channels.OverlappingFileLockException     // Catch:{ all -> 0x007f }
            if (r4 != 0) goto L_0x001d
            boolean r4 = r0 instanceof java.io.IOException     // Catch:{ all -> 0x007f }
            if (r4 == 0) goto L_0x005d
        L_0x001d:
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x007f }
            long r4 = r4 + r10
        L_0x0022:
            int r6 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r6 <= 0) goto L_0x0056
            java.lang.Thread.sleep(r12)     // Catch:{ all -> 0x0029 }
        L_0x0029:
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0034 }
            long r10 = r4 - r10
            boolean r9 = r8.a(r9)     // Catch:{ all -> 0x0034 }
            goto L_0x0057
        L_0x0034:
            r6 = move-exception
            boolean r7 = r6 instanceof java.nio.channels.OverlappingFileLockException     // Catch:{ all -> 0x007f }
            if (r7 != 0) goto L_0x0048
            boolean r6 = r6 instanceof java.io.IOException     // Catch:{ all -> 0x007f }
            if (r6 == 0) goto L_0x003e
            goto L_0x0048
        L_0x003e:
            com.mob.tools.log.NLog r10 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x007f }
            r10.w((java.lang.Throwable) r0)     // Catch:{ all -> 0x007f }
            r10 = -1
            goto L_0x0022
        L_0x0048:
            int r6 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r6 > 0) goto L_0x0022
            com.mob.tools.log.NLog r6 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x007f }
            java.lang.String r7 = "OverlappingFileLockException or IOExcept timeout"
            r6.w((java.lang.String) r7)     // Catch:{ all -> 0x007f }
            goto L_0x0022
        L_0x0056:
            r9 = r1
        L_0x0057:
            int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r10 <= 0) goto L_0x0064
            monitor-exit(r8)
            return r9
        L_0x005d:
            com.mob.tools.log.NLog r9 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x007f }
            r9.w((java.lang.Throwable) r0)     // Catch:{ all -> 0x007f }
        L_0x0064:
            java.nio.channels.FileLock r9 = r8.f28053b     // Catch:{ all -> 0x007f }
            if (r9 == 0) goto L_0x006e
            r9.release()     // Catch:{ all -> 0x006b }
        L_0x006b:
            r9 = 0
            r8.f28053b = r9     // Catch:{ all -> 0x007f }
        L_0x006e:
            r9 = 2
            java.io.Closeable[] r9 = new java.io.Closeable[r9]     // Catch:{ all -> 0x007f }
            java.nio.channels.FileChannel r10 = r8.f28054c     // Catch:{ all -> 0x007f }
            r9[r1] = r10     // Catch:{ all -> 0x007f }
            r10 = 1
            java.io.FileOutputStream r11 = r8.f28052a     // Catch:{ all -> 0x007f }
            r9[r10] = r11     // Catch:{ all -> 0x007f }
            com.mob.commons.v.a((java.io.Closeable[]) r9)     // Catch:{ all -> 0x007f }
            monitor-exit(r8)
            return r1
        L_0x007f:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.FileLocker.lock(boolean, long, long):boolean");
    }

    public synchronized void lock(Runnable runnable, boolean z11) {
        if (lock(z11) && runnable != null) {
            runnable.run();
        }
    }
}
