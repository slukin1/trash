package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

final class zzd extends ContinuationImpl {
    public /* synthetic */ Object zza;
    public final /* synthetic */ zzg zzb;
    public int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzd(zzg zzg, c cVar) {
        super(cVar);
        this.zzb = zzg;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zzb2 = this.zzb.zzb(0, (zzoe) null, this);
        return zzb2 == IntrinsicsKt__IntrinsicsKt.d() ? zzb2 : Result.m3071boximpl(zzb2);
    }
}
