package com.google.android.recaptcha.internal;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlinx.coroutines.h0;

final class zzex extends SuspendLambda implements p {
    public final /* synthetic */ zzez zza;
    public final /* synthetic */ String zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzex(zzez zzez, String str, c cVar) {
        super(2, cVar);
        this.zza = zzez;
        this.zzb = str;
    }

    public final c create(Object obj, c cVar) {
        return new zzex(this.zza, this.zzb, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzex) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        k.b(obj);
        zzez.zzm(this.zza, this.zzb);
        return Unit.f56620a;
    }
}
