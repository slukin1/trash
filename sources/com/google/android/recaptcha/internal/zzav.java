package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.h0;

final class zzav extends SuspendLambda implements p {
    public final /* synthetic */ zzbd zza;
    public final /* synthetic */ zzaw zzb;
    public final /* synthetic */ RecaptchaAction zzc;
    public final /* synthetic */ zzog zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzav(zzbd zzbd, zzaw zzaw, RecaptchaAction recaptchaAction, zzog zzog, c cVar) {
        super(2, cVar);
        this.zza = zzbd;
        this.zzb = zzaw;
        this.zzc = recaptchaAction;
        this.zzd = zzog;
    }

    public final c create(Object obj, c cVar) {
        return new zzav(this.zza, this.zzb, this.zzc, this.zzd, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzav) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00f3, code lost:
        throw new com.google.android.recaptcha.internal.zzp(com.google.android.recaptcha.internal.zzn.zzc, com.google.android.recaptcha.internal.zzl.zzR, (java.lang.String) null);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x00ea */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object unused = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            kotlin.k.b(r6)
            com.google.android.recaptcha.internal.zzbd r6 = r5.zza
            com.google.android.recaptcha.internal.zzne r0 = com.google.android.recaptcha.internal.zzne.FETCH_TOKEN
            com.google.android.recaptcha.internal.zzbb r6 = r6.zza(r0)
            com.google.android.recaptcha.internal.zzaw r0 = r5.zzb
            com.google.android.recaptcha.internal.zzbg r0 = r0.zzi
            r1 = 0
            r2 = 2
            r0.zze.put(r6, new com.google.android.recaptcha.internal.zzbf(r6, r0.zza, new com.google.android.recaptcha.internal.zzac()))
            com.google.android.recaptcha.internal.zzob r0 = com.google.android.recaptcha.internal.zzoc.zzf()
            com.google.android.recaptcha.internal.zzaw r2 = r5.zzb
            java.lang.String r3 = r2.zzg()
            r0.zzr(r3)
            com.google.android.recaptcha.RecaptchaAction r3 = r5.zzc
            java.lang.String r3 = r3.getAction()
            r0.zzd(r3)
            com.google.android.recaptcha.internal.zzoe r3 = r2.zzg
            java.lang.String r3 = r3.zzI()
            r0.zzq(r3)
            com.google.android.recaptcha.internal.zzoe r2 = r2.zzg
            java.lang.String r2 = r2.zzH()
            r0.zzp(r2)
            com.google.android.recaptcha.internal.zzog r2 = r5.zzd
            java.lang.String r3 = r2.zzH()
            r0.zzt(r3)
            java.lang.String r3 = r2.zzj()
            r0.zze(r3)
            java.lang.String r2 = r2.zzI()
            r0.zzs(r2)
            com.google.android.recaptcha.internal.zzit r0 = r0.zzj()
            com.google.android.recaptcha.internal.zzoc r0 = (com.google.android.recaptcha.internal.zzoc) r0
            com.google.android.recaptcha.internal.zzaw r2 = r5.zzb     // Catch:{ Exception -> 0x010f }
            com.google.android.recaptcha.internal.zzab r2 = r2.zzf     // Catch:{ Exception -> 0x010f }
            java.net.URL r3 = new java.net.URL     // Catch:{ Exception -> 0x010f }
            java.lang.String r2 = r2.zzd()     // Catch:{ Exception -> 0x010f }
            r3.<init>(r2)     // Catch:{ Exception -> 0x010f }
            java.net.URLConnection r2 = r3.openConnection()     // Catch:{ Exception -> 0x010f }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x010f }
            java.lang.String r3 = "POST"
            r2.setRequestMethod(r3)     // Catch:{ Exception -> 0x010f }
            r3 = 1
            r2.setDoOutput(r3)     // Catch:{ Exception -> 0x010f }
            java.lang.String r3 = "application/x-protobuffer"
            java.lang.String r4 = "Content-Type"
            r2.setRequestProperty(r4, r3)     // Catch:{ Exception -> 0x010f }
            r2.connect()     // Catch:{ Exception -> 0x00fd }
            com.google.android.recaptcha.internal.zzoi r3 = com.google.android.recaptcha.internal.zzoj.zzf()     // Catch:{ Exception -> 0x00fd }
            java.lang.String r4 = r0.zzi()     // Catch:{ Exception -> 0x00fd }
            r3.zzd(r4)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r4 = r0.zzk()     // Catch:{ Exception -> 0x00fd }
            r3.zzq(r4)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r4 = r0.zzI()     // Catch:{ Exception -> 0x00fd }
            r3.zzt(r4)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r4 = r0.zzH()     // Catch:{ Exception -> 0x00fd }
            r3.zzp(r4)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r4 = r0.zzJ()     // Catch:{ Exception -> 0x00fd }
            r3.zzr(r4)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r4 = r0.zzK()     // Catch:{ Exception -> 0x00fd }
            r3.zzs(r4)     // Catch:{ Exception -> 0x00fd }
            java.lang.String r0 = r0.zzj()     // Catch:{ Exception -> 0x00fd }
            r3.zze(r0)     // Catch:{ Exception -> 0x00fd }
            com.google.android.recaptcha.internal.zzit r0 = r3.zzj()     // Catch:{ Exception -> 0x00fd }
            com.google.android.recaptcha.internal.zzoj r0 = (com.google.android.recaptcha.internal.zzoj) r0     // Catch:{ Exception -> 0x00fd }
            byte[] r0 = r0.zzd()     // Catch:{ Exception -> 0x00fd }
            java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ Exception -> 0x00fd }
            r3.write(r0)     // Catch:{ Exception -> 0x00fd }
            int r0 = r2.getResponseCode()     // Catch:{ Exception -> 0x00fd }
            r3 = 200(0xc8, float:2.8E-43)
            if (r0 != r3) goto L_0x00f4
            java.io.InputStream r0 = r2.getInputStream()     // Catch:{ Exception -> 0x00fd }
            com.google.android.recaptcha.internal.zzol r0 = com.google.android.recaptcha.internal.zzol.zzg(r0)     // Catch:{ Exception -> 0x00ea }
            com.google.android.recaptcha.internal.zzaw r1 = r5.zzb
            com.google.android.recaptcha.internal.zzbg r1 = r1.zzi
            r1.zza(r6)
            return r0
        L_0x00ea:
            com.google.android.recaptcha.internal.zzp r0 = new com.google.android.recaptcha.internal.zzp     // Catch:{ Exception -> 0x00fd }
            com.google.android.recaptcha.internal.zzn r2 = com.google.android.recaptcha.internal.zzn.zzc     // Catch:{ Exception -> 0x00fd }
            com.google.android.recaptcha.internal.zzl r3 = com.google.android.recaptcha.internal.zzl.zzR     // Catch:{ Exception -> 0x00fd }
            r0.<init>(r2, r3, r1)     // Catch:{ Exception -> 0x00fd }
            throw r0     // Catch:{ Exception -> 0x00fd }
        L_0x00f4:
            int r0 = r2.getResponseCode()     // Catch:{ Exception -> 0x00fd }
            com.google.android.recaptcha.internal.zzp r0 = com.google.android.recaptcha.internal.zzbr.zza(r0)     // Catch:{ Exception -> 0x00fd }
            throw r0     // Catch:{ Exception -> 0x00fd }
        L_0x00fd:
            r0 = move-exception
            boolean r2 = r0 instanceof com.google.android.recaptcha.internal.zzp     // Catch:{ Exception -> 0x010f }
            if (r2 == 0) goto L_0x0105
            com.google.android.recaptcha.internal.zzp r0 = (com.google.android.recaptcha.internal.zzp) r0     // Catch:{ Exception -> 0x010f }
            goto L_0x010e
        L_0x0105:
            com.google.android.recaptcha.internal.zzp r0 = new com.google.android.recaptcha.internal.zzp     // Catch:{ Exception -> 0x010f }
            com.google.android.recaptcha.internal.zzn r2 = com.google.android.recaptcha.internal.zzn.zze     // Catch:{ Exception -> 0x010f }
            com.google.android.recaptcha.internal.zzl r3 = com.google.android.recaptcha.internal.zzl.zzQ     // Catch:{ Exception -> 0x010f }
            r0.<init>(r2, r3, r1)     // Catch:{ Exception -> 0x010f }
        L_0x010e:
            throw r0     // Catch:{ Exception -> 0x010f }
        L_0x010f:
            r0 = move-exception
            boolean r2 = r0 instanceof com.google.android.recaptcha.internal.zzp
            if (r2 == 0) goto L_0x0117
            com.google.android.recaptcha.internal.zzp r0 = (com.google.android.recaptcha.internal.zzp) r0
            goto L_0x0120
        L_0x0117:
            com.google.android.recaptcha.internal.zzp r0 = new com.google.android.recaptcha.internal.zzp
            com.google.android.recaptcha.internal.zzn r2 = com.google.android.recaptcha.internal.zzn.zzc
            com.google.android.recaptcha.internal.zzl r3 = com.google.android.recaptcha.internal.zzl.zzam
            r0.<init>(r2, r3, r1)
        L_0x0120:
            com.google.android.recaptcha.internal.zzaw r2 = r5.zzb
            com.google.android.recaptcha.internal.zzbg r2 = r2.zzi
            r2.zzb(r6, r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzav.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
