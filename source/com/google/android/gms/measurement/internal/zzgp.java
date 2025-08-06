package com.google.android.gms.measurement.internal;

final class zzgp implements Runnable {
    public final /* synthetic */ zzau zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzgv zzc;

    public zzgp(zzgv zzgv, zzau zzau, String str) {
        this.zzc = zzgv;
        this.zza = zzau;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzA();
        this.zzc.zza.zzF(this.zza, this.zzb);
    }
}
