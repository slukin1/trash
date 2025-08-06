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
import kotlinx.coroutines.t;
import kotlinx.coroutines.v;

final class zzet extends SuspendLambda implements p {
    public int zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzez zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzet(String str, zzez zzez, c cVar) {
        super(2, cVar);
        this.zzb = str;
        this.zzc = zzez;
    }

    public final c create(Object obj, c cVar) {
        return new zzet(this.zzb, this.zzc, cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzet) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.zza;
        k.b(obj);
        if (i11 == 0) {
            zzez zzez = this.zzc;
            String str = this.zzb;
            t b11 = v.b((n1) null, 1, (Object) null);
            zzez.zzl.put(str, b11);
            String str2 = this.zzb;
            zzou zzf = zzov.zzf();
            zzf.zzd(str2);
            byte[] zzd = ((zzov) zzf.zzj()).zzd();
            n1 unused = i.d(this.zzc.zzq.zzb(), (CoroutineContext) null, (CoroutineStart) null, new zzes(this.zzc, zzfy.zzh().zzi(zzd, 0, zzd.length), (c) null), 3, (Object) null);
            this.zza = 1;
            obj = b11.j(this);
            if (obj == d11) {
                return d11;
            }
        }
        return obj;
    }
}
