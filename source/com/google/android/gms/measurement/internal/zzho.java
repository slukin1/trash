package com.google.android.gms.measurement.internal;

final class zzho implements Runnable {
    public final /* synthetic */ long zza;
    public final /* synthetic */ zzik zzb;

    public zzho(zzik zzik, long j11) {
        this.zzb = zzik;
        this.zza = j11;
    }

    public final void run() {
        this.zzb.zzt.zzm().zzf.zzb(this.zza);
        this.zzb.zzt.zzaA().zzc().zzb("Session timeout duration set", Long.valueOf(this.zza));
    }
}
