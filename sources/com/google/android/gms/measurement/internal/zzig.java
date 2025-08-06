package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzqu;

final class zzig implements Runnable {
    public final /* synthetic */ zzhb zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ zzhb zzd;
    public final /* synthetic */ zzik zze;

    public zzig(zzik zzik, zzhb zzhb, long j11, boolean z11, zzhb zzhb2) {
        this.zze = zzik;
        this.zza = zzhb;
        this.zzb = j11;
        this.zzc = z11;
        this.zzd = zzhb2;
    }

    public final void run() {
        this.zze.zzV(this.zza);
        zzik.zzw(this.zze, this.zza, this.zzb, false, this.zzc);
        zzqu.zzc();
        if (this.zze.zzt.zzf().zzs((String) null, zzeg.zzan)) {
            zzik.zzv(this.zze, this.zza, this.zzd);
        }
    }
}
