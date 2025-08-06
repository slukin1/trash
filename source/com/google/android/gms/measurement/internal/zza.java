package com.google.android.gms.measurement.internal;

final class zza implements Runnable {
    public final /* synthetic */ String zza;
    public final /* synthetic */ long zzb;
    public final /* synthetic */ zzd zzc;

    public zza(zzd zzd, String str, long j11) {
        this.zzc = zzd;
        this.zza = str;
        this.zzb = j11;
    }

    public final void run() {
        zzd.zza(this.zzc, this.zza, this.zzb);
    }
}
