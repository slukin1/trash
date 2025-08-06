package com.google.android.gms.measurement.internal;

final class zzgf implements Runnable {
    public final /* synthetic */ zzac zza;
    public final /* synthetic */ zzq zzb;
    public final /* synthetic */ zzgv zzc;

    public zzgf(zzgv zzgv, zzac zzac, zzq zzq) {
        this.zzc = zzgv;
        this.zza = zzac;
        this.zzb = zzq;
    }

    public final void run() {
        this.zzc.zza.zzA();
        if (this.zza.zzc.zza() == null) {
            this.zzc.zza.zzO(this.zza, this.zzb);
        } else {
            this.zzc.zza.zzU(this.zza, this.zzb);
        }
    }
}
