package com.google.android.recaptcha.internal;

import d10.p;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.a;
import kotlin.k;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;

final class zzbx extends SuspendLambda implements p {
    public int zza;
    public final /* synthetic */ zzcj zzb;
    public final /* synthetic */ List zzc;
    public final /* synthetic */ zzca zzd;
    private /* synthetic */ Object zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbx(zzcj zzcj, List list, zzca zzca, c cVar) {
        super(2, cVar);
        this.zzb = zzcj;
        this.zzc = list;
        this.zzd = zzca;
    }

    public final c create(Object obj, c cVar) {
        zzbx zzbx = new zzbx(this.zzb, this.zzc, this.zzd, cVar);
        zzbx.zze = obj;
        return zzbx;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbx) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.zza;
        k.b(obj);
        if (i11 == 0) {
            h0 h0Var = (h0) this.zze;
            zzfh zzb2 = zzfh.zzb();
            while (true) {
                zzcj zzcj = this.zzb;
                if (zzcj.zza() < 0) {
                    break;
                }
                if (zzcj.zza() >= this.zzc.size() || !i0.i(h0Var)) {
                    break;
                }
                try {
                    this.zzd.zzi((zzpr) this.zzc.get(this.zzb.zza()), this.zzb);
                } catch (Exception e11) {
                    zzca zzca = this.zzd;
                    zzcj zzcj2 = this.zzb;
                    this.zza = 1;
                    if (zzca.zzh(e11, zzcj2, this) == d11) {
                        return d11;
                    }
                }
            }
            zzb2.zzf();
            a.d(zzb2.zza(TimeUnit.MICROSECONDS));
            return Unit.f56620a;
        }
        return Unit.f56620a;
    }
}
