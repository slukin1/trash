package com.alibaba.verificationsdk.utils;

public class FileUtil {
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0036 A[SYNTHETIC, Splitter:B:20:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0041 A[SYNTHETIC, Splitter:B:27:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x004e A[SYNTHETIC, Splitter:B:34:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005a A[SYNTHETIC, Splitter:B:41:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0031=Splitter:B:17:0x0031, B:24:0x003c=Splitter:B:24:0x003c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readStringFromFile(java.io.File r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L_0x0057
            boolean r1 = r4.exists()     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x002f, all -> 0x002d }
            if (r1 == 0) goto L_0x0057
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x002f, all -> 0x002d }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x002f, all -> 0x002d }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x002f, all -> 0x002d }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x002f, all -> 0x002d }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x002f, all -> 0x002d }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x002f, all -> 0x002d }
        L_0x0018:
            java.lang.String r4 = r2.readLine()     // Catch:{ FileNotFoundException -> 0x002b, IOException -> 0x0029 }
            if (r4 == 0) goto L_0x0022
            r1.append(r4)     // Catch:{ FileNotFoundException -> 0x002b, IOException -> 0x0029 }
            goto L_0x0018
        L_0x0022:
            java.lang.String r0 = r1.toString()     // Catch:{ FileNotFoundException -> 0x002b, IOException -> 0x0029 }
            r4 = r0
            r0 = r2
            goto L_0x0058
        L_0x0029:
            r4 = move-exception
            goto L_0x0031
        L_0x002b:
            r4 = move-exception
            goto L_0x003c
        L_0x002d:
            r4 = move-exception
            goto L_0x004c
        L_0x002f:
            r4 = move-exception
            r2 = r0
        L_0x0031:
            r4.printStackTrace()     // Catch:{ all -> 0x004a }
            if (r2 == 0) goto L_0x0063
            r2.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0063
        L_0x003a:
            r4 = move-exception
            r2 = r0
        L_0x003c:
            r4.printStackTrace()     // Catch:{ all -> 0x004a }
            if (r2 == 0) goto L_0x0063
            r2.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0063
        L_0x0045:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x0063
        L_0x004a:
            r4 = move-exception
            r0 = r2
        L_0x004c:
            if (r0 == 0) goto L_0x0056
            r0.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0056:
            throw r4
        L_0x0057:
            r4 = r0
        L_0x0058:
            if (r0 == 0) goto L_0x0062
            r0.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0062
        L_0x005e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0062:
            r0 = r4
        L_0x0063:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.verificationsdk.utils.FileUtil.readStringFromFile(java.io.File):java.lang.String");
    }
}
