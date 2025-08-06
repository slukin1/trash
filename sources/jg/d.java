package jg;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40537a = "SecureX509SingleInstance";

    /* renamed from: b  reason: collision with root package name */
    public static volatile e f40538b;

    /* JADX WARNING: Can't wrap try/catch for region: R(2:10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        com.huawei.secure.android.common.ssl.util.e.d(f40537a, "get files bks error");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001d */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static jg.e a(android.content.Context r6) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.security.KeyStoreException, java.io.IOException {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.String r2 = "context is null"
            java.util.Objects.requireNonNull(r6, r2)
            com.huawei.secure.android.common.ssl.util.ContextUtil.b(r6)
            jg.e r2 = f40538b
            if (r2 != 0) goto L_0x004d
            java.lang.Class<jg.d> r2 = jg.d.class
            monitor-enter(r2)
            jg.e r3 = f40538b     // Catch:{ all -> 0x004a }
            if (r3 != 0) goto L_0x0048
            r3 = 0
            java.io.InputStream r3 = lg.a.n(r6)     // Catch:{ RuntimeException -> 0x001d }
            goto L_0x0024
        L_0x001d:
            java.lang.String r4 = f40537a     // Catch:{ all -> 0x004a }
            java.lang.String r5 = "get files bks error"
            com.huawei.secure.android.common.ssl.util.e.d(r4, r5)     // Catch:{ all -> 0x004a }
        L_0x0024:
            if (r3 != 0) goto L_0x0038
            java.lang.String r3 = f40537a     // Catch:{ all -> 0x004a }
            java.lang.String r4 = "get assets bks"
            com.huawei.secure.android.common.ssl.util.e.e(r3, r4)     // Catch:{ all -> 0x004a }
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ all -> 0x004a }
            java.lang.String r3 = "hmsrootcas.bks"
            java.io.InputStream r3 = r6.open(r3)     // Catch:{ all -> 0x004a }
            goto L_0x003f
        L_0x0038:
            java.lang.String r6 = f40537a     // Catch:{ all -> 0x004a }
            java.lang.String r4 = "get files bks"
            com.huawei.secure.android.common.ssl.util.e.e(r6, r4)     // Catch:{ all -> 0x004a }
        L_0x003f:
            jg.e r6 = new jg.e     // Catch:{ all -> 0x004a }
            java.lang.String r4 = ""
            r6.<init>(r3, r4)     // Catch:{ all -> 0x004a }
            f40538b = r6     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r2)     // Catch:{ all -> 0x004a }
            goto L_0x004d
        L_0x004a:
            r6 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004a }
            throw r6
        L_0x004d:
            java.lang.String r6 = f40537a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "SecureX509TrustManager getInstance: cost : "
            r2.append(r3)
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r0
            r2.append(r3)
            java.lang.String r0 = " ms"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.huawei.secure.android.common.ssl.util.e.b(r6, r0)
            jg.e r6 = f40538b
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: jg.d.a(android.content.Context):jg.e");
    }
}
