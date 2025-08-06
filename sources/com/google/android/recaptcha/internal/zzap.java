package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

final class zzap extends ContinuationImpl {
    public /* synthetic */ Object zza;
    public final /* synthetic */ zzaw zzb;
    public int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzap(zzaw zzaw, c cVar) {
        super(cVar);
        this.zzb = zzaw;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object r42 = this.zzb.m3245execute0E7RQCE((RecaptchaAction) null, 0, this);
        return r42 == IntrinsicsKt__IntrinsicsKt.d() ? r42 : Result.m3071boximpl(r42);
    }
}
