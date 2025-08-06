package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

final class zzar extends ContinuationImpl {
    public /* synthetic */ Object zza;
    public final /* synthetic */ zzaw zzb;
    public int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzar(zzaw zzaw, c cVar) {
        super(cVar);
        this.zzb = zzaw;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object r22 = this.zzb.m3246executegIAlus((RecaptchaAction) null, this);
        return r22 == IntrinsicsKt__IntrinsicsKt.d() ? r22 : Result.m3071boximpl(r22);
    }
}
