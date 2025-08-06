package com.google.android.recaptcha.internal;

import android.app.Application;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaException;
import java.util.List;
import java.util.UUID;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.g;
import kotlinx.coroutines.i;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.coroutines.sync.a;

public final class zzam {
    public static final zzam zza = new zzam();
    private static zzaw zzb;
    private static final String zzc = UUID.randomUUID().toString();
    private static final a zzd = MutexKt.b(false, 1, (Object) null);
    private static final zzt zze = new zzt();
    private static zzg zzf = new zzg((List) null, 1, (r) null);

    private zzam() {
    }

    public static final Object zzc(Application application, String str, long j11, zzbq zzbq, c cVar) throws TimeoutCancellationException, ApiException, RecaptchaException {
        return g.g(zze.zzb().getCoroutineContext(), new zzah(application, str, j11, (zzbq) null, (c) null), cVar);
    }

    public static final Task zzd(Application application, String str, long j11) throws TimeoutCancellationException, ApiException, RecaptchaException {
        return zzj.zza(i.b(zze.zzb(), (CoroutineContext) null, (CoroutineStart) null, new zzak(application, str, j11, (c) null), 3, (Object) null));
    }

    public static final zzg zze() {
        return zzf;
    }

    public static final void zzf(zzg zzg) {
        zzf = zzg;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v0, resolved type: com.google.android.recaptcha.internal.zzai} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: kotlinx.coroutines.sync.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v8, resolved type: com.google.android.recaptcha.internal.zzai} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r1v2, types: [kotlinx.coroutines.sync.a] */
    /* JADX WARNING: type inference failed for: r1v31 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:60:0x01a8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d5 A[Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e, all -> 0x0040 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x017e A[Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object zza(android.app.Application r22, java.lang.String r23, long r24, com.google.android.recaptcha.internal.zzab r26, android.webkit.WebView r27, com.google.android.recaptcha.internal.zzbq r28, com.google.android.recaptcha.internal.zzt r29, kotlin.coroutines.c r30) throws kotlinx.coroutines.TimeoutCancellationException, com.google.android.gms.common.api.ApiException, com.google.android.recaptcha.RecaptchaException {
        /*
            r21 = this;
            r0 = r30
            boolean r1 = r0 instanceof com.google.android.recaptcha.internal.zzai
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.google.android.recaptcha.internal.zzai r1 = (com.google.android.recaptcha.internal.zzai) r1
            int r2 = r1.zzg
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.zzg = r2
            r2 = r21
            goto L_0x001e
        L_0x0017:
            com.google.android.recaptcha.internal.zzai r1 = new com.google.android.recaptcha.internal.zzai
            r2 = r21
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.zze
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r1.zzg
            r5 = 1
            r6 = 2
            r7 = 0
            if (r4 == 0) goto L_0x0067
            if (r4 == r5) goto L_0x004e
            if (r4 != r6) goto L_0x0046
            java.lang.Object r3 = r1.zzc
            com.google.android.recaptcha.internal.zzbg r3 = (com.google.android.recaptcha.internal.zzbg) r3
            java.lang.Object r4 = r1.zzb
            com.google.android.recaptcha.internal.zzbd r4 = (com.google.android.recaptcha.internal.zzbd) r4
            java.lang.Object r1 = r1.zza
            kotlinx.coroutines.sync.a r1 = (kotlinx.coroutines.sync.a) r1
            kotlin.k.b(r0)     // Catch:{ RecaptchaException -> 0x0043, Exception -> 0x01a8 }
            goto L_0x014f
        L_0x0040:
            r0 = move-exception
            goto L_0x01b7
        L_0x0043:
            r0 = move-exception
            goto L_0x01b6
        L_0x0046:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x004e:
            long r4 = r1.zzd
            kotlinx.coroutines.sync.a r8 = r1.zzh
            com.google.android.recaptcha.internal.zzt r9 = r1.zzi
            java.lang.Object r10 = r1.zzc
            com.google.android.recaptcha.internal.zzab r10 = (com.google.android.recaptcha.internal.zzab) r10
            java.lang.Object r11 = r1.zzb
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r1.zza
            android.app.Application r12 = (android.app.Application) r12
            kotlin.k.b(r0)
            r15 = r8
            r14 = r9
            r9 = r12
            goto L_0x0090
        L_0x0067:
            kotlin.k.b(r0)
            kotlinx.coroutines.sync.a r0 = zzd
            r4 = r22
            r1.zza = r4
            r8 = r23
            r1.zzb = r8
            r9 = r26
            r1.zzc = r9
            r10 = r29
            r1.zzi = r10
            r1.zzh = r0
            r11 = r24
            r1.zzd = r11
            r1.zzg = r5
            java.lang.Object r5 = r0.d(r7, r1)
            if (r5 == r3) goto L_0x01bb
            r15 = r0
            r14 = r10
            r10 = r9
            r9 = r4
            r4 = r11
            r11 = r8
        L_0x0090:
            java.util.UUID r0 = java.util.UUID.randomUUID()     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            java.lang.String r0 = r0.toString()     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            java.lang.String r8 = zzc     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            com.google.android.recaptcha.internal.zzbd r13 = new com.google.android.recaptcha.internal.zzbd     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r13.<init>(r8, r0, r7)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r13.zzc(r0)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            com.google.android.recaptcha.internal.zzbg r0 = new com.google.android.recaptcha.internal.zzbg     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            com.google.android.recaptcha.internal.zzbm r8 = new com.google.android.recaptcha.internal.zzbm     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            com.google.android.recaptcha.internal.zzbo r12 = new com.google.android.recaptcha.internal.zzbo     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            java.lang.String r6 = r10.zzc()     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r12.<init>(r6)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            kotlinx.coroutines.h0 r6 = r14.zza()     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r8.<init>(r9, r12, r6)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r22 = r0
            r23 = r11
            r24 = r9
            r25 = r10
            r26 = r14
            r27 = r8
            r22.<init>(r23, r24, r25, r26, r27)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            com.google.android.recaptcha.internal.zzne r6 = com.google.android.recaptcha.internal.zzne.INIT_TOTAL     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            com.google.android.recaptcha.internal.zzbb r8 = r13.zza(r6)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r12 = 2
            r0.zze.put(r8, new com.google.android.recaptcha.internal.zzbf(r8, r0.zza, new com.google.android.recaptcha.internal.zzac()))     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r16 = 5000(0x1388, double:2.4703E-320)
            int r8 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r8 < 0) goto L_0x017e
            java.lang.String r8 = "android.permission.INTERNET"
            int r8 = androidx.core.content.ContextCompat.checkSelfPermission(r9, r8)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            if (r8 != 0) goto L_0x0162
            com.google.android.recaptcha.internal.zzbq r12 = new com.google.android.recaptcha.internal.zzbq     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            com.google.android.recaptcha.internal.zzy r8 = new com.google.android.recaptcha.internal.zzy     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r8.<init>(r9)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r12.<init>(r8, r0)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            com.google.android.recaptcha.internal.zzaw r8 = zzb     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            if (r8 == 0) goto L_0x0122
            java.lang.String r1 = r8.zzg()     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            boolean r1 = kotlin.jvm.internal.x.b(r1, r11)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            if (r1 == 0) goto L_0x00fd
            com.google.android.recaptcha.internal.zzbb r1 = r13.zza(r6)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r0.zza(r1)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            goto L_0x015e
        L_0x00fd:
            com.google.android.recaptcha.RecaptchaException r0 = new com.google.android.recaptcha.RecaptchaException     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            com.google.android.recaptcha.RecaptchaErrorCode r1 = com.google.android.recaptcha.RecaptchaErrorCode.INVALID_SITEKEY     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            java.lang.String r3 = r8.zzg()     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r4.<init>()     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            java.lang.String r5 = "Only one site key can be used per runtime. The site key you provided "
            r4.append(r5)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r4.append(r11)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            java.lang.String r5 = " is different than "
            r4.append(r5)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r4.append(r3)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            java.lang.String r3 = r4.toString()     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r0.<init>(r1, r3)     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            throw r0     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
        L_0x0122:
            r1.zza = r15     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r1.zzb = r13     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r1.zzc = r0     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r1.zzi = r7     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r1.zzh = r7     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r6 = 2
            r1.zzg = r6     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            com.google.android.recaptcha.internal.zzaj r6 = new com.google.android.recaptcha.internal.zzaj     // Catch:{ RecaptchaException -> 0x01b1, Exception -> 0x01a4, all -> 0x019e }
            r16 = 0
            r19 = 0
            r8 = r6
            r22 = r13
            r20 = r15
            r15 = r16
            r16 = r0
            r17 = r4
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r19)     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            java.lang.Object r1 = kotlinx.coroutines.TimeoutKt.c(r4, r6, r1)     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            if (r1 == r3) goto L_0x01bb
            r4 = r22
            r3 = r0
            r0 = r1
            r1 = r20
        L_0x014f:
            r8 = r0
            com.google.android.recaptcha.internal.zzaw r8 = (com.google.android.recaptcha.internal.zzaw) r8     // Catch:{ RecaptchaException -> 0x0043, Exception -> 0x01a8 }
            zzb = r8     // Catch:{ RecaptchaException -> 0x0043, Exception -> 0x01a8 }
            com.google.android.recaptcha.internal.zzne r0 = com.google.android.recaptcha.internal.zzne.INIT_TOTAL     // Catch:{ RecaptchaException -> 0x0043, Exception -> 0x01a8 }
            com.google.android.recaptcha.internal.zzbb r0 = r4.zza(r0)     // Catch:{ RecaptchaException -> 0x0043, Exception -> 0x01a8 }
            r3.zza(r0)     // Catch:{ RecaptchaException -> 0x0043, Exception -> 0x01a8 }
            r15 = r1
        L_0x015e:
            r15.e(r7)
            return r8
        L_0x0162:
            r20 = r15
            r1 = r13
            com.google.android.recaptcha.internal.zzbb r1 = r1.zza(r6)     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            com.google.android.recaptcha.internal.zzp r3 = new com.google.android.recaptcha.internal.zzp     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            com.google.android.recaptcha.internal.zzn r4 = com.google.android.recaptcha.internal.zzn.zze     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            com.google.android.recaptcha.internal.zzl r5 = com.google.android.recaptcha.internal.zzl.zzv     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            r3.<init>(r4, r5, r7)     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            r0.zzb(r1, r3, r7)     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            com.google.android.recaptcha.RecaptchaException r0 = new com.google.android.recaptcha.RecaptchaException     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            com.google.android.recaptcha.RecaptchaErrorCode r1 = com.google.android.recaptcha.RecaptchaErrorCode.NETWORK_ERROR     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            r3 = 2
            r0.<init>(r1, r7, r3, r7)     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            throw r0     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
        L_0x017e:
            r1 = r13
            r20 = r15
            com.google.android.recaptcha.internal.zzp r3 = new com.google.android.recaptcha.internal.zzp     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            com.google.android.recaptcha.internal.zzn r4 = com.google.android.recaptcha.internal.zzn.zzm     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            com.google.android.recaptcha.internal.zzl r5 = com.google.android.recaptcha.internal.zzl.zzT     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            r3.<init>(r4, r5, r7)     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            com.google.android.recaptcha.internal.zzbb r1 = r1.zza(r6)     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            r0.zzb(r1, r3, r7)     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            com.google.android.recaptcha.RecaptchaException r0 = new com.google.android.recaptcha.RecaptchaException     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            com.google.android.recaptcha.RecaptchaErrorCode r1 = com.google.android.recaptcha.RecaptchaErrorCode.INVALID_TIMEOUT     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            r3 = 2
            r0.<init>(r1, r7, r3, r7)     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
            throw r0     // Catch:{ RecaptchaException -> 0x019c, Exception -> 0x01a6, all -> 0x019a }
        L_0x019a:
            r0 = move-exception
            goto L_0x01a1
        L_0x019c:
            r0 = move-exception
            goto L_0x01b4
        L_0x019e:
            r0 = move-exception
            r20 = r15
        L_0x01a1:
            r1 = r20
            goto L_0x01b7
        L_0x01a4:
            r20 = r15
        L_0x01a6:
            r1 = r20
        L_0x01a8:
            com.google.android.recaptcha.RecaptchaException r0 = new com.google.android.recaptcha.RecaptchaException     // Catch:{ all -> 0x0040 }
            com.google.android.recaptcha.RecaptchaErrorCode r3 = com.google.android.recaptcha.RecaptchaErrorCode.INTERNAL_ERROR     // Catch:{ all -> 0x0040 }
            r4 = 2
            r0.<init>(r3, r7, r4, r7)     // Catch:{ all -> 0x0040 }
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x01b1:
            r0 = move-exception
            r20 = r15
        L_0x01b4:
            r1 = r20
        L_0x01b6:
            throw r0     // Catch:{ all -> 0x0040 }
        L_0x01b7:
            r1.e(r7)
            throw r0
        L_0x01bb:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzam.zza(android.app.Application, java.lang.String, long, com.google.android.recaptcha.internal.zzab, android.webkit.WebView, com.google.android.recaptcha.internal.zzbq, com.google.android.recaptcha.internal.zzt, kotlin.coroutines.c):java.lang.Object");
    }
}
