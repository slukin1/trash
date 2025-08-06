package com.google.android.recaptcha;

import android.app.Application;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.internal.zzam;
import kotlin.coroutines.c;

public final class Recaptcha {
    public static final Recaptcha INSTANCE = new Recaptcha();

    private Recaptcha() {
    }

    /* renamed from: getClient-BWLJW6A$default  reason: not valid java name */
    public static /* synthetic */ Object m3241getClientBWLJW6A$default(Recaptcha recaptcha, Application application, String str, long j11, c cVar, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            j11 = 10000;
        }
        return recaptcha.m3242getClientBWLJW6A(application, str, j11, cVar);
    }

    public static final Task<RecaptchaTasksClient> getTasksClient(Application application, String str) {
        zzam zzam = zzam.zza;
        return zzam.zzd(application, str, 10000);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: getClient-BWLJW6A  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object m3242getClientBWLJW6A(android.app.Application r8, java.lang.String r9, long r10, kotlin.coroutines.c<? super kotlin.Result<? extends com.google.android.recaptcha.RecaptchaClient>> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.google.android.recaptcha.Recaptcha$getClient$1
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.google.android.recaptcha.Recaptcha$getClient$1 r0 = (com.google.android.recaptcha.Recaptcha$getClient$1) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.zzc = r1
            goto L_0x0018
        L_0x0013:
            com.google.android.recaptcha.Recaptcha$getClient$1 r0 = new com.google.android.recaptcha.Recaptcha$getClient$1
            r0.<init>(r7, r12)
        L_0x0018:
            r6 = r0
            java.lang.Object r12 = r6.zza
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r6.zzc
            r2 = 1
            if (r1 == 0) goto L_0x0034
            if (r1 != r2) goto L_0x002c
            kotlin.k.b(r12)     // Catch:{ all -> 0x002a }
            goto L_0x0048
        L_0x002a:
            r8 = move-exception
            goto L_0x004f
        L_0x002c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0034:
            kotlin.k.b(r12)
            kotlin.Result$a r12 = kotlin.Result.Companion     // Catch:{ all -> 0x002a }
            com.google.android.recaptcha.internal.zzam r12 = com.google.android.recaptcha.internal.zzam.zza     // Catch:{ all -> 0x002a }
            r6.zzc = r2     // Catch:{ all -> 0x002a }
            r5 = 0
            r1 = r8
            r2 = r9
            r3 = r10
            java.lang.Object r12 = com.google.android.recaptcha.internal.zzam.zzc(r1, r2, r3, r5, r6)     // Catch:{ all -> 0x002a }
            if (r12 != r0) goto L_0x0048
            return r0
        L_0x0048:
            com.google.android.recaptcha.internal.zzaw r12 = (com.google.android.recaptcha.internal.zzaw) r12     // Catch:{ all -> 0x002a }
            java.lang.Object r8 = kotlin.Result.m3072constructorimpl(r12)     // Catch:{ all -> 0x002a }
            goto L_0x0059
        L_0x004f:
            kotlin.Result$a r9 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.k.a(r8)
            java.lang.Object r8 = kotlin.Result.m3072constructorimpl(r8)
        L_0x0059:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.Recaptcha.m3242getClientBWLJW6A(android.app.Application, java.lang.String, long, kotlin.coroutines.c):java.lang.Object");
    }

    public static final Task<RecaptchaTasksClient> getTasksClient(Application application, String str, long j11) {
        zzam zzam = zzam.zza;
        return zzam.zzd(application, str, j11);
    }
}
