package org.ejbca.cvc.example;

import java.io.File;
import java.io.IOException;

public final class FileHelper {
    private FileHelper() {
    }

    public static byte[] loadFile(String str) throws IOException {
        return loadFile(new File(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeFile(java.io.File r3, byte[] r4) throws java.io.IOException {
        /*
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0017 }
            r1.<init>(r3)     // Catch:{ all -> 0x0017 }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0017 }
            r2 = 1000(0x3e8, float:1.401E-42)
            r3.<init>(r1, r2)     // Catch:{ all -> 0x0017 }
            r3.write(r4)     // Catch:{ all -> 0x0014 }
            r3.close()
            return
        L_0x0014:
            r4 = move-exception
            r0 = r3
            goto L_0x0018
        L_0x0017:
            r4 = move-exception
        L_0x0018:
            if (r0 == 0) goto L_0x001d
            r0.close()
        L_0x001d:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ejbca.cvc.example.FileHelper.writeFile(java.io.File, byte[]):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0044 A[SYNTHETIC, Splitter:B:22:0x0044] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] loadFile(java.io.File r7) throws java.io.IOException {
        /*
            java.lang.String r0 = "loadFile - error when closing: "
            r1 = 0
            long r2 = r7.length()     // Catch:{ all -> 0x0041 }
            int r2 = (int) r2     // Catch:{ all -> 0x0041 }
            byte[] r3 = new byte[r2]     // Catch:{ all -> 0x0041 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x0041 }
            r4.<init>(r7)     // Catch:{ all -> 0x0041 }
            r7 = 1
            r1 = 0
            r5 = r7
            r6 = r1
        L_0x0013:
            if (r5 == 0) goto L_0x0027
            int r5 = r2 - r6
            int r5 = r4.read(r3, r6, r5)     // Catch:{ all -> 0x0024 }
            int r6 = r6 + r5
            if (r5 <= 0) goto L_0x0022
            if (r6 == r2) goto L_0x0022
            r5 = r7
            goto L_0x0013
        L_0x0022:
            r5 = r1
            goto L_0x0013
        L_0x0024:
            r7 = move-exception
            r1 = r4
            goto L_0x0042
        L_0x0027:
            r4.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x0040
        L_0x002b:
            r7 = move-exception
            java.io.PrintStream r1 = java.lang.System.out
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r1.println(r7)
        L_0x0040:
            return r3
        L_0x0041:
            r7 = move-exception
        L_0x0042:
            if (r1 == 0) goto L_0x005d
            r1.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x005d
        L_0x0048:
            r1 = move-exception
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.println(r0)
        L_0x005d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ejbca.cvc.example.FileHelper.loadFile(java.io.File):byte[]");
    }
}
