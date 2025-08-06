package com.google.android.gms.measurement.internal;

final class zzgg implements Runnable {
    public final /* synthetic */ zzac zza;
    public final /* synthetic */ zzgv zzb;

    public zzgg(zzgv zzgv, zzac zzac) {
        this.zzb = zzgv;
        this.zza = zzac;
    }

    public final void run() {
        this.zzb.zza.zzA();
        if (this.zza.zzc.zza() == null) {
            this.zzb.zza.zzN(this.zza);
        } else {
            this.zzb.zza.zzT(this.zza);
        }
    }
}
