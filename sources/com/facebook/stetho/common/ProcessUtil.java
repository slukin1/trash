package com.facebook.stetho.common;

import java.io.FileInputStream;
import java.io.IOException;

public class ProcessUtil {
    private static final int CMDLINE_BUFFER_SIZE = 64;
    private static String sProcessName;
    private static boolean sProcessNameRead;

    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|(3:5|6|7)|8|9|10) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0010 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String getProcessName() {
        /*
            java.lang.Class<com.facebook.stetho.common.ProcessUtil> r0 = com.facebook.stetho.common.ProcessUtil.class
            monitor-enter(r0)
            boolean r1 = sProcessNameRead     // Catch:{ all -> 0x0014 }
            if (r1 != 0) goto L_0x0010
            r1 = 1
            sProcessNameRead = r1     // Catch:{ all -> 0x0014 }
            java.lang.String r1 = readProcessName()     // Catch:{ IOException -> 0x0010 }
            sProcessName = r1     // Catch:{ IOException -> 0x0010 }
        L_0x0010:
            java.lang.String r1 = sProcessName     // Catch:{ all -> 0x0014 }
            monitor-exit(r0)
            return r1
        L_0x0014:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.stetho.common.ProcessUtil.getProcessName():java.lang.String");
    }

    private static int indexOf(byte[] bArr, int i11, int i12, byte b11) {
        for (int i13 = 0; i13 < bArr.length; i13++) {
            if (bArr[i13] == b11) {
                return i13;
            }
        }
        return -1;
    }

    private static String readProcessName() throws IOException {
        byte[] bArr = new byte[64];
        FileInputStream fileInputStream = new FileInputStream("/proc/self/cmdline");
        boolean z11 = false;
        try {
            int read = fileInputStream.read(bArr);
            try {
                int indexOf = indexOf(bArr, 0, read, (byte) 0);
                if (indexOf > 0) {
                    read = indexOf;
                }
                String str = new String(bArr, 0, read);
                Util.close(fileInputStream, false);
                return str;
            } catch (Throwable th2) {
                th = th2;
                z11 = true;
                Util.close(fileInputStream, true ^ z11);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            Util.close(fileInputStream, true ^ z11);
            throw th;
        }
    }
}
