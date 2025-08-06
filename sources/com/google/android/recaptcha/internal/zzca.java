package com.google.android.recaptcha.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;

public final class zzca implements zzbu {
    public static final zzbv zza = new zzbv((r) null);
    private final h0 zzb;
    private final zzcl zzc;
    /* access modifiers changed from: private */
    public final zzee zzd;
    private final Map zze;
    private final Map zzf;

    public zzca(h0 h0Var, zzcl zzcl, zzee zzee, Map map) {
        this.zzb = h0Var;
        this.zzc = zzcl;
        this.zzd = zzee;
        this.zze = map;
        this.zzf = zzcl.zzb().zzc();
    }

    /* access modifiers changed from: private */
    public final Object zzg(List list, zzcj zzcj, c cVar) {
        Object g11 = i0.g(new zzbx(zzcj, list, this, (c) null), cVar);
        return g11 == IntrinsicsKt__IntrinsicsKt.d() ? g11 : Unit.f56620a;
    }

    /* access modifiers changed from: private */
    public final Object zzh(Exception exc, zzcj zzcj, c cVar) {
        Object g11 = i0.g(new zzby(exc, zzcj, this, (c) null), cVar);
        return g11 == IntrinsicsKt__IntrinsicsKt.d() ? g11 : Unit.f56620a;
    }

    /* access modifiers changed from: private */
    public final void zzi(zzpr zzpr, zzcj zzcj) throws zzae {
        zzfh zzb2 = zzfh.zzb();
        int zza2 = zzcj.zza();
        zzdd zzdd = (zzdd) this.zze.get(Integer.valueOf(zzpr.zzf()));
        if (zzdd != null) {
            int zzg = zzpr.zzg();
            zzpq[] zzpqArr = (zzpq[]) zzpr.zzj().toArray(new zzpq[0]);
            zzdd.zza(zzg, zzcj, (zzpq[]) Arrays.copyOf(zzpqArr, zzpqArr.length));
            if (zza2 == zzcj.zza()) {
                zzcj.zzg(zzcj.zza() + 1);
            }
            zzb2.zzf();
            long zza3 = zzb2.zza(TimeUnit.MICROSECONDS);
            zzv zzv = zzv.zza;
            int zzk = zzpr.zzk();
            if (zzk != 1) {
                zzv.zza(zzk - 2, zza3);
                zzpr.zzk();
                zzpr.zzg();
                String unused = CollectionsKt___CollectionsKt.k0(zzpr.zzj(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new zzbw(this), 31, (Object) null);
                return;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        throw new zzae(5, 2, (Throwable) null);
    }

    public final void zza(String str) {
        n1 unused = i.d(this.zzb, (CoroutineContext) null, (CoroutineStart) null, new zzbz(new zzcj(this.zzc), this, str, (c) null), 3, (Object) null);
    }
}
