package com.google.android.gms.measurement.internal;

final class zzb implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzd zzc;

    public zzb(zzd zzd, String str, long j11) {
        this.zzc = zzd;
        this.zza = str;
        this.zzb = j11;
    }

    public final void run() {
        zzd.zzb(this.zzc, this.zza, this.zzb);
    }
}
