package com.google.android.gms.measurement.internal;

final class zzgt implements Runnable {
    public final /* synthetic */ zzq zza;
    public final /* synthetic */ zzgv zzb;

    public zzgt(zzgv zzgv, zzq zzq) {
        this.zzb = zzgv;
        this.zza = zzq;
    }

    public final void run() {
        this.zzb.zza.zzA();
        this.zzb.zza.zzL(this.zza);
    }
}
