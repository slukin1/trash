package com.google.android.recaptcha;

import android.app.Application;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

public final class Recaptcha$getClient$1 extends ContinuationImpl {
    public /* synthetic */ Object zza;
    public final /* synthetic */ Recaptcha zzb;
    public int zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Recaptcha$getClient$1(Recaptcha recaptcha, c cVar) {
        super(cVar);
        this.zzb = recaptcha;
    }

    public final Object invokeSuspend(Object obj) {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object r72 = this.zzb.m3242getClientBWLJW6A((Application) null, (String) null, 0, this);
        return r72 == IntrinsicsKt__IntrinsicsKt.d() ? r72 : Result.m3071boximpl(r72);
    }
}
