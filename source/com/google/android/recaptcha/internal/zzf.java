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
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.k;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n0;

final class zzf extends SuspendLambda implements p {
    public int zza;
    public final /* synthetic */ zzg zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ zzoe zzd;
    private /* synthetic */ Object zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzf(zzg zzg, long j11, zzoe zzoe, c cVar) {
        super(2, cVar);
        this.zzb = zzg;
        this.zzc = j11;
        this.zzd = zzoe;
    }

    public final c create(Object obj, c cVar) {
        zzf zzf = new zzf(this.zzb, this.zzc, this.zzd, cVar);
        zzf.zze = obj;
        return zzf;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzf) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Ref$ObjectRef ref$ObjectRef;
        Object obj3;
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        if (this.zza != 0) {
            ref$ObjectRef = (Ref$ObjectRef) this.zze;
            k.b(obj);
            obj2 = obj;
        } else {
            k.b(obj);
            h0 h0Var = (h0) this.zze;
            ArrayList arrayList = new ArrayList();
            for (zza zze2 : this.zzb.zzc()) {
                arrayList.add(i.b(h0Var, (CoroutineContext) null, (CoroutineStart) null, new zze(zze2, this.zzc, this.zzd, (c) null), 3, (Object) null));
            }
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            n0[] n0VarArr = (n0[]) arrayList.toArray(new n0[0]);
            this.zze = ref$ObjectRef2;
            this.zza = 1;
            obj2 = AwaitKt.b((n0[]) Arrays.copyOf(n0VarArr, n0VarArr.length), this);
            if (obj2 == d11) {
                return d11;
            }
            ref$ObjectRef = ref$ObjectRef2;
        }
        for (Result r32 : (List) obj2) {
            T r33 = Result.m3075exceptionOrNullimpl(r32.m3081unboximpl());
            if (r33 != null) {
                T t11 = null;
                if (ref$ObjectRef.element != null) {
                    t11 = new zzp(zzn.zzc, zzl.zzal, (String) null);
                } else if (r33 instanceof zzp) {
                    t11 = (zzp) r33;
                }
                ref$ObjectRef.element = t11;
            }
        }
        zzp zzp = (zzp) ref$ObjectRef.element;
        if (zzp != null) {
            Result.a aVar = Result.Companion;
            obj3 = k.a(zzp);
        } else {
            Result.a aVar2 = Result.Companion;
            obj3 = Unit.f56620a;
        }
        return Result.m3071boximpl(Result.m3072constructorimpl(obj3));
    }
}
