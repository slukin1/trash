package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

final class zzas extends ContinuationImpl {
    public /* synthetic */ Object zza;
    public final /* synthetic */ zzaw zzb;
    public int zzc;
    public zzaw zzd;
    public zzbd zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzas(zzaw zzaw, c cVar) {
        super(cVar);
        this.zzb = zzaw;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object zze2 = this.zzb.zzk((RecaptchaAction) null, 0, this);
        return zze2 == IntrinsicsKt__IntrinsicsKt.d() ? zze2 : Result.m3071boximpl(zze2);
    }
}
