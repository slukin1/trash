package com.google.android.recaptcha.internal;

import d10.p;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlinx.coroutines.h0;

final class zze extends SuspendLambda implements p {
    public int zza;
    public final /* synthetic */ zza zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ zzoe zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zze(zza zza2, long j11, zzoe zzoe, c cVar) {
        super(2, cVar);
        this.zzb = zza2;
        this.zzc = j11;
        this.zzd = zzoe;
    }

    public final c create(Object obj, c cVar) {
        return new zze(this.zzb, this.zzc, this.zzd, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zze) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.zza;
        k.b(obj);
        if (i11 != 0) {
            obj2 = ((Result) obj).m3081unboximpl();
        } else {
            zza zza2 = this.zzb;
            long j11 = this.zzc;
            zzoe zzoe = this.zzd;
            this.zza = 1;
            obj2 = zza2.zzb(j11, zzoe, this);
            if (obj2 == d11) {
                return d11;
            }
        }
        return Result.m3071boximpl(obj2);
    }
}
