package com.google.android.recaptcha.internal;

import d10.p;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.k;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.t;

final class zzew extends SuspendLambda implements p {
    public int zza;
    public final /* synthetic */ zzez zzb;
    public final /* synthetic */ zzoe zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzew(zzez zzez, zzoe zzoe, c cVar) {
        super(2, cVar);
        this.zzb = zzez;
        this.zzc = zzoe;
    }

    public final c create(Object obj, c cVar) {
        return new zzew(this.zzb, this.zzc, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzew) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.zza;
        k.b(obj);
        if (i11 == 0) {
            zzez zzez = this.zzb;
            zzez.zzi.zza(zzez.zzp.zza(zzne.INIT_NATIVE));
            zzcb.zza(zznz.zzj(zzfy.zzh().zzj(this.zzc.zzJ())));
            this.zzb.zzn.zzd();
            this.zzb.zzn.zze();
            zzez.zzl(this.zzb, this.zzc);
            a.c(this.zzb.zzk().hashCode());
            t zzk = this.zzb.zzk();
            this.zza = 1;
            if (zzk.j(this) == d11) {
                return d11;
            }
        }
        return Result.m3071boximpl(Result.m3072constructorimpl(Unit.f56620a));
    }
}
