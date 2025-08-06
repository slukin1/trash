package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

final class zzer extends ContinuationImpl {
    public /* synthetic */ Object zza;
    public final /* synthetic */ zzez zzb;
    public int zzc;
    public zzez zzd;
    public String zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzer(zzez zzez, c cVar) {
        super(cVar);
        this.zzb = zzez;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zza2 = this.zzb.zza((String) null, 0, this);
        return zza2 == IntrinsicsKt__IntrinsicsKt.d() ? zza2 : Result.m3071boximpl(zza2);
    }
}
