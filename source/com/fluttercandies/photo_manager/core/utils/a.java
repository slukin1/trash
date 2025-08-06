package com.fluttercandies.photo_manager.core.utils;

import android.os.Build;
import android.os.Environment;
import java.io.File;

public final class a {
    public static final void a(String str) {
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        kotlin.io.b.a(r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int b(java.io.InputStream r2) {
        /*
            r0 = 0
            m1.a r1 = new m1.a     // Catch:{ all -> 0x000e }
            r1.<init>((java.io.InputStream) r2)     // Catch:{ all -> 0x000e }
            int r1 = r1.s()     // Catch:{ all -> 0x000e }
            kotlin.io.b.a(r2, r0)     // Catch:{ all -> 0x0015 }
            goto L_0x0016
        L_0x000e:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0010 }
        L_0x0010:
            r1 = move-exception
            kotlin.io.b.a(r2, r0)     // Catch:{ all -> 0x0015 }
            throw r1     // Catch:{ all -> 0x0015 }
        L_0x0015:
            r1 = 0
        L_0x0016:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.utils.a.b(java.io.InputStream):int");
    }

    public static final boolean c() {
        return Build.VERSION.SDK_INT == 29 && Environment.isExternalStorageLegacy();
    }
}
