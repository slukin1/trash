package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzqu;

final class zzif implements Runnable {
    public final /* synthetic */ zzhb zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ zzhb zze;
    public final /* synthetic */ zzik zzf;

    public zzif(zzik zzik, zzhb zzhb, long j11, long j12, boolean z11, zzhb zzhb2) {
        this.zzf = zzik;
        this.zza = zzhb;
        this.zzb = j11;
        this.zzc = j12;
        this.zzd = z11;
        this.zze = zzhb2;
    }

    public final void run() {
        this.zzf.zzV(this.zza);
        this.zzf.zzL(this.zzb, false);
        zzik.zzw(this.zzf, this.zza, this.zzc, true, this.zzd);
        zzqu.zzc();
        if (this.zzf.zzt.zzf().zzs((String) null, zzeg.zzan)) {
            zzik.zzv(this.zzf, this.zza, this.zze);
        }
    }
}
