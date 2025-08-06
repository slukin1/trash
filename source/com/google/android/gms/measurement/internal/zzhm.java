package com.google.android.gms.measurement.internal;

public final /* synthetic */ class zzhm implements Runnable {
    public final /* synthetic */ zzik zza;

    public /* synthetic */ zzhm(zzik zzik) {
        this.zza = zzik;
    }

    public final void run() {
        zzik zzik = this.zza;
        zzik.zzg();
        if (!zzik.zzt.zzm().zzn.zzb()) {
            long zza2 = zzik.zzt.zzm().zzo.zza();
            zzik.zzt.zzm().zzo.zzb(1 + zza2);
            zzik.zzt.zzf();
            if (zza2 >= 5) {
                zzik.zzt.zzaA().zzk().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                zzik.zzt.zzm().zzn.zza(true);
                return;
            }
            zzik.zzt.zzE();
            return;
        }
        zzik.zzt.zzaA().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
    }
}
