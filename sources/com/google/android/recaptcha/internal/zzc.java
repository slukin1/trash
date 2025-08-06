package com.google.android.recaptcha.internal;

import d10.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;

final class zzc extends SuspendLambda implements p {
    public int zza;
    public final /* synthetic */ zzg zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ long zzd;
    private /* synthetic */ Object zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzc(zzg zzg, String str, long j11, c cVar) {
        super(2, cVar);
        this.zzb = zzg;
        this.zzc = str;
        this.zzd = j11;
    }

    public final c create(Object obj, c cVar) {
        zzc zzc2 = new zzc(this.zzb, this.zzc, this.zzd, cVar);
        zzc2.zze = obj;
        return zzc2;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzc) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.zza;
        k.b(obj);
        if (i11 != 0) {
            obj2 = obj;
        } else {
            h0 h0Var = (h0) this.zze;
            ArrayList arrayList = new ArrayList();
            for (zza zzb2 : this.zzb.zzc()) {
                arrayList.add(i.b(h0Var, (CoroutineContext) null, (CoroutineStart) null, new zzb(zzb2, this.zzc, this.zzd, (c) null), 3, (Object) null));
            }
            n0[] n0VarArr = (n0[]) arrayList.toArray(new n0[0]);
            this.zza = 1;
            obj2 = AwaitKt.b((n0[]) Arrays.copyOf(n0VarArr, n0VarArr.length), this);
            if (obj2 == d11) {
                return d11;
            }
        }
        String str = this.zzc;
        zzof zzf = zzog.zzf();
        zzf.zzd(str);
        for (Result r22 : (List) obj2) {
            Object r23 = r22.m3081unboximpl();
            if (Result.m3079isSuccessimpl(r23)) {
                zzf.zzg((zzog) r23);
            }
        }
        return (zzog) zzf.zzj();
    }
}
