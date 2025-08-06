package com.jumio.core.network;

import kotlin.jvm.internal.r;

public final class ByteArrayDownloadTask extends DownloadTask<byte[]> {
    public ByteArrayDownloadTask(String str, int i11) {
        super(str, i11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ByteArrayDownloadTask(String str, int i11, int i12, r rVar) {
        this(str, (i12 & 2) != 0 ? 0 : i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0042 A[SYNTHETIC, Splitter:B:24:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004c A[SYNTHETIC, Splitter:B:29:0x004c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] processInputStream(java.io.InputStream r9, int r10) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "ByteArrayDownloadTask"
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ all -> 0x003e }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x003e }
            r3.<init>()     // Catch:{ all -> 0x003e }
            r4 = 0
            r5 = r4
        L_0x000f:
            int r6 = r9.read(r2)     // Catch:{ all -> 0x003c }
            if (r6 <= 0) goto L_0x0027
            r3.write(r2, r4, r6)     // Catch:{ all -> 0x003c }
            int r5 = r5 + r6
            com.jumio.core.network.DownloadTask$ProgressListener r6 = r8.getProgressListener()     // Catch:{ all -> 0x003c }
            if (r6 == 0) goto L_0x000f
            int r7 = r5 * 100
            int r7 = r7 / r10
            float r7 = (float) r7     // Catch:{ all -> 0x003c }
            r6.onProgressUpdate(r7)     // Catch:{ all -> 0x003c }
            goto L_0x000f
        L_0x0027:
            byte[] r10 = r3.toByteArray()     // Catch:{ all -> 0x003c }
            r3.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x0033
        L_0x002f:
            r2 = move-exception
            com.jumio.commons.log.Log.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r2)
        L_0x0033:
            r9.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r9 = move-exception
            com.jumio.commons.log.Log.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r9)
        L_0x003b:
            return r10
        L_0x003c:
            r10 = move-exception
            goto L_0x0040
        L_0x003e:
            r10 = move-exception
            r3 = 0
        L_0x0040:
            if (r3 == 0) goto L_0x004a
            r3.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r2 = move-exception
            com.jumio.commons.log.Log.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r2)
        L_0x004a:
            if (r9 == 0) goto L_0x0054
            r9.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r9 = move-exception
            com.jumio.commons.log.Log.e((java.lang.String) r1, (java.lang.String) r0, (java.lang.Throwable) r9)
        L_0x0054:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.network.ByteArrayDownloadTask.processInputStream(java.io.InputStream, int):byte[]");
    }
}
