package com.google.android.recaptcha.internal;

import d10.p;
import java.util.Arrays;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Reflection;
import kotlin.k;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i0;

final class zzby extends SuspendLambda implements p {
    public final /* synthetic */ Exception zza;
    public final /* synthetic */ zzcj zzb;
    public final /* synthetic */ zzca zzc;
    private /* synthetic */ Object zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzby(Exception exc, zzcj zzcj, zzca zzca, c cVar) {
        super(2, cVar);
        this.zza = exc;
        this.zzb = zzcj;
        this.zzc = zzca;
    }

    public final c create(Object obj, c cVar) {
        zzby zzby = new zzby(this.zza, this.zzb, this.zzc, cVar);
        zzby.zzd = obj;
        return zzby;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzby) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        zzpg zzpg;
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        k.b(obj);
        h0 h0Var = (h0) this.zzd;
        Exception exc = this.zza;
        if (exc instanceof zzae) {
            zzpg = ((zzae) exc).zza();
            zzpg.zzd(this.zzb.zza());
        } else {
            zzcj zzcj = this.zzb;
            zzpg zzf = zzph.zzf();
            zzf.zzd(zzcj.zza());
            zzf.zzp(2);
            zzf.zze(2);
            zzpg = zzf;
        }
        zzph zzph = (zzph) zzpg.zzj();
        zzph.zzk();
        zzph.zzj();
        Reflection.b(this.zza.getClass()).f();
        this.zza.getMessage();
        zzcj zzcj2 = this.zzb;
        zzz zzb2 = zzcj2.zzb();
        zzz zzz = zzcj2.zza;
        if (zzz == null) {
            zzz = null;
        }
        zzno zza2 = zzbp.zza(zzb2, zzz);
        String zzd2 = this.zzb.zzd();
        if (zzd2.length() == 0) {
            zzd2 = "recaptcha.m.Main.rge";
        }
        if (i0.i(h0Var)) {
            zzca zzca = this.zzc;
            zzfy zzh = zzfy.zzh();
            byte[] zzd3 = zzph.zzd();
            zzfy zzh2 = zzfy.zzh();
            byte[] zzd4 = zza2.zzd();
            zzca.zzc.zze().zzb(zzd2, (String[]) Arrays.copyOf(new String[]{zzh.zzi(zzd3, 0, zzd3.length), zzh2.zzi(zzd4, 0, zzd4.length)}, 2));
        }
        return Unit.f56620a;
    }
}
