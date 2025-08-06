package com.hbg.module.libkt.helper.s3;

public final class S3UploadHelperKt {
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0052, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        kotlin.io.b.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0056, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0059, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        kotlin.io.b.a(r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005d, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.io.File toFile(android.net.Uri r5, android.content.Context r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 24
            if (r0 >= r2) goto L_0x0014
            java.io.File r6 = new java.io.File
            java.lang.String r5 = r5.getPath()
            if (r5 != 0) goto L_0x0010
            return r1
        L_0x0010:
            r6.<init>(r5)
            goto L_0x0068
        L_0x0014:
            java.io.File r0 = r6.getCacheDir()     // Catch:{ all -> 0x0063 }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0063 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0063 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0063 }
            r3.<init>(r0, r2)     // Catch:{ all -> 0x0063 }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ all -> 0x0060 }
            java.io.InputStream r5 = r6.openInputStream(r5)     // Catch:{ all -> 0x0060 }
            if (r5 == 0) goto L_0x005e
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x0057 }
            r6.<init>(r3)     // Catch:{ all -> 0x0057 }
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0050 }
        L_0x0038:
            int r2 = r5.read(r0)     // Catch:{ all -> 0x0050 }
            r4 = -1
            if (r2 == r4) goto L_0x0044
            r4 = 0
            r6.write(r0, r4, r2)     // Catch:{ all -> 0x0050 }
            goto L_0x0038
        L_0x0044:
            r6.flush()     // Catch:{ all -> 0x0050 }
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0050 }
            kotlin.io.b.a(r6, r1)     // Catch:{ all -> 0x0057 }
            kotlin.io.b.a(r5, r1)     // Catch:{ all -> 0x0060 }
            goto L_0x005e
        L_0x0050:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r1 = move-exception
            kotlin.io.b.a(r6, r0)     // Catch:{ all -> 0x0057 }
            throw r1     // Catch:{ all -> 0x0057 }
        L_0x0057:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r0 = move-exception
            kotlin.io.b.a(r5, r6)     // Catch:{ all -> 0x0060 }
            throw r0     // Catch:{ all -> 0x0060 }
        L_0x005e:
            r6 = r3
            goto L_0x0068
        L_0x0060:
            r5 = move-exception
            r1 = r3
            goto L_0x0064
        L_0x0063:
            r5 = move-exception
        L_0x0064:
            r5.printStackTrace()
            r6 = r1
        L_0x0068:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.libkt.helper.s3.S3UploadHelperKt.toFile(android.net.Uri, android.content.Context):java.io.File");
    }
}
