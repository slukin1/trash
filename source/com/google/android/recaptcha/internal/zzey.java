package com.google.android.recaptcha.internal;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

final class zzey extends SuspendLambda implements p {
    public final /* synthetic */ zzez zza;
    public final /* synthetic */ zzoe zzb;
    public final /* synthetic */ zzbb zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzey(zzez zzez, zzoe zzoe, zzbb zzbb, c cVar) {
        super(2, cVar);
        this.zza = zzez;
        this.zzb = zzoe;
        this.zzc = zzbb;
    }

    public final c create(Object obj, c cVar) {
        return new zzey(this.zza, this.zzb, this.zzc, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzey) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        k.b(obj);
        try {
            zzez zzez = this.zza;
            n1 unused2 = i.d(this.zza.zzq.zzb(), (CoroutineContext) null, (CoroutineStart) null, new zzex(this.zza, zzez.zzf().zzb(this.zzb, zzez.zzp), (c) null), 3, (Object) null);
        } catch (zzp e11) {
            zzez zzez2 = this.zza;
            zzez2.zzi.zzb(this.zzc, e11, (String) null);
            this.zza.zzk().o(e11);
        }
        return Unit.f56620a;
    }
}
