package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.h0;

final class zzat extends SuspendLambda implements p {
    public int zza;
    public final /* synthetic */ zzaw zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ RecaptchaAction zzd;
    public final /* synthetic */ zzbd zze;
    public final /* synthetic */ String zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzat(zzaw zzaw, long j11, RecaptchaAction recaptchaAction, zzbd zzbd, String str, c cVar) {
        super(2, cVar);
        this.zzb = zzaw;
        this.zzc = j11;
        this.zzd = recaptchaAction;
        this.zze = zzbd;
        this.zzf = str;
    }

    public final c create(Object obj, c cVar) {
        return new zzat(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzat) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        if (r1 != 1) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0029, code lost:
        if (r13 != r0) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003a, code lost:
        if (r13 == r0) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003d, code lost:
        r13 = (com.google.android.recaptcha.internal.zzol) r13;
        r12.zzb.zzl(r13, r12.zze);
        r12.zzb.zzi.zza(r12.zze.zza(com.google.android.recaptcha.internal.zzne.EXECUTE_TOTAL));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0063, code lost:
        return kotlin.Result.m3071boximpl(kotlin.Result.m3072constructorimpl(r13.zzi()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0064, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r12.zza
            r2 = 1
            kotlin.k.b(r13)
            if (r1 == 0) goto L_0x000f
            if (r1 == r2) goto L_0x002b
            goto L_0x003d
        L_0x000f:
            com.google.android.recaptcha.internal.zzaw r13 = r12.zzb
            long r3 = r12.zzc
            com.google.android.recaptcha.RecaptchaAction r1 = r12.zzd
            com.google.android.recaptcha.internal.zzbd r5 = r12.zze
            com.google.android.recaptcha.internal.zzaw.zzi(r13, r3, r1, r5)
            com.google.android.recaptcha.internal.zzaw r6 = r12.zzb
            long r7 = r12.zzc
            java.lang.String r9 = r12.zzf
            com.google.android.recaptcha.internal.zzbd r10 = r12.zze
            r12.zza = r2
            r11 = r12
            java.lang.Object r13 = r6.zzj(r7, r9, r10, r11)
            if (r13 == r0) goto L_0x0064
        L_0x002b:
            com.google.android.recaptcha.internal.zzaw r1 = r12.zzb
            com.google.android.recaptcha.RecaptchaAction r2 = r12.zzd
            com.google.android.recaptcha.internal.zzbd r3 = r12.zze
            com.google.android.recaptcha.internal.zzog r13 = (com.google.android.recaptcha.internal.zzog) r13
            r4 = 2
            r12.zza = r4
            java.lang.Object r13 = kotlinx.coroutines.g.g(r1.zzl.zza().getCoroutineContext(), new com.google.android.recaptcha.internal.zzav(r3, r1, r2, r13, (kotlin.coroutines.c) null), r12)
            if (r13 != r0) goto L_0x003d
            goto L_0x0064
        L_0x003d:
            com.google.android.recaptcha.internal.zzaw r0 = r12.zzb
            com.google.android.recaptcha.internal.zzbd r1 = r12.zze
            com.google.android.recaptcha.internal.zzol r13 = (com.google.android.recaptcha.internal.zzol) r13
            r0.zzl(r13, r1)
            com.google.android.recaptcha.internal.zzaw r0 = r12.zzb
            com.google.android.recaptcha.internal.zzbd r1 = r12.zze
            com.google.android.recaptcha.internal.zzbg r0 = r0.zzi
            com.google.android.recaptcha.internal.zzne r2 = com.google.android.recaptcha.internal.zzne.EXECUTE_TOTAL
            com.google.android.recaptcha.internal.zzbb r1 = r1.zza(r2)
            r0.zza(r1)
            java.lang.String r13 = r13.zzi()
            java.lang.Object r13 = kotlin.Result.m3072constructorimpl(r13)
            kotlin.Result r13 = kotlin.Result.m3071boximpl(r13)
            return r13
        L_0x0064:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzat.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
