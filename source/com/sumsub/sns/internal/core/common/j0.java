package com.sumsub.sns.internal.core.common;

import android.content.Context;
import android.content.pm.PackageManager;
import com.sumsub.sns.internal.log.c;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;

public final class j0 {

    /* renamed from: f  reason: collision with root package name */
    public static final a f32085f = new a((r) null);

    /* renamed from: g  reason: collision with root package name */
    public static final Charset f32086g = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    public final Context f32087a;

    /* renamed from: b  reason: collision with root package name */
    public final f f32088b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f32089c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f32090d;

    /* renamed from: e  reason: collision with root package name */
    public final Runtime f32091e;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public j0(Context context, f fVar, String[] strArr, String[] strArr2, Runtime runtime) {
        this.f32087a = context;
        this.f32088b = fVar;
        this.f32089c = strArr;
        this.f32090d = strArr2;
        this.f32091e = runtime;
    }

    public final boolean a() {
        String[] strArr = this.f32089c;
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
        PackageManager packageManager = this.f32087a.getPackageManager();
        if (packageManager != null) {
            String[] strArr = this.f32090d;
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
        if (r0 != null) goto L_0x0060;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x004f */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c() {
        /*
            r10 = this;
            java.lang.String r0 = "/system/xbin/which"
            java.lang.String r1 = "su"
            java.lang.String[] r0 = new java.lang.String[]{r0, r1}
            r1 = 0
            r2 = 0
            java.lang.Runtime r3 = r10.f32091e     // Catch:{ IOException -> 0x004f, all -> 0x003b }
            java.lang.Process r0 = r3.exec(r0)     // Catch:{ IOException -> 0x004f, all -> 0x003b }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            java.io.InputStream r5 = r0.getInputStream()     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
            java.nio.charset.Charset r6 = f32086g     // Catch:{ IOException -> 0x0039, all -> 0x0037 }
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
            goto L_0x004f
        L_0x003b:
            r0 = move-exception
            r9 = r2
            r2 = r0
            r0 = r9
        L_0x003f:
            com.sumsub.sns.internal.log.a r3 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ all -> 0x004d }
            java.lang.String r4 = com.sumsub.sns.internal.log.c.a(r10)     // Catch:{ all -> 0x004d }
            java.lang.String r5 = "Error when trying to check if SU exists."
            r3.d(r4, r5, r2)     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x0063
            goto L_0x0060
        L_0x004d:
            r1 = move-exception
            goto L_0x0066
        L_0x004f:
            com.sumsub.sns.internal.log.a r3 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ all -> 0x0064 }
            java.lang.String r4 = com.sumsub.sns.internal.log.c.a(r10)     // Catch:{ all -> 0x0064 }
            java.lang.String r5 = "SU isn't found on this Device."
            r6 = 0
            r7 = 4
            r8 = 0
            com.sumsub.log.logger.a.a(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0064 }
            if (r2 == 0) goto L_0x0063
            r0 = r2
        L_0x0060:
            r0.destroy()
        L_0x0063:
            return r1
        L_0x0064:
            r1 = move-exception
            r0 = r2
        L_0x0066:
            if (r0 == 0) goto L_0x006b
            r0.destroy()
        L_0x006b:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.j0.c():boolean");
    }

    public final boolean d() {
        String a11 = this.f32088b.a();
        if (a11 == null || !StringsKt__StringsKt.R(a11, "test-keys", false, 2, (Object) null)) {
            return false;
        }
        return true;
    }

    public final Context e() {
        return this.f32087a;
    }

    public final boolean f() {
        return d() || a() || c() || b();
    }

    public j0(Context context, f fVar) {
        this(context, fVar, new String[]{"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/su/bin", "/system/xbin/daemonsu"}, new String[]{"com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "com.koushikdutta.superuser", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.noshufou.android.su"}, Runtime.getRuntime());
    }
}
