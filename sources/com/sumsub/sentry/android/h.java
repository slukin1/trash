package com.sumsub.sentry.android;

import android.content.Context;
import android.content.pm.PackageManager;
import com.sumsub.sns.internal.log.c;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;

public final class h {

    /* renamed from: f  reason: collision with root package name */
    public static final a f30281f = new a((r) null);

    /* renamed from: g  reason: collision with root package name */
    public static final Charset f30282g = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    public final Context f30283a;

    /* renamed from: b  reason: collision with root package name */
    public final a f30284b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f30285c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f30286d;

    /* renamed from: e  reason: collision with root package name */
    public final Runtime f30287e;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public h(Context context, a aVar, String[] strArr, String[] strArr2, Runtime runtime) {
        this.f30283a = context;
        this.f30284b = aVar;
        this.f30285c = strArr;
        this.f30286d = strArr2;
        this.f30287e = runtime;
    }

    public final boolean a() {
        String[] strArr = this.f30285c;
        int length = strArr.length;
        int i11 = 0;
        while (i11 < length) {
            String str = strArr[i11];
            try {
                if (new File(str).exists()) {
                    return true;
                }
                i11++;
            } catch (RuntimeException e11) {
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                String a11 = c.a(this);
                d0 d0Var = d0.f56774a;
                aVar.e(a11, String.format("Error when trying to check if root file %s exists.", Arrays.copyOf(new Object[]{str}, 1)), e11);
            }
        }
        return false;
    }

    public final boolean b() {
        PackageManager packageManager = this.f30283a.getPackageManager();
        if (packageManager != null) {
            String[] strArr = this.f30286d;
            int length = strArr.length;
            int i11 = 0;
            while (i11 < length) {
                try {
                    packageManager.getPackageInfo(strArr[i11], 0);
                    return true;
                } catch (PackageManager.NameNotFoundException unused) {
                    i11++;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        kotlin.io.b.a(r3, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0036, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004a, code lost:
        if (r0 != null) goto L_0x0057;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c() {
        /*
            r8 = this;
            java.lang.String r0 = "/system/xbin/which"
            java.lang.String r1 = "su"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            r1 = 0
            r2 = 0
            java.lang.Runtime r3 = r8.f30287e     // Catch:{ IOException -> 0x0054, all -> 0x003b }
            java.lang.Process r0 = r3.exec(r0)     // Catch:{ IOException -> 0x0054, all -> 0x003b }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            java.io.InputStream r5 = r0.getInputStream()     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            java.nio.charset.Charset r6 = f30282g     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            r4.<init>(r5, r6)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            java.lang.String r4 = r3.readLine()     // Catch:{ all -> 0x0030 }
            if (r4 == 0) goto L_0x0028
            r4 = 1
            goto L_0x0029
        L_0x0028:
            r4 = r1
        L_0x0029:
            kotlin.io.b.a(r3, r2)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            r0.destroy()
            return r4
        L_0x0030:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0032 }
        L_0x0032:
            r4 = move-exception
            kotlin.io.b.a(r3, r2)     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            throw r4     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
        L_0x0037:
            r2 = move-exception
            goto L_0x003f
        L_0x0039:
            r2 = r0
            goto L_0x0054
        L_0x003b:
            r0 = move-exception
            r7 = r2
            r2 = r0
            r0 = r7
        L_0x003f:
            com.sumsub.sns.internal.log.a r3 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ all -> 0x004d }
            java.lang.String r4 = com.sumsub.sns.internal.log.c.a(r8)     // Catch:{ all -> 0x004d }
            java.lang.String r5 = "Error when trying to check if SU exists."
            r3.e(r4, r5, r2)     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x005a
            goto L_0x0057
        L_0x004d:
            r1 = move-exception
            if (r0 == 0) goto L_0x0053
            r0.destroy()
        L_0x0053:
            throw r1
        L_0x0054:
            if (r2 == 0) goto L_0x005a
            r0 = r2
        L_0x0057:
            r0.destroy()
        L_0x005a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.android.h.c():boolean");
    }

    public final boolean d() {
        String a11 = this.f30284b.a();
        if (a11 == null || !StringsKt__StringsKt.R(a11, "test-keys", false, 2, (Object) null)) {
            return false;
        }
        return true;
    }

    public final boolean e() {
        return d() || a() || c() || b();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ h(android.content.Context r15, com.sumsub.sentry.android.a r16, java.lang.String[] r17, java.lang.String[] r18, java.lang.Runtime r19, int r20, kotlin.jvm.internal.r r21) {
        /*
            r14 = this;
            r0 = r20 & 2
            if (r0 == 0) goto L_0x000a
            com.sumsub.sentry.android.a r0 = new com.sumsub.sentry.android.a
            r0.<init>()
            goto L_0x000c
        L_0x000a:
            r0 = r16
        L_0x000c:
            r1 = r20 & 4
            if (r1 == 0) goto L_0x002d
            java.lang.String r2 = "/system/app/Superuser.apk"
            java.lang.String r3 = "/sbin/su"
            java.lang.String r4 = "/system/bin/su"
            java.lang.String r5 = "/system/xbin/su"
            java.lang.String r6 = "/data/local/xbin/su"
            java.lang.String r7 = "/data/local/bin/su"
            java.lang.String r8 = "/system/sd/xbin/su"
            java.lang.String r9 = "/system/bin/failsafe/su"
            java.lang.String r10 = "/data/local/su"
            java.lang.String r11 = "/su/bin/su"
            java.lang.String r12 = "/su/bin"
            java.lang.String r13 = "/system/xbin/daemonsu"
            java.lang.String[] r1 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13}
            goto L_0x002f
        L_0x002d:
            r1 = r17
        L_0x002f:
            r2 = r20 & 8
            if (r2 == 0) goto L_0x0044
            java.lang.String r3 = "com.devadvance.rootcloak"
            java.lang.String r4 = "com.devadvance.rootcloakplus"
            java.lang.String r5 = "com.koushikdutta.superuser"
            java.lang.String r6 = "com.thirdparty.superuser"
            java.lang.String r7 = "eu.chainfire.supersu"
            java.lang.String r8 = "com.noshufou.android.su"
            java.lang.String[] r2 = new java.lang.String[]{r3, r4, r5, r6, r7, r8}
            goto L_0x0046
        L_0x0044:
            r2 = r18
        L_0x0046:
            r3 = r20 & 16
            if (r3 == 0) goto L_0x004f
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()
            goto L_0x0051
        L_0x004f:
            r3 = r19
        L_0x0051:
            r16 = r14
            r17 = r15
            r18 = r0
            r19 = r1
            r20 = r2
            r21 = r3
            r16.<init>(r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.android.h.<init>(android.content.Context, com.sumsub.sentry.android.a, java.lang.String[], java.lang.String[], java.lang.Runtime, int, kotlin.jvm.internal.r):void");
    }
}
