package com.google.android.recaptcha.internal;

import d10.p;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlinx.coroutines.h0;

final class zzb extends SuspendLambda implements p {
    public int zza;
    public final /* synthetic */ zza zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ long zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzb(zza zza2, String str, long j11, c cVar) {
        super(2, cVar);
        this.zzb = zza2;
        this.zzc = str;
        this.zzd = j11;
    }

    public final c create(Object obj, c cVar) {
        return new zzb(this.zzb, this.zzc, this.zzd, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzb) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
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
            String str = this.zzc;
            long j11 = this.zzd;
            this.zza = 1;
            obj2 = zza2.zza(str, j11, this);
            if (obj2 == d11) {
                return d11;
            }
        }
        return Result.m3071boximpl(obj2);
    }
}
