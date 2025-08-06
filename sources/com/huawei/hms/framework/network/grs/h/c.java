package com.huawei.hms.framework.network.grs.h;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f38092a = "c";

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        com.huawei.hms.framework.common.Logger.w(f38092a, "local config file is not exist.filename is {%s}", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006e, code lost:
        com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.OutputStream) r2);
        com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0074, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0061 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r6, android.content.Context r7) {
        /*
            java.lang.String r0 = f38092a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Io getConfigContent, fileName: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            com.huawei.hms.framework.common.Logger.d(r0, r1)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x001f
            return r1
        L_0x001f:
            r0 = 0
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x0061 }
            r4.<init>(r6)     // Catch:{ IOException -> 0x0061 }
            boolean r4 = r4.isDirectory()     // Catch:{ IOException -> 0x0061 }
            if (r4 == 0) goto L_0x0038
        L_0x0031:
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.OutputStream) r2)
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r0)
            return r1
        L_0x0038:
            android.content.res.AssetManager r7 = r7.getAssets()     // Catch:{ IOException -> 0x0061 }
            java.io.InputStream r0 = r7.open(r6)     // Catch:{ IOException -> 0x0061 }
            r7 = 8192(0x2000, float:1.14794E-41)
            byte[] r7 = new byte[r7]     // Catch:{ IOException -> 0x0061 }
        L_0x0044:
            int r4 = r0.read(r7)     // Catch:{ IOException -> 0x0061 }
            r5 = -1
            if (r4 == r5) goto L_0x004f
            r2.write(r7, r3, r4)     // Catch:{ IOException -> 0x0061 }
            goto L_0x0044
        L_0x004f:
            r2.flush()     // Catch:{ IOException -> 0x0061 }
            java.lang.String r7 = "UTF-8"
            java.lang.String r6 = r2.toString(r7)     // Catch:{ IOException -> 0x0061 }
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.OutputStream) r2)
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r0)
            return r6
        L_0x005f:
            r6 = move-exception
            goto L_0x006e
        L_0x0061:
            java.lang.String r7 = f38092a     // Catch:{ all -> 0x005f }
            java.lang.String r4 = "local config file is not exist.filename is {%s}"
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x005f }
            r5[r3] = r6     // Catch:{ all -> 0x005f }
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r7, (java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ all -> 0x005f }
            goto L_0x0031
        L_0x006e:
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.OutputStream) r2)
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.h.c.a(java.lang.String, android.content.Context):java.lang.String");
    }
}
