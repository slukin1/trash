package com.blankj.utilcode.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class b0 {
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.io.File r1, java.util.List<java.io.File> r2, java.util.zip.ZipFile r3, java.util.zip.ZipEntry r4, java.lang.String r5) throws java.io.IOException {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r1, r5)
            r2.add(r0)
            boolean r1 = r4.isDirectory()
            if (r1 == 0) goto L_0x0013
            boolean r1 = com.blankj.utilcode.util.a0.b(r0)
            return r1
        L_0x0013:
            boolean r1 = com.blankj.utilcode.util.a0.c(r0)
            r2 = 0
            if (r1 != 0) goto L_0x001b
            return r2
        L_0x001b:
            r1 = 0
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ all -> 0x004b }
            java.io.InputStream r3 = r3.getInputStream(r4)     // Catch:{ all -> 0x004b }
            r5.<init>(r3)     // Catch:{ all -> 0x004b }
            java.io.BufferedOutputStream r3 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0048 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0048 }
            r4.<init>(r0)     // Catch:{ all -> 0x0048 }
            r3.<init>(r4)     // Catch:{ all -> 0x0048 }
            r1 = 8192(0x2000, float:1.14794E-41)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x0046 }
        L_0x0033:
            int r4 = r5.read(r1)     // Catch:{ all -> 0x0046 }
            r0 = -1
            if (r4 == r0) goto L_0x003e
            r3.write(r1, r2, r4)     // Catch:{ all -> 0x0046 }
            goto L_0x0033
        L_0x003e:
            r5.close()
            r3.close()
            r1 = 1
            return r1
        L_0x0046:
            r1 = move-exception
            goto L_0x004f
        L_0x0048:
            r2 = move-exception
            r3 = r1
            goto L_0x004e
        L_0x004b:
            r2 = move-exception
            r3 = r1
            r5 = r3
        L_0x004e:
            r1 = r2
        L_0x004f:
            if (r5 == 0) goto L_0x0054
            r5.close()
        L_0x0054:
            if (r3 == 0) goto L_0x0059
            r3.close()
        L_0x0059:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.b0.a(java.io.File, java.util.List, java.util.zip.ZipFile, java.util.zip.ZipEntry, java.lang.String):boolean");
    }

    public static List<File> b(File file, File file2) throws IOException {
        return c(file, file2, (String) null);
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0060=Splitter:B:17:0x0060, B:7:0x0026=Splitter:B:7:0x0026} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<java.io.File> c(java.io.File r11, java.io.File r12, java.lang.String r13) throws java.io.IOException {
        /*
            if (r11 == 0) goto L_0x00a9
            if (r12 != 0) goto L_0x0006
            goto L_0x00a9
        L_0x0006:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile
            r1.<init>(r11)
            java.util.Enumeration r11 = r1.entries()
            boolean r2 = com.blankj.utilcode.util.a0.C(r13)     // Catch:{ all -> 0x00a4 }
            java.lang.String r3 = " is dangerous!"
            java.lang.String r4 = "entryName: "
            java.lang.String r5 = "ZipUtils"
            java.lang.String r6 = "../"
            java.lang.String r7 = "/"
            java.lang.String r8 = "\\"
            if (r2 == 0) goto L_0x0060
        L_0x0026:
            boolean r13 = r11.hasMoreElements()     // Catch:{ all -> 0x00a4 }
            if (r13 == 0) goto L_0x00a0
            java.lang.Object r13 = r11.nextElement()     // Catch:{ all -> 0x00a4 }
            java.util.zip.ZipEntry r13 = (java.util.zip.ZipEntry) r13     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = r13.getName()     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = r2.replace(r8, r7)     // Catch:{ all -> 0x00a4 }
            boolean r9 = r2.contains(r6)     // Catch:{ all -> 0x00a4 }
            if (r9 == 0) goto L_0x0056
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r13.<init>()     // Catch:{ all -> 0x00a4 }
            r13.append(r4)     // Catch:{ all -> 0x00a4 }
            r13.append(r2)     // Catch:{ all -> 0x00a4 }
            r13.append(r3)     // Catch:{ all -> 0x00a4 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00a4 }
            android.util.Log.e(r5, r13)     // Catch:{ all -> 0x00a4 }
            goto L_0x0026
        L_0x0056:
            boolean r13 = a(r12, r0, r1, r13, r2)     // Catch:{ all -> 0x00a4 }
            if (r13 != 0) goto L_0x0026
            r1.close()
            return r0
        L_0x0060:
            boolean r2 = r11.hasMoreElements()     // Catch:{ all -> 0x00a4 }
            if (r2 == 0) goto L_0x00a0
            java.lang.Object r2 = r11.nextElement()     // Catch:{ all -> 0x00a4 }
            java.util.zip.ZipEntry r2 = (java.util.zip.ZipEntry) r2     // Catch:{ all -> 0x00a4 }
            java.lang.String r9 = r2.getName()     // Catch:{ all -> 0x00a4 }
            java.lang.String r9 = r9.replace(r8, r7)     // Catch:{ all -> 0x00a4 }
            boolean r10 = r9.contains(r6)     // Catch:{ all -> 0x00a4 }
            if (r10 == 0) goto L_0x0090
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r2.<init>()     // Catch:{ all -> 0x00a4 }
            r2.append(r4)     // Catch:{ all -> 0x00a4 }
            r2.append(r9)     // Catch:{ all -> 0x00a4 }
            r2.append(r3)     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00a4 }
            android.util.Log.e(r5, r2)     // Catch:{ all -> 0x00a4 }
            goto L_0x0060
        L_0x0090:
            boolean r10 = r9.contains(r13)     // Catch:{ all -> 0x00a4 }
            if (r10 == 0) goto L_0x0060
            boolean r2 = a(r12, r0, r1, r2, r9)     // Catch:{ all -> 0x00a4 }
            if (r2 != 0) goto L_0x0060
            r1.close()
            return r0
        L_0x00a0:
            r1.close()
            return r0
        L_0x00a4:
            r11 = move-exception
            r1.close()
            throw r11
        L_0x00a9:
            r11 = 0
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.b0.c(java.io.File, java.io.File, java.lang.String):java.util.List");
    }
}
