package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

final class zzev extends ContinuationImpl {
    public long zza;
    public /* synthetic */ Object zzb;
    public final /* synthetic */ zzez zzc;
    public int zzd;
    public zzez zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzev(zzez zzez, c cVar) {
        super(cVar);
        this.zzc = zzez;
    }

    public final Object invokeSuspend(Object obj) {
        this.zzb = obj;
        this.zzd |= Integer.MIN_VALUE;
        Object zzb2 = this.zzc.zzb(0, (zzoe) null, this);
        return zzb2 == IntrinsicsKt__IntrinsicsKt.d() ? zzb2 : Result.m3071boximpl(zzb2);
    }
}
