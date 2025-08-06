package com.sumsub.sentry;

import kotlin.jvm.internal.r;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final t f30497a = new t();

    /* renamed from: b  reason: collision with root package name */
    public static final String f30498b = "Sentry";

    /* renamed from: c  reason: collision with root package name */
    public static boolean f30499c;

    /* renamed from: d  reason: collision with root package name */
    public static String f30500d;

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.b.a(r2, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r10) {
        /*
            r9 = this;
            boolean r0 = r9.a()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 0
            android.content.res.AssetManager r10 = r10.getAssets()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r1 = "sentry/build_uuid.prop"
            java.io.InputStream r10 = r10.open(r1)     // Catch:{ Exception -> 0x0053 }
            java.nio.charset.Charset r1 = kotlin.text.b.f56908b     // Catch:{ Exception -> 0x0053 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0053 }
            r2.<init>(r10, r1)     // Catch:{ Exception -> 0x0053 }
            r10 = 8192(0x2000, float:1.14794E-41)
            boolean r1 = r2 instanceof java.io.BufferedReader     // Catch:{ Exception -> 0x0053 }
            if (r1 == 0) goto L_0x0022
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2     // Catch:{ Exception -> 0x0053 }
            goto L_0x0028
        L_0x0022:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0053 }
            r1.<init>(r2, r10)     // Catch:{ Exception -> 0x0053 }
            r2 = r1
        L_0x0028:
            java.lang.String r10 = kotlin.io.g.c(r2)     // Catch:{ all -> 0x004c }
            kotlin.io.b.a(r2, r0)     // Catch:{ Exception -> 0x0053 }
            com.sumsub.sns.internal.log.a r3 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ Exception -> 0x0053 }
            java.lang.String r4 = "Sentry"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0053 }
            r1.<init>()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r2 = "SDK build UUID read from assets: "
            r1.append(r2)     // Catch:{ Exception -> 0x0053 }
            r1.append(r10)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r5 = r1.toString()     // Catch:{ Exception -> 0x0053 }
            r6 = 0
            r7 = 4
            r8 = 0
            com.sumsub.log.logger.a.a(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0053 }
            r0 = r10
            goto L_0x005d
        L_0x004c:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x004e }
        L_0x004e:
            r1 = move-exception
            kotlin.io.b.a(r2, r10)     // Catch:{ Exception -> 0x0053 }
            throw r1     // Catch:{ Exception -> 0x0053 }
        L_0x0053:
            r10 = move-exception
            com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r2 = "Sentry"
            java.lang.String r3 = "Failed to read build UUID"
            r1.e(r2, r3, r10)
        L_0x005d:
            f30500d = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.t.a(android.content.Context):void");
    }

    public final void a(z zVar) {
        String str = f30500d;
        if (str != null) {
            f fVar = new f((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Long) null, (String) null, 511, (r) null);
            fVar.a(f.f30328j);
            fVar.b(str);
            zVar.B().a().add(fVar);
        }
    }

    public final boolean a() {
        boolean z11 = f30499c;
        f30499c = true;
        return z11;
    }
}
