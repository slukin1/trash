package com.google.android.gms.measurement.internal;

final class zzam implements Runnable {
    public final /* synthetic */ zzgy zza;
    public final /* synthetic */ zzan zzb;

    public zzam(zzan zzan, zzgy zzgy) {
        this.zzb = zzan;
        this.zza = zzgy;
    }

    public final void run() {
        this.zza.zzay();
        if (zzab.zza()) {
            this.zza.zzaB().zzp(this);
            return;
        }
        boolean zze = this.zzb.zze();
        this.zzb.zzd = 0;
        if (zze) {
            this.zzb.zzc();
        }
    }
}
