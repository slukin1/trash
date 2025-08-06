package com.google.android.recaptcha.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

final class zzao extends ContinuationImpl {
    public /* synthetic */ Object zza;
    public final /* synthetic */ zzaw zzb;
    public int zzc;
    public zzaw zzd;
    public zzbb zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzao(zzaw zzaw, c cVar) {
        super(cVar);
        this.zzb = zzaw;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        return this.zzb.zzj(0, (String) null, (zzbd) null, this);
    }
}
