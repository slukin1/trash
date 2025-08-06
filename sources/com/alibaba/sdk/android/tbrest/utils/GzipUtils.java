package com.alibaba.sdk.android.tbrest.utils;

public class GzipUtils {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: byte[]} */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: type inference failed for: r0v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0040 A[SYNTHETIC, Splitter:B:29:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x004a A[SYNTHETIC, Splitter:B:34:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0052 A[SYNTHETIC, Splitter:B:40:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x005c A[SYNTHETIC, Splitter:B:45:0x005c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] a(byte[] r4) {
        /*
            if (r4 == 0) goto L_0x0065
            int r0 = r4.length
            if (r0 != 0) goto L_0x0007
            goto L_0x0065
        L_0x0007:
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            r1.<init>()     // Catch:{ Exception -> 0x0038, all -> 0x0035 }
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ Exception -> 0x0032, all -> 0x0030 }
            int r3 = r4.length     // Catch:{ Exception -> 0x0032, all -> 0x0030 }
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x0032, all -> 0x0030 }
            r2.write(r4)     // Catch:{ Exception -> 0x002e }
            r2.finish()     // Catch:{ Exception -> 0x002e }
            byte[] r0 = r1.toByteArray()     // Catch:{ Exception -> 0x002e }
            r2.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0025:
            r1.close()     // Catch:{ IOException -> 0x0029 }
            goto L_0x004d
        L_0x0029:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x004d
        L_0x002e:
            r4 = move-exception
            goto L_0x003b
        L_0x0030:
            r4 = move-exception
            goto L_0x0050
        L_0x0032:
            r4 = move-exception
            r2 = r0
            goto L_0x003b
        L_0x0035:
            r4 = move-exception
            r1 = r0
            goto L_0x0050
        L_0x0038:
            r4 = move-exception
            r1 = r0
            r2 = r1
        L_0x003b:
            r4.printStackTrace()     // Catch:{ all -> 0x004e }
            if (r2 == 0) goto L_0x0048
            r2.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0048:
            if (r1 == 0) goto L_0x004d
            r1.close()     // Catch:{ IOException -> 0x0029 }
        L_0x004d:
            return r0
        L_0x004e:
            r4 = move-exception
            r0 = r2
        L_0x0050:
            if (r0 == 0) goto L_0x005a
            r0.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r0 = move-exception
            r0.printStackTrace()
        L_0x005a:
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0064
        L_0x0060:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0064:
            throw r4
        L_0x0065:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.tbrest.utils.GzipUtils.a(byte[]):byte[]");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v8, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x005f A[SYNTHETIC, Splitter:B:43:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0069 A[SYNTHETIC, Splitter:B:48:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0073 A[SYNTHETIC, Splitter:B:53:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x007a A[SYNTHETIC, Splitter:B:58:0x007a] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0084 A[SYNTHETIC, Splitter:B:63:0x0084] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x008e A[SYNTHETIC, Splitter:B:68:0x008e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] b(byte[] r8) {
        /*
            r0 = 0
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            r1.<init>(r8)     // Catch:{ Exception -> 0x0056, all -> 0x0050 }
            java.util.zip.GZIPInputStream r8 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r2]     // Catch:{ Exception -> 0x0046, all -> 0x0042 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0046, all -> 0x0042 }
            r4.<init>()     // Catch:{ Exception -> 0x0046, all -> 0x0042 }
        L_0x0014:
            r5 = 0
            int r6 = r8.read(r3, r5, r2)     // Catch:{ Exception -> 0x0040 }
            r7 = -1
            if (r6 == r7) goto L_0x0020
            r4.write(r3, r5, r6)     // Catch:{ Exception -> 0x0040 }
            goto L_0x0014
        L_0x0020:
            r4.flush()     // Catch:{ Exception -> 0x0040 }
            byte[] r0 = r4.toByteArray()     // Catch:{ Exception -> 0x0040 }
            r4.close()     // Catch:{ Exception -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r2 = move-exception
            r2.printStackTrace()
        L_0x002f:
            r8.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0037:
            r1.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x0076
        L_0x003b:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x0076
        L_0x0040:
            r2 = move-exception
            goto L_0x005a
        L_0x0042:
            r2 = move-exception
            r4 = r0
            r0 = r2
            goto L_0x0078
        L_0x0046:
            r2 = move-exception
            r4 = r0
            goto L_0x005a
        L_0x0049:
            r8 = move-exception
            r4 = r0
            goto L_0x0053
        L_0x004c:
            r2 = move-exception
            r8 = r0
            r4 = r8
            goto L_0x005a
        L_0x0050:
            r8 = move-exception
            r1 = r0
            r4 = r1
        L_0x0053:
            r0 = r8
            r8 = r4
            goto L_0x0078
        L_0x0056:
            r2 = move-exception
            r8 = r0
            r1 = r8
            r4 = r1
        L_0x005a:
            r2.printStackTrace()     // Catch:{ all -> 0x0077 }
            if (r4 == 0) goto L_0x0067
            r4.close()     // Catch:{ Exception -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0067:
            if (r8 == 0) goto L_0x0071
            r8.close()     // Catch:{ IOException -> 0x006d }
            goto L_0x0071
        L_0x006d:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0071:
            if (r1 == 0) goto L_0x0076
            r1.close()     // Catch:{ IOException -> 0x003b }
        L_0x0076:
            return r0
        L_0x0077:
            r0 = move-exception
        L_0x0078:
            if (r4 == 0) goto L_0x0082
            r4.close()     // Catch:{ Exception -> 0x007e }
            goto L_0x0082
        L_0x007e:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0082:
            if (r8 == 0) goto L_0x008c
            r8.close()     // Catch:{ IOException -> 0x0088 }
            goto L_0x008c
        L_0x0088:
            r8 = move-exception
            r8.printStackTrace()
        L_0x008c:
            if (r1 == 0) goto L_0x0096
            r1.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x0096
        L_0x0092:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0096:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.tbrest.utils.GzipUtils.b(byte[]):byte[]");
    }
}
